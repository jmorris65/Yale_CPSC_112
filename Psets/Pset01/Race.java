/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 *Create a race simulation between two unique shapes
 */
 
public class Race {
   public static void main(String[] args) {
      // generate background
      PennDraw.setCanvasSize(512, 512);
      PennDraw.setScale(0, 20);
      PennDraw.clear(255, 255, 255);
      
      // generate list containing Y values (these are static)
      double[] bcarY = {12.25, 13, 13, 13.5, 13.5, 13, 13, 12.25};
      double[] rcarY = {7.25, 8, 8, 8.5, 8.5, 8, 8, 7.25};
      
      // generate list containing initial x values
      double[] bcarX0 = {2, 2, 1.65, 1.65, 0.65, 0.65, 0.3, 0.3};
      double[] rcarX0 = {2, 2, 1.65, 1.65, 0.65, 0.65, 0.3, 0.3};
      
      // will later be sum of x positions
      double both = 0;
      
      //draw finish line
      PennDraw.setPenColor(0, 0, 0);     
      PennDraw.rectangle(2, 10, 0.5, 10.5);
      PennDraw.setPenRadius(0.004);
      PennDraw.line(19, 0, 19, 19);
      PennDraw.setFontSize(20);
      PennDraw.text(19, 19.5, "Finish");
      
      //draw start line
      for (int sq1 = 1; sq1 <= 20; sq1 += 2) {
         PennDraw.setPenColor(0, 0, 0);
         PennDraw.filledRectangle(1.75, sq1, 0.25, 0.5);
      }
      for (int sq1 = 0; sq1 <= 20; sq1 += 2) {
         PennDraw.setPenColor(0, 0, 0);
         PennDraw.filledRectangle(2.25, sq1, 0.25, 0.5);
      }
      
      //draw cars at start
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledPolygon(bcarX0, bcarY);
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledPolygon(bcarX0, rcarY); 
      
      //start animation
      PennDraw.enableAnimation(30);
      PennDraw.setFontSize(20);
      
      //cars don't move until it says go rsg stands for ready set go
      boolean start = false;
      for (int rsg = 0; rsg < 60; rsg++) {
         if (rsg < 20) {
            PennDraw.text(15, 15, "READY");
            PennDraw.setPenColor(255, 0, 0);
            PennDraw.filledCircle(17.5, 15, 0.7);
            PennDraw.advance();
         }
         else if (rsg < 40) {
            PennDraw.text(15, 13, "SET");
            PennDraw.setPenColor(255, 255, 0);
            PennDraw.filledCircle(17.5, 13, 0.7);
            PennDraw.advance();
         }
         else if (rsg < 59) {
            PennDraw.setFontSize(40);
            PennDraw.text(15, 11, "GO");
            PennDraw.setPenColor(0, 255, 0);
            PennDraw.filledCircle(17.5, 11, 0.7);
            PennDraw.advance();
         }
         else { // now start
            start = true; 
         }
      }
      //setting parameters for cars BX is blue car RX is red car
      double bX12 = 2, bX34 = 1.65, bX56 = 0.65, bX78 = 0.3;
      double rX12 = 2, rX34 = 1.65, rX56 = 0.65, rX78 = 0.3;
      while ((both < 38) && (start == true)) {
         if ((bX34 < 19) && (rX34 < 19)) {
            // clear and recreate background and move car
            PennDraw.clear(255, 255, 255);
            PennDraw.setPenColor(0, 0, 0);     
            PennDraw.rectangle(2, 10, 0.5, 10.5);
            PennDraw.setPenRadius(0.004);
            PennDraw.line(19, 0, 19, 19);
            PennDraw.setFontSize(20);
            PennDraw.text(19, 19.5, "Finish");
            for (int sq1 = 1; sq1 <= 20; sq1 += 2) {
               PennDraw.setPenColor(0, 0, 0);
               PennDraw.filledRectangle(1.75, sq1, 0.25, 0.5);
            }
            for (int sq1 = 0; sq1 <= 20; sq1 += 2) {
               PennDraw.setPenColor(0, 0, 0);
               PennDraw.filledRectangle(2.25, sq1, 0.25, 0.5);
            }
            //car speeds
            double blueM = 0.2 * Math.random();
            double redM = 0.2 * Math.random();
            //car positions
            double[] bcarX = {bX12, bX12, bX34, bX34, bX56, bX56, bX78, bX78};
            double[] rcarX = {rX12, rX12, rX34, rX34, rX56, rX56, rX78, rX78};
            //redraw cars
            PennDraw.setPenColor(0, 0, 255);
            PennDraw.filledPolygon(bcarX, bcarY);
            PennDraw.setPenColor(255, 0, 0);
            PennDraw.filledPolygon(rcarX, rcarY);
            bX12 += blueM; 
            bX34 += blueM; 
            bX56 += blueM; 
            bX78 += blueM;
            rX12 += redM; 
            rX34 += redM; 
            rX56 += redM; 
            rX78 += redM;
            PennDraw.advance();
         }
         else { //pause for a moment
            both += 1.0;
            PennDraw.advance();
         }
      }
      if ((both >= 38) && (bX34 == rX34)) { // if they tie
         PennDraw.setPenColor(0, 0, 0);
         PennDraw.setFontSize(40);
         PennDraw.text(10, 10, "Fuck they tied...");
         PennDraw.advance();
      }
      else if ((both >= 38) && (bX34 > rX34)) { //if blue car wins
         PennDraw.setPenColor(0, 0, 0);
         PennDraw.setPenRadius(0.022);
         for (double i = 30; i > 2; i = i - 0.5) { // pause and do winner animation
            if (i > 25) {
               PennDraw.setFontSize(25);
               PennDraw.text(10, 18, "And the winner is...");
               PennDraw.advance();
            }
            else {
               PennDraw.setPenColor(0, 0, 255);
               PennDraw.arc(18.5, 12.875, i, 0, 360);
               PennDraw.advance();
            }
         }
      }
      else if ((both >= 36.6) && (rX34 > bX34)) { //if red car wins
         PennDraw.setPenColor(0, 0, 0);
         PennDraw.setPenRadius(0.022);
         for (double j = 30; j > 2; j = j - 0.5) { //pause and do winner animation
            if (j > 25) {
               PennDraw.setFontSize(25);
               PennDraw.text(10, 18, "And the winner is...");
               PennDraw.advance();
            }
            else {
               PennDraw.setPenColor(255, 0, 0);
               PennDraw.arc(18.5, 7.875, j, 0, 360);
               PennDraw.advance();
            }
         }
      }
   }
}