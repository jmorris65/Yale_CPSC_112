   /* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java Wing
 *
 * Class to create wing part
 *
 */

public class Wing {
   private double x = 4; // size does not change
   private double y = 10;
   private int red; // variables hold color values 
   private int green;
   private int blue;
   private double counter = 1; // counter to recursively draw wing
   private double currentX; // current position
   private double currentY;
   private int position;
  
  // helper function for constructors 
   private void setup(int r, int g, int b) {
      red = r;
      green = g;
      blue = b;
   }
   
   // constructor uses given color values
   public Wing(int r, int g, int b) {
      setup(r, g, b);
   }
   
   // constructor creates wing with random color
   public Wing() {
      setup((int) (Math.random() * 255), (int) (Math.random() * 255), 
                  (int) (Math.random() * 255));
   }

   // function returns current colors
   public int[] getColors() {
      int [] colors = {red, green, blue};
      return colors;
   }
   
   // function sets current position
   public void setPosition(double x, double y) {
      currentX = x;
      currentY = y;
   }
   
   // function sets orientation
   public void setOrientation(int val) {
      position = val;
   }
   
   // function draws single wing using arguments (helper funcion)
   private void drawWing(double xCenter, double yCenter, int orientation) {
      double leftX = xCenter - (x / (2 * counter));
      double rightX = xCenter + (x / (2 * counter));
      double downY = yCenter - (y / (2 * counter));
      double upY = yCenter + (y / (2 * counter));
      double tCornerY = yCenter + (y / (4 * counter));
      double bCornerY = yCenter - (y / (4 * counter));
      PennDraw.setPenColor((int) (red / (3 - counter)), 
         (int) (green / (3 - counter)), (int) (blue / (3 - counter)));
      
      if (orientation == 0) {
         double[] xValues = {leftX, xCenter, rightX, rightX, leftX};
         double[] yValues = {tCornerY, upY, upY, downY, downY};
         PennDraw.filledPolygon(xValues, yValues);
      }
      else if (orientation == 1) {
         double[] xValues = {leftX, xCenter, rightX, rightX, leftX};
         double[] yValues = {upY, upY, tCornerY, downY, downY};
         PennDraw.filledPolygon(xValues, yValues);
      }
      else if (orientation == 2) {
         double[] xValues = {leftX, rightX, rightX, xCenter, leftX};
         double[] yValues = {upY, upY, downY, downY, bCornerY};
         PennDraw.filledPolygon(xValues, yValues);
      }
      if (orientation == 3) {
         double[] xValues = {leftX, rightX, rightX, xCenter, leftX};
         double[] yValues = {upY, upY, bCornerY, downY, downY};
         PennDraw.filledPolygon(xValues, yValues);
      }
      counter += 0.1;
      if (counter > 1.5) {
         counter = 1;
         return;
      }
      drawWing(xCenter, yCenter, orientation);
   }
   
   // function draws both wings
   public void drawWings() {
      if (position == 0) {
         drawWing(currentX - 4.5, currentY, 0);
         drawWing(currentX + 4.5, currentY, 1);
      }
      else if (position == 1) {
         drawWing(currentX - 4.5, currentY, 2);
         drawWing(currentX + 4.5, currentY, 3); 
      }
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 50);
      Wing test1 = new Wing(255, 255, 0);
      test1.setPosition(15, 15);
      test1.setOrientation(0);
      test1.drawWings();
   }
}