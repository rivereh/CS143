import java.util.*;

public class JobSim {

   private Stack<String> employed;
   private Queue<String> waitlist;
   private int cycle;

   public JobSim(int workers, int jobs) {
      employed = new Stack<>();
      waitlist = new LinkedList<>();
      cycle = 1;
      int empNum = 1;
      
      for (int i = 0; i < workers; i++)
         if (i < jobs)
            employed.push("Worker #" + empNum++);
         else
            waitlist.add("Worker #" + empNum++);
   }
   
   public String toString() {
      String result = "Employed: " + employed;
      result += "\nWaitlist: " + waitlist;
      return result;
   }
   
   public void cycle() {
      Random r = new Random();
      int roll = r.nextInt(employed.size()) + 1;
      System.out.println("-------Cycle " + cycle++ + "-------");
      System.out.println("Corporate rolls a " + roll);
      System.out.println("---------------------");
      for (int i = 0; i < roll; i++) {
         String emp = employed.pop();
         waitlist.add(emp);
         System.out.println("FIRE:\t" + emp);
      }
      for (int i = 0; i < roll; i++) {
         String emp = waitlist.remove();
         employed.push(emp);
         System.out.println("HIRE:\t" + emp);
      }
   }
}