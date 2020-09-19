public class Drum {
   private static String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
   public static void main(String[] args) {
   
      DrumBeat[] bigDrum = new DrumBeat[NOTE_MAPPING.indexOf(" ") + 1];
      
      
      for (int i = 0; i < bigDrum.length; i++)
         bigDrum[i] = new DrumBeat(200 * Math.pow(2, (i - 24) / 6));
         
      while (true) {
         if (PennDraw.hasNextKeyTyped()) {
            char keyPressed = PennDraw.nextKeyTyped();
            int key = NOTE_MAPPING.indexOf(keyPressed);
            if (key >= 0)
               bigDrum[key].pluck();
         }
         
         double music = 0.0;
         for (int i = 0; i < bigDrum.length; i++)
            music += bigDrum[i].sample();
            
         StdAudio.play(music);
        
         for (int i = 0; i < bigDrum.length; i++)
            bigDrum[i].tic();
      }
   }
}