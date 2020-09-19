/* Name: Jalil Morris
 * NetID: jim33
 *
 * Execution: java Art 
 *
 * Creates a pattern using unique shape (Kirby and Burgies) and repeats it
 * recursively by the number in Run Arguments ("Him busy eating burgies")
 *
 */
public class Art {
   public static void main(String[] args) {
      int counter = Integer.parseInt(args[0]);
      PennDraw.setXscale(-1, 1); // changed scale to make drawing easier to size
      PennDraw.setYscale(-0.5, 1.07);
      PennDraw.enableAnimation(3); // animatates my drawing
      drawPattern(90, 90, 0.83, 0.17, counter); // call animation
   }
   public static void drawPattern(double startAngle, double startAngle2, 
      double circleRadius, double radius, int counter) { // takes in 5 arguments
      if (counter == 0)
         return;
         
      double angleRadians = Math.toRadians(startAngle); // record coordinates
      double x = circleRadius * Math.cos(angleRadians) + 0.28;
      double y = circleRadius * Math.sin(angleRadians);
      drawKirby(x, y, radius, 0, 0); // draw pink kirby
      drawBurgie(x, y - (radius * 0.415), radius / 4);
      double x2 = (circleRadius * 0.85) * 
         Math.cos(Math.toRadians(startAngle - 30)) + 0.28;
      double y2 = (circleRadius * 0.85) * 
         Math.sin(Math.toRadians(startAngle - 30));
      drawBurgie(x2, y2 - ((radius * 0.85) * 0.415), (radius * 0.85) / 4);
         
      double angleRadians2 = Math.toRadians(startAngle2); // record coordinates
      double x3 = circleRadius * Math.cos(angleRadians2) - 0.28;
      double y3 = circleRadius * Math.sin(angleRadians2);
      drawKirby(x3, y3, radius, 0, 1); // draw blue kirby 
      drawBurgie(x3, y3 - (radius * 0.415), radius / 4);
      double x4 = (circleRadius * 0.85) * 
         Math.cos(Math.toRadians(startAngle2 + 30)) - 0.28;
      double y4 = (circleRadius * 0.85) * 
         Math.sin(Math.toRadians(startAngle2 + 30));
      drawBurgie(x4, y4 - ((radius * 0.85) * 0.415), (radius * 0.85) / 4);
         
      PennDraw.advance(); // draw initial positions (and subsequent positions)
      drawKirby(x, y, radius, 1, 0); // draw second stage kirbies
      drawKirby(x3, y3, radius, 1, 1);
      drawPattern(startAngle - 30, startAngle2 + 30, circleRadius * 0.85, 
         radius * 0.85, counter - 1);
   }
   public static void drawKirby(double x, double y, double radius, int state, 
      int color) { // draw kirby with 5 arguments 
      if (color == 0) // color 0 is pink
         PennDraw.setPenColor(PennDraw.RED);
      else if (color == 1) // color 1 is blue
         PennDraw.setPenColor(PennDraw.BLUE);
      PennDraw.filledEllipse(x - (radius * Math.tan(Math.toRadians(25))), 
         y - (radius * 0.9), radius * 0.5, radius * 0.25);
      PennDraw.filledEllipse(x + (radius * Math.tan(Math.toRadians(25))), 
         y - (radius * 0.9), radius * 0.5, radius * 0.25);
      if (color == 0)
         PennDraw.setPenColor(PennDraw.PINK);
      else if (color == 1)
         PennDraw.setPenColor(0, 255, 220);
      PennDraw.filledCircle(x, y, radius);
      PennDraw.filledCircle(x - radius, y - (radius / 20), radius / 3);
      PennDraw.filledCircle(x + radius, y - (radius / 20), radius / 3);
      PennDraw.setPenColor(PennDraw.BLACK);
      PennDraw.filledEllipse(x + (radius * 0.33), y + (radius * 0.415), 
         radius / 5.5, radius / 2.75);
      PennDraw.filledEllipse(x - (radius * 0.33), y + (radius * 0.415), 
         radius / 5.5, radius / 2.75);
      if (state == 0 && color == 0) { // state 0 is open mouth
         PennDraw.setPenColor(200, 0, 80);
         PennDraw.filledEllipse(x, y - (radius * 0.415), radius / 1.75, radius / 2);
      }
      else if (state == 1 && color == 0) { //state 1 is closed mouth
         PennDraw.setPenRadius(0.5 * (radius / 25));
         PennDraw.setPenColor(200, 0, 80);
         PennDraw.arc(x, y + (radius / 1.5), radius, 240, 300);
      }
      if (state == 0 && color == 1) {
         PennDraw.setPenColor(0, 170, 200);
         PennDraw.filledEllipse(x, y - (radius * 0.415), radius / 1.75, radius / 2);
      }
      else if (state == 1 && color == 1) {
         PennDraw.setPenRadius(0.5 * (radius / 25));
         PennDraw.setPenColor(0, 170, 200);
         PennDraw.arc(x, y + (radius / 1.5), radius, 240, 300);
      }
   }
   public static void drawBurgie(double x, double y, double radius) { 
     // draw burgie
      PennDraw.setPenColor(PennDraw.ORANGE);
      PennDraw.filledCircle(x, y, radius);
      PennDraw.setPenColor(150, 90, 0);
      PennDraw.filledRectangle(x, y, radius * 1.1, radius / 4);
   }
}