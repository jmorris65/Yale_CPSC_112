public class Ball {
   private static double GRAVITY = -300.0;
   private double size;
   private double x;
   private double y;
   private int red;
   private int green;
   private int blue;
   private double xSpeed;
   private double ySpeed;
   private double vAngle;
   
   private void setup(double initialX, double initialY, int r, int g, int b, double initialV, double angle, double s) {
      x = initialX;
      y = initialY;
      red = r;
      green = g;
      blue = b;
      double radians = Math.toRadians(angle);
      xSpeed = initialV * Math.cos(radians);
      ySpeed = initialV * Math.sin(radians);
      vAngle = radians;
      size = s;
   }
   
   public Ball() {
      double initialX = 100 + (800 * Math.random());
      double initialY = 100 + (800 * Math.random());
      double initialV = 200 + (300 * Math.random());
      double angle = 180 * Math.random();
      int r = (int) (255 * Math.random());
      int g = (int) (255 * Math.random());
      int b = (int) (255 * Math.random());
      double s = 40 + (30 * Math.random());
      setup(initialX, initialY, r, g, b, initialV, angle, s);
   }
   
   public Ball(double initialX, double initialY) {
      double initialV = 200 + (300 * Math.random());
      double angle = 180 * Math.random();
      int r = (int) (255 * Math.random());
      int g = (int) (255 * Math.random());
      int b = (int) (255 * Math.random());
      double s = 40 + (30 * Math.random());
      setup(initialX, initialY, r, g, b, initialV, angle, s);
   }
   
   public Ball(double initialX, double initialY, double s) {
      double initialV = 200 + (300 * Math.random());
      double angle = 180 * Math.random();
      int r = (int) (255 * Math.random());
      int g = (int) (255 * Math.random());
      int b = (int) (255 * Math.random());
      setup(initialX, initialY, r, g, b, initialV, angle, s);
   }
   
   public Ball(double initialX, double initialY, double initialV, double angle) {
      int r = (int) (255 * Math.random());
      int g = (int) (255 * Math.random());
      int b = (int) (255 * Math.random());
      double s = 40 + (30 * Math.random());
      setup(initialX, initialY, r, g, b, initialV, angle, s);
   }
   
   public Ball(double initialX, double initialY, double initialV, double angle, double s) {
      int r = (int) (255 * Math.random());
      int g = (int) (255 * Math.random());
      int b = (int) (255 * Math.random());
      setup(initialX, initialY, r, g, b, initialV, angle, s);
   }
   
   public Ball(double initialX, double initialY, double initialV, double angle, int r, int g, int b) {
      double s = 40 + (30 * Math.random());
      setup(initialX, initialY, r, g, b, initialV, angle, s);
   }
   
   public Ball(double initialX, double initialY, double initialV, double angle, int r, int g, int b, double s) {
      setup(initialX, initialY, r, g, b, initialV, angle, s);
   }
   
   public void incrementVelocity(int frames) {
      ySpeed += GRAVITY / frames;
      vAngle = Math.atan(ySpeed / xSpeed);
   }
   
   public void move(int frames) {
      x += xSpeed / frames;
      y += ySpeed / frames;
      if (y <= 0)
         y = 0;
   }
   
   public double getX() {
      return x;
   }
   
   public double getY() {
      return y;
   }
   
   public double getYSpeed() {
      return ySpeed;
   }
   
   public double getXSpeed() {
      return xSpeed;
   }
   
   public void reverseX() {
      xSpeed = -xSpeed;
   }
   
   public void reverseY() {
      ySpeed = -ySpeed;
   }
   
   public void draw() {
      PennDraw.setPenColor(red, green, blue);
      PennDraw.filledCircle(x, y, size);
   }
   
   public void checkContact(LineNode node) {
      double[] pointSlope = node.getPointSlope();
      double startX = pointSlope[0];
      double startY = pointSlope[1];
      //System.out.println("Start: " + startX + " , " + startY);
      double stepX = pointSlope[2] / 50.0;
      double stepY = pointSlope[3] / 50.0;
      for (int i = 0; i < 50; i++) {
         double h = startX + (stepX * i);
         double k = startY + (stepY * i);
         //System.out.println(h + "," + k);
         double checkX = Math.pow(h - x, 2.0);
         double checkY = Math.pow(k - y, 2.0);
         if (checkX + checkY <= Math.pow(size, 2.0)) {
            double radians = node.getNormal();
            double newAngle = (2 * radians) - vAngle;
            double velocity = Math.sqrt(Math.pow(xSpeed, 2.0) + Math.pow(ySpeed, 2.0));
            xSpeed = velocity * Math.cos(newAngle);
            ySpeed = velocity * Math.sin(newAngle);
            if (x < h) 
               ySpeed = -ySpeed;
               
         }
      }
      if (node.getNext() != null)
         checkContact(node.getNext());
   }
}