import java.io.*;
import java.util.*;

public class SyntaxChecker {
	private List<String> expressions;
   private static final Map<String,String> SYNTAX = known();

   // allows the syntax checker to be used with a file
	public SyntaxChecker() {
		expressions = new ArrayList<String>();
   }

   // loads all the expressions from filename into `expressions`
   // to be checked later
	public SyntaxChecker(String filename) {
		expressions = new ArrayList<String>();
		try {
         Scanner fileIn = new Scanner(new File(filename));
			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
				expressions.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
   
   // stores the known syntax matching in `SYNTAX`
   private static Map<String,String> known() {
      Map<String, String> map = new HashMap<>();
      map.put("<", ">");
      map.put("(", ")");
      map.put("[", "]");
      map.put("{", "}");
      return map;
   }

	// checkExpressions method determines if the expression
	// has a closing symbol for every opening symbol
   /*
      for each character in the expression
         if you have an opening symbol
            push it on the stack
         else if it is a closing symbol
       	   if the stack of opening symbols is empty
       	      return false 
            endif
       	   pop a value from the opening symbol stack 
            if the open symbol doesnít match the close symbol
               return false
            endif
          endif
      endfor
      return true if the stack is empty (all opening symbols had a closing symbol)
   */
	public boolean checkExpression(String exp) {
      Stack<String> stack = new Stack<>();
      for (char c : exp.toCharArray()) {
         String symbol = c + "";
         if (SYNTAX.keySet().contains(symbol))
            stack.push(symbol);
         else if (SYNTAX.values().contains(symbol)) {
            if (stack.isEmpty())
               return false;
            String popped = stack.pop();
            if (!symbol.equals(SYNTAX.get(popped)))
               return false;
         }
      }
      return stack.isEmpty();
	}

   // goes through all the loaded expressions and
   // checks their syntax
	public String toString() {
		String result = "Syntax Checking... \n";
      if(expressions.size() == 0) { result += "No expressions to check."; }
      
		for (String s : expressions) {
			if (checkExpression(s))
				result += "  valid -> " + s + "\n";
			else
				result += "INVALID -> " + s + "\n";
		}
      
		return result;
	}

	public static void main(String[] args) {
		SyntaxChecker check = new SyntaxChecker("expressions.txt");
		System.out.println(check);
	}
}
