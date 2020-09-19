public class BinaryConverter {
   public static String decimalToBinary(double number) {
      if (number == 0)
         return "0";
      int sign = 0;
      if (number < 0) {
         number = Math.abs(number);
         sign = 1;
      }
      String placeholder = Double.toString(number);
      int point = placeholder.indexOf(".");
      double decimal = 0;
      int whole = 0;
      if (point >= 0) {
         whole = Integer.parseInt(placeholder.substring(0, point));
         decimal = number - whole;
      }
      else 
         whole = Integer.parseInt(placeholder);
     
      String backWhole = "";
      while (whole != 0) {
         backWhole += (whole % 2) + " ";
         whole = whole / 2;
      }
      String wholeString = "";
      for (int i = 0; i < backWhole.length(); i++)
         wholeString += backWhole.charAt(backWhole.length() - 1 - i);
      
      int bits = 0;
      String decimalString = "";
      while (decimal != 0 && bits < 40) {
         decimal = decimal * 2;
         
         if (decimal >= 1.0) {
            decimalString += "1 ";
            decimal--;
         }
         else
            decimalString += "0 ";
         bits++;
      }
      
      wholeString = wholeString.trim();
      decimalString = decimalString.trim();
      
      if (decimalString.equals(""))
         return wholeString;
      else if (wholeString.equals(""))
         return "0 . " + decimalString;
      else
         return wholeString + " . " + decimalString;
   }
   
   public static String twoComplement(double number) {
      int sign = 0;
      String bits = decimalToBinary(number);
      if (number < 0)
         sign = 1;
      if (sign == 0) {
         bits = "0 " + bits;
         if (bits.charAt(0) == '0' && bits.charAt(2) == '0')
            bits = bits.substring(1, bits.length());
         return bits.trim();
      }
      else {
         bits = "0 " + bits + " ";
         bits = bits.replace("0", "h");
         bits = bits.replace("1", "l");
         bits = bits.replace("h", "1");
         bits = bits.replace("l", "0");
         for (int i = 0; i < bits.length(); i++) {
            char str = bits.charAt(bits.length() - 1 - i);
            if (str == '1') {
               String placeholder = bits.substring(bits.length() - i);
               bits = bits.substring(0, bits.length() - 1 - i) + "0" + placeholder;
            }
            else if (str == '0') {
               String placeholder = bits.substring(bits.length() - i);
               bits = bits.substring(0, bits.length() - 1 - i) + "1" + placeholder;
               if (bits.charAt(0) == '0')
                  bits = bits.substring(1, bits.length());
               bits = bits.trim();
               if (bits.charAt(0) == '1' && bits.charAt(2) == '1')
                  bits = bits.substring(1, bits.length());
               return bits.trim();
            }
         }
      }
      return "";
   }
   
   public static String[] floatingPoint(double number) {
      int sign = 0;
      if (number < 0)
         sign = 1;
      String bits = decimalToBinary(number);
      if (number == (int) number)
         bits = bits + " . 0";
      int point = bits.indexOf('.');
      int one = bits. indexOf('1');
      int exponent = (point - one) / 2;
      if (number >= 1 || number <= -1)
         exponent--;
      String exponentString = decimalToBinary(127 + exponent);
      if (exponentString.length() < 15)
         exponentString = "0 " + exponentString;
      String placeholder = bits.substring(point + 1);
      placeholder = placeholder.trim();
      bits = bits.substring(0, point);
      bits = bits + placeholder + " ";
      bits = bits.substring(bits.indexOf("1") + 1);
      int bitCount = 0;
      for (int i = 0; i < bits.length(); i++) {
         if (bits.charAt(i) == '1' || bits.charAt(i) == '0')
            bitCount++;
      } 
      
      if (bitCount > 23) {
         bits = bits.substring(0, 46);
      } 
      while (bitCount < 23) {
         bits = bits + "0 ";
         bitCount++;
      }
      
      String signString = Integer.toString(sign);
      String[] strArray = {signString.trim(), exponentString.trim(), bits.trim()};
      return strArray;
   
   }
   
   public static void main(String[] args) {
      double val = Double.parseDouble(args[0]);
      String mag = decimalToBinary(val);
      String twos = twoComplement(val);
      String[] floats = floatingPoint(val);
      
      System.out.println("Magnitude: " + mag);
      System.out.println("Two's Compliment: " + twos);
      System.out.println("Sign: " + floats[0] + " Exponenet: " + floats[1] + " Mantissa: " + floats[2]);
   }
}