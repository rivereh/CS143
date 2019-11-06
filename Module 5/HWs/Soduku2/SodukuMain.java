public class SodukuMain {
   public static void main(String[] args) {
      SudokuBoard board = new SudokuBoard("board1.sdk");
      //System.out.println(board.getCol(1)); 
      int[] col = board.getCol(1);
      for (int num : col)
         System.out.println(num);     
   }
}