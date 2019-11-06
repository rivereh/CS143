import java.util.*;

public class ExploringGenerics {

   public static void main(String[] args) {
      //ArrayIntList numbers = new ArrayIntList();
      MyArrayList<Double> numbers = new MyArrayList<>();
      
      System.out.println(numbers);
      for(int i = 1; i <= 5; i++) {
         numbers.add(i * 1.5);
      }
      System.out.println(numbers);
      numbers.add(25.5);
      numbers.remove(0);
      numbers.remove(3);
      System.out.println(numbers);
   }

}