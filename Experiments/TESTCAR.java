public class TESTCAR {
   public static void main(String[] args) {
      PennDraw.setCanvasSize(500,500);
      PennDraw.setScale(0, 20);
      PennDraw.clear(255, 255, 255);
      
      double[] BCarX0 = {2, 2, 1.65, 1.65, 0.65, 0.65, 0.3, 0.3};
      double[] RCarX0 = {2, 2, 1.65, 1.65, 0.65, 0.65, 0.3, 0.3};
      
      double[] BCarY = {12.25, 13, 13, 13.5, 13.5, 13, 13, 12.25};
      double[] RCarY = {7.25, 8, 8, 8.5, 8.5, 8, 8, 7.25};
      
      double BW = BCarX[3], RW = RCarX[3];
      
      
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledPolygon(BCarX, BCarY);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledPolygon(RCarX, RCarY);     
   }
}