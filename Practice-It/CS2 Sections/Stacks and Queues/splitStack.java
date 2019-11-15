/*
   Write a method splitStack that takes a stack of integers as a parameter
   and splits it into negatives and non-negatives. The numbers in the stack
   should be rearranged so that all the negatives appear on the bottom of
   the stack and all the non-negatives appear on the top. In other words, 
   if after this method is called you were to pop numbers off the stack, 
   you would first get all the nonnegative numbers and then get all the 
   negative numbers. It does not matter what order the numbers appear in 
   as long as all the negatives appear lower in the stack than all the 
   non-negatives. You may use a single queue as auxiliary storage. 
*/

import java.util.*;

public class splitStack {
   public static void splitStack(Stack<Integer> s) {
      Queue<Integer> q = new LinkedList<>();
      int negatives = 0;
      
      // add each number to queue
      // and count total negatives
      while (!s.isEmpty()) {
         if (s.peek() < 0)
            negatives++;
         q.add(s.pop());
      }
      
      // go through queue, if
      // negative add to stack
      // if positive readd to queue
      while (negatives > 0) {
         if (q.peek() < 0) {
            s.push(q.remove());
            negatives--;
         } else
            q.add(q.remove());
      }
      
      // add remaining positives to stack
      while (!q.isEmpty())
         s.push(q.remove());  
   }
   
   public static void main(String[] args) {
      Random r = new Random();
      
      splitStack split = new splitStack();
      Stack<Integer> stack = new Stack<>();
      
      for (int i = 1; i <= 5; i++) {
         for (int j = 0; j < 10; j++)
            stack.push(r.nextInt(21) - 10);
         System.out.println("Stack " + i + " before: " + stack);
         split.splitStack(stack);
         System.out.println("Stack " + i + " after : " + stack + "\n");
         stack.clear();
      }
   }
}