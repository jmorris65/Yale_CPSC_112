/* Name: Jalil Morris
 *
 * NetID: jim33
 *
 * Execution: java Game
 *
 * Class to combine everything and implement game
 *
 */

public class Game {
   private Invader[] enemies; // array of enemies
   private Invader hero; // player controlled invader
   private ShotNode head; // nodes hold current shots on screen
   private ShotNode current;
   
   // constructor for placeholder game (prior ro game start)
   public Game() {
   }
   
   // constructor to create actual game with user inputs
   public Game(DesignNode node, int val) {
      hero = new Invader(node);
      hero.setPosition(100, 30);
      enemies = new Invader[val];
      for (int i = 0; i < enemies.length; i++) { // enemy intial positions
         enemies[i] = new Invader();
         if (i <= 5)
            enemies[i].setPosition(10 + (35 * i), 190);
         else if (i <= 11)
            enemies[i].setPosition(10 + (35 * (i - 6)), 170);
         else if (i <= 17)
            enemies[i].setPosition(10 + (35 * (i - 12)), 150);
         else if (i <= 23)
            enemies[i].setPosition(10 + (35 * (i - 18)), 130);
         else
            enemies[i].setPosition(10 + (35 * (i - 24)), 110);
      }
   }
   
   // function draws everything on screen at any given moment
   public void drawGame() {
      PennDraw.setScale(0, 200);
      PennDraw.setPenColor(210, 140, 0);
      PennDraw.filledCircle(100, 0, 20);
      hero.drawInvader();
      for (int i = 0; i < enemies.length; i++)
         enemies[i].drawInvader();
      if (head != null) {
         for (ShotNode display = head; display != null; 
                  display = display.getNext()) {
            PennDraw.setPenColor(0, 0, 0);
            PennDraw.filledSquare(display.getX(), display.getY(), 1);
         }
      }
   }
   
   // function creates start animation returns user selections 
   public static DesignNode startAnimation() {
      PennDraw.clear();
      PennDraw.setScale(0, 60); 
      PennDraw.setFontSize(30);
      PennDraw.setPenColor(0, 0, 0);
      for (int i = 0; i <= 100; i++) { // start screen
         if (i == 0) PennDraw.text(30, 50, "CS112 Final Project");
         if (i == 50) PennDraw.text(30, 40, "Stop the Invaders");
         PennDraw.advance();
      }
      boolean c = true;
      int counter = 0;
      DesignNode node1 = new DesignNode();
      DesignNode node2 = new DesignNode();
      DesignNode node3 = new DesignNode();
      while (c) { // player chooses body parts
         if (counter == 0) {
            PennDraw.clear();
            PennDraw.setScale(0, 60);
            PennDraw.setFontSize(30);
            PennDraw.text(30, 50, "CHOOSE YOUR BODY");
            Body choice1 = new Body(255, 0, 0);
            choice1.setPosition(10, 30); 
            Body choice2 = new Body(0, 255, 0);
            choice2.setPosition(30, 30); 
            Body choice3 = new Body(0, 0, 255);
            choice3.setPosition(50, 30);
            choice1.drawBody();
            choice2.drawBody();
            choice3.drawBody();
            PennDraw.advance();
            if (PennDraw.mousePressed()) {
               double x = PennDraw.mouseX();
               double y = PennDraw.mouseY();
               if (x > 0 && x < 20) node1 = new DesignNode(choice1);
               if (x > 20 && x < 40) node1 = new DesignNode(choice2);
               if (x > 40 && x < 60) node1 = new DesignNode(choice3);
               for (int i = 0; i < 10; i++) {
                  if (i == 9) counter = 1;
                  PennDraw.advance();
               }
            }
         }
      
         if (counter == 1) {
            PennDraw.clear();
            PennDraw.text(30, 50, "CHOOSE YOUR WINGS");
            Wing choice1 = new Wing(255, 0, 0);
            choice1.setPosition(10, 30); 
            Wing choice2 = new Wing(0, 255, 0);
            choice2.setPosition(30, 30); 
            Wing choice3 = new Wing(0, 0, 255);
            choice3.setPosition(50, 30);
            choice1.drawWings();
            choice2.drawWings();
            choice3.drawWings();
            PennDraw.advance();
            if (PennDraw.mousePressed()) {
               double x = PennDraw.mouseX();
               double y = PennDraw.mouseY();
               if (x > 0 && x < 20) node2 = new DesignNode(choice1);
               if (x > 20 && x < 40) node2 = new DesignNode(choice2);
               if (x > 40 && x < 60) node2 = new DesignNode(choice3);
               for (int i = 0; i < 10; i++) {
                  if (i == 9) counter = 2;
                  PennDraw.advance();
               }
            }
         }
      
         if (counter == 2) {
            PennDraw.clear();
            PennDraw.text(30, 50, "CHOOSE YOUR SHOOTER");
            Shooter choice1 = new Shooter(255, 0, 0);
            choice1.setPosition(10, 30); 
            Shooter choice2 = new Shooter(0, 255, 0);
            choice2.setPosition(30, 30); 
            Shooter choice3 = new Shooter(0, 0, 255);
            choice3.setPosition(50, 30);
            choice1.drawShooters();
            choice2.drawShooters();
            choice3.drawShooters();
            PennDraw.advance();
            if (PennDraw.mousePressed()) {
               double x = PennDraw.mouseX();
               double y = PennDraw.mouseY();
               if (x > 0 && x < 20) node3 = new DesignNode(choice1);
               if (x > 20 && x < 40) node3 = new DesignNode(choice2);
               if (x > 40 && x < 60) node3 = new DesignNode(choice3);
               for (int i = 0; i < 10; i++) {
                  if (i == 9) counter = 3;
                  PennDraw.advance();
               }
            }
         }
         
         if (counter == 3) {
            PennDraw.clear();
            PennDraw.setScale(-12, 12);
            node1.setNext(node2);
            node2.setNext(node3);
            Invader choice = new Invader(node1);
            choice.setPosition(0, 0);
            choice.drawInvader();
            PennDraw.setFontSize(60);
            PennDraw.setPenColor(0, 0, 255);
            PennDraw.text(0, 10, "IS THIS OKAY?");
            PennDraw.setPenColor(255, 0, 0);
            PennDraw.text(-6, -9, "NO");
            PennDraw.setPenColor(0, 255, 0);
            PennDraw.text(6, -9, "YES");
            PennDraw.advance();
            if (PennDraw.mousePressed()) {
               double x = PennDraw.mouseX();
               double y = PennDraw.mouseY();
               if (x > -8 && x < -4 && y > -11 && y < -7) {
                  for (int i = 0; i < 10; i++) {
                     if (i == 9) counter = 0;
                     PennDraw.advance();
                  }
               }
               if (x > 4 && x < 8 && y > -11 && y < -7) {
                  for (int i = 0; i < 10; i++) {
                     if (i == 9) c = false;
                     PennDraw.advance();
                  }
               }
            }
         }
      }
      return node1; // holds user selections
   }
   
   
   // function creates animation for level select and returns enemy amount
   public static int levelSelect() {
      boolean a = true;
      int val = 0;
      PennDraw.setXscale(0, 30);
      PennDraw.setYscale(0, 35);
      while (a) {
         PennDraw.clear();
         PennDraw.setFontSize(30);
         PennDraw.setPenColor(0, 0, 255);
         PennDraw.text(15, 32, "How Many Can You Handle?");
         PennDraw.setPenColor(100, 0, 255);
         PennDraw.text(7.5, 25, "Noob, 5");
         PennDraw.text(22.5, 25, "Cake, 10");
         PennDraw.text(7.5, 15, "Decent, 15");
         PennDraw.text(22.5, 15, "Work, 20");
         PennDraw.text(7.5, 5, "Try-Hard, 25");
         PennDraw.text(22.5, 5, "Sweaty, 30");
         PennDraw.advance();
         if (PennDraw.mousePressed()) {
            double x = PennDraw.mouseX();
            double y = PennDraw.mouseY();
            if (x < 15) {
               if (y > 20 && y < 30) val = 5; 
               else if (y >= 10 && y <= 20) val = 15;
               else if (y < 10) val = 25;
            }
            else if (x >= 15) {
               if (y > 20 && y < 30) val = 10;
               else if (y >= 10 && y <= 20) val = 20;
               else if (y < 10) val = 30;
            }
            for (int i = 0; i < 10; i++) {
               if (i == 9) a = false;
            }
         }
      }
      return val; // enemy amount
   }
   
   // functions creates screen to show rules and controls
   public static void ready() {
      boolean b = true;
      PennDraw.setScale(0, 10);
      while (b) {
         PennDraw.clear();
         PennDraw.setFontSize(30);
         PennDraw.setPenColor(150, 0, 0);
         PennDraw.text(5, 8, "Use W, A, S, D to Move");
         PennDraw.text(5, 6, "Use M to Shoot");
         PennDraw.text(5, 4, "Don't Let Them Reach Your Planet");
         PennDraw.text(5, 2, "Press SPACE to Continue");
         PennDraw.advance();
         if (PennDraw.hasNextKeyTyped()) {
            char i = PennDraw.nextKeyTyped();
            if (i == ' ') {
               return;
            }
         }
      }
   }
   
   // functions moves bullets on screen by iterating through the node
   public void incrementShots() {
      if (head == null)
         return;
      else if (head.getY() > 200 || head.getY() < 0) {
         head = head.getNext();
         incrementShots();
      }
      else {
         for (ShotNode display = head; display != null; display = display.getNext())
            display.incrementY();
      }
   }
   
   // function interates through shot node and checks if anything was hit
   public int checkHits(int val) {
      int value = val;
      if (head != null) {
         for (ShotNode display = head; display != null; 
                  display = display.getNext()) {
            for (int i = 0; i < enemies.length; i++) {
               HitBox[] boxes = enemies[i].getHitBoxes();
               if (boxes[0].inRange(display.getX(), display.getY()) || 
                        boxes[1].inRange(display.getX(), display.getY())) {
                  if (!display.compShot()) {
                     enemies[i].kill();
                     display.setY(300);
                     value--;
                  }
               }
            }
            HitBox[] heroBox = hero.getHitBoxes();
            if (heroBox[0].inRange(display.getX(), display.getY()) || 
                     heroBox[1].inRange(display.getX(), display.getY())) {
               if (display.compShot()) {
                  hero.kill();
                  display.setY(-300);
               }
            }
         }
      }
      return value; // amount of remaining ships
   }
   
   // function moves enemies along predetermined path
   public void moveEnemies() {
      for (int i = 0; i < enemies.length; i++) {
         if (enemies[i].getX() <= 100 && enemies[i].getY() <= 50)
            enemies[i].moveDown();
         else if (enemies[i].getY() < 50)
            enemies[i].moveLeft();
         else if (enemies[i].getX() >= 190 && enemies[i].getY() <= 70)
            enemies[i].moveDown();
         else if (enemies[i].getY() < 70)
            enemies[i].moveRight();
         else if (enemies[i].getX() <= 10 && enemies[i].getY() <= 90)
            enemies[i].moveDown();
         else if (enemies[i].getY() <= 90)
            enemies[i].moveLeft();
         else if (enemies[i].getX() >= 190 && enemies[i].getY() <= 110)
            enemies[i].moveDown();
         else if (enemies[i].getY() <= 110)
            enemies[i].moveRight();
         else if (enemies[i].getX() <= 10 && enemies[i].getY() <= 130)
            enemies[i].moveDown();
         else if (enemies[i].getY() <= 130)
            enemies[i].moveLeft();
         else if (enemies[i].getX() >= 190 && enemies[i].getY() <= 150)
            enemies[i].moveDown();
         else if (enemies[i].getY() <= 150)
            enemies[i].moveRight();
         else if (enemies[i].getX() <= 10 && enemies[i].getY() <= 170)
            enemies[i].moveDown();
         else if (enemies[i].getY() <= 170)
            enemies[i].moveLeft();
         else if (enemies[i].getX() >= 190 && enemies[i].getY() <= 190)
            enemies[i].moveDown();
         else 
            enemies[i].moveRight();
      }
   }
   
   // function checks to see if enemies have reached their destination
   public boolean checkEnemyPositions() {
      for (int i = 0; i < enemies.length; i++) {
         if (enemies[i].getY() <= 10)
            return true;
      }
      return false;
   }
   
   // function adds shot to main shotnode using ship current position
   public void addShot(double[] coords, boolean who) {
      if (head == null) {
         head = new ShotNode(coords[0], coords[1], who);
         current = new ShotNode(coords[2], coords[1], who);
         head.setNext(current);
      }
      else {
         ShotNode placeholder = new ShotNode(coords[0], coords[1], who);
         current.setNext(placeholder);
         current = placeholder;
         placeholder = new ShotNode(coords[2], coords[1], who);
         current.setNext(placeholder);
         current = placeholder;
      }
   }
   
   // function sets probability for enemies to shoot
   public void enemyShots() {
      for (int i = 0; i < enemies.length; i++) {
         double k = Math.random();
         if (k < (0.07 / enemies.length)) // probability based on enemies
            addShot(enemies[i].getShot(), true);
      }
   }
   
   // function returns player
   public Invader getHero() {
      return hero;
   }
   
   // main function runs game
   public static void main(String[] args) {
      Game test = new Game(); // placeholder game
      int timer = 0; // counts time between user shots
      int clock = 0; // timer for end animation
      int gracePeriod = 0; // timer so game doesnt start too quickly
      int amount = 0; // number of remaining enemies
      boolean cooldown = false; // slows down player shots
      boolean loss = false; // check if player has lost
      boolean start = true; // start state
      boolean game = false; // gameplay state
      boolean endWin = false; // end state (win)
      boolean endLose = false; // end state(loss)
      PennDraw.enableAnimation(35);
      while (true) {
         while (start) { // start state
            timer = 0;
            clock = 0;
            gracePeriod = 0;
            loss = false;
            cooldown = false;
            DesignNode node = startAnimation();
            amount = levelSelect();
            ready();
            test = new Game(node, amount);
            game = true;
            start = false;
         }
         while (game) { // gameplay state
            if (PennDraw.hasNextKeyTyped() && gracePeriod > 50) { 
               char i = PennDraw.nextKeyTyped(); // player controls
               if (i == 'a') test.getHero().moveLeft();
               if (i == 'w') test.getHero().moveUp();
               if (i == 'd') test.getHero().moveRight();
               if (i == 's') test.getHero().moveDown();
               if (i == 'm' && !cooldown) {
                  test.addShot(test.getHero().getShot(), false);
                  cooldown = true;
               }
            }
         
            if (cooldown) { // slows down player shots
               timer++;
               if (timer == 30) {
                  timer = 0;
                  cooldown = false;
               }
            }
            
            
            PennDraw.clear();
            
            // grace period calm before the storm
            if (gracePeriod < 30) {
               PennDraw.setPenColor(255, 0, 0);
               PennDraw.setFontSize(30);
               PennDraw.text(100, 100, "Ready?");
            }
            else if (gracePeriod < 50) {
               PennDraw.setPenColor(0, 255, 0);
               PennDraw.setFontSize(30);
               PennDraw.text(100, 100, "GO");
            }
            
            // checks win/loss conditions
            amount = test.checkHits(amount);
            loss = test.checkEnemyPositions();
            
            // also grace period
            if (gracePeriod > 100)
               test.enemyShots();
            test.incrementShots();
            if (gracePeriod > 50)
               test.moveEnemies();
            test.drawGame();
            
            // win conditions
            if (amount <= 0) {
               PennDraw.setPenColor(150, 0, 0);
               PennDraw.setFontSize(30 + (0.5 * clock));
               PennDraw.text(100, 100, "YOU WIN", 10.8 * clock);
               if (clock == 100) {
                  endWin = true;
                  game = false;
               }
               clock++;
            }
            // loss conditions
            else if ((!test.getHero().isAlive() || loss) && amount != 0) {
               PennDraw.setPenColor(150, 0, 0);
               PennDraw.setFontSize(30 + (0.5 * clock));
               PennDraw.text(100, 100, "YOU LOSE", 10.8 * clock);
               if (clock == 100) {
                  endLose = true;
                  game = false;
               }
               clock++;
            }
            PennDraw.advance();
            gracePeriod++;
         }
         
         while (endWin || endLose) { // end states
            PennDraw.clear();
            PennDraw.setScale(-12, 12);
            PennDraw.setPenColor(150, 0, 0);
            PennDraw.setFontSize(30);
            if (endWin) {
               PennDraw.text(0, 10, "YOU WON :)");
               PennDraw.text(0, -10, "Play Again? Press SPACE");
            }
            else if (endLose) {
               PennDraw.text(0, 10, "YOU LOST :(");
               PennDraw.text(0, -10, "Try Again? Press SPACE");
            }
            test.getHero().rez();
            test.getHero().drawInvader();
            PennDraw.advance();
            if (PennDraw.hasNextKeyTyped()) {
               char k = PennDraw.nextKeyTyped();
               if (k == ' ') {
                  start = true;
                  endWin = false;
                  endLose = false;
               }
            }
         }
      }
   }
}