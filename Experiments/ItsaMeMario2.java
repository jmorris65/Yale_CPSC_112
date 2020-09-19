/* Name: Jalil Morris
 * Net ID: jim33
 *
 * Execution: java Itsa Me, Mario
 *
 * Itsa Me, Mario
 *
 */
 
public class ItsaMeMario2 {
   public static void main(String[] args) {
      PennDraw.setCanvasSize(500, 500);
      
      //Draw blue background
      PennDraw.clear(131, 252, 252);
      
      //Change coordinate grid
      PennDraw.setXscale(0, 30);
      PennDraw.setYscale(0, 30);
      
      //Draw red hat
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledRectangle(10, 18, 3, 0.5);
      PennDraw.filledRectangle(10.5, 17, 4.5, 0.5);
      
      //Draw face (Line 1)
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledRectangle(7.5, 16, 1.5, 0.5);
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(11, 16, 2, 0.5);
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.filledSquare(11.5, 16, 0.5);
      
      //Draw face (Line 2)
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledSquare(5.5, 15, 0.5);
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(10.5, 15, 4.5, 0.5);
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledSquare(7.5, 15, 0.5);
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.filledSquare(11.5, 15, 0.5);
      
      //Draw face (Line 3)
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledSquare(5.5, 14, 0.5);
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(11, 14, 5, 0.5);
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledRectangle(8, 14, 1, 0.5);
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.filledSquare(12.5, 14, 0.5);
      
      //Draw face (Line 4)
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledRectangle(6, 13, 1, 0.5);
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(9, 13, 2, 0.5);
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.filledRectangle(13, 13, 2, 0.5);
      
      //Draw face (Line 5)
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(10, 12, 4, 0.5);
      
      //Clothes (Line 1)
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledRectangle(10, 11, 3, 0.5);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledSquare(8.5, 11, 0.5);
      PennDraw.filledSquare(11.5, 11, 0.5);
      
      //Clothes (Line 2)
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledRectangle(10, 10, 5, 0.5);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledSquare(8.5, 10, 0.5);
      PennDraw.filledSquare(11.5, 10, 0.5);
      
      //Clothes (Line 3)
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledRectangle(6, 9, 2, 0.5);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledRectangle(10, 9, 2, 0.5);
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledRectangle(14, 9, 2, 0.5);
      
      //Clothes (Line 4)
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(10, 8, 6, 0.5);
      PennDraw.setPenColor(255, 0, 0);
      PennDraw.filledRectangle(10, 8, 4, 0.5);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledRectangle(10, 8, 3, 0.5);
      PennDraw.setPenColor(250, 255, 0);
      PennDraw.filledSquare(8.5, 8, 0.5);
      PennDraw.filledSquare(11.5, 8, 0.5);
      
      //CLothes (Line 5)
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(10, 7, 6, 0.5);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledRectangle(10, 7, 3, 0.5);
      
      //Clothes (Line 6)
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(10, 6, 6, 0.5);
      PennDraw.setPenColor(0, 0, 255);
      PennDraw.filledRectangle(10, 6, 4, 0.5);
      
      //Clothes (Line 7)
      PennDraw.filledRectangle(7.5, 5, 1.5, 0.5);
      PennDraw.filledRectangle(12.5, 5, 1.5, 0.5);
      
      //Clothes (Line 8)
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledRectangle(6.5, 4, 1.5, 0.5);
      PennDraw.filledRectangle(13.5, 4, 1.5, 0.5);
      
      //Clothes (Line 9)
      PennDraw.filledRectangle(6, 3, 2, 0.5);
      PennDraw.filledRectangle(14, 3, 2, 0.5);
      
      //Draw Goomba 1
      //Feet
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.filledRectangle(21.5, 2.75, 1.25, 0.25);
      PennDraw.filledRectangle(25, 2.75, 1.25, 0.25);
      PennDraw.filledRectangle(21.25, 3, 1.5, 0.25);
      PennDraw.filledRectangle(25.25, 3, 1.5, 0.25);
      PennDraw.filledRectangle(21, 3.25, 1.25, 0.25);
      PennDraw.filledRectangle(25.5, 3.25, 1.25, 0.25);
      PennDraw.filledRectangle(20.75, 3.5, 0.5, 0.25);
      PennDraw.filledRectangle(25.75, 3.5, 0.5, 0.25);
      
      //Stem
      PennDraw.setPenColor(252, 212, 131);
      PennDraw.filledRectangle(23.25, 3.25, 1, 0.25);
      PennDraw.filledRectangle(23.25, 3.5, 2, 0.25);
      PennDraw.filledRectangle(23.25, 3.75, 2, 0.25);
      PennDraw.filledRectangle(23.25, 4, 2, 0.25);
      PennDraw.filledRectangle(23.25, 4.25, 1.5, 0.25);
      
      //Head
      PennDraw.setPenColor(84, 36, 0);
      PennDraw.filledRectangle(20.75, 4.25, 1, 0.25);
      PennDraw.filledRectangle(25.75, 4.25, 1, 0.25);
      PennDraw.filledRectangle(23.25, 4.5, 4, 0.25);
      PennDraw.filledRectangle(23.25, 4.75, 4, 0.25);
      PennDraw.filledRectangle(23.25, 5, 4, 0.25);
      PennDraw.filledRectangle(23.25, 5.25, 4, 0.25);
      PennDraw.filledRectangle(23.25, 5.5, 3.5, 0.25);
      PennDraw.filledRectangle(23.25, 5.75, 3.5, 0.25);
      PennDraw.filledRectangle(23.25, 6, 3.5, 0.25);
      PennDraw.filledRectangle(23.25, 6.25, 3, 0.25);
      PennDraw.filledRectangle(23.25, 6.5, 2.5, 0.25);
      PennDraw.filledRectangle(23.25, 6.75, 2, 0.25);
      PennDraw.filledRectangle(23.25, 7, 1.5, 0.25);
      PennDraw.filledRectangle(23.25, 7.25, 1, 0.25);
      
      //Eyes
      PennDraw.setPenColor(0, 0, 0);
      PennDraw.filledRectangle(21.5, 5.75, 0.5, 0.25);
   }
}