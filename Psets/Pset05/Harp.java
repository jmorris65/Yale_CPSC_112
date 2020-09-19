/* Name: Jalil Morris
 *
 * Net ID: jim33
 *
 * Execution: java Harp
 *
 * Create a Harp with 37 keys
 *
 */

public class Harp {
   private static String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
   private static int FREQUENCY = 440;
   public static void main(String[] args) {
   
      HarpString[] bigHarp = new HarpString[NOTE_MAPPING.length()];
      
      
      for (int i = 0; i < bigHarp.length; i++) // sets frequencies
         bigHarp[i] = new HarpString(FREQUENCY * Math.pow(2, (i - 24.0) / 12.0)); 
         
      while (true) {
         if (PennDraw.hasNextKeyTyped()) { // pluck string
            char keyPressed = PennDraw.nextKeyTyped();
            int key = NOTE_MAPPING.indexOf(keyPressed);
            if (key >= 0)
               bigHarp[key].pluck();
         }
         
         double music = 0.0;
         for (int i = 0; i < bigHarp.length; i++) // adds all Harp samples together
            music += bigHarp[i].sample();
            
         StdAudio.play(music);
        
         for (int i = 0; i < bigHarp.length; i++) // tics everything
            bigHarp[i].tic();
      }
   }
}