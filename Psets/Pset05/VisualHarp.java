/* Name: Jalil Morris
 *
 * Net ID: jim33
 *
 * Execution: java VisualHarp
 *
 * Create images to go with sounds
 *
 */
public class VisualHarp {
   private static String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
   private static int FREQUENCY = 440;
   public static void main(String[] args) {
   
      HarpString[] bigHarp = new HarpString[NOTE_MAPPING.indexOf(" ") + 1];
      // creates ring buffer for y values
      RingBuffer visualHarpY = new RingBuffer(1000); 
      double[] visualHarpX = new double[1000];
      for (int i = 0; i < 1000; i++) // creates x values fro polyline
         visualHarpX[i] = i * 0.001;
      int counter = 0;
      
      PennDraw.enableAnimation(50);
      
      
      for (int i = 0; i < bigHarp.length; i++) // sets frequencies
         bigHarp[i] = new HarpString(FREQUENCY * Math.pow(2, (i - 24.0) / 12.0)); 
         
      while (true) {
         if (PennDraw.hasNextKeyTyped()) { // plucks string
            char keyPressed = PennDraw.nextKeyTyped();
            int key = NOTE_MAPPING.indexOf(keyPressed);
            if (key >= 0)
               bigHarp[key].pluck();
         }
         
         double music = 0.0;
         for (int i = 0; i < bigHarp.length; i++) // adds samples together
            music += bigHarp[i].sample();
        
         if (visualHarpY.isFull())
            visualHarpY.dequeue();
         
         if (counter % 2 == 0) // enqueues samples
            visualHarpY.enqueue(0.5 + music);
         
         if (counter % 2000 == 0) { // advances every 2000 tics
            PennDraw.clear();
            double [] visualHarpY2 = visualHarpY.toDoubleArray();
            PennDraw.polyline(visualHarpX, visualHarpY2);
            PennDraw.advance();
         }
            
         StdAudio.play(music);
        
         for (int i = 0; i < bigHarp.length; i++) // tics every string
            bigHarp[i].tic();
        
        
         counter++;
      }
   
   }
}