public class Caesar {
   public static void main(String[] args) {
   
      String job = args[0]; //take arguments
      String filename = args[1];
      String other = args[2];
      
      In messagefile = new In(filename); // In the file that has the message
      String message = messagefile.readAll();
      int key = 0;
   
      if (job.equals("encrypt")) { // check arguments
         if ((int) other.charAt(0) >= 65 && (int) other.charAt(0) <= 90) {
            key = (int) other.charAt(0) - 65;
         }
         else {
            key = Integer.parseInt(other);
         } // if other is a letter convert to int if not parse integer
         
         String enMessage = encrypt(message, key);
         System.out.println(enMessage);
      }
      
      else if (job.equals("decrypt")) { // same as above with decrypt
         if ((int) other.charAt(0) >= 65 && (int) other.charAt(0) <= 90) {
            key = (int) other.charAt(0) - 65;
         }
         else {
            key = Integer.parseInt(other);
         }
         String deMessage = decrypt(message, key);
         System.out.println(deMessage);
      }
      
      else if (job.equals("crack")) { //crack using files in arguments
         String crackedMessage = crack(message, other);
         System.out.println(crackedMessage);
      }
   }
   
   // takes message and file with frequencies and cracks encryption
   public static String crack(String message, String englishFile) { 
      In freqFile = new In(englishFile);
      double [] freqNumbers = getDictionaryFrequencies(freqFile);
      
      //get initial summation of scored frequencies
      int[] symbolism = stringToSymbolArray(message);
      int key = 0;
      double total = 0;
      double[] frequencies = findFrequencies(symbolism);
      double[] scoredFrequencies = scoreFrequencies(frequencies, freqNumbers);
      for (int i = 0; i < 26; i++) {
         total += scoredFrequencies[i];
      }
      
      // decrypt using each letter in alphabet and compute frequencies
      for (int i = 0; i < 26; i++) {
         double newTotal = 0;
         String newMessage = decrypt(message, i);
         
         int[] newSymbolism = stringToSymbolArray(newMessage);
         
         double[] newFrequencies = findFrequencies(newSymbolism);
         double[] newScoredFrequencies = scoreFrequencies(newFrequencies, 
            freqNumbers);
      
         for (int j = 0; j < 26; j++) { 
            newTotal += newScoredFrequencies[j];
         }
         
         if (newTotal < total) { // compare and save the lowest scored frequencies
            total = newTotal;
            key = i;
         }
      }
      //System.out.println(key); (originally to print key and corresponding letter)
      //System.out.println((char) (key + 65)); (c out to match checkstyle)
      
      String newMessage = decrypt(message, key);
      return newMessage; // return cracked message
   }
   
   // take frequencies and find differences between that and english frequencies
   public static double[] scoreFrequencies(double [] freqs, double[] englishFreqs) {
      double[] scores = new double[26];
      for (int i = 0; i < 26; i++) scores[i] = Math.abs(freqs[i] - englishFreqs[i]);
      return scores;
   }
   
   // create a int array containing the frequencies in the message
   public static double[] findFrequencies(int[] symbols) {
      double[] amount = new double[26];
      for (int i = 0; i < 26; i++) {
         int counter = 0;
         for (int j = 0; j < symbols.length; j++) {
            if (symbols[j] == i) counter++;
         }
         amount[i] = counter;
      }
      int total = 0;
      for (int i = 0; i < 26; i++)
         total += amount[i];
      for (int i = 0; i < 26; i++)
         amount[i] = amount[i] / total;
     
      return amount;
   }
   
   // take english.txt and store frequencies in a double array
   public static double[] getDictionaryFrequencies(In dictionary) {
      double[] numbers = new double [26];
      for (int i = 0; i < numbers.length; i++)
         numbers[i] = dictionary.readDouble();
      return numbers;
   }
   
   // takes message and shifts by key and returns new message
   public static String encrypt(String message, int key) {
      int[] a = stringToSymbolArray(message);
      for (int i = 0; i < a.length; i++)
         a[i] = shift(a[i], key);
      String b = symbolArrayToString(a);
      return b;
   }
   
   // takes message and unshifts by key and returns new message 
   public static String decrypt(String message, int key) {
      int[] a = stringToSymbolArray(message);
      for (int i = 0; i < a.length; i++)
         a[i] = unshift(a[i], key);
      String b = symbolArrayToString(a);
      return b;
   }

   // takes string converts to char array and converts to symbol array
   public static int[] stringToSymbolArray(String str) {
      String a = str.toUpperCase();
      char[] b = a.toCharArray();
      int[] c = new int[b.length];
      for (int i = 0; i < b.length; i++) {
         int d = (int) b[i];
         c[i] = d - 65; // takes char and subtracts by 65 so range (0 - 25)
      }
      return c;
   }
   
   // takes symbol array adds 65 and convert back to char 
   public static String symbolArrayToString(int[] symbols) {
      int [] a = symbols;
      String d = "";
      for (int i = 0; i < a.length; i++) {
         int c = a[i];
         d += (char) (c + 65); // add chars together to form a new string 
      }
      return d;
   }
   
   // shift letter by offset
   public static int shift(int symbol, int offset) {
      if (symbol < 0 || symbol > 25) 
         return symbol;
      int a = symbol + offset;
      if (a > 25) a -= 26;
      return a;
   }
   
   // unshift letter by offset
   public static int unshift(int symbol, int offset) {
      if (symbol < 0 || symbol > 25) 
         return symbol;
      int a = symbol - offset;
      if (a < 0) a += 26;
      return a;
   }
}