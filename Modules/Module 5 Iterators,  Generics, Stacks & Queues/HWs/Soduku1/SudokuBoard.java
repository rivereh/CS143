// River Hill
// CS 143
// HW #1: Sudoku #1
//
// This object class will allow us to create a Sudoku board
// which reads in a file to populate it's numerical fields, it
// also allows us to neatly print a representation of the board
// to the console

import java.util.*;
import java.io.*;

public class SudokuBoard {
   
   private int[][] board = new int[9][9];
   
   public SudokuBoard(String fileName) {
      try {
         Scanner file = new Scanner(new File(fileName));
         int row = 0;
         while (file.hasNextLine()) {
            String line = file.nextLine();
            for (int i = 0; i < line.length(); i++) {
               board[row][i] = line.charAt(i) == '.' ? 0 : Character.getNumericValue(line.charAt(i));
            }
            row++;
         }
      } catch (FileNotFoundException e) {
         System.out.println("File not found: " + fileName);
      }
   }
   
   public String toString() {
      String result = "";
      for (int r = 0; r < board.length; r++) {
         if (r % 3 == 0 && r != 0)
            result += "--- + --- + ---\n";
         for (int c = 0; c < board[0].length; c++) {
            if (c % 3 == 0 && c != 0)
               result += " | ";
            result += board[r][c] == 0 ? "*" : board[r][c];
         }
         result += "\n";
      }
      return result;
   }
}

/* Exptected output from SudokuMain
  ----jGRASP exec: java SodukuMain
 2** | 1*5 | **3
 *54 | *** | 71*
 *1* | 2*3 | *8*
 --- + --- + ---
 6*2 | 8*7 | 3*4
 *** | *** | ***
 1*5 | 3*9 | 8*6
 --- + --- + ---
 *2* | 7*1 | *6*
 *81 | *** | 24*
 7** | 4*2 | **1
 
 
  ----jGRASP: operation complete.
*/