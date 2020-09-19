public class Vigenere {
   public static void main(String[] args) {
   
      String job = args[0]; // takes arguments
      String filename = args[1];
      String keyword = args[2];
   
      if (job.equals("encrypt")) { // checks arguments and encrpyt
         String message = encrypt(filename, keyword);
         System.out.println(message);
      }
      
      if (job.equals("decrypt")) { // check arguments and decrypt
         String message = decrypt(filename, keyword);
         System.out.println(message);
      }
   
   }
   
   // convert string to int array with numbers representing characters
   public static int[] stringToSymbolArray(String str) {
      String a = str.toUpperCase();
      char[] b = a.toCharArray();
      int[] c = new int[b.length];
      for (int i = 0; i < b.length; i++) {
         int d = (int) b[i];
         c[i] = d - 65;
      }
      return c;
   }
   
   // convert int array back to String 
   public static String symbolArrayToString(int[] symbols) {
      int [] a = symbols;
      String d = "";
      for (int i = 0; i < a.length; i++) {
         int c = a[i];
         d += (char) (c + 65);
      }
      return d;
   }
   
   // turn keyword into symbol array and shift using symbols
   public static int[] shift(int[] symbols, String keyword) {
      String newKeyword = keyword.toUpperCase();
      int[] keywordNumbers = new int[symbols.length];
      int[] newSymbols = new int[symbols.length];
      char[] letters = newKeyword.toCharArray();
      int counter = 0;
      
      for (int i = 0; i < keywordNumbers.length; i++) {
         if (counter >= letters.length) counter = 0;
         keywordNumbers[i] = (int) letters[counter] - 65;
         counter++;
      }
      
      for (int i = 0; i < newSymbols.length; i++) { // add symbols together
         if (symbols[i] >= 0 && symbols[i] <= 25)
            newSymbols[i] = symbols[i] + keywordNumbers[i];
         else newSymbols[i] = symbols[i];
         if (newSymbols[i] > 25) newSymbols[i] -= 26;
      }
         
      return newSymbols;
   }
   
   // encrpyt using Vigenere's encryption return encrypted message
   public static String encrypt(String messageFile, String keyword) {
      In message = new In(messageFile);
      String words  = message.readAll();
      int[] symbols = stringToSymbolArray(words);
      int[] newSymbols = shift(symbols, keyword);
      String newMessage = symbolArrayToString(newSymbols);
      return newMessage;
   }
   
   // unshift symbols using keyword
   public static int[] unshift(int[] symbols, String keyword) {
      String newKeyword = keyword.toUpperCase();
      int[] keywordNumbers = new int[symbols.length];
      int[] newSymbols = new int[symbols.length];
      char[] letters = newKeyword.toCharArray();
      int counter = 0;
      
      for (int i = 0; i < keywordNumbers.length; i++) {
         if (counter >= letters.length) counter = 0;
         keywordNumbers[i] = (int) letters[counter] - 65;
         counter++;
      }
      
      for (int i = 0; i < newSymbols.length; i++) {
         if (symbols[i] >= 0 && symbols[i] <= 25) {
            newSymbols[i] = symbols[i] - keywordNumbers[i];
            if (newSymbols[i] < 0) newSymbols[i] += 26;
         }
         else newSymbols[i] = symbols[i];
      }
         
      return newSymbols;
   }
   
   // decrypt using Vigerene's encryption
   public static String decrypt(String messageFile, String keyword) {
      In message = new In(messageFile);
      String words  = message.readAll();
      int[] symbols = stringToSymbolArray(words);
      int[] newSymbols = unshift(symbols, keyword);
      String newMessage = symbolArrayToString(newSymbols);
      return newMessage;
   }


}