/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java Invader
 *
 * Class to create invader using body part designs
 *
 */

public class Invader {
   private Body partB; // variables containing body parts
   private Wing partW;
   private Shooter partS;
   private double currentX; // current position
   private double currentY;
   private HitBox boxT; // two hitboxes to represent the invade body
   private HitBox boxB;
   private boolean alive = true; // always alive at first
   private boolean CPU; // is a computer controlled invader
   
   // helper function to create invader
   private void setup(DesignNode node) {
      if (node == null)
         return;
      if (node.getBody() != null) {
         partB = node.getBody();
      }
      else if (node.getWing() != null) {
         partW = node.getWing();
      }
      else if (node.getShooter() !=  null) {
         partS = node.getShooter();
      }
      setup(node.getNext());
   }
   
   // creates invader using user input nodes
   public Invader(DesignNode node) {
      boxB = new HitBox(12.75, 5.5);
      boxT = new HitBox(9, 5.5);
      CPU = false;
      setup(node);
   }
   
   // creates a randomly generated invader (for CPUs)
   public Invader() {
      boxT = new HitBox(12.75, 5.5);
      boxB = new HitBox(9, 5.5);
      CPU = true;
      Body random1 = new Body();
      Wing random2 = new Wing();
      Shooter random3 = new Shooter();
      random2.setOrientation(1);
      random3.setOrientation(1);
      DesignNode hold1 = new DesignNode(random1);
      DesignNode hold2 = new DesignNode(random2);
      DesignNode hold3 = new DesignNode(random3);
      hold1.setNext(hold2);
      hold2.setNext(hold3);
      setup(hold1);
   }
   
   // function returns hitboxes
   public HitBox[] getHitBoxes() {
      HitBox[] a = {boxT, boxB};
      return a;
   }
   
   // function sets alive to false and places the invader outside 
   public void kill() {
      alive = false;
      setPosition(500, 500);
   }
   
   // resurrect the hero (only for end animation)
   public void rez() {
      alive = true;
      setPosition(0, 0);
   }
   
   // function sets position of invader
   public void setPosition(double x, double y) {
      partB.setPosition(x, y);
      partW.setPosition(x, y);
      partS.setPosition(x, y);
      boxB.setPosition(x, y - 2.75);
      boxT.setPosition(x, y + 2.75);
      currentX = x;
      currentY = y;
   }
   
   // returns if invader is currently alive or not
   public boolean isAlive() {
      return alive;
   }
   
   // function returns hitbox Y range
   public double[] getYRange() {
      double [] a = boxT.getYRange();
      double [] b = boxB.getYRange();
      double [] c = {a[0], a[1], b[0], b[1]};
      return c;
   }
   
   // function returns hitbox X range
   public double[] getXRange() {
      double [] a = boxT.getXRange();
      double [] b = boxB.getXRange();
      double [] c = {a[0], a[1], b[0], b[1]};
      return c;
   }
   
   // function returns current Y position
   public double getY() {
      return currentY;
   }
   
   // function returns current X position
   public double getX() {
      return currentX;
   }
   
   // increments invaders current position by small amount
   private void move(int direction) {
      if (!alive)
         return;
      if (direction == 0) {
         double x = 0;
         if (CPU) x = currentX - 1.5;
         else x = currentX - 4;
         if (x < 5) x = 5;
         setPosition(x, currentY);  
      }
      else if (direction == 1) {
         double y = 0;
         if (CPU) y = currentY + 1.5;
         else y = currentY + 4;
         if (y > 200) y = 200;
         setPosition(currentX, y);
      }
      else if (direction == 2) {
         double x = 0;
         if (CPU) x = currentX + 1.5;
         else x = currentX + 4;
         if (x > 200) x = 200;
         setPosition(x, currentY);
      }
      else if (direction == 3) {
         double y = 0;
         if (CPU) y = currentY - 1.5;
         else y = currentY - 4;
         if (y < 5) y = 5;
         setPosition(currentX, y);
      }
   }
   
   // following four functions move invader in indicated direction
   public void moveLeft() {
      move(0);
   }
   
   public void moveUp() {
      move(1);
   }
   
   public void moveRight() {
      move(2);
   }
   
   public void moveDown() {
      move(3);
   }
   
   // function draws the invader on the screen if its alive
   public void drawInvader() {
      if (!alive)
         return;
      partB.drawBody();
      partW.drawWings();
      partS.drawShooters();
   }
   
   // function returns position of start of shot 
   public double[] getShot() {
      if (!CPU) {
         double[] a = {currentX - 3.475, currentY + 8, currentX + 3.475};
         return a;
      }
      else {
         double[] a = {currentX - 3.475, currentY - 8, currentX + 3.475};
         return a;
      }
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 100); 
      Invader test = new Invader();
      test.setPosition(15, 32);
      test.drawInvader();
      PennDraw.setPenColor(255, 255, 0);
      test.boxT.draw();
      test.boxB.draw();
      double [] a = test.getXRange();
      double [] b = test.getYRange();
      String c = "X Values: ";
      String d = "Y Values: ";
      for (int i = 0; i < 4; i++) {
         c += a[i] + " ";
         d += b[i] + " ";
      }
      System.out.println(c);
      System.out.println(d);
   }
}