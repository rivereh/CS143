import java.util.Scanner;

public class LinkedListTester {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      LinkedIntList llist = new LinkedIntList();
      System.out.println(llist + " size=" + llist.size());
      
      String option = "";
      do {
         option = displayOptions(console);
         if(option.startsWith("af")) {
            System.out.print("Add what? > ");
            llist.addFront(console.nextInt());
         } else if(option.startsWith("ae")) {
            System.out.print("Add what? > ");
            llist.addEnd(console.nextInt());
         } else if(option.startsWith("rf")) {
            int removed = llist.removeFront();
            System.out.println("Removed " + removed);
         } else if(option.startsWith("re")) {
            int removed = llist.removeEnd();
            System.out.println("Removed " + removed);
         }
         System.out.println(llist + " size=" + llist.size());
      } while(!option.startsWith("d"));
   }
   
   public static String displayOptions(Scanner console) {
      System.out.println("\nOptions: (af) add to front (ae) add to end (rf) remove front (re) remove end (d) done");
      System.out.print("What do? > ");
      return console.next().toLowerCase();
   }
}