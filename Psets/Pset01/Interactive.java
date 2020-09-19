public class Interactive {
   public static void main(String[] args) {
   
      PennDraw.setCanvasSize(512, 512);
      PennDraw.setScale(0, 100);
      PennDraw.clear(0, 255, 255);
      
      PennDraw.setPenColor(0, 230, 0);
      PennDraw.filledRectangle(50, 25, 55, 30);
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledSquare(90, 55, 4);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledCircle(90, 55, 3);
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.text(90, 62, "Click me...");
   
      boolean FIRST = true;
      boolean START = true;
      boolean GAME = false;
      boolean HINT1 = false;
      boolean HINT2 = false;
      int POINTS = 0;
      boolean WIN = false;
      boolean D = false, A = false, V = false, E = false, N = false, P = false, O = false, R = false, T = false;
      String[] Message = {"D","A","V","E","N","P","O","R","T"};
   
      PennDraw.enableAnimation(20);
      while (true) {
         if ((START == true) && (FIRST == false)) {
            PennDraw.clear(0, 255, 255);
            PennDraw.setPenColor(0, 230, 0);
            PennDraw.filledRectangle(50, 25, 55, 30);
            PennDraw.setPenColor(255, 0, 0);
            PennDraw.filledSquare(90, 55, 4);
            PennDraw.setPenColor(0, 0, 255);
            PennDraw.filledCircle(90, 55, 3);
            PennDraw.setPenColor(0, 0, 0);
            PennDraw.setFontSize(15);
            if (WIN == true) {
               PennDraw.text(85, 62, "Welcome back!!");
            }
            else {
               PennDraw.text(90, 62, "Fucking noob");
            }
            for (int a = 0; a < 30; a++) {
               PennDraw.setPenColor(0, 0, (int) (255 - 155*Math.random()));
               PennDraw.filledCircle(100*Math.random(), 65 + 35*Math.random(), 1);
            }
            while (PennDraw.hasNextKeyTyped()) {
               PennDraw.nextKeyTyped();
            }
            START = false;
            PennDraw.advance();
         }
         while ((START == false) && (GAME == false) || FIRST == true) {
            if (PennDraw.mousePressed()) {
               double X0 = PennDraw.mouseX();
               double Y0 = PennDraw.mouseY();
               if ((X0 >= 86) && (X0 <= 94) && (Y0 >= 51) && (Y0 <= 59)) {
                  PennDraw.clear(0, 255, 255);
                  PennDraw.setPenColor(0, 230, 0);
                  PennDraw.filledRectangle(50, 25, 55, 30);
                  PennDraw.setPenColor(255, 0, 0);
                  PennDraw.filledSquare(5, 95, 4, 45);
                  PennDraw.setPenColor(0, 0, 255);
                  PennDraw.filledCircle(5, 95, 3);
                  PennDraw.advance();
                  PennDraw.setPenColor(0, 0, 0);
                  for (int b = 0; b < 40; b++) {
                     if (b < 20) {
                        PennDraw.setFontSize(15);
                        PennDraw.text(32, 95, "You have to find the code");
                        PennDraw.advance();
                     }
                     else {
                        PennDraw.setFontSize(15);
                        PennDraw.text(32, 90, "Click around to get hints");
                        PennDraw.advance();
                     }
                  }
                  GAME = true;
                  FIRST = false;
               }
            }
         }
         while (GAME == true) {
            if (PennDraw.mousePressed()) {
               double X1 = PennDraw.mouseX();
               double Y1 = PennDraw.mouseY();
               PennDraw.clear(0, 255, 255);
               PennDraw.setPenColor(0, 230, 0);
               PennDraw.filledRectangle(50, 25, 55, 30);
               PennDraw.setPenColor(255, 0, 0);
               PennDraw.filledSquare(5, 95, 4, 45);
               PennDraw.setPenColor(0, 0, 255);
               PennDraw.filledCircle(5, 95, 3);
               if (HINT1 == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  for (int i = 0; i < 9; i++) {
                     PennDraw.line(2 + 11*i, 5, 10 + 11*i, 5);
                  }
               }
               if (HINT2 == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(15);
                  PennDraw.text(50, 1, "THE BEST RESIDENTIAL COLLEGE");
               }
               if (D == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(6, 10, Message[0]);
               }
               if (A == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(17, 10, Message[1]);
               }
               if (V == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(28, 10, Message[2]);
               }
               if (E == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(39, 10, Message[3]);
               }
               if (N == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(50, 10, Message[4]);
               }
               if (P == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(61, 10, Message[5]);
               }
               if (O == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(72, 10, Message[6]);
               }
               if (R == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(83, 10, Message[7]);
               }
               if (T == true) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(94, 10, Message[8]);
               }
               if (X1 < 50 && Y1 > 75) {
                  for (int c = 0; c < 7; c++) {
                     PennDraw.setPenColor((int) (255*Math.random()), 0, 0);
                     PennDraw.filledCircle(100 - 85*Math.random(), 100 - 15*Math.random(), 3);
                     PennDraw.filledCircle(100*Math.random(), 60 + 25*Math.random(), 3);
                     PennDraw.setPenColor(255, 0, 0);
                     PennDraw.filledCircle(18, 60, 3);
                     PennDraw.setPenColor(0, 0, 0);
                     PennDraw.setFontSize(15);
                     PennDraw.text(18, 60, Message[1]);
                  }
               }
               else if (X1 < 50 && (Y1 <= 75 && Y1 > 50)) {
                  for (int d = 0; d < 7; d++) {
                     PennDraw.setPenColor((int) (255*Math.random()), 0, 0);
                     PennDraw.filledCircle(100 - 85*Math.random(), 100 - 15*Math.random(), 3);
                     PennDraw.filledCircle(100*Math.random(), 60 + 25*Math.random(), 3);
                     PennDraw.setPenColor(255, 0, 0);
                     PennDraw.filledCircle(96, 60, 3);
                     PennDraw.setPenColor(0, 0, 0);
                     PennDraw.setFontSize(15);
                     PennDraw.text(96, 60, Message[8]);
                  }
               }
               else if (X1 < 50 &&  (Y1 <= 50 && Y1 > 25)) {
                  for (int e = 0; e < 7; e++) {
                     PennDraw.setPenColor((int) (255*Math.random()), 0, 0);
                     PennDraw.filledCircle(100 - 85*Math.random(), 100 - 15*Math.random(), 3);
                     PennDraw.filledCircle(100*Math.random(), 60 + 25*Math.random(), 3);
                     PennDraw.setPenColor(255, 0, 0);
                     PennDraw.filledCircle(8, 60, 3);
                     PennDraw.filledCircle(76, 73, 3);
                     PennDraw.setPenColor(0, 0, 0);
                     PennDraw.setFontSize(15);
                     PennDraw.text(8, 60, Message[7]);
                  }
               }
               else if (X1 > 50 && Y1 > 75) {
                  for (int f = 0; f < 7; f++) {
                     PennDraw.setPenColor((int) (255*Math.random()), 0, 0);
                     PennDraw.filledCircle(100 - 85*Math.random(), 100 - 15*Math.random(), 3);
                     PennDraw.filledCircle(100*Math.random(), 60 + 25*Math.random(), 3);
                     PennDraw.setPenColor(255, 0, 0);
                     PennDraw.filledCircle(65, 98, 3);
                     PennDraw.filledCircle(22, 62, 3);
                     PennDraw.setPenColor(0, 0, 0);
                     PennDraw.setFontSize(15);
                     PennDraw.text(65, 98, Message[2]);
                  }
               }
               else if (X1 > 50 && (Y1 <= 75 && Y1 > 50)) {         
                  for (int g = 0; g < 7; g++) {
                     PennDraw.setPenColor((int) (255*Math.random()), 0, 0);
                     PennDraw.filledCircle(100 - 85*Math.random(), 100 - 15*Math.random(), 3);
                     PennDraw.filledCircle(100*Math.random(), 60 + 25*Math.random(), 3);
                     PennDraw.setPenColor(0, 0, 0);
                     for (int i = 0; i < 9; i++) {
                        PennDraw.line(2 + 11*i, 5, 10 + 11*i, 5);
                        HINT1 = true;
                     }
                  }
               }
               else if (X1 > 50 && (Y1 <= 50 && Y1 > 25)) {
                  for (int h = 0; h < 7; h++) {
                     PennDraw.setPenColor((int) (255*Math.random()), 0, 0);
                     PennDraw.filledCircle(100 - 85*Math.random(), 100 - 15*Math.random(), 3);
                     PennDraw.filledCircle(100*Math.random(), 60 + 25*Math.random(), 3);
                     PennDraw.setPenColor(255, 0, 0);
                     PennDraw.filledCircle(98, 73, 3);
                     PennDraw.setPenColor(0, 0, 0);
                     PennDraw.setFontSize(15);
                     PennDraw.text(98, 73, Message[3]);
                     PennDraw.text(50, 1, "THE BEST RESIDENTIAL COLLEGE");
                     HINT2 = true;
                  }
               }
               PennDraw.advance();
            }
            if (PennDraw.hasNextKeyTyped()) {
               char LETTER = PennDraw.nextKeyTyped();
               if (LETTER == 'd' && D == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(6, 10, Message[0]);
                  D = true;
                  POINTS++;
               }
               else if (LETTER == 'a' && A == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(17, 10, Message[1]);
                  A = true;
                  POINTS++;
               }
               else if (LETTER == 'v' && V == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(28, 10, Message[2]);
                  V = true;
                  POINTS++;
               }
               else if (LETTER == 'e' && E == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(39, 10, Message[3]);
                  E = true;
                  POINTS++;
               }
               else if (LETTER == 'n' && N == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(50, 10, Message[4]);
                  N = true;
                  POINTS++;
               }
               else if (LETTER == 'p' && P == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(61, 10, Message[5]);
                  P = true;
                  POINTS++;
               }
               else if (LETTER == 'o' && O == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(72, 10, Message[6]);
                  O = true;
                  POINTS++;
               }
               else if (LETTER == 'r' && R == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(83, 10, Message[7]);
                  R = true;
                  POINTS++;
               }
               else if (LETTER == 't' && T == false) {
                  PennDraw.setPenColor(0, 0, 0);
                  PennDraw.setFontSize(50);
                  PennDraw.text(94, 10, Message[8]);
                  T = true;
                  POINTS++;
               }
               else {
                  D = false;
                  A = false;
                  V = false;
                  E = false;
                  N = false;
                  P = false;
                  O = false;
                  R = false;
                  T = false;
                  HINT1 = false;
                  HINT2 = false;
                  GAME = false;
                  if (POINTS == 9) {
                     WIN = true;
                  }
                  else {
                     WIN = false;
                  }
                  START = true;
                  POINTS = 0;
               }
               PennDraw.advance();
            }
            if (POINTS == 9) {
               PennDraw.setFontSize(60);
               PennDraw.setPenColor(255, 0, 0);
               PennDraw.text(50, 35, "YOU WIN");
               PennDraw.setFontSize(15);
               PennDraw.setPenColor(0, 0, 0);
               PennDraw.text(50, 25, "PRESS ANY KEY TO PLAY AGAIN");
               PennDraw.advance();
            }
         }
      }
   }
}