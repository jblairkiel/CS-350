import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TestDialog extends JFrame implements ActionListener {
	JLabel  myLabel;
    JButton myButton;

    public TestDialog() {
		super("Test Dialog");

	    Container c = getContentPane();
	    c.setLayout(null);		
		
	    myLabel = new JLabel("No answer from dialog yet");
		myLabel.setSize( 200, 50 );
		myLabel.setLocation( 100, 100 );
		c.add(myLabel);
		
		myButton = new JButton("Click to open dialog");
		myButton.setSize( 200, 50 );
		myButton.setLocation( 100, 500 );
		myButton.addActionListener(this);
		c.add(myButton);
		
	    setSize( 800, 600 );
	    setLocation( 100, 100 );
	    setVisible(true);
   }
    
    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myButton) {
		    MyDialog dialogWnd = new MyDialog(this, "Test JCheckBox", 5);
		    if (!dialogWnd.isCancelled()) {
		    	String str="Answer from dialog:";
		    	int answer=dialogWnd.getAnswer();
		    	if ((answer&1)!=0) str += " CS415";
		    	if ((answer&2)!=0) str += " CS425";
		    	if ((answer&4)!=0) str += " CS435";
		    	myLabel.setText(str);
		    }
		}
    }

	public static void main(String[] args) {
    	TestDialog mainWnd = new TestDialog();
    }
}
