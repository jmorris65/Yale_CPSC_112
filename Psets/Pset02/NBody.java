/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 *
 * Use PennDraw to create an animation of planetary motion 
 * using the laws of physics
 *
 */
public class NBody {
   public static void main(String[] args) {
   
      double simulationTime = Double.parseDouble(args[0]); //simulation length
      double timeStep = Double.parseDouble(args[1]); // change in time
      String filename = args[2]; //file to be read
      
      In systemUnits = new In(filename);
      
      int numParticles = systemUnits.readInt();
      double radius = systemUnits.readDouble();
      
      //variables necessary to read file
      double[] mass = new double[numParticles];
      double[] px = new double[numParticles];
      double[] py = new double[numParticles];
      double[] vx = new double[numParticles];
      double[] vy = new double[numParticles];
      String[] img = new String[numParticles];
      
      //variables necessary to make calculations
      double G = 6.67e-11;
      double distance = 0;
      double deltaX = 0;
      double deltaY = 0;
      double force = 0;
      double forceX = 0;
      double forceY = 0;
      double sumX = 0;
      double sumY = 0;
      double accelerationX = 0;
      double accelerationY = 0;
      
      //read contents of file
      for (int i = 0; i < numParticles; i++) {
         mass [i] = systemUnits.readDouble();
         px [i] = systemUnits.readDouble();
         py [i] = systemUnits.readDouble();
         vx [i] = systemUnits.readDouble();
         vy [i] = systemUnits.readDouble();
         img [i] = systemUnits.readString();
      }
      
      //create background and draw planets
      PennDraw.setScale(-radius, radius);
      PennDraw.picture(0, 0, "starfield.jpg");
      for (int j = 0; j < numParticles; j++) {
         PennDraw.picture(px[j], py[j], img[j]);
      }
      
      //start animation
      double elapsedTime = 0;
      PennDraw.enableAnimation(30);
      
      while (elapsedTime < simulationTime) {
         //redraw background
         PennDraw.picture(0, 0, "starfield.jpg");
         //edit the accelerations and velocities using the forces
         for (int l = 0; l < numParticles; l++) {
            for (int m = numParticles - 1; m >= 0; m--) {
               if (m != l) {
                  deltaX = px[m] - px[l];
                  deltaY = py[m] - py[l];
                  distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
                  force = ((G * mass[l]) / (distance * distance)) * mass[m];
                  forceX = (force * deltaX) / distance;
                  forceY = (force * deltaY) / distance;
                  sumX += forceX * timeStep;
                  sumY += forceY * timeStep;
               }
            }
            accelerationX = sumX / mass[l];
            accelerationY = sumY / mass[l];
            vx[l] += accelerationX;
            vy[l] += accelerationY;
            sumX = 0;
            sumY = 0;
         }
         //change the positions 
         for (int k = 0; k < numParticles; k++) {
            px[k] += timeStep * vx[k];
            py[k] += timeStep * vy[k];
         }
         //redraw planets 
         for (int j = 0; j < numParticles; j++) {
            PennDraw.picture(px[j], py[j], img[j]);
         }
         PennDraw.advance();
         elapsedTime += timeStep;
      }
      System.out.printf("%d\n", numParticles);
      System.out.printf("%.2e\n", radius);
      for (int i = 0; i < numParticles; i++) {
         System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n", 
            mass[i], px[i], py[i], vx[i], vy[i], img[i]);
      }
   }
}