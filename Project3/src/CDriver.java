import java.io.Serializable;

public class CDriver implements Serializable{

	String customerNum;
	String customerName;
	String drivingYears;
	String jeepOwner;
	String models;
	String transmission;
	String[] modelsArray;
	String model1;
	String model2;
	String model3;
	String model4;
	String model5;
	String trans1;
	String trans2;
	String trans3;
	String trans4;
	Integer numCount;
	Integer nameCount;
	Integer beforeYearsCount;
	Integer yearsCount;
	Integer jeepCount;
	Integer modelsCount;
	Integer transmissionCount;
	String numSpaces = "";
	String nameSpaces = "";
	String yearsSpaces = "";
	String beforeYearsSpaces = "";
	String jeepSpaces = "";
	String modelsSpaces = "";
	String tranmsissionSpaces = "";

	private String newNum;
	private String newName;
	private String newYears;
	private String newJeep;
	private String newModel;
	private String newTransmission;
	private String newRow;

	public CDriver(String cNum, String cName, String cYears, String cJeep, String cModels, String cTransmission){

		setcNum(cNum);
		setcName(cName);
		setcYears(cYears);
		setcJeep(cJeep);
		setcModels(cModels);
		setcTransmission(cTransmission);

		System.out.print(models);
		modelsArray = models.split("");
		System.out.print(modelsArray);
		model1 = modelsArray[0];
		model2 = modelsArray[1];
		model3 = modelsArray[2];
		model4 = modelsArray[3];
		model5 = modelsArray[4];


	}
	
	public void setcNum(String cNum){
		customerNum = cNum;
	}
	
	public void setcName(String cName){
		customerName = cName;
	}
	
	public void setcYears(String cYears){
		drivingYears = cYears;
	}
	
	public void setcJeep(String cJeep){
		jeepOwner = cJeep;
	}
	
	public void setcModels(String cModels){
		models = cModels;
	}
	
	public void setcTransmission(String cTransmission){
		transmission = cTransmission;
	}
	
	public String getcNum(){
		return customerNum;
	}
	
	public String getcName(){
		return customerName;
	}
	public String getcYears(){
		return drivingYears;
	}
	public String getcJeep(){
		return jeepOwner;
	}
	public String getcModel(){
		return models;
	}
	public String getcTransmission(){
		return transmission;
	}

	public String getCustomerNum(){return customerNum;}

	public String getCustomerArray(){
		String tempYears;
		String tempJeep;
		String tempModel;
		String tempTrans;
		tempYears = getcYears();
		tempJeep = getcJeep();
		tempModel = getcModel();
		tempTrans = getcTransmission();
		String arr = customerNum + "," + customerName + ","  + tempYears + "," + tempJeep + "," + tempModel + "," + tempTrans;
		return arr;
	}
	public String getCustomerData(){

		numCount = 17 - customerNum.length();
		nameCount = 25 - customerName.length() - drivingYears.length();
		//beforeYearsCount = 19 - customerName.length();
		yearsCount = 9;
		jeepCount = 15 - jeepOwner.length();
		modelsCount = 17 - models.length();
		transmissionCount = 17 - transmission.length();

		int i;
		for (i=0; i<numCount; i++){
			numSpaces += " ";
		}
		for (i=0; i<nameCount; i++){
			nameSpaces += " ";
		}
		//for (i=0; i<beforeYearsCount; i++){
		//	beforeYearsSpaces += " ";
		//}
		for (i=0; i<yearsCount; i++){
			yearsSpaces += " ";
		}
		for (i=0; i<jeepCount; i++){
			jeepSpaces += " ";
		}
		for (i=0; i<modelsCount; i++){
			modelsSpaces += " ";
		}
		for (i=0; i<transmissionCount; i++){
			tranmsissionSpaces += " ";
		}

		newNum = customerNum + numSpaces;
		newName = customerName + nameSpaces;
		newYears = drivingYears + yearsSpaces;
		newJeep = jeepOwner + jeepSpaces;
		newModel = models + modelsSpaces;
		newTransmission = transmission;

		newRow = newNum + newName + newYears + newJeep + newModel + newTransmission;
		return newRow;

	}
}


