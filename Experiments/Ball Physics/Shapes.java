public class Shapes {
   
   public static void drawEPolygon(double x, double y, double s, int sides, double angle) {
      if (sides < 3) {
         System.out.println("Not a polygon");
         return;
      }
      double radians = Math.toRadians(angle + 90);
      double centralAngle = Math.toRadians(360.0 / sides);
      double vertexAngle = Math.toRadians(((180 * (sides - 2)) / sides) / 2);
      double[] xCoords = new double[sides];
      double[] yCoords = new double[sides];
      double vertexDistance = s / (2 * Math.cos(vertexAngle));
      for (int i = 0; i < sides; i++) {
         double moveAngle = radians + (centralAngle * i);
         xCoords[i] = x + (vertexDistance * Math.cos(moveAngle));
         yCoords[i] = y + (vertexDistance * Math.sin(moveAngle));
      }
      PennDraw.filledPolygon(xCoords, yCoords);
   }
   
   public static double getRadius(int sides, double s) {
      double vertexAngle = Math.toRadians(((180 * (sides - 2)) / sides) / 2);
      return s / (2 * Math.cos(vertexAngle));
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 100);
      PennDraw.setPenColor(PennDraw.BLUE);
      drawEPolygon(50, 50, 30, 8, 22.75);
   }
}