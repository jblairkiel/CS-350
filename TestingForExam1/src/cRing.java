

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import java.util.*;

public class cRing extends JPanel implements MouseListener{

	int X, Y;
	int R = 50;
	int r = 30;
	Component circle;
	
	private Image backBuffer;
	private Graphics gBackBuffer;
	
	boolean isInitialized;
	
	

	public void paintComponent(Graphics g){
			CRing(R, r);
			//g.drawImage(backBuffer);
			backBuffer = createImage(500, 500);
			gBackBuffer = backBuffer.getGraphics();
	}

	public void CRing(int r_larger, int r_smaller) {
		isInitialized=false;
		R=r_larger; r=r_smaller;
		
		
	}
	
	public boolean isInside(int x, int y){
		int d2=(X-x)*(X-x)+(Y-y)*(Y-y);
		if (d2>R*R) return false;
		if (d2<r*r) return false;
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
		System.out.print(isInside(X, Y));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
