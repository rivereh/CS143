
public class SudokuSolverEngine {

   public static void main(String[] args) {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      SudokuBoard board = new SudokuBoard("boards/very-fast-solve.sdk");
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println();
      
      if (board.isSolved())
         System.out.println("Board is already solved");
      else if (!board.isValid())
         System.out.println("Board is invalid");
      else {
         System.out.print("Solving board...");
         long start = System.currentTimeMillis();
         board.solve();
         long stop = System.currentTimeMillis();
         System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
         System.out.println();
         System.out.println(board);
      }
      
   }
}