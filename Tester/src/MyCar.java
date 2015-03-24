/*  CS 350
 *  Project 2
 *  Justin Lichtle
 *  
 *  
 *  A Java application called CarFormation that allows a user 
 *  to create a car formation out of six model cars.
 *  
 */

import java.awt.Color;
import java.awt.Graphics;

public class MyCar {

     public MyCar(Color c, int x, int y, int w, int h, int r) {
          FillColor=c;
          X=x;
          Y=y;
          Width=w;
          Height=h;
          wheelRadius=r;

     }
     public MyCar(MyCar src) {     // copy constructor
          X=src.X;
          Y=src.Y;
          Width=src.Width;
          Height=src.Height;
          FillColor=src.FillColor;
          wheelRadius=src.wheelRadius;
     }

     public int getX() { return X; }
     public void setX(int x) { X=x; }
     public int getY() { return Y; }
     public void setY(int y) { Y=y; }
     public int getW() {return Width;}
     public int getH() {return Height;}
    

     public void draw(Graphics g) {
          g.setColor(Color.black);
          for(int i=0;i<10;i++){
        	  for(int j=0;j<20;j++){
        		  if(j<=i || j>=19-i) {
        			  g.fillOval(30+40*j,30+40*i,40,40);
        			  
        		  }
        			  
        		  
        		  
        	  }
          }
}
          

         
     
     public boolean hitTest(int x, int y) {
         
               double a=Width/2.0;
               double b=Height/2.0;
               double xc=X+a;
               double yc=Y+b;
               int temp = Width/3;
               if((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
               {
                    return true;
               }
               else if(x>=X && y>=Y+Height-wheelRadius && x<X+2*wheelRadius && y<Y+Height+wheelRadius)
               {
                    return true;
               }
               else if(x>=X+Width-2*wheelRadius && y>=Y+Height-wheelRadius && x<X+Width && y<Y+Height+wheelRadius)
               {
                    return true;
               }
               else if(x>=X+temp && y>=Y-temp && x<X+Width && y<Y)
               {
                    return true;
               }
               else
                    return false;

     }

     private int X;
     private int Y;
     private int Width;
     private int Height;
     private Color FillColor;
     private int wheelRadius;
}
