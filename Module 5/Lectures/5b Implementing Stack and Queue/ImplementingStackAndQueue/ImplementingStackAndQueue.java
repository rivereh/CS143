import java.util.*;

public class ImplementingStackAndQueue {

   public static void main(String[] args) {
      MyStack<Integer> stack = new MyStack<>(); 
      //Stack<Integer> stack = new Stack<>(); // <---- Java version
      MyQueue<Integer> queue = new MyQueue<>();
      //Queue<Integer> queue = new LinkedList<>(); // <- Java version
      
      Random r = new Random();
      Scanner console = new Scanner(System.in);
      
      String again = "";
      do {
         System.out.print("add, remove, or end? > ");
         again = console.nextLine().toLowerCase();
         if(again.startsWith("a")) {
            int x = r.nextInt(1000) + 1;
            stack.push(x);
            queue.add(x);
         }
         else if(again.startsWith("r")) {
            stack.pop();
            queue.remove();
         }
         System.out.println("stack = " + stack);
         //System.out.println("Top of stack is " + stack.peek());
         System.out.println("queue = " + queue);
      } while(again.startsWith("a") || again.startsWith("r"));
   
   }

}