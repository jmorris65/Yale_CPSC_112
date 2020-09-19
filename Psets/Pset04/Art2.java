public class Art2 {
   public static void main(String[] args) {
      PennDraw.setXscale(-140, 140);
      PennDraw.setYscale(-60, 150);
      //PennDraw.enableAnimation(2);
      drawPattern(90, 125, 25, 30, 1);
      drawPattern(90, 125, 25, 30, 0);
   }
   public static void drawPattern(double startAngle, double circleRadius, double radius, int counter, int direction) {
      if (counter == 0)
         return;
            
      if (direction == 0) {
         double angleRadians = Math.toRadians(startAngle);
         double x = circleRadius * Math.cos(angleRadians) + 42;
         double y = circleRadius * Math.sin(angleRadians);
         drawKirby(x, y, radius, 0, 0);
         drawBurgie(x, y - (radius * 0.415), radius / 4);
         double x2 = (circleRadius * 0.85) * Math.cos(Math.toRadians(startAngle - 30)) + 42;
         double y2 = (circleRadius * 0.85) * Math.sin(Math.toRadians(startAngle - 30));
         drawBurgie(x2, y2 - ((radius * 0.85) * 0.415), (radius * 0.85) / 4);
         //PennDraw.advance();
         drawKirby(x, y, radius, 1, 0);
         drawPattern(startAngle - 30, circleRadius * 0.85, radius * 0.85, counter - 1, 0);
      }
      
      if (direction == 1) {
         double angleRadians = Math.toRadians(startAngle);
         double x = circleRadius * Math.cos(angleRadians) - 42;
         double y = circleRadius * Math.sin(angleRadians);
         drawKirby(x, y, radius, 0, 1);
         drawBurgie(x, y - (radius * 0.415), radius / 4);
         double x2 = (circleRadius * 0.85) * Math.cos(Math.toRadians(startAngle + 30)) - 42;
         double y2 = (circleRadius * 0.85) * Math.sin(Math.toRadians(startAngle + 30));
         drawBurgie(x2, y2 - ((radius * 0.85) * 0.415), (radius * 0.85) / 4);
         //PennDraw.advance();
         drawKirby(x, y, radius, 1, 1);
         drawPattern(startAngle + 30, circleRadius * 0.85, radius * 0.85, counter - 1, 1);
      }
      
   }
   public static void drawKirby(double x, double y, double radius, int state, int color) {
      if (color == 0)
         PennDraw.setPenColor(PennDraw.RED);
      else if (color == 1)
         PennDraw.setPenColor(PennDraw.BLUE);
      PennDraw.filledEllipse(x - (radius * Math.tan(Math.toRadians(25))), y - (radius * 0.9), radius * 0.5, radius * 0.25);
      PennDraw.filledEllipse(x + (radius * Math.tan(Math.toRadians(25))), y - (radius * 0.9), radius * 0.5, radius * 0.25);
      if (color == 0)
         PennDraw.setPenColor(PennDraw.PINK);
      else if (color == 1)
         PennDraw.setPenColor(0, 255, 220);
      PennDraw.filledCircle(x, y, radius);
      PennDraw.filledCircle(x - radius, y - (radius / 20), radius / 3);
      PennDraw.filledCircle(x + radius, y - (radius / 20), radius / 3);
      PennDraw.setPenColor(PennDraw.BLACK);
      PennDraw.filledEllipse(x + (radius * 0.33), y + (radius * 0.415), radius / 5.5, radius / 2.75);
      PennDraw.filledEllipse(x - (radius * 0.33), y + (radius * 0.415), radius / 5.5, radius / 2.75);
      if (state == 0 && color == 0) {
         PennDraw.setPenColor(200, 0, 80);
         PennDraw.filledEllipse(x, y - (radius * 0.415), radius / 1.75, radius / 2);
      }
      else if (state == 1 && color == 0) {
         PennDraw.setPenRadius(0.005 * (radius / 25));
         PennDraw.setPenColor(200, 0, 80);
         PennDraw.arc(x, y + (radius / 1.5), radius, 240, 300);
      }
      if (state == 0 && color == 1) {
         PennDraw.setPenColor(0, 170, 200);
         PennDraw.filledEllipse(x, y - (radius * 0.415), radius / 1.75, radius / 2);
      }
      else if (state == 1 && color == 1) {
         PennDraw.setPenRadius(0.005 * (radius / 25));
         PennDraw.setPenColor(0, 170, 200);
         PennDraw.arc(x, y + (radius / 1.5), radius, 240, 300);
      }
   }
   public static void drawBurgie(double x, double y, double radius) {
      PennDraw.setPenColor(PennDraw.ORANGE);
      PennDraw.filledCircle(x, y, radius);
      PennDraw.setPenColor(150, 90, 0);
      PennDraw.filledRectangle(x, y, radius * 1.1, radius / 4);
   }
}