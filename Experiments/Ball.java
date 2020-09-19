public class Ball {
   public static void main(String[] args) {
      double coin = Math.random();
      if (coin < 0.5) {
         System.out.println("Yes");
      }
      else {
         System.out.println("No");
      } 
   }
}