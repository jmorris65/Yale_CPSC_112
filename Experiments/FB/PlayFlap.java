public class PlayFlap {
   private FlappyBird player;
   private TubeNode head;
   private int score;
   
   public PlayFlap() {
      player = new FlappyBird(15, 50);
      head = null; 
      score = 0;
   }
   
   public void addTube() {
      TubeNode placeholder = new TubeNode();
      placeholder.setNext(head);
      head = placeholder;
   }
   
   public void moveEverything(int frames) {
      player.incrementVelocity(frames);
      player.move(frames);
      if (head != null)
         head.moveTubes(frames);
      else 
         return;
   }
   
   public void jump() {
      player.jump();
   }
   
   public void drawScreen() {
      PennDraw.clear(PennDraw.BLUE);
      if (head != null)
         for (TubeNode block = head; block.getNext() != null; block = block.getNext())
            block.getTube().draw();
      player.draw();
      PennDraw.setPenColor(PennDraw.BLACK);
      PennDraw.setFontSize(30);
      String w = "" + score;
      PennDraw.text(10, 90, w);
   }
   
   public boolean checkLoss() {
      if (head != null) {
         for (TubeNode block = head; block.getNext() != null; block = block.getNext()) {
         
            double[] box = block.getTube().getRange();
            double[] bird = player.getRange();
            
            if (box[0] >= bird[0] && box[0] <= bird[1]) {
               if (bird[3] >= box[3] || bird[2] <= box[4])
                  return false;
            }
            
            if (box[1] >= bird[0] && box[1] <= bird[1]) {
               if (bird[3] >= box[3] || bird[2] <= box[4])
                  return false;
            }
            
            if (bird[0] >= box[0] && bird[1] <= box[1]) {
               if (bird[3] >= box[3] || bird[2] <= box[4])
                  return false;
            }
            
            if (bird[2] < -5)
               return false;
               
            if (bird[3] > 105)
               return false;
         }
      }
      return true;
   }
  
   public void addPoints() {
      if (head != null) {
         score += head.addPoint();
         if (head.getTube().getRange()[1] < -80)
            head = head.getNext();
      }
   }
   
   public static void main(String[] args) {
      PennDraw.setScale(0, 100);
      PlayFlap game = new PlayFlap();
      int frames = 35;
      PennDraw.enableAnimation(frames);
      boolean alive = true;
      int tubeCounter = 0;
    
      while(alive) {
         if (PennDraw.hasNextKeyTyped()) {
            char i = PennDraw.nextKeyTyped();
            if (i == ' ')
               game.jump();
         }
       
         if (tubeCounter % 50 == 0)
            game.addTube();
       
         alive = game.checkLoss();
         game.moveEverything(frames);
         game.addPoints();
         game.drawScreen();
         PennDraw.advance();
         tubeCounter++;
      }
   }
}