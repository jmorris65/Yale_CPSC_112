public class BallNode {
   private Ball ball;
   private BallNode next;
   private int frames;
   
   public BallNode(int f) {
      ball = new Ball();
      next = null;
      frames = f;
   } 
   
   public BallNode(int f, Ball b) {
      ball = b;
      next = null;
      frames = f;
   }
   
   public void setNext(BallNode n) {
      next = n;
   }
   
   public BallNode getNext() {
      return next;
   }
   
   public Ball getBall() {
      return ball;
   }
   
   public void moveBalls() {
      ball.incrementVelocity(frames);
      ball.move(frames);
      if ((ball.getX() >= 1000 && ball.getXSpeed() >= 0) || (ball.getX() <= 0 && ball.getXSpeed() <= 0))
         ball.reverseX();
      if ((ball.getY() <= 0 && ball.getYSpeed() <= 0) || (ball.getY() >= 1000 && ball.getYSpeed() >= 0))
         ball.reverseY();
      if (next != null)
         next.moveBalls();
   }
   
   public void draw() {
      ball.draw();
      if (next != null)
         next.draw();
   }
   
   public void checkHits(LineNode node) {
      ball.checkContact(node);
      if (next != null)
         next.checkHits(node);
   }
}