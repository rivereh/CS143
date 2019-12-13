import java.util.Scanner;

public class LinkedListTesterV2 {
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
         } else if(option.startsWith("g")) {
            System.out.print("Get what index? > ");
            int got = llist.get(console.nextInt());
            System.out.println("Got " + got);
         } else if(option.startsWith("s")) {
            System.out.print("Set what index? > ");
            int index = console.nextInt();
            System.out.print("To what? > ");
            int value = console.nextInt();
            llist.set(index, value);
         } else if(option.startsWith("ai")) {
            System.out.print("Add at what index? > ");
            int index = console.nextInt();
            System.out.print("Add what? > ");
            int value = console.nextInt();
            llist.add(index, value);
         } else if(option.startsWith("ri")) {
            System.out.print("Remove what index? > ");
            int removed = llist.remove(console.nextInt());
            System.out.println("Removed " + removed);
         }
         System.out.println(llist + " size=" + llist.size());
      } while(!option.startsWith("d"));
   }
   
   public static String displayOptions(Scanner console) {
      System.out.println("\nOptions: (af) add to front (ae) add to end (rf) remove front (re) remove end ");
      System.out.println("         (g) get by index (s) set by index (ai) add at index (ri) remove at index (d) done");
      System.out.print("What do? > ");
      return console.next().toLowerCase();
   }
}