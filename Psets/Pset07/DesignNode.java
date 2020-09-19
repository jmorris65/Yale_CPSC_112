/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java DesignNode
 *
 * Class to create node that holds body part selections
 *
 */

public class DesignNode {
   private Body partB; // variables to hold body parts
   private Wing partW;
   private Shooter partS;
   private DesignNode next;
   
   // helper function for constructor
   private void setup(Body b, Wing w, Shooter s) {
      partB = b;
      partW = w;
      partS = s;
      next = null;
   }
   
   // constructor no arguments 
   public DesignNode() {
      setup(null, null, null);
   }
   
   // following 3 constructors set value for one body part
   public DesignNode(Body b) {
      setup(b, null, null);
   }
   
   public DesignNode(Wing w) {
      setup(null, w, null);
   }
   
   public DesignNode(Shooter s) {
      setup(null, null, s);
   }
   
   // following 3 constructors return body parts
   public Body getBody() {
      return partB;
   }  
 
   public Wing getWing() {
      return partW;
   }
 
   public Shooter getShooter() {
      return partS;
   }
   
   // returns next node
   public DesignNode getNext() {
      return next;
   }
   
   // sets next node
   public void setNext(DesignNode n) {
      next = n;
   }
}