public class WritingRecursiveMethods {

   /*
      Write a recursive method called digitProduct, that takes an 
      integer n as a parameter and returns the product of all non-zero 
      digits of n. If passed a negative number, the method should return 
      the negative product of the digits. 
   */
   // digitProduct(0) = 1 <---------------------------------------- base case
   // digitProduct(62) = 2 * digitProduct(6)
   // digitProduct(6) = 6 * digitProduct(0)
   // digitProduct(n) = n % 10 * digitProduct(Math.abs(n / 10)) <-- recursive case
   public static int digitProduct(int n) {
      if (n == 0)
         return 1;
      else
         return n % 10 * digitProduct(Math.abs(n / 10));
   }
   
   /*
      Write a recursive method called pattern that takes as parameters 
      an int n and an int m and that returns a string containing m dots 
      surrounded by n pairs of square brackets (one pair is "[]"). 
   */
   // pattern(0, 0) = "" <----------------------------------------------- base case
   // pattern(n, m) where n > 0, return "[" + pattern(n - 1, m) + "]" <-- recursive 1
   // pattern(n, m) where m > 0, return "." + pattern(n, m - 1) <-------- recursive 2
   public static String pattern(int n, int m) {
      if (n == 0 && m == 0)
         return "";
      else if (n > 0)
         return "[" + pattern(n - 1, m) + "]";
      else
         return "." + pattern(n, m - 1);
   }
   /*
      Write a method commonChars that takes two strings as parameters 
      and that returns a string representing the characters they have 
      in common. The characters that are different between the two 
      strings should be represented by a ".” in the returned string. 
      You can assume the two strings passed in to the method contain 
      no ".” characters.
   */
   public static String commonChars(String s1, String s2) {
      return "";
   }
   
   /*
      Write a method countToBy that takes integer parameters n and m 
      and that produces output indicating how to count to n in 
      increments of m.
   */
   public static void countToBy(int n, int m) {
   }

   public static void main(String[] args) {
      System.out.println("digitProduct(62) = " + digitProduct(62));       // 12
      System.out.println("digitProduct(-151) = " + digitProduct(-151));   // -5
      System.out.println("digitProduct(12345) = " + digitProduct(12345)); // 120
      System.out.println();
      
      System.out.println("pattern(0, 1) = " + pattern(0, 1));     // "."
      System.out.println("pattern(1, 2) = " + pattern(1, 2));     // "[..]"
      System.out.println("pattern(3, 0) = " + pattern(3, 0));     // "[[[]]]"
      System.out.println("pattern(3, 2) = " + pattern(3, 2));     // "[[[..]]]"
      System.out.println();
      
      System.out.print("\ncommonChars(\"foo\", \"oof\") = " + commonChars("foo", "oof"));                // ".o."
      System.out.print("\ncommonChars(\"dog person\", \"cat perSon\") = " + commonChars("dog person", "cat perSon"));  // "... per.on"
      System.out.print("\ncommonChars(\"hello\", \"jello\") = " + commonChars("hello", "jello"));            // ".ello"
      System.out.println();
      
      System.out.print("\ncountToBy(34, 5) = ");
      countToBy(34, 5);     // 4, 9, 14, 19, 24, 29, 34 
      System.out.print("\ncountToBy(3, 6) = ");
      countToBy(3, 6);      // 3
      System.out.print("\ncountToBy(17, 3) = "); 
      countToBy(17, 3);     // 2, 5, 8, 11, 14, 17
      System.out.println("\n"); 
   }
   
}