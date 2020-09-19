/* Name: Jalil Morris
 *
 * Net ID: jim33
 *
 * Execution: java Tour
 *
 * Create a tour using a given set of points
 *
 */

public class Tour { 
   private Node head;
   private Node lastNode;
   
   public Tour() {
      head = null;
      lastNode = null;
   }
   
   public String toString() {
      String tourString = "";
      if (head == null) 
         return tourString;
      else if (head.size() != 0) tourString += head.toString();
      return tourString + "\n";
   }
   
   public void insertInOrder(Point p) {
      if (head == null) {
         lastNode = new Node(p);
         head = new Node(p, lastNode);
      }
      else {
         for (Node insert = head; true; insert = insert.getNext()) {
            if (insert.getNext() == lastNode) {
               Node placeholder = new Node(p, lastNode);
               insert.setNext(placeholder);
               return;
            }
         }
      }
   }
   
   public void insertNearest(Point p) {
      if (head == null) {
         lastNode = new Node(p);
         head = new Node(p, lastNode);
      }
      else {
         double distance = 0;
         for (Node insert = head; insert.getNext() != null; 
                  insert = insert.getNext()) {
            Point pointHolder = insert.getPoint();
            double move = pointHolder.distanceTo(p);
            if (insert == head) distance = move;
            else if (move < distance) distance = move;
         }
         for (Node insert = head; insert.getNext() != null; 
                  insert = insert.getNext()) {
            Point pointHolder = insert.getPoint();
            double move = pointHolder.distanceTo(p);
            if (move == distance) {
               Node placeholder = new Node(p, insert.getNext());
               insert.setNext(placeholder);
               return;
            }
         }
      }
   }
   
   public void shortestDetour(Point p) {
      if (head == null) {
         lastNode = new Node(p);
         head = new Node(p, lastNode);
      }
      else {
         double distance = 0;
         for (Node insert = head; insert.getNext() != null; 
                  insert = insert.getNext()) {
            Point initial = insert.getPoint();
            Point last = insert.getNext().getPoint();
            double move = initial.distanceTo(p) + p.distanceTo(last) - 
                              initial.distanceTo(last);
            if (insert == head) distance = move;
            else if (move < distance) distance = move;
         }
         for (Node insert = head; insert.getNext() != null; 
                  insert = insert.getNext()) {
            Point initial = insert.getPoint();
            Point last = insert.getNext().getPoint();
            double move = initial.distanceTo(p) + p.distanceTo(last) -
                              initial.distanceTo(last);
            if (move == distance) {
               Node placeholder = new Node(p, insert.getNext());
               insert.setNext(placeholder);
               return;
            }
         }
      }
   }
   
   
   public int size() { // returns number of points in tour
      if (head == null) 
         return 0;
      return head.size();
   }
   
   public double distance() {
      if (head == null) 
         return 0;
      return head.distance();
   }
   
   public void draw(Point p) {
      if (head == null)
         return;
      for (Node image = head; image.getNext() != null; 
               image = image.getNext()) {
         if (image.getPoint() == p || image.getNext().getPoint() == p) {
            PennDraw.setPenColor(255, 0, 0);
            Point initial = image.getPoint();
            Node next = image.getNext();
            initial.drawTo(next.getPoint());
         }
         else {
            PennDraw.setPenColor(0, 0, 0);
            Point initial = image.getPoint();
            Node next = image.getNext();
            initial.drawTo(next.getPoint());
         }
      }
   }
   
   
   public static void main(String[] args) {
      //PennDraw.setScale(0, 10);
      Tour test = new Tour();
      Point pt1 = new Point(0, 0);
      Point pt2 = new Point(1, 0);
      Point pt3 = new Point(1, 1);
      Point pt4 = new Point(0, 1);
      //Point pt5 = new Point(3, 3);
      //Point pt6 = new Point(9, 3);
      test.insertInOrder(pt1);
      test.insertInOrder(pt2);
      test.insertInOrder(pt3);
      test.insertInOrder(pt4);
      //test.insertNearest(pt5);
      //test.shortestDetour(pt6);
      String str = test.toString();
      System.out.println(str);
      //System.out.println(test.size());
      //System.out.println(test.distance());
      //test.draw(pt1);
   }
}