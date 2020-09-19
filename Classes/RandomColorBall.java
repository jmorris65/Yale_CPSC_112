public class RandomColorBall {
   public static void main(String[] args) {
      PennDraw.setCanvasSize(500, 500);
      PennDraw.clear(255, 255, 255);
      PennDraw.setScale(0, 1);
      PennDraw.setPenRadius(0.015);
      double i = 0.5;
      
      PennDraw.enableAnimation(40);
      
      while (true) {
         if (i < 0.00) {
            i = 0.5;
         }
         else {
            PennDraw.setPenColor( (int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random()));
            PennDraw.arc(0.5, 0.5, i, 0, 360);
            i -= 0.015;
            PennDraw.advance();
         } 
      }     
   }
}