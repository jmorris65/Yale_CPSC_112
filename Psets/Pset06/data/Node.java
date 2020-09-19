public class Node {
   private Point data;
   private Node next;
   public Node(Point p, Node next) {
      data = p;
      this.next = next;
   }
   public Node(Point p) {
      data = p;
      next = null;
   }
   public Point getPoint() {
      return data;
   }
   public Node getNext() {
      return next;
   }
   public void setNext(Node n) {
      next = n;
   }
   public String toString() {
      String str = data.toString();
      if (next != null)
         str += "\n" + next.toString();
      return str;
   }
   
   public int size() { // returns number of points in tour
      int number = 0;
      if (next != null) {
         number = 1 + next.size();
      }
      return number;
   }
   
   public double distance() {
      double distance = 0.0;
      for (Node runner = this; runner.next != null; runner = runner.next)
         distance += runner.data.distanceTo(runner.next.data);
      return distance;
   }
 
   public static void main(String[] args) {
      Point pt1 = new Point(-1, -1);
      Node n1 = new Node(pt1);
      
      Node n2 = new Node(pt1);
      
      for (int i = 0; i < 10; i++) {
         if (i == 0) {
            Point pt2 = new Point(i, i);
            n2 = new Node(pt2);
            n1.setNext(n2);
         }
         else {
            Point pt3 = new Point(i, i);
            Node n3 = new Node(pt3);
            n2.setNext(n3);
            n2 = n3;
         }
      }
      
      String test = n1.toString();
      System.out.println(test);
   }
}