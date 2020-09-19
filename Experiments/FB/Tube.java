public class Tube {
   private static double WIDTH = 15.0;
   private static double SPACE = 25.0;
   private double topLength;
   private double botLength;
   private double currentX;
   private final double currentTY;
   private final double currentBY;
   private static double VELOCITY = 40.0;
   
   public Tube() {
      topLength = 10 + 50 * Math.random();
      botLength = 100 - topLength - SPACE;
      currentX = 150;
      currentTY = 100 - (topLength / 2);
      currentBY = botLength / 2;
   }
   
   public void draw() {
      PennDraw.setPenColor(0, 150, 0);
      PennDraw.filledRectangle(currentX, 100, WIDTH / 2, 10);
      PennDraw.filledRectangle(currentX, 0, WIDTH / 2, 10);
      PennDraw.filledRectangle(currentX, currentTY, WIDTH / 2, topLength / 2);
      PennDraw.filledRectangle(currentX, currentBY, WIDTH / 2, botLength / 2);
   }
   
   public void move(int frames) {
      currentX = currentX - (VELOCITY / frames);
   }
   
   public double[] getRange() {
      double x1 = currentX - (WIDTH / 2);
      double x2 = currentX + (WIDTH / 2);
      double y1 = currentTY + (topLength / 2) + 20;
      double y2 = currentTY - (topLength / 2);
      double y3 = currentBY + (botLength / 2);
      double y4 = currentBY - (botLength / 2) - 20;
      double[] range = {x1, x2, y1, y2, y3, y4};
      return range;
   }
}