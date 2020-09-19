public class Bounce {
   private BallNode head;
   private LineNode head2;
   
   public Bounce() {
   
   }
   
   public void simulate(int time, int frames) {
      PennDraw.setScale(0, 1000);
      int counter = 0;
      double x1 = 0;
      double y1 = 0;
      boolean wait1 = false;
      boolean wait2 = false;
      boolean wait3 = false;
      int timer = 0;
      int timer2 = 0;
      PennDraw.enableAnimation(frames);
      while (counter < (time * frames)) {
         PennDraw.clear();
         if (PennDraw.mousePressed()) {
            if (!wait3) {
               x1 = PennDraw.mouseX();
               y1 = PennDraw.mouseY();
               wait1 = true;
               wait2 = true;
               wait3 = true;
            }
            else if (!wait1 && wait2) {
               double x2 = PennDraw.mouseX();
               double y2 = PennDraw.mouseY();
               PennDraw.setPenRadius(0.004);
               LineNode p = new LineNode(x1, y1, x2, y2);
               p.setNext(head2);
               head2 = p;
               wait2 = false;
            }
         }
         
         if (PennDraw.hasNextKeyTyped()) {
            char c = PennDraw.nextKeyTyped();
            Ball b = new Ball(500, 500, 50);
            BallNode n = new BallNode(frames, b);
            n.setNext(head);
            head = n;
         }
         
         if (wait1)
            timer++;
         if (timer > 10) {
            wait1 = false;
            timer = 0;
         }
         
         if (wait3 && !wait2)
            timer2++;
         if (timer2 > 10) {
            wait3 = false;
            timer2 = 0;
         }
      
         if (head2 != null)
            head2.draw();
         if (head != null) {
            head.moveBalls();
            head.draw();
         }
            
         checkHits();
         PennDraw.advance();
         counter++;
      }
   }
   
   public void checkHits() {
      if (head != null && head2 != null) {
         head.checkHits(head2);
      }
   }
   
   public static void main(String[] args) {
      Bounce test = new Bounce();
      test.simulate(10000, 40);
   }
}