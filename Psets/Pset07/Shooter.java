/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java Shooter
 *
 * Class to create thing that shoots bullets 
 *
 */

public class Shooter {
   private double x = 2; // size does not change
   private int red; // variables to hold color values
   private int green;
   private int blue;
   private double currentX; // current position
   private double currentY;
   private double counter = 1; // to recursively draw thing
   private int position; // orientation (up or down)

   // helper function for constructors 
   public void setup(int r, int g, int b) {
      red = r;
      green = g;
      blue = b;
   }
   
   // creates shooter using specified color values
   public Shooter(int r, int g, int b) {
      setup(r, g, b);
   }
   
   // creates shooter using random color
   public Shooter() {
      setup((int) (Math.random() * 255), (int) (Math.random() * 255),
             (int) (Math.random() * 255));
   }
   
   // sets position of shooter (based on invader position)
   public void setPosition(double x, double y) {
      currentX = x;
      currentY = y;
   }
   
   // function draws the shooters
   public void drawShooters() {
      PennDraw.setPenColor((int) (red / (3 - counter)), 
         (int) (green / (3 - counter)), (int) (blue / (3 - counter)));
      if (position == 0) {
         drawTriangle(currentX + 3.475, currentY + 5 + (counter - 1), 
                        x / counter, 1);
         drawTriangle(currentX - 3.475, currentY + 5 + (counter - 1), 
                        x / counter, 1);
      }
      else if (position == 1) {
         drawTriangle(currentX + 3.475, currentY - 5 - (counter - 1), 
                        x / counter, 0);
         drawTriangle(currentX - 3.475, currentY - 5 - (counter - 1), 
                        x / counter, 0);
      }
      counter += 0.1;
      if (counter > 1.5) {
         counter = 1;
         return;
      }
      drawShooters();
   }
   
   // sets the orientation of shooter
   public void setOrientation(int val) {
      position = val;
   }
   
   // function to draw triangles
   private static void drawTriangle(double xCenter, double yCenter, 
                                          double side, int flip) {
      if (flip == 1) {
         double[] xCoords = {xCenter - (side / 2), xCenter, xCenter + 
                              (side / 2)};
         double[] yCoords = {yCenter, yCenter + 
                              ((side / 2) * Math.sqrt(3)), yCenter};
         PennDraw.filledPolygon(xCoords, yCoords);
      }
      else if (flip == 0) {
         double[] xCoords = {xCenter - (side / 2), xCenter, xCenter + 
                              (side / 2)};
         double[] yCoords = {yCenter, yCenter - 
                              ((side / 2) * Math.sqrt(3)), yCenter};
         PennDraw.filledPolygon(xCoords, yCoords);
      }
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 30);
      Body test2 = new Body();
      test2.setPosition(15, 15);
      test2.drawBody();
      Wing test1 = new Wing();
      test1.setPosition(15, 15);
      test1.setOrientation(0);
      test1.drawWings();
      Shooter test3 = new Shooter();
      test3.setPosition(15, 15);
      test3.drawShooters();
   }
}