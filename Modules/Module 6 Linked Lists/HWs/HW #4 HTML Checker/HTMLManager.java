// River Hill
// CS 143
// HW Core Topics: Queues and Stacks
//
// This program will create a queue of html tags and
// fix any tags that are out of order.

import java.util.*;

public class HTMLManager {
   private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> passedTags) {
      tags = new LinkedList<>();
      if (passedTags == null)
         throw new IllegalArgumentException();
      else {
         int size = passedTags.size();
         for (int i = 0; i < size; i++) {
            HTMLTag removed = passedTags.remove();
            tags.add(removed);
            passedTags.add(removed);
         }
      }
   }
   
   // return list of opening and self closing tags being managed
   // in the tags Queue
   public Queue<HTMLTag> getTags() {
      Queue<HTMLTag> managedTags = new LinkedList<>();
      int size = tags.size();
      for (int i = 0; i < size; i++) {
         HTMLTag tag = tags.remove();
         if (tag.isOpening() || tag.isSelfClosing())
            managedTags.add(tag);
         tags.add(tag);
      }
      return managedTags;
   }
   
   public void fixHTML() {
      Stack<HTMLTag> stack = new Stack<>();
      int size = tags.size();
      for (int i = 0; i < size; i++) {
         HTMLTag tag = tags.remove();
         // if tag is opening or self closing add to stack and readd to tags
         if (tag.isOpening()) { 
            tags.add(tag);
            stack.push(tag);
         } else if (tag.isSelfClosing())
            tags.add(tag);
         else
            // otherwise if tag is closing and matches the top of stack then add
            // closing tag to tags Queue
            if (!stack.isEmpty()) // make sure not to peek into an empty stack
               if (tag.matches(stack.peek())) {
                  tags.add(tag);
                  stack.pop();
               }
      }
      while (!stack.isEmpty()) // add opposite of remaining tags in stack to tags Queue
         tags.add(stack.pop().getMatching());
   }
   
   public String toString() {
      int size = tags.size();
      String result = "";
      for (int i = 0; i < size; i++) {
         HTMLTag tag = tags.remove();
         result += tag.toString().trim();
         tags.add(tag);
      }
      return result;
   }
}

/*
  ----jGRASP exec: java -ea HTMLChecker
 ===============================
 Processing tests/test1.html...
 ===============================
 HTML: <b><i><br /></b></i>
 Checking HTML for errors...
 HTML after fix: <b><i><br /></i></b>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test2.html...
 ===============================
 HTML: <a><a><a></a>
 Checking HTML for errors...
 HTML after fix: <a><a><a></a></a></a>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test3.html...
 ===============================
 HTML: <br /></p></p>
 Checking HTML for errors...
 HTML after fix: <br />
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test4.html...
 ===============================
 HTML: <div><div><ul><li></li><li></li><li></ul></div>
 Checking HTML for errors...
 HTML after fix: <div><div><ul><li></li><li></li><li></li></ul></div></div>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test5.html...
 ===============================
 HTML: <div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>
 Checking HTML for errors...
 HTML after fix: <div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>
 ----> Result matches Expected Output!
 
 ===============================
         All tests passed!
 ===============================
 
  ----jGRASP: operation complete.
*/  