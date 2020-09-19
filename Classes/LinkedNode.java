public class LinkedNode {
   private int val;
   private LinkedNode next;
   
   private setup(int value, LinkedNode nex) {
      val = value;
      next = next;
   }
   
   
   public boolean containsSum(int total) {
      if (val == total) 
         return true;
      else if (next == null) 
         return false;
   
   }
}