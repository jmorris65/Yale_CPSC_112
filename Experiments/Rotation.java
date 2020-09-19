public class Rotation {
   public static void main(String[] args) {
      
      PennDraw.setCanvasSize(512, 512);
      PennDraw.clear(PennDraw.BLACK);
      PennDraw.setScale(-10, 10);
      
      PennDraw.setPenColor(PennDraw.RED);
      PennDraw.filledCircle(0, 0, 1);
      
      double angle = 0;
      int run = 0;
      PennDraw.setPenColor(PennDraw.BLUE);
      PennDraw.filledCircle(5, 0, 0.5);
      
      PennDraw.enableAnimation(20);
      while (true) {
         if (PennDraw.mousePressed()) {
            run++;
         }
         if (run % 2 == 0) {
            PennDraw.clear(PennDraw.BLACK);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(0, 0, 1);
         
            PennDraw.setPenColor(PennDraw.BLUE);
            PennDraw.filledCircle(5 * Math.cos(angle), 5 * Math.sin(angle), 0.5);
            
            angle += 0.05;
         }
         PennDraw.advance();
         
      }
   }
}