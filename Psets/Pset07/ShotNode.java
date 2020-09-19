   /* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java ShotNode
 *
 * Class to create node that holds current shot positions 
 *
 */
 
public class ShotNode {
   private double x; // current x position
   private double y; // current y position
   private ShotNode next;  
   private boolean compShot; // is this shot by a CPU
   
   // constructors creates a shotnode using position and who shot
   public ShotNode(double xcoord, double ycoord, boolean who) {
      x = xcoord;
      y = ycoord;
      compShot = who;
      next = null;
   }
   
   // function returns if this is a CPU
   public boolean compShot() {
      return compShot;
   }
   
   // function sets next shot
   public void setNext(ShotNode n) {
      next = n;
   }
   
   // function gets x position
   public double getX() {
      return x;
   }
   
   // function gets y position 
   public double getY() {
      return y;
   }
   
   // function gets next node 
   public ShotNode getNext() {
      return next;
   }
   
   // function moves shot (only in y direction)
   public void incrementY() {
      if (compShot())
         y -= 4;
      else
         y += 4;
   }
   
   // function sets the y position
   public void setY(double ycoord) {
      y = ycoord;
   }
}