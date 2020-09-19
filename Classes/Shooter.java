public class Shooter {
   private double x = 2.25;
   private int red;
   private int green;
   private int blue;
   private double currentX;
   private double currentY;

   public void setup(int r, int g, int b){
      red = r;
      green = g;
      blue = b;
   }
   
   public Shooter(int r, int g, int b) {
      setup(r, g, b);
   }
   
   public void setPosition(double x, double y) {
      currentX = x;
      currentY = y;
   }
   
   public void drawShooters() {
      PennDraw.setPenColor(red, green, blue);
      drawTriangle(currentX + 3.625, currentY + 5, x);
      drawTriangle(currentX - 3.625, currentY + 5, x);
   }

   private static void drawTriangle(double xCenter, double yCenter, double side) {
      double[] xCoords = {xCenter - (side / 2), xCenter, xCenter + (side / 2)};
      double[] yCoords = {yCenter, yCenter + ((side / 2) * Math.sqrt(3)), yCenter};
      PennDraw.filledPolygon(xCoords, yCoords);
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 30);
      Body test2 = new Body(255, 0, 0);
      test2.setPosition(15, 15);
      test2.drawBody();
      Wing test1 = new Wing(255, 255, 0);
      test1.setPosition(15, 15);
      test1.setOrientation(0);
      test1.drawWings();
      Shooter test3 = new Shooter(0, 255, 0);
      test3.setPosition(15, 15);
      test3.drawShooters();
   }
}