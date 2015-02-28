import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.accessibility.AccessibleContext;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class JeepGUI extends JFrame implements ActionListener
{
	//Jlabels
	JLabel customerNoLabel;
	JLabel customerNameLabel;
	JLabel customerDrivingYearsLabel;
	JLabel customerJeepOwnerLabel;
	JLabel customerCarModelLabel;
	JLabel customerCarTransmissionLabel;

	//Button objects
	JButton addButton;
	JButton editButton;
	JButton removeButton;
	JButton clearButton;
	
	static JTable guiTable;
	public static JList list;
	public static DefaultListModel model;
	public static ArrayList<Integer> customerNums = new ArrayList<Integer>();
	
	
	public JeepGUI() {
		super("Jeep GUI");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		addButton = new JButton("Add");
		addButton.setSize(150, 50);
		addButton.setLocation(40, 500);
		addButton.addActionListener(this);
		c.add(addButton);
		
		editButton = new JButton("Edit");
		editButton.setSize(150, 50);
		editButton.setLocation(230, 500);
		editButton.addActionListener(this);
		c.add(editButton);
		
		removeButton = new JButton("Remove");
		removeButton.setSize(150, 50);
		removeButton.setLocation(420, 500);
		removeButton.addActionListener(this);
		c.add(removeButton);
		
		clearButton = new JButton("Clear");
		clearButton.setSize(150, 50);
		clearButton.setLocation(610, 500);
		clearButton.addActionListener(this);
		c.add(clearButton);
		
		//String columnHeaders[] = {"Customer No.", "Customer Name", "Driving Years", "Jeep Owner", "Models", "Transmission"};
		//String[][] dataValues = {{"00001", "Dustin Mark", "7", "Yes", "C--R-", "5-Manual"}, {"00002", "Hamza Jeff", "18", "No", "--P--", "8-Auto"}};
		//DefaultTableModel model = new DefaultTableModel(dataValues, columnHeaders);
		//customerNums.add(1);
		//customerNums.add(2);
		//guiTable = new JTable(model);
		//guiTable.setSize(700, 400);
		//guiTable.setLocation(50, 50);
		//c.add(guiTable);
		//list = new DefaultListModel();
		model = new DefaultListModel();
		String dataValues = "00001                    Dustin Mark            7                            Yes                     C--R-                   5-Manual";
		model.addElement(dataValues);
		customerNums.add(1);
		list = new JList(model);
		list.setSize(700, 400);
		list.setLocation(50, 50);
		c.add(list);


		//list.setFont(Font.getFont("monospaced"));
		//list.setSize(700, 400);
		//list.setLocation(50, 50);
		//c.add(list);

		//Column Labels
		customerNoLabel = new JLabel("Customer No.");
		customerNoLabel.setSize(100, 25);
		customerNoLabel.setLocation(50, 25);
		c.add(customerNoLabel);
		
		customerNameLabel = new JLabel("Customer Name");
		customerNameLabel.setSize(120, 25);
		customerNameLabel.setLocation(168, 25);
		c.add(customerNameLabel);
		
		customerDrivingYearsLabel = new JLabel("Years Driving");
		customerDrivingYearsLabel.setSize(100, 25);
		customerDrivingYearsLabel.setLocation(284, 25);
		c.add(customerDrivingYearsLabel);
		
		customerJeepOwnerLabel = new JLabel("Jeep Owner");
		customerJeepOwnerLabel.setSize(100, 25);
		customerJeepOwnerLabel.setLocation(403, 25);
		c.add(customerJeepOwnerLabel);

		customerCarModelLabel = new JLabel("Models");
		customerCarModelLabel.setSize(100, 25);
		customerCarModelLabel.setLocation(516, 25);
		c.add(customerCarModelLabel);
		
		customerCarTransmissionLabel = new JLabel("Transmission");
		customerCarTransmissionLabel.setSize(100, 25);
		customerCarTransmissionLabel.setLocation(634, 25);
		c.add(customerCarTransmissionLabel);
	}
	
	public void actionPerformed(ActionEvent e) {
		//addButton
		if(e.getSource()==addButton) {
			String newNum = newCustomerNum();
			System.out.print(newNum);
			AddGUI a = new AddGUI(newNum);
			//System.out.println("Add button pressed");
		}
		//editButton
		else if(e.getSource()==editButton) {
			System.out.println("Edit button pressed");
		}
		//removeButton
		else if(e.getSource()==removeButton) {
			System.out.println("Remove button pressed");
		}
		//clearButton
		else if(e.getSource()==clearButton) {
			System.out.println("Clear button pressed");
		}
	}
	
	public static void addCustomerNum(String customerNum){
		Integer custNum = Integer.parseInt(customerNum);
		customerNums.add(custNum);
	}
	
	public String newCustomerNum(){
		String ret = "";
		Integer cur = customerNums.get(0);
		for (int i = 1; i < customerNums.size(); i++){
			if(customerNums.get(i) > cur){
				cur = customerNums.get(i);
			}
		}
		if((int) Math.log10(cur) + 1 == 1){
			ret = "0000" + Integer.toString(cur + 1);
		}
		return ret;
	}
	
	public static void addCustomer(String cNum, String cName, String cYears, String cJeep, String cModels, String cTransmission) {

		model = new DefaultListModel();
		CDriver newDriver = new CDriver(cNum, cName, cYears, cJeep, cModels, cTransmission);
		String newData = newDriver.getCustomerData();
		model = (DefaultListModel) list.getModel();
		model.addElement(newData);
		list.setModel(model);
		//list.addElement()
		//DefaultTableModel model = (DefaultTableModel) guiTable.getModel();
		//model.addRow(new Object[]{custNo, custName, custYearsDriving, ownsJeep, custModel, custTrans});
	}

}
