// River Hill
// CS 143
// HW Core Topics: Linked lists
//
// This program will allow the user to simulate Josephus Permutation
// with a given list of names 

import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode circle;     // a PersonNode pointer that tracks first node
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       
   private PersonNode track;      // a PersonNode pointer to help with elimination

   public JosephusSim(String fileName) {
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         while (file.hasNext()) {
            add(file.next());
         }
         // make the ring circular by attaching last node's next to front
         PersonNode curr = circle;
         while (curr.next != null)
            curr = curr.next;
         curr.next = circle;
         
         // remember the last node as the one in front of the next to get eliminated
         track = curr;
         
         // generate, print, and save the random elimination count
         Random r = new Random();
         eliminationCount = r.nextInt(size / 2) + 1;
         System.out.println("== Elimination count is " + eliminationCount + " ==");
         
      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
      if (size == 0) {
         circle = new PersonNode(val);
         size++;
      }
      else {
         PersonNode curr = circle;
         for (int i = 0; i < size - 1; i++)
            curr = curr.next;
         curr.next = new PersonNode(val);
         size++;
      }
   }
   
   public void eliminate() {
      // count to the elimination count
      for (int i = 0; i < eliminationCount - 1; i++)
         track = track.next;
      // print who will be eliminated
      System.out.println(track.next.name + " eliminated!");
      
      // eliminate the person and update "front" of the circle and size
      track.next = track.next.next;
      circle = track.next;
          
      size--;
   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return size == 1;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      String result;
      if (size == 1) {
         result = circle.name + " is the last survivor!";
      } else {
         // print the remaining survivors (watch out for infinite loop since list is circular)
         result = "Remaining survivors: ";
         int count = 1;
         result += count++ + "-" + circle.name; 
         PersonNode curr = circle.next;
         for (int i = 1; i < size; i++) {
            result += ", " + count++ + "-" + curr.name;
            curr = curr.next;
         }
      }
      return result;
   }
}

/*
  ----jGRASP exec: java -ea JosephusDriver
 == Elimination count is 4 ==
 Remaining survivors: 1-Muhammad, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal, 6-River, 7-Soham, 8-Leon, 9-Will, 10-Qiao
 
 Continue elimination? <press enter>
 
 Nur eliminated!
 Remaining survivors: 1-Krystal, 2-River, 3-Soham, 4-Leon, 5-Will, 6-Qiao, 7-Muhammad, 8-Beza, 9-Ibrar
 
 Continue elimination? <press enter>
 
 Leon eliminated!
 Remaining survivors: 1-Will, 2-Qiao, 3-Muhammad, 4-Beza, 5-Ibrar, 6-Krystal, 7-River, 8-Soham
 
 Continue elimination? <press enter>
 
 Beza eliminated!
 Remaining survivors: 1-Ibrar, 2-Krystal, 3-River, 4-Soham, 5-Will, 6-Qiao, 7-Muhammad
 
 Continue elimination? <press enter>
 
 Soham eliminated!
 Remaining survivors: 1-Will, 2-Qiao, 3-Muhammad, 4-Ibrar, 5-Krystal, 6-River
 
 Continue elimination? <press enter>
 
 Ibrar eliminated!
 Remaining survivors: 1-Krystal, 2-River, 3-Will, 4-Qiao, 5-Muhammad
 
 Continue elimination? <press enter>
 
 Qiao eliminated!
 Remaining survivors: 1-Muhammad, 2-Krystal, 3-River, 4-Will
 
 Continue elimination? <press enter>
 
 Will eliminated!
 Remaining survivors: 1-Muhammad, 2-Krystal, 3-River
 
 Continue elimination? <press enter>
 
 Muhammad eliminated!
 Remaining survivors: 1-Krystal, 2-River
 
 Continue elimination? <press enter>
 
 River eliminated!
 Krystal is the last survivor!
 
  ----jGRASP: operation complete.
*/