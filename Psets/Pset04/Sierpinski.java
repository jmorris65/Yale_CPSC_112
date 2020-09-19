/* Name: Jalil Morris
 * NetID: jim33
 *
 * Execution: java Sierpinski
 *
 * Creates the Sierpinski triangle by recursively reproducing
 * a triangle pattern by the number of times specified in the
 * run argiments
 *
 */
public class Sierpinski {
   public static void main(String[] args) {
   
      int numLevels = Integer.parseInt(args[0]); // takes argument as an integer
      sierpinski(numLevels, 0.5, 0.5, 0.95);
   }
   
   public static void triangle(double sideLength, double x, double y) {
      // draws a triangle using top vertex as arguments
      double[] xcoords = {x - (sideLength / 2), x, x + (sideLength / 2)};
      double[] ycoords = {y - ((sideLength * Math.sqrt(3)) / 2), y,
         y - ((sideLength * Math.sqrt(3)) / 2)};
      PennDraw.filledPolygon(xcoords, ycoords);
   }
   
   public static void sierpinski(int numLevels, double size, double x, double y) {
      if (numLevels == 0)
         return;
         
      PennDraw.setPenColor((int) (Math.random() * 250), (int) (Math.random() * 250),
         (int) (Math.random() * 250)); // random colors
      triangle(size, x, y);
   
      sierpinski(numLevels - 1, size / 2, x - (size / 2), y); // makes pattern
      sierpinski(numLevels - 1, size / 2, x, y - ((size * Math.sqrt(3)) / 2));
      sierpinski(numLevels - 1, size / 2, x + (size / 2), y);
   
   }
   
}