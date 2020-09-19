/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Create an image that produces a image with varying size when clicked
 * and a randomly generate background when a key is pressed
 */

public class StampSketch {
   public static void main(String[] args) {
   
      //set up background
      PennDraw.setCanvasSize(512, 512);
      PennDraw.setScale(0, 100);
      PennDraw.clear(PennDraw.ORANGE);
      PennDraw.setPenColor(PennDraw.YELLOW);
      PennDraw.filledRectangle(50, 25, 55, 30);
      PennDraw.setPenColor(PennDraw.RED);
      PennDraw.filledCircle(100, 100, 15);
      
      //necessary variables to change background
      boolean dunes = true;
      int cycle = 1;
      
      //animation begins
      PennDraw.enableAnimation(20);
      
      //never-ending loop
      while (true) {
         if (PennDraw.mousePressed()) { //record x and y positions of mouse
            double X0 = PennDraw.mouseX();
            double Y0 = PennDraw.mouseY();
            if (Y0 >= 70 && dunes == true) { //generate clouds in the sky
               int K = (int) (75 * ((Y0 - 70) / 30));
               double J = Y0 - 70;
               PennDraw.setPenColor(200 - K, 200 - K, 200 - K);
               PennDraw.filledCircle(X0, Y0, 2 + (J / 15));
               PennDraw.filledCircle(X0 + 1.85 + (J / 20), Y0 - 0.75 - (J / 30),
                  2 + (J / 15));
               PennDraw.filledCircle(X0 - 1.85 - (J / 20), Y0 - 0.75 - (J / 30),
                  2 + (J / 15));
               PennDraw.filledCircle(X0, Y0 - 1.25 - (J / 30), 2 + (J / 15));
               PennDraw.advance();
            }
            if (Y0 > 45 && Y0 < 70 && dunes == true) { 
            //generate raindrops that get smaller as Y decreases
               PennDraw.setPenColor(PennDraw.BLUE);
               PennDraw.filledPolygon(X0 - 0.75 - ((Y0 - 45) / 50), Y0, X0 + 0.7 + 
                  ((Y0 - 45) / 50), Y0, X0, Y0 + 1.677 + ((Y0 - 45) / 20));
               PennDraw.filledPie(X0, Y0, 0.75 + ((Y0 - 45) / 50), 180, 360);
               PennDraw.advance();
            }   
            if (Y0 >= 55 && dunes == false) { //generates stars a night
               double L = Y0 - 55;
               PennDraw.setPenColor(255, 255, 110);
               PennDraw.filledPolygon(X0 - 1 - (L / 25), Y0, X0, Y0 + 2 + 
                  (L / 10), X0 + 1 + (L / 25), Y0, X0, Y0 - 2 - (L / 10));
               PennDraw.advance();
            }
         }
         if (PennDraw.hasNextKeyTyped()) {
            if (cycle % 2 == 0) { //clear and create day cycle
               PennDraw.clear(PennDraw.ORANGE);
               PennDraw.setPenColor(PennDraw.YELLOW);
               PennDraw.filledRectangle(50, 25, 55, 30);
               PennDraw.setPenColor(PennDraw.RED);
               PennDraw.filledCircle(100, 100, 15);
               dunes = true;
            }
            else { //clear and create night cycle
               PennDraw.clear(70, 70, 70);
               PennDraw.setPenColor(PennDraw.YELLOW);
               PennDraw.filledRectangle(50, 25, 55, 30);
               PennDraw.setPenColor(PennDraw.WHITE);
               PennDraw.filledCircle(100, 100, 15);
               dunes = false;
            }
            for (int a = 0; a < 2; a++) { 
            // generate 2 cacti in bottom left of bottom half
               double cx = 50 * Math.random();
               double cy = 30 * Math.random();
               PennDraw.setPenColor(PennDraw.GREEN);
               PennDraw.filledRectangle(cx, cy, 2, 5);
               PennDraw.filledRectangle(cx + 2, cy + 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx - 2, cy - 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx + 3.5, cy + 4, 1, 2.5);
               PennDraw.filledRectangle(cx - 3.5, cy - 1, 1, 2.5);
            }
            for (int a = 0; a < 2; a++) { 
            //generate 2 cacti in top left of bottom half
               double cx = 50 * Math.random();
               double cy = 25 + 30 * Math.random();
               PennDraw.setPenColor(PennDraw.GREEN);
               PennDraw.filledRectangle(cx, cy, 2, 5);
               PennDraw.filledRectangle(cx + 2, cy + 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx - 2, cy - 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx + 3.5, cy + 4, 1, 2.5);
               PennDraw.filledRectangle(cx - 3.5, cy - 1, 1, 2.5);
            }
            for (int a = 0; a < 2; a++) { 
            //generate 2 cacti in bottom right of bottom half
               double cx = 50 + 50 * Math.random();
               double cy = 30 * Math.random();
               PennDraw.setPenColor(PennDraw.GREEN);
               PennDraw.filledRectangle(cx, cy, 2, 5);
               PennDraw.filledRectangle(cx + 2, cy + 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx - 2, cy - 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx + 3.5, cy + 4, 1, 2.5);
               PennDraw.filledRectangle(cx - 3.5, cy - 1, 1, 2.5);
            }
            for (int a = 0; a < 2; a++) { 
            //generate 2 cacti in top right of bottom half
               double cx = 50 + 50 * Math.random();
               double cy = 25 + 30 * Math.random();
               PennDraw.setPenColor(PennDraw.GREEN);
               PennDraw.filledRectangle(cx, cy, 2, 5);
               PennDraw.filledRectangle(cx + 2, cy + 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx - 2, cy - 2.5, 2.5, 1);
               PennDraw.filledRectangle(cx + 3.5, cy + 4, 1, 2.5);
               PennDraw.filledRectangle(cx - 3.5, cy - 1, 1, 2.5);
            }
            PennDraw.nextKeyTyped(); // do nothing with key typed
            PennDraw.advance();
            cycle++; //change day cycle
         }
      }
   }
}