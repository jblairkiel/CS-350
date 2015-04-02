import java.awt.Component;
import java.io.InputStreamReader;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.accessibility.AccessibleContext;
import javax.swing.DefaultListCellRenderer;
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
import javax.swing.JFileChooser;

public class JeepGUI extends JFrame implements ActionListener, Serializable
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
	JButton saveButton;
	JButton openButton;

	JFileChooser fileChooser;
	int returnVal;
	String record;

	public static ArrayList<CDriver> customerList = new ArrayList<CDriver>();
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

		saveButton = new JButton("Save");
		saveButton.setSize(150, 50);
		saveButton.setLocation(100, 100);
		saveButton.addActionListener(this);
		c.add(saveButton);

		openButton = new JButton("Open");
		openButton.setSize(150, 50);
		openButton.setLocation(150, 150);
		openButton.addActionListener(this);
		c.add(openButton);


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

		model = new DefaultListModel();
		list = new JList(model);
		list.setSize(700, 400);
		list.setLocation(50, 50);
		list.setFont(new Font("Courier New", Font.PLAIN, 12));
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer(); 
		renderer.setFont(new Font("Courier", Font.PLAIN, 12));
		c.add(list);

		//Column Labels
		customerNoLabel = new JLabel("Customer No.");
		customerNoLabel.setSize(100, 25);
		customerNoLabel.setLocation(50, 25);
		customerNoLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		c.add(customerNoLabel);

		customerNameLabel = new JLabel("Customer Name");
		customerNameLabel.setSize(120, 25);
		customerNameLabel.setLocation(170, 25);
		customerNameLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		c.add(customerNameLabel);

		customerDrivingYearsLabel = new JLabel("Years Driving");
		customerDrivingYearsLabel.setSize(100, 25);
		customerDrivingYearsLabel.setLocation(284, 25);
		customerDrivingYearsLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		c.add(customerDrivingYearsLabel);

		customerJeepOwnerLabel = new JLabel("Jeep Owner");
		customerJeepOwnerLabel.setSize(100, 25);
		customerJeepOwnerLabel.setLocation(408, 25);
		customerJeepOwnerLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		c.add(customerJeepOwnerLabel);

		customerCarModelLabel = new JLabel("Models");
		customerCarModelLabel.setSize(100, 25);
		customerCarModelLabel.setLocation(513, 25);
		customerCarModelLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		c.add(customerCarModelLabel);

		customerCarTransmissionLabel = new JLabel("Transmission");
		customerCarTransmissionLabel.setSize(100, 25);
		customerCarTransmissionLabel.setLocation(631, 25);
		customerCarTransmissionLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		c.add(customerCarTransmissionLabel);
	}

	;

	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent e) {
		//addButton
		if(e.getSource()==addButton) {
			String newNum = newCustomerNum();
			System.out.print(newNum);
			AddGUI a = new AddGUI(newNum);
		}
		//editButton
		else if(e.getSource()==editButton) {
			int index = list.getSelectedIndex();
			if(index == -1){
				// do nothing
			}
			else{
				String newData;
				CDriver editingCust = customerList.get(index);
				EditGUI a = new EditGUI(editingCust);
				editingCust = customerList.get(index);
				newData = editingCust.getCustomerData();
				model.setElementAt(newData, index);
				list.setModel(model);
			}
		}
		//removeButton
		else if(e.getSource()==removeButton) {
			if(list.isSelectionEmpty()){
				//do nothing
			}
			removeCustomer();
		}
		//clearButton
		else if(e.getSource()==clearButton) {
			model.removeAllElements();
			list.setModel(model);
		}
		else if(e.getSource()==openButton) {
			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Choose a File to open");
			fileChooser.setVisible(true);
			returnVal = fileChooser.showSaveDialog(fileChooser);
			System.out.println("Test");

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				FileInputStream input;
				BufferedReader reader;
				try {
					input = new FileInputStream(file);
					reader = new BufferedReader(new InputStreamReader(input));
					while(true){
						try {
							record =  reader.readLine();
							System.out.println(record);
							readInNewRecord(record);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					return;
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					return;
				}

			}
		}
		else if(e.getSource()==saveButton) {
			//filechooser
			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Choose a Save Filename");
			fileChooser.setVisible(true);
			returnVal = fileChooser.showSaveDialog(fileChooser);
			System.out.println("Test");

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					FileWriter writer = new FileWriter(file);
					//int size = model.getSize();
					int size = customerList.size();
					String data;
					CDriver curDriver;
					for(int i = 0; i < size; i++){
						curDriver = customerList.get(i);
						data = curDriver.getCustomerArray();
						System.out.println(data);
						writer.write(data + "\n");
					}
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				; 
			}
		}
	}

	public static void readInNewRecord(String record){

		List<String> items = Arrays.asList(record.split("\\s*,\\s*"));

		addCustomerNum(items.get(0));
		addCustomer(items.get(0), items.get(1), items.get(2), items.get(3), items.get(4), items.get(5));

	}
	public static void addCustomerNum(String customerNum){
		Integer custNum = Integer.parseInt(customerNum);
		customerNums.add(custNum);
	}

	public String newCustomerNum(){
		String ret = "";
		if(customerNums.size() == 0){
			ret = "00001";
		}
		else{
			Integer cur = customerNums.get(0);
			for (int i = 1; i < customerNums.size(); i++){
				if(customerNums.get(i) > cur){
					cur = customerNums.get(i);
				}
			}
			if((int) Math.log10(cur) + 1 == 1){
				ret = "0000" + Integer.toString(cur + 1);
			}
		}
		return ret;
	}

	public static void addCustomer(String cNum, String cName, String cYears, String cJeep, String cModels, String cTransmission) {

		model = new DefaultListModel();
		CDriver newDriver = new CDriver(cNum, cName, cYears, cJeep, cModels, cTransmission);
		String newData = newDriver.getCustomerData();
		customerList.add(newDriver);
		model = (DefaultListModel) list.getModel();
		model.addElement(newData);
		list.setModel(model);
	}

	public static void removeCustomer(){
		if(list.isSelectionEmpty()){
			//do nothing
		}
		else{
			int index = list.getSelectedIndex();
			Object object = model.getElementAt(index);
			model.removeElement(object);
			list.setModel(model);
		}
	}

}
