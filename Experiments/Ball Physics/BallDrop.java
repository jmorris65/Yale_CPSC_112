public class BallDrop {
   private BallNode head;
   
   public BallDrop() {
      head = null;
   }
   
   public void simulate(int time, int frames) {
      int counter = 0;
      int cool = 0;
      boolean down = false;
      PennDraw.enableAnimation(frames);
      while (counter < (time * frames)) {
         PennDraw.clear();
         if (PennDraw.mousePressed() && down == false) {
            double x = PennDraw.mouseX();
            double y = PennDraw.mouseY();
            Ball b = new Ball(x, y);
            BallNode p = new BallNode(frames, b);
            p.setNext(head);
            head = p;
            down = true;
         }
         
         if (down == true) {
            cool++;
            if (cool > 10)
               down = false; 
         }
         else
            cool = 0;
            
         if (head != null) {
            head.moveBalls();
            head.draw();
         }
      
         PennDraw.advance();
         counter++;
      }
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 1000);
      BallDrop test = new BallDrop();
      test.simulate(120, 40);
   }
}