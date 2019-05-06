/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Departamento TIC - Algoritmos y programación I
 * Laboratio #4
 * Autor: Jaime Eduardo Cardona <jaime.cardona@correo.icesi.edu.co
 * Periodo: 2019-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;
import java.util.ArrayList;
public class Pet{
//constants
public final static char DOG='D';
public final static char CAT='C';
public final static char BIRD='B';
public final static char OTHER='O';
//attributes
private String name;
private char typeAnimal;
private double weight;
private double height;
private int age;
	/**
	* Description: The method is responsible for creating a pet
	* <b>pre</b>: typeAnimal must be one of the four constants (bird, dog, etc) mentioned above, weight, height and age they have to be positive numbers
	* <b>pos</b>: create a new pet
	* @param n - is the name of the pet
	* @param t - is the type of animal of the pet
	* @param w - is the weight of the pet
	* @param h - is the height of the pet
	* @param a - is the age of the pet
	*/
//constructor
public Pet(String n, char t, double w, double h, int a){
	name = n;
	typeAnimal = t;
	weight = w;
	height = h;
	age = a;
	history = new ArrayList<History>();
	services = new ArrayList<AditionalServices>();
	medicine = new ArrayList<Medicine>();
}
//relations
private ArrayList<History>history;
private ArrayList<AditionalServices>services;
private ArrayList<Medicine>medicine;
//methods
	/**
	 * Description this method serves to give name of the pet
	 * @return name
	 */
public String getName(){
	return name;
}
	/**
	 * this method is used to change name of the pet
	 * @param newName - The new name of the pet
	 */
public void setName(String newName){
	name = newName;
}
	/**
	 * Description this method serves to give type animal
	 * @return type animal
	 */
public char getTypeAnimal(){
	return typeAnimal;
}
	/**
	 * this method is used to change type animal of the pet
	 * @param newTypeAnimal - the new type animal of the pet
	 */
public void setTypeAnimal(char newTypeAnimal){
	typeAnimal = newTypeAnimal;
}
	/**
	 * Description this method serves to give weight
	 * @return weight
	 */
public double getWeight(){
	return weight;
}
	/**
	 * this method is used to change weight
	 * @param newWeight - the new weight of the pet
	 */
public void setWeight(double newWeight){
	weight = newWeight;
}
	/**
	 * this method serves to give height
	 * @return height
	 */
public double getHeight(){
	return height;
}
	/**
	 * this method is used to change height
	 * @param newHeight - the new height of the pet
	 */
public void setHeight(double newHeight){
	height = newHeight;
}
	/**
	 *Description this method serves to give age
	 * @return age
	 */
public double getAge(){
	return age;
}
	/**
	 * this method is used to change age of the pet
	 * @param newAge - the new age of the pet
	 */
public void setAge(int newAge){
	age = newAge;
}
	/**
	*Description this method is responsible for adding a new story to the pet
	*<b>post</b>: A new history object is added to the pet's Array list of history
	*@param s - state of the history
	*@param d - the date of admssion
	*@param sy- the sympton of the pet
	*@param pd- the posible diagnosis of the pet
	*@param nh- the number of history
	*@return message confirming that the history was added
	*/
public String addHistory(char s, String d, String sy, String pd, String nh){
	String text="";
	History objH=new History(History.OPEN,d,sy,pd,nh);
	history.add(objH);
	text="the history was created successfully";
	return text;
}
	/**
	*Description this method makes a report of the pet's clinical history.
	*@return the report of the pet's clinical history.
	*/
public String reportClinicHistory(){
	String text="";
	if(history.isEmpty()==true){
	text="the pet has no clinical history"+"\n";
	}
	for(int i=0;i<history.size();i++){
		if(history.get(i).getState()==History.OPEN)
		text+="the state is: "+history.get(i).getState()+" the Date Of Admission: "+history.get(i).getDateOfAdmission()+" the sympton is: "+history.get(i).getSympton()+" the posible diagnosis is: "+history.get(i).getPossibleDiagnosis()+" the number of history is "+history.get(i).getNumberHistory()+"\n";
	}
	return text;
	}
	/**
	*Description this method adds a new service
	*<b>post</b>: A new service object is added to the pet's Array list of service
	*@param typeService - the type of service the pet will take 
	*@param price - the price of the service
	*@param pid - the id of the owner of the pet that will take the service
	*@param np- the name of the pet that will take the service
	*@return message confirming that the medicine was added
	*/
public String addServices(String typeService, double price, String pid, String np){
	String text = "";
	AditionalServices objservice = new AditionalServices(typeService,price,pid,np);
	services.add(objservice);
	text = "Successful added service";
	return text;
}
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*<b>post</b>: A new medicine object is added to the pet's Array list of medicines
	*@param name - name of the medicine
	*@param costPerDose - the cost per dose of the medication
	*@param frequency - the frequency with which medicine is used
	*@param dose - the amount that should be used for that medicine
	*@return The pet body mass index.
	*/
public String addMedicine(String name, double costPerDose, int frequency, double dose){
	String text="";
	Medicine objmed = new Medicine (name, costPerDose, frequency,dose);
	medicine.add(objmed);
	text="the medication was successfully added";
	return text;
}
	/**
	*Description this method is responsible for calculating the total cost for medicine concepts.
	*@return the sum of the costs of all medicine supplied to the pet.
	*/
public double calculateCostMed(){
	double total = 0;
	for(int i=0;i<medicine.size();i++){
		if(medicine.get(i)!=null){
		total += medicine.get(i).costMedicine();
		}
	}
	return total;
}
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*<b>pre</b>: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*<b>post</b>: The BMI is calculated.
	*@return The pet body mass index.
	*/
public double calculateBMI(){
	return weight/height;
}
	/**
	*Description This method is responsible for verifying if the note can be added
	*@param note - the note that you want to add
	*@return if the note can not be added it returns an error message otherwise it returns the message of the history object
	*/
public String addNoteD(String note){
	String text = "Could not add note";
	for(int i=0;i<history.size();i++){
		if(history.get(i) != null && history.get(i).getState() == history.get(i).OPEN){
			text = history.get(i).addNotesD(note);
		}
	}
	return text;
}
	/**
	*Description this method goes through the notes and creates a report
	*@return the report of the notes
	*/
public String reportNoteD(){
	String text = "Could not add note";
	for(int i=0;i<history.size();i++){
		if(history.get(i) != null ){
			text = history.get(i).reportNotesD();
		}
	}
	return text;
}
	/**
	*Description This method is responsible for verifying if the note can be added
	*@param note - the note that you want to add
	*@return if the note can not be added it returns an error message otherwise it returns the message of the history object
	*/
public String addNoteS(String note){
	String text = "Could not add note";
	for(int i=0;i<history.size();i++){
		if(history.get(i) != null && history.get(i).getState() == history.get(i).OPEN){
			text = history.get(i).addNoteS(note);
		}
	}
	return text;
}
	/**
	*Description this method goes through the notes and creates a report
	*@return the report of the notes
	*/
public String reportNoteS(){
	String text = "Could not add note";
	for(int i=0;i<history.size();i++){
		if(history.get(i) != null){
			text = history.get(i).reportNotesS();
		}
	}
	return text;
}
	/**
	*Description this method serves to report history
	*@return report of history
	*/
public String makeReportH(){
	String text = "";
	for(int i=0;i<history.size();i++){
		if(history.get(i) != null){
			text += "the state is: "+history.get(i).getState()+" the Date Of Admission: "+history.get(i).getDateOfAdmission()+" the sympton is: "+history.get(i).getSympton()+" the posible diagnosis is: "+history.get(i).getPossibleDiagnosis()+" the number of history is "+history.get(i).getNumberHistory()+"\n";
		}
	}
	return text;
}
	/**
	*Description this method calculates the expenses for concepts of additional services
	*@return the expenses in aditional services
	*/
public double expensesAditionalS(){
	double expenses = 0;
	for(int i=0;i<services.size();i++){
		if(services.get(i) != null){
			expenses += services.get(i).getPrice();
		}
	}
	return expenses;
}
	/**
	*Description this method calculates the expenses for especific additional services
	*@param typeService - the type of service
	*@return the expenses for especific aditional services
	*/
public double expensesEspecificAS(String typeService){
	double expenses = 0;
	for(int i=0;i<services.size();i++){
		if(services.get(i) != null && typeService.equals(services.get(i).getTypeService())){
			expenses += services.get(i).getPrice();
		}
	}
	return expenses;
}
	/**
	*Description count how many times the aditional services was used
	*@return the number of times an aditional services was used
	*/
public int counterAS(){
	int total = 0;
	for(int i=0;i<services.size();i++){
		if(services.get(i) != null ){
			total++;
		}
	}
	return total;
}
}