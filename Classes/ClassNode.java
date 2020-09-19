public class ClassNode {
   private int item;
   private ClassNode next;
   
   
   
   private void setup(int item, ClassNode next) {
      this.next = next;
      this.item = item;
   }
   
   public ClassNode(int item) {
      setup(item, null);
   }
   
   public ClassNode(int item, ClassNode next) {
      setup(item, next);
   }
   
   public ClassNode(ClassNode next) {
      setup(0, next);
   }
  
   public ClassNode() {
      setup(0, null);
   }
   
   public void setNext(ClassNode next) {
      this.next = next;
   }
   
   public void setItem(int item) {
      this.item = item;
   }
   
   public void printList() {
      System.out.println(item);
      if (next == null)
         return;
      else next.printList();
   }
   
   public void insertBefore(int val, ClassNode newItem) {
      if (item == val) {
         newItem.next = this;
         return;
      }
      else if (next == null) 
         return;
      else if (next.item == val) {
         newItem.next = this.next;
         this.next = newItem;
         return;
      }
      else next.insertBefore(val, newItem);
   }
   
   public static void insertBefore(ClassNode head, int val, ClassNode newItem) {
      if (head == null)
         return;
      else {
         for(ClassNode test = head; test.next != null; test = test.next) {
            
            if (test.item == val) {
               newItem.next = test;
               return;
            }
            else if (test.next == null)
               return;
            else if (test.next.item == val) {
               newItem.next = test.next;
               test.next = newItem;
               return;
            }
         }
      }
   } 
   
   public static void main(String[] args) {
   
      ClassNode test1 = new ClassNode(1);
      ClassNode test2 = new ClassNode(3);
      ClassNode test3 = new ClassNode(5);
      ClassNode test4 = new ClassNode(7);
      ClassNode test5 = new ClassNode(9);
      ClassNode test6 = new ClassNode(8);
      
      test1.setNext(test2);
      test2.setNext(test3);
      test3.setNext(test4);
      test4.setNext(test5);
      
      insertBefore(test1, 7, test6);
      
      test1.printList();
   }
}