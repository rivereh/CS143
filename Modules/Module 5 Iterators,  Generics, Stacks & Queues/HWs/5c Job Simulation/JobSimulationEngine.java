import java.util.*;

public class JobSimulationEngine {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      // Start a simulation with 10 workers, 6 jobs
      JobSim simulation = new JobSim(10, 6);
      System.out.println("Before simulation");
      System.out.println(simulation);
      System.out.println();
      
      String again = "";
      do {
         simulation.cycle();
         System.out.println(simulation);
         System.out.println("------------------------------");
         System.out.print("\nPress enter to cycle, anything else to quit...");
         again = console.nextLine();
      } while(again.equals(""));
      
      System.out.println("Simulation Ended");
   }
}
