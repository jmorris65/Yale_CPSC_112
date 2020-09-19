public class Recursion {
   public static void main(String[] args) {
      PennDraw.setCanvasSize(500, 500);
      PennDraw.clear(PennDraw.WHITE);
      PennDraw.setScale(0, 100);
      drawPattern(50, 50, 5, 7);
   }
   public static void drawPattern(double x, double y, double size, int counter) {
      if (counter == 0) 
         return;
      PennDraw.setPenColor((int) (Math.random() * 250), (int) (Math.random() * 250), (int) (Math.random() * 250));
      PennDraw.square(x, y, size, 45);
      counter --;
      drawPattern(x + ((2 * size) * Math.cos(Math.PI / 4)), y + ((2 * size) * Math.sin(Math.PI / 4)), size, counter);
      drawPattern(x - ((2 * size) * Math.cos(Math.PI / 4)), y + ((2 * size) * Math.sin(Math.PI / 4)), size, counter);
      drawPattern(x + ((2 * size) * Math.cos(Math.PI / 4)), y - ((2 * size) * Math.sin(Math.PI / 4)), size, counter);
      drawPattern(x - ((2 * size) * Math.cos(Math.PI / 4)), y - ((2 * size) * Math.sin(Math.PI / 4)), size, counter);
   }
}