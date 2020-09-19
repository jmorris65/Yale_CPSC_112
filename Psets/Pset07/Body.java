/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java Body
 *
 * Class to design body for ships
 *
 */
public class Body {
   private static double X = 5; // size is always the same
   private static double Y = 10;
   private int red; // ints to represent the color
   private int green;
   private int blue;
   private double counter = 1; // used to recursively draw design
   private double currentX; // current position
   private double currentY;
   
   // helper for constructors
   public void setup(int r, int g, int b) {
      red = r;
      green = g;
      blue = b;
   }
   
   // constructor using color values as arguments
   public Body(int r, int g, int b) {
      setup(r, g, b);
   }
   
   // constructor that creates a body with a random color
   public Body() {
      setup((int) (Math.random() * 255), (int) (Math.random() * 255), 
               (int) (Math.random() * 255));
   }
   
   // returns color values (not important but nice to have)
   public int[] getColors() {
      int [] colors = {red, green, blue};
      return colors;
   }
   
   // sets the position of the body
   public void setPosition(double x, double y) {
      currentX = x;
      currentY = y;
   }
   
   // draw the body at the current position
   public void drawBody() {
      PennDraw.setPenColor((int) (red / (3 - counter)),
               (int) (green / (3 - counter)), (int) (blue / (3 - counter)));
      PennDraw.filledRectangle(currentX, currentY, X / (2 * counter), 
               Y / (2 * counter));
      counter += 0.1;
      if (counter > 1.5) { // stops recursion
         counter = 1;
         return;
      }
      drawBody();
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 30);
      Body test2 = new Body();
      test2.setPosition(15, 15);
      test2.drawBody();
      Wing test1 = new Wing(255, 255, 0);
      test1.setPosition(15, 15);
      test1.setOrientation(0);
      test1.drawWings();
   }
}