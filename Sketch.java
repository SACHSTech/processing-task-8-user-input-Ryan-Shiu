import processing.core.PImage;
import processing.core.PApplet;

public class Sketch extends PApplet {
  PImage imgbackground;
  PImage imgbackground2;
  PImage imgthanos;
  PImage imgIronMan;
  PImage gifguantlet;

  float ironManX = 0;
  float ironManY = 0;

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
    imgbackground = loadImage("cityskyline.png");
    imgbackground2 = loadImage("background2.jpg");
    imgthanos = loadImage("thanos.png");
    imgIronMan = loadImage("ironman.png");
    gifguantlet = loadImage("gauntlet.gif");


    imgbackground.resize(imgbackground.width/2, imgbackground.height/2);
    imgbackground2.resize(960,540);
    imgthanos.resize(imgthanos.width/2, imgthanos.height/2);
    imgIronMan.resize(100,100);
    gifguantlet.resize(960,540);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    int imgthanosX = 400;
    int imgthanosY = 100;

    image(imgbackground, 0, 0);
	  ellipse(mouseX, mouseY, 50, 50);

    if(mousePressed) {
      image(imgthanos, imgthanosX, imgthanosY);
    }
  
    if(keyPressed){
      if(key == 'b'){
      image(imgbackground2, 0, 0);
      }
    }

    if(keyPressed && mousePressed){
      image(imgthanos, imgthanosX, imgthanosY);
    }

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

  public void mouseWheel(){
    image(imgIronMan, 200, 400);
    image(imgIronMan, 400, 400);
    image(imgIronMan, 600, 400);
  }

  public void mouseDragged(){
    image(gifguantlet, 0, 0);
  }
  
       
  
  // define other methods down here.
}