/*
MyStack<E>()   Constructs a new stack with elements of type E 
push(val)      Places val on top of the stack
pop()          Removes top value from the stack and returns it; throws NoSuchElementException if stack is empty
peek()         Returns top value from the stack without removing it; throws NoSuchElementException if stack is empty
isEmpty()      Returns true if the stack has no elements
size()         Returns the number of elements in the stack
*/

import java.util.*;

public class MyStack<E> {
   private ArrayList<E> data;

   public MyStack() {
      data = new ArrayList<>();
   }
   
   public void push(E val) {
      data.add(val);
   }
   
   public E pop() {
      if (isEmpty())
         throw new NoSuchElementException("Stack is empty; can't pop");
      return data.remove(data.size() - 1);
   }
   
   public E peek() {
      if (isEmpty())
         throw new NoSuchElementException("Stack is empty; can't pop");
      return data.get(data.size() - 1);
   }
   
   public boolean isEmpty() {
      return data.size() == 0;
   }
   
   public int size() {
      return data.size();
   }
   
   public String toString() {
      return data.toString();
   }
}