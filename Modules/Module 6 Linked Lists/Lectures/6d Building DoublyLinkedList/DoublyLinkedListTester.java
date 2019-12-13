import java.util.Scanner;

public class DoublyLinkedListTester {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      DoublyLinkedList<Character> dllist = new DoublyLinkedList<>();
      System.out.println(dllist);
      
      String option = "";
      do {
         option = displayOptions(console);
         if(option.startsWith("ai")) {
            System.out.print("Add at what index? > ");
            int index = console.nextInt(); console.nextLine(); // skips newline char after int
            System.out.print("Add what? > ");
            char value = console.nextLine().charAt(0);
            dllist.add(index, value);
         } else if(option.startsWith("a")) {
            System.out.print("Add What? > ");
            dllist.add(console.nextLine().charAt(0));
         } else if(option.startsWith("g")) {
            System.out.print("Get what index? > ");
            char got = dllist.get(console.nextInt()); console.nextLine(); // skips newline char after int
            System.out.println("--- Got " + got + " ---");
         } else if(option.startsWith("io")) {
            System.out.print("Index of what? > ");
            char value = console.nextLine().charAt(0);
            int index = dllist.indexOf(value);
            if(index > 0)
               System.out.println("--- Found at index: " + index + " ---");
            else
               System.out.println("--- Not found ---");
         } else if(option.startsWith("ri")) {
            System.out.print("Remove what index? > ");
            char removed = dllist.remove(console.nextInt()); console.nextLine(); // skips newline char after int
            System.out.println("--- Removed " + removed + " ---");
         } else if(option.startsWith("p")) {
            System.out.println("Printing with the iterator: ");
            for(char c : dllist) {
               System.out.println(c);
            }
         }
         System.out.println(dllist);
      } while(!option.startsWith("d"));
      
   }
   
   public static String displayOptions(Scanner console) {
      System.out.println("\nOptions: (a) add to the end (ai) add at index (io) indexOf a value");
      System.out.println("         (g) get by index  (ri) remove at index (p) print with iterator (d) done");
      System.out.print("What do? > ");
      return console.nextLine().toLowerCase();
   }
}