public class Midterm {
   public static void main(String[] args) {
      int [] a = new int[10];
      for (int i = 0; i < a.length; i++) a[i] = 1;
      for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
      double c = timesTwo(a[2]);
      System.out.println();
      c = c + c;
      System.out.println(c);
   }
   public static double timesTwo(double b) {
      return 2 * b;
   }
}