public class Reverse {
   public static void main(String[] args) {
      String[] reverseWord = new String[args.length];
      int j = 0;
      for (int i = args.length - 1; i >= 0; i--) {
         reverseWord[j] = args[i];
         j++;
      }
      String everything = "";
      for (int l = 0; l < args.length; l++) {
         everything += reverseWord[l] + " ";
      }
      System.out.println(everything);
      System.out.println();
      String words = "";
      
      for (int m = 0; m < args.length; m++) {
         words = words + args[m] + " ";
      }
         
      char[] letters = words.toCharArray();
      char[] reverseLetters = new char[letters.length];
      
      for (int n = 0; n < letters.length; n++) {
         reverseLetters[n] = letters[letters.length - n - 1];
      }
      
      for (int o = 0; o < reverseLetters.length; o++) {
         System.out.print(reverseLetters[o]);
      }
      
      System.out.println();
   }
}