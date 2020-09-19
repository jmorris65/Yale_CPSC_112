public class Art4 {
   public static void main(String[] args) {
      PennDraw.setCanvasSize(500, 500);
      PennDraw.setScale(0, 1000);
      
      art(500, 500, 80, 180, 7, 0);
      art(500, 250, 60, 90, 7, 0);
      art(500, 750, 60, 90, 7, 0);
   }
   
   public static void art(double x, double y, double length, double startAngle, int counter, int a) {
      if (counter == 0) return;
      
      PennDraw.setPenColor(a, 0, 0);
      drawShape(x, y, length, startAngle);
      
      double angleRadians = Math.toRadians(startAngle);
      double otherAngle = Math.toRadians(90 - (startAngle / 2));
      double radius = 2 * length;
      double secantLength = 2 * radius * Math.sin(angleRadians / 2);
      double yMove = secantLength * Math.sin(otherAngle) + (length / 2);
      double xMove = secantLength * Math.cos(otherAngle);
      
      a = (int) (Math.random() * 255);

      art(x - xMove, y + yMove, length / 2, startAngle + 30, counter - 1, a);
      art(x - xMove, y - yMove, length / 2, startAngle + 30, counter - 1, a);
      art(x + xMove, y + yMove, length / 2, startAngle + 30, counter - 1, a);
      art(x + xMove, y - yMove, length / 2, startAngle + 30, counter - 1, a);
      }
      
   public static void drawShape(double x, double y, double length, double angle) {
      PennDraw.line(x, y - (length / 2), x,  y + (length / 2));
      PennDraw.arc(x - (2 * length), y + (length / 2), 2 * length, 0, angle);
      PennDraw.arc(x + (2 * length), y + (length / 2), 2 * length, 180 - angle, 180);
      PennDraw.arc(x - (2 * length), y - (length / 2), 2 * length, 360 - angle, 360);
      PennDraw.arc(x + (2 * length), y - (length / 2), 2 * length, 180, 180 + angle);
   }
}