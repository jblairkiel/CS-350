
public class CDriver {

	private String customerNum;
	private String customerName;
	private String drivingYears;
	private String jeepOwner;
	private String models;
	private String transmission;

	private String newNum;
	private String newName;
	private String newYears;
	private String newJeep;
	private String newModel;
	private String newTransmission;
	private String newRow;


	public CDriver(String cNum, String cName, String cYears, String cJeep, String cModels, String cTransmission){

		customerNum = cNum;
		customerName = cName;
		drivingYears = cYears;
		jeepOwner = cJeep;
		models = cModels;
		transmission = cTransmission;
		

	}

	public String getCustomerNum(){return customerNum;}
	
	public String getCustomerData(){
		newNum = customerNum + "                    ";
		newName = customerName + "            ";
		newYears = drivingYears + "                            ";
		newJeep = jeepOwner + "                     ";
		newModel = models + "                   ";
		newTransmission = transmission;

		newRow = newNum + newName + newYears + newJeep + newModel + newTransmission;
		//String newRow = "00001                    Dustin Mark            7                            Yes                     C--R-                   5-Manual";
		return newRow;
		
	}
}


