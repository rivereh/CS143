import java.util.*;

public class TestMain {
   
   
   public static void main(String[] args) {
      // Map<String, String> map = new TreeMap();
//       map.put("Hello", "World");
//       map.put("cool", "beans");
//       Map<String, String> newMap = reverse(map);
//       System.out.println(newMap);

      Stack<Integer> stack = new Stack<>();
      stack.push(3);
      stack.push(5);
      stack.push(40);
      stack.push(10);
      stack.push(3);
      stack.push(40);
      // System.out.println(stack);
// 
//       System.out.println("max: " + removeMax(stack));
//       System.out.println(stack);



      LinkedList
      
   }


   public static <V, K> Map<V, K> reverse(Map<K, V> map) {
       Map<V, K> newMap = new HashMap<>();
   
       for (K key : map.keySet()) {
           newMap.put(map.get(key), key);
       }
       return newMap;
   }
   
   public static int removeMax(Stack<Integer> stack) {
      Queue<Integer> queue = new LinkedList<>();
      int max = Integer.MIN_VALUE;
      // find max in stack while adding each value to queue
      while (!stack.isEmpty()) {
         int num = stack.pop();
         if (num > max)
            max = num;
         queue.add(num);
      }
      // readd all values from queue except max to stack
      while (!queue.isEmpty()) {
         int num = queue.remove();
         if (num != max)
            stack.push(num);
      }
      // readd values to queue and then stack to revert
      // back to original order
      while (!stack.isEmpty())
         queue.add(stack.pop());
      while (!queue.isEmpty())
         stack.push(queue.remove());    
      return max;
   }




}