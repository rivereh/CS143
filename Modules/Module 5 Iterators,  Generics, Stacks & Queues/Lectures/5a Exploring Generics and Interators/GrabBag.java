/*
   This class is used to make a group of data where you can
   `grab` a random value.
   @author Crystal Hess 10/29/2019
*/

import java.util.*;

public class GrabBag<E> implements Iterable<E> {
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
   
   public Iterator<E> iterator() {
      return new GrabBagIterator<E>();
   }
   
   private class GrabBagIterator<E> implements Iterator<E> {
      private int currentIndex = 0;
      
      @Override
      public boolean hasNext() {
         return currentIndex < bag.size();
      }
      
      @Override
      public E next() {
         return (E)bag.get(currentIndex++);
      }
      
      @Override
      public void remove() {
         throw new UnsupportedOperationException("Don't use remove on an interator.");
      }
   }
}