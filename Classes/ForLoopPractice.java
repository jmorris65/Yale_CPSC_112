public class ForLoopPractice {
   public static void main(String[] args) {
      PennDraw.setCanvasSize(500, 500);
      PennDraw.clear(255, 255, 255);
        
      for (double i = 0.25; i < 1.0; i += 0.25) {
            
         for (double j = 0.25; j < 1.0; j += 0.25) {
                  
            if (i == 0.25) {
               PennDraw.setPenColor(255, 0, 0);
            }
            else if (i == 0.5) {
               PennDraw.setPenColor(0, 255, 0);
            }
            else {
               PennDraw.setPenColor(0, 0, 255);
            }
            PennDraw.filledCircle(i, j, 0.075);
         }
      }
   }
}