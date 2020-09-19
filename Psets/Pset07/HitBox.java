/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java HitBox
 *
 * Class to create hitboxes for invader class
 *
 */

public class HitBox {
   private double height; // y distance
   private double width; // x distance
   private double currentX; // position
   private double currentY; // position
   
   // constructor creates hitbox with given size 
   public HitBox(double x, double y) {
      width = x;
      height = y;
   }
   
   // function draws hitbox (for testing purposes)
   public void draw() {
      PennDraw.rectangle(currentX, currentY, width / 2, height / 2);
   }
   
   // function sets position of hitbox
   public void setPosition(double x, double y) {
      currentX = x;
      currentY = y;
   }
   
   // function returns hitbox Y range 
   public double[] getYRange() {
      double[] range = {currentY - (height / 2), currentY + (height / 2)};
      return range;
   }
   
   // function returns hitbox X range
   public double[] getXRange() {
      double[] range = {currentX - (width / 2), currentX + (width / 2)};
      return range;
   }
   
   // function returns true if given point is inside hitbox
   public boolean inRange(double x, double y) {
      if (x >= currentX - (width / 2) && x <= currentX + (width / 2) && 
            y >= currentY - (height / 2) && y <= currentY + (height / 2))
         return true;
      else 
         return false;
   }
}