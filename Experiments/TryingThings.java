public class TryingThings {
   public static void main(String[] args) {
   
      String words = "";
      for (int i = 0; i < args.length; i++) {
         words = words + args[i] + " ";
      }
      char [] letters = words.toCharArray();
      
      int[] perWord = new int[args.length];
      
      for (int k = 0; k < args.length; k++) {
         char[] a = args[k].toCharArray();
         perWord[k] = a.length;
      }
      
      int total = 0;
      boolean stop = false;
      boolean stop2 = false;
      int wordStop = 0;
      int wordStop2 = 0;
      int wordStop3 = 0;
      
      for (int j = 0; j < args.length; j++) {
         total += perWord[j] + 1;
         if (total >= 26) {
            wordStop3 = j;
         }
         if (total > 14 && total < 28) {
            wordStop2 = j + 1;
         }
         if (stop2 == false && total >= 28) {
            wordStop2 = j;
            stop2 = true;
         }
         if (stop == false && total >= 14) {
            wordStop = j;
            stop = true;
         }
         if (total < 14) {
            wordStop = j + 1;
         }
      }
      
      
      PennDraw.setCanvasSize(512, 512);
      PennDraw.setScale(0, 100);
      PennDraw.clear(PennDraw.WHITE);
      
      int firstRow = 0;
      for (int k = 0; k < wordStop; k++) {
         firstRow += perWord[k];
      }
      
      int secondRow = 0;
      for (int m = wordStop; m < wordStop2; m++) {
         secondRow += perWord[m];
      }
      
      int thirdRow = 0;
      for (int o = wordStop2 - 1; o < wordStop3; o++) {
         thirdRow += perWord[o];
      }
      
      int z = 0;
      for (int l = 0; l < firstRow + wordStop; l++) {
         if (letters[l] != ' ') {
            PennDraw.line(0 + 7 * l, 25, 5 + 7 * l, 25);
         }
         z = l + 1;
      }
      
      int y = 0;
      for (int n = 0; n < secondRow + wordStop2 - wordStop; n++) {
         if (letters[z + n] != ' ') {
            PennDraw.line(0 + 7 * n, 15, 5 + 7 * n, 15);
         }
         y = z + n + 1;
      }
      
      for (int p = 0; p < thirdRow + wordStop3 - wordStop2 + 1; p++) {
         if (letters[y + p] != ' ') {
            PennDraw.line(0 + 7 * p, 5, 5 + 7 * p, 5);
         }
      }
      
      System.out.println(secondRow);
   }
}