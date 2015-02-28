import java.awt.Container;
import java.awt.event.*;
import javax.swing.*; 

public class MyDialog extends JDialog implements ActionListener {
    private JLabel myLabel;
    private JCheckBox cbCS415;    
    private JCheckBox cbCS425;    
    private JCheckBox cbCS435;    
    private JButton okButton;
    private JButton cancelButton;
    
    private boolean cancelled;
    public boolean isCancelled() { return cancelled; }
    private int answer;
    public int getAnswer() { return answer; }
    // public void setAnswer(String str) { answer=str; }

    public MyDialog(JFrame owner, String title, int initVal) {
		super(owner, title, true);
		
	    Container c = getContentPane();
	    c.setLayout(null);		

	    myLabel = new JLabel("Check all appropriate courses:");
		myLabel.setSize( 200, 50 );
		myLabel.setLocation( 100, 50 );
		c.add(myLabel);
		
		cbCS415 = new JCheckBox("CS415", (initVal&1)!=0);
		cbCS415.setSize( 100, 25 );
		cbCS415.setLocation( 100, 100 );
		c.add(cbCS415);

		cbCS425 = new JCheckBox("CS425", (initVal&2)!=0);
		cbCS425.setSize( 100, 25 );
		cbCS425.setLocation( 100, 130 );
		c.add(cbCS425);

		cbCS435 = new JCheckBox("CS435", (initVal&4)!=0);
		cbCS435.setSize( 100, 25 );
		cbCS435.setLocation( 100, 160 );
		c.add(cbCS435);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setSize( 75, 50 );
		cancelButton.setLocation( 100, 200 );
		c.add(cancelButton);	

		okButton = new JButton("OK");
		okButton.addActionListener(this);
		okButton.setSize( 75, 50 );
		okButton.setLocation( 200, 200 );
		c.add(okButton);	
		
	    setSize( 400, 300 );
		setLocationRelativeTo(owner);
		setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
		if (e.getSource()==okButton) {
			answer = 0;
			if (cbCS415.isSelected()) answer |= 1;
			if (cbCS425.isSelected()) answer |= 2;
			if (cbCS435.isSelected()) answer |= 4;
		    cancelled = false;
		    setVisible(false);
		}
		else if(e.getSource()==cancelButton) {
		    cancelled = true;
		    setVisible(false);
		}
    }
    
}
