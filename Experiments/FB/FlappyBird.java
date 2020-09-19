public class FlappyBird {
   private final double currentX;
   private double currentY;
   private static double GRAVITY = -100.0;
   private static double size = 10.0;
   private double velocity;
   
   public FlappyBird(double x, double y) {
      currentX = x;
      currentY = y;
      velocity = 0;
   }
   
   public double[] getRange() {
      double x1 = currentX - 4;
      double x2 = currentX + 4;
      double y1 = currentY - 4;
      double y2 = currentY + 4;
      double[] range = {x1, x2, y1, y2};
      return range;  
   }
   
   public void jump() {
      velocity = 45.0;
   }
   
   public void move(int frames) {
      currentY = currentY + (velocity / frames);
   }
   
   public void incrementVelocity(int frames) {
      velocity = velocity + (GRAVITY / frames);
   }
   
   public void draw() {
      PennDraw.setPenColor(PennDraw.YELLOW);
      PennDraw.filledCircle(currentX, currentY, size / 2);
      //PennDraw.setPenColor(PennDraw.RED);
      //PennDraw.square(currentX, currentY, 4);
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 100);
      FlappyBird test = new FlappyBird(15, 50);
      Tube test1 = new Tube();
      test1.draw();
      test.draw();
      int frames = 50;
      PennDraw.enableAnimation(frames);
      while(true) {
         if (PennDraw.hasNextKeyTyped()) {
            char i = PennDraw.nextKeyTyped();
            if (i == ' ') test.jump();
            else;
         }
         PennDraw.clear();
         test.incrementVelocity(frames);
         test.move(frames);
         test1.move(frames);
         test1.draw();
         test.draw();
         PennDraw.advance();
      }
   }
}