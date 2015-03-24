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
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import java.util.*;

public class BuildingPanel extends JPanel 
     implements MouseListener, MouseMotionListener
{    
     // state representation
     private ArrayList<MyCar> originals; 
     private ArrayList<MyCar> duplicates; 

     private MyCar CarToBeMoved;
     private int m_nOffsetX;     // difference between cursor and top-left corner
     private int m_nOffsetY;

     // double buffering
     private Image backBuffer;
     private Graphics gBackBuffer;
    
     boolean isInitialized;
    
    // init and register mouse event handler
    public BuildingPanel()
    {
         isInitialized=false;
        // handle mouse and mouse motion events
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    // Set up the initial state after the panel is created
    void init()
    {
          // Initial state
          duplicates = new ArrayList<MyCar>();
          originals = new ArrayList<MyCar>();
          Color[] colors = {Color.red, Color.green, Color.blue, Color.magenta, Color.cyan, Color.yellow};
          int count=colors.length;
          int dx=15;
          int dy=50;
          int wr=15;
          int height=50;
          int width=100;
          int gap = width +150;
          int length=(getSize().height-2*dx-(count-1)*gap)/count;
          for (int i=0; i<count; i++) {
               originals.add(new MyCar(colors[i], dx+i*(length+gap), dy, width, height, wr));
          }
          CarToBeMoved=null; // no shape selected

          // create the back buffer
          backBuffer = createImage(getSize().width, getSize().height);
          gBackBuffer = backBuffer.getGraphics();
    }
   
    // State Presentation
    public void paintComponent( Graphics g )
    {
        // super.paintComponent( g ); // clears drawing area

         if (!isInitialized) {
              isInitialized=true;
              init();
         }
          // State Presentation, using double buffers
          // First, clear the back buffer
          gBackBuffer.setColor(Color.white);
          gBackBuffer.clearRect(0, 0, getSize().width, getSize().height);
          // draw the originals to back buffer
          for (int i=0; i<originals.size(); i++) {
               originals.get(i).draw(gBackBuffer);
          }
          // draw the duplicates to back buffer
          for (int i=0; i<duplicates.size(); i++) {
               duplicates.get(i).draw(gBackBuffer);
          }
          // copy from back buffer to front
          g.drawImage(backBuffer, 0, 0, null);
    } // end method paintComponent
   
    public boolean isInside(int x, int y){
		System.out.println();
		int d2=(70-x)*(70-x)+(70-y)*(70-y);
		System.out.println("d2 is " + d2);
		if (d2>80*80) return false;
		if (d2<40*40) return false;
		System.out.println();
		return true;
	}
    // MouseListener event handlers
    public void mouseClicked( MouseEvent e )
    {
          if (e.isMetaDown()) {     // right button
        	  int x = e.getX() - 70;
        	  int y = e.getY() - 70;
        	  System.out.print(isInside(x,y));
               //for (int i=duplicates.size()-1; i>=0; i--) {
               //     if (duplicates.get(i).hitTest(e.getX(), e.getY())) {
               //          duplicates.remove(i);
               //          repaint();
               //          break;
               //     }
               //}
          }
    }

    public void mousePressed( MouseEvent e )
    {
         if (e.isMetaDown()) return;     // ignore right button
       
          // First, check the originals, from top down (i.e. back to front)
          for (int i=duplicates.size()-1; i>=0; i--) {
        	  MyCar p=duplicates.get(i);
               if (p.hitTest(e.getX(), e.getY())) {
                    duplicates.remove(i);
                    duplicates.add(p);     // move to the end, i.e. the top
                    CarToBeMoved=p;
                    m_nOffsetX=e.getX()-CarToBeMoved.getX();
                    m_nOffsetY=e.getY()-CarToBeMoved.getY();
                    repaint();
                    return;
               }
          }
          // Second, check the orginals
          for (int i=originals.size()-1; i>=0; i--) {
        	  MyCar p=originals.get(i);
               if (p.hitTest(e.getX(), e.getY())) {
            	   MyCar p2=new MyCar(p); // make a copy of p
                    duplicates.add(p2);     // add to the end
                    CarToBeMoved=p2;     // p2 is selected, to be moved
                    m_nOffsetX=e.getX()-CarToBeMoved.getX();
                    m_nOffsetY=e.getY()-CarToBeMoved.getY();
                    repaint();
                    return;
               }
          }
    }

    public void mouseReleased( MouseEvent e )
    {
    	CarToBeMoved=null; // no shape selected
   }

    public void mouseEntered( MouseEvent e )
    {
    }

    public void mouseExited( MouseEvent e )
    {
    }

    public void mouseMoved( MouseEvent e )
    {
    }
   
    public void mouseDragged( MouseEvent e )
    {
        if (e.isMetaDown()) return;     // ignore right button
        
          if (CarToBeMoved!=null) {
        	  CarToBeMoved.setX(e.getX()-m_nOffsetX);
        	  CarToBeMoved.setY(e.getY()-m_nOffsetY);
               repaint();
          }

    } // end method mouseDragged
} // end class BuildingBlockPanel
