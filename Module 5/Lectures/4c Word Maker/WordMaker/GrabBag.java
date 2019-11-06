/*
   This class is used to make a group of data where you can
   `grab` a random value.
   @author Crystal Hess 10/29/2019
*/

import java.util.*;

public class GrabBag<E> {
   private ArrayList<E> bag;

   public GrabBag() {
      bag = new ArrayList<E>();
   }
   
   public void add(E data) {
      bag.add(data);
   }
   
   public E grab() {
      Random r = new Random();
      E removed = bag.remove(r.nextInt(bag.size()));
      return removed;
   }
   
   public boolean isEmpty() {
      return bag.size() == 0;
   }
   
   public String toString() {
      return bag.toString();
   }
}