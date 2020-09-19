public class Electromagnetism {
   private static double E_FIELD = 5.0 * Math.pow(10.0, -9.0);
   private static double ELEMENTARY_CHARGE = 1.6 * Math.pow(10.0, -19.0);
   private static double B_FIELD = 25.0 * Math.pow(10.0, -11.0);
   private static double E_FORCE = E_FIELD * ELEMENTARY_CHARGE;
   private static double MASS = 1.6 * Math.pow(10.0, -27.0);
   private double xPosition = 0.0;
   private double yPosition = 0.0;
   private double xForce = 0.0;
   private double yForce = 0.0;
   private double xAcceleration = 0.0;
   private double yAcceleration = 0.0;
   private double xVelocity = 0.0;
   private double yVelocity = 0.0;
   
   public Electromagnetism() {
   
   }
   
   public void calculateForces() {
      double xBForce = ELEMENTARY_CHARGE * yVelocity * B_FIELD;
      double yBForce = -1 * ELEMENTARY_CHARGE * xVelocity * B_FIELD;
      
      xForce = xBForce;
      yForce = yBForce + E_FORCE;
   }
   
   public void calculateAcceleration() {
      xAcceleration = xForce / MASS;
      yAcceleration = yForce / MASS;
   }
   
   public void incrementVelocity() {
      xVelocity += xAcceleration;
      yVelocity += yAcceleration;
      
      System.out.println(xVelocity + " and " + yVelocity);
   }
   
   public void move() {
      xPosition += xVelocity;
      yPosition += yVelocity;
   }
   
   public void drawBall() {
      PennDraw.clear();
      PennDraw.setYscale(-2500, 2500);
      PennDraw.setXscale(0, 5000);
      PennDraw.setPenColor(PennDraw.RED);
      PennDraw.filledCircle(xPosition, yPosition, 50);
   }
   
   public void simulate(int time) {
      int counter = 0;
      PennDraw.enableAnimation(40);
      while (counter < (time * 40)) {
         drawBall();
         calculateForces();
         calculateAcceleration();
         incrementVelocity();
         move();
         PennDraw.advance();
         counter++;
      }
   }
   
   public static void main(String[] args) {
      Electromagnetism test = new Electromagnetism();
      test.simulate(10);
   }
}