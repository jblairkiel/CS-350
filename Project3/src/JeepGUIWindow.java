//###########################
//# This is a project to simulate a Jeep Dealership's GUI for servicing cars
//#	CS350 Project 3
//# Blair Kiel
//##########################
import javax.swing.JFrame;

public class JeepGUIWindow {

	public static void main(String[] args) {

		JeepGUI guiFrame = new JeepGUI();
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		guiFrame.setSize(800, 600); //frame size
		guiFrame.setVisible(true); //displays frame
	}

}
