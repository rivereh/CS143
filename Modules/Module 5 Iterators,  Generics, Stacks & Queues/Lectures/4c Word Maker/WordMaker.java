import java.util.*;
import java.io.*;

public class WordMaker {
   private Set<String> words;

   public WordMaker(String filePath) {
      words = new HashSet<>();
      load(filePath);
   }
   
   public void load(String filePath) {
      try {
         // adds all the words in the file to the word set
         Scanner file = new Scanner(new File(filePath));
         while(file.hasNext()) {
            words.add(file.next().toLowerCase());
         }
      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with: " + filePath);
      }
   }
   
   public String makeLexiographically(int length) {
      return makeLexiographically(length, "");
   }
   
   private String makeLexiographically(int length, String word) {
      if(length == word.length() && words.contains(word)) {
         return word;
      }
      if(word.length() < length) {
         for(char c = 'a'; c <= 'z'; c++) {
            word += c;
            String attempt = makeLexiographically(length, word);
            if(!attempt.equals(""))
               return attempt;
            word = word.substring(0, word.length() - 1);
         }
      }
      return "";
   }
   
   public String makeRandomly(int length) {
      return "";
   }
   
   
   public String makeRandomlyNoRepeats(int length) {
      return "";
   }
   
   public String toString() {
      return "This is a word maker object.";
   }
}