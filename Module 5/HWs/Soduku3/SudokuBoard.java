// River Hill
// CS 143
// HW #3: Sudoku #3
//
// This class allows us to create a Sudoku board
// which reads in a file to populate it's numerical fields, it
// also allows us to neatly print a representation of the board
// to the console.
// Addition 1: Validating and checking to see if boards are solved
// Addition 2: Ability to solve board using recursive backtracking
// NOTE: In order to see GUI, uncomment the three boardGUI lines and
// also make sure BoardGUI update method accepts int[][] instead
// of char[][] :)

import java.util.*;
import java.io.*;

public class SudokuBoard {
   public final int SIZE = 9;
   protected int[][] board;
   //protected BoardGUI boardGUI;
   
   public SudokuBoard(String fileName) {
      board = new int[SIZE][SIZE];
      //boardGUI = new BoardGUI(SIZE);
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
   
   public boolean solve() {
      if (!isValid())
         return false;
      else if (isSolved())
         return true;
      
      for (int r = 0; r < board.length; r++)
         for (int c = 0; c < board[0].length; c++)
            if (board[r][c] == 0)
               for (int i = 1; i <= 9; i++) {
                  board[r][c] = i;
                  //boardGUI.update(board);
                  if (solve())
                     return true;
                  board[r][c] = 0;
               }
      return false;
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

/* Exptected output from SudokuSolverEngine
  ----jGRASP exec: java -ea SudokuSolverEngine
 Initial board
 *34 | 678 | 912
 *72 | 195 | 348
 198 | 342 | 567
 --- + --- + ---
 **9 | *61 | 423
 *26 | 853 | 791
 *13 | 924 | *56
 --- + --- + ---
 *61 | 537 | 284
 *8* | 419 | 635
 345 | *86 | 179
 
 
 Solving board...SOLVED in 1.353 seconds.
 
 534 | 678 | 912
 672 | 195 | 348
 198 | 342 | 567
 --- + --- + ---
 859 | 761 | 423
 426 | 853 | 791
 713 | 924 | 856
 --- + --- + ---
 961 | 537 | 284
 287 | 419 | 635
 345 | 286 | 179
 
  ----jGRASP: operation complete.
*/