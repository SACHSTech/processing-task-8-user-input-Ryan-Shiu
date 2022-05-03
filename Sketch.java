import processing.core.PImage;
import processing.core.PApplet;

public class Sketch extends PApplet {
  // Declaring images
  PImage imgbackground;
  PImage imgbackground2;
  PImage imgthanos;
  PImage imgIronMan;
  PImage imgguantlet;

  // Setting variables
  float ironManX = 0;
  float ironManY = 0;
  boolean rightpressed = false;
  boolean leftpressed = false;
  boolean uppressed = false;
  boolean downpressed = false;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(960, 540);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    //Loading in images
    imgbackground = loadImage("cityskyline.png");
    imgbackground2 = loadImage("background2.jpg");
    imgthanos = loadImage("thanos.png");
    imgIronMan = loadImage("ironman.png");
    imgguantlet = loadImage("gauntlet.gif");

    // resizing backgrounds
    imgbackground.resize(imgbackground.width/2, imgbackground.height/2);
    imgbackground2.resize(960,540);
    imgthanos.resize(imgthanos.width/2, imgthanos.height/2);
    imgIronMan.resize(100,100);
    imgguantlet.resize(960,540);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // Positions for thanos image
    int imgthanosX = 400;
    int imgthanosY = 100;

    // Delcaring background and white circle that follows the cursor
    image(imgbackground, 0, 0);
	  ellipse(mouseX, mouseY, 25, 25);

    // When the mouse is pressed, thanos appears
    if(mousePressed) {
      image(imgthanos, imgthanosX, imgthanosY);
    }
  
    // When the "b" key is pressed the background changes
    if(keyPressed){
      if(key == 'b'){
      image(imgbackground2, 0, 0);
      }
    }

    // When both "b" and mouse are pressed the background changes and thanos appears
    if(keyPressed && mousePressed){
      image(imgthanos, imgthanosX, imgthanosY);
    }

    // Controls for Iron Man
    if(keyPressed){
       if(keyCode == UP){
        ironManY-=5;
       }
       if(keyCode == DOWN){
         ironManY+=5;
       }
       if(keyCode == RIGHT){
         ironManX+=5;
       }
       if(keyCode == LEFT){
         ironManX-=5;
       }
    }
    image(imgIronMan, ironManX, ironManY);
  }

  // Handling multiple keys pressed
  public void keyPressed(){
    if(keyCode == RIGHT){
      rightpressed = true;
    }
    else if(keyCode == LEFT){
      leftpressed = true;
    }
    else if(keyCode == UP){
      uppressed = true;
    }
     else if(keyCode == DOWN){
      downpressed = true;
    }
  }

    // Handling multiple keys released
    public void keyReleased(){
      if(keyCode == RIGHT){
        rightpressed = false;
      }
      else if(keyCode == LEFT){
        leftpressed = false;
      }
      else if(keyCode == UP){
        uppressed = false;
      }
       else if(keyCode == DOWN){
        downpressed = false;
      }
    } 

  // When the user scrolls the mouse wheel, 3 other Iron Mans appear
  public void mouseWheel(){
    image(imgIronMan, 200, 400);
    image(imgIronMan, 400, 400);
    image(imgIronMan, 600, 400);
  }

  // When the mouse is dragged, the infinity guantlet image appears
  public void mouseDragged(){
    image(imgguantlet, 0, 0);
  }
  
  
  // define other methods down here.
}