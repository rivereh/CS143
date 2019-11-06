// River Hill
// CS 143
// HW #1: Sudoku #2
//
// This object class will allow us to create a Sudoku board
// which reads in a file to populate it's numerical fields, it
// also allows us to neatly print a representation of the board
// to the console.
// Newest Addition: Validating and checking to see if boards are solved

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
   
   public boolean isValid() {
      return checkValidData() && checkRows() && checkCols() && checkMiniSquares();
   }
   
   private boolean checkValidData() {
      Set<Integer> validData = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
      Set<Integer> boardData = new HashSet<>();
      for (int[] row : board)
         for (int num : row)
            boardData.add(num);
      boardData.removeAll(validData);
      return boardData.size() == 0;
   }
   
   // creates a row HashSet and iterates through each row.
   // if current element is in the HashSet return false,
   // otherwise add it to the HashSet
   private boolean checkRows() {  
      for (int[] row : board) {
         Set<Integer> setRow = new HashSet<>();
         for (int num : row)
            if (setRow.contains(num) && num != 0)
               return false;
            else   
               setRow.add(num);
      }
      return true;
   }
   
   private boolean checkCols() {
      for (int c = 0; c < board.length; c++) {
         Set<Integer> setCol = new HashSet<>();
         int[] checkCol = getCol(c);
         for (int num : checkCol)
            if (setCol.contains(num) && num != 0)
               return false;
            else
               setCol.add(num);
      }
      return true;
   }
   
   private int[] getCol(int i) {
      int[] col = new int[board.length];
      for (int r = 0; r < board.length; r++)
         col[r] = board[r][i];
      return col;
   }
   
   private boolean checkMiniSquares() {
      for (int i = 1; i <= board.length; i++) {
         Set<Integer> setSquare = new HashSet<>();
         int[][] checkSquare = miniSquare(i);
         for (int[] row : checkSquare)
            for (int num : row) {
               if (setSquare.contains(num) && num != 0)
                  return false;
               else
                  setSquare.add(num);
         }
      }
      return true;
   }
   
   // from Crystal
   private int[][] miniSquare(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }
   
   // modified from Crystal's HW #3 starter files
   public boolean isSolved() {
      if (!isValid())
         return false;
      Map<Integer, Integer> map = new HashMap<>();
      for (int[] row : board)
         for (int num : row)
            if (map.containsKey(num))
               map.put(num, map.get(num) + 1);
            else
               map.put(num, 1);
      // info on Collections: https://docs.oracle.com/javase/8/docs/api/?java/util/Collections.html
      return map.keySet().size() == 9 && Collections.frequency(map.values(),9) == 9;
   }
}

/* Exptected output from SudokuCheckerEngineV2
  ----jGRASP exec: java -ea SudokuCheckerEngineV2
 Checking empty board...passed.
 Checking incomplete, valid board...passed.
 Checking complete, valid board...passed.
 Checking dirty data board...passed.
 Checking row violating board...passed.
 Checking col violating board...passed.
 Checking row&col violating board...passed.
 Checking mini-square violating board...passed.
 **** HORRAY: ALL TESTS PASSED ****
 
  ----jGRASP: operation complete.
*/