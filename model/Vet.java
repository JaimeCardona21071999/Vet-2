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
public class Vet{
//constants
public final static int numberOfRooms=8;
public final static int numberOfMedicine=3;
//attributes
private String name;
private String nit;
private String address;
//relations
private ArrayList<Person>person;
private MiniRoom []miniroom;
private Medicine []medicine;
	/**
	* Description: The method is responsible for creating a vet
	* <b>pos</b>: create a new vet
	* @param n - is the name of the vet
	* @param ni - is the nit of the vet
	* @param a - is the address of the vet
	*/
//constructor
public Vet(String n, String ni, String a){
	person = new ArrayList <Person>();
	name = n;	
	nit = ni;
	address = a;
	medicine = new Medicine[numberOfMedicine];
	medicine[0] = new Medicine("Dolomin", 45.5, 3, 5);
	medicine[1] = new Medicine("Safemax", 32.4, 2, 4);
    medicine[2] = new Medicine("Rt32", 32, 1,6);
	miniroom = new MiniRoom[numberOfRooms];
	miniroom[0] = new MiniRoom(true, "1", 3);
	miniroom[1] = new MiniRoom(true, "2", 4);
	miniroom[2] = new MiniRoom(true, "3", 2);
	miniroom[3] = new MiniRoom(true, "4", 8);
	miniroom[4] = new MiniRoom(true, "5", 2);
	miniroom[5] = new MiniRoom(true, "6", 6);
	miniroom[6] = new MiniRoom(true, "7", 7);
	miniroom[7] = new MiniRoom(true, "8", 8);
	addPerson("Diego Henao","45454543","Las Vegas","345453456",Person.ACTIVE);
	addPerson("Jaime Cardona","1107527338","La Flora","3168718780",Person.ACTIVE);
	addPet("45454543","Lupita",Pet.DOG,34.5,60.5,2);
	addPet("1107527338","Cesar",Pet.DOG,34.5,70,4);
	addPet("1107527338","arr",Pet.DOG,34.5,80,7);
	addPet("45454543","James",Pet.DOG,34.5,54.5,2);
	addPetMini("45454543","Lupita",Pet.DOG,34.5,56,2,3);
	addHistory("45454543","Lupita", History.OPEN, "21/01/2019", "little appetite", "stomach knot", "1");
	addServices(AditionalServices.TNAILCUT,"45454543","James");
	addServices(AditionalServices.TNAILCUT,"1107527338","Cesar");
	addServices(AditionalServices.TVACCINES,"1107527338","arr");
}
//methods
	/**
	 * Description this method serves to give name of the vet
	 * @return name
	 */
//this method serves to give name
public String getName(){
	return name;
}
	/**
	 * this method is used to change name of the vet
	 * @param newName - The new name of the vet
	 */
//this method is used to change name
public void setName(String newName){
	name=newName;
}
	/**
	 * Description this method serves to give the nit of the vet
	 * @return nit
	 */
//this method serves to give nit
public String getNit(){
	return nit;
}
	/**
	 * this method is used to change nit of the vet
	 * @param newNit - The new nit of the vet
	 */
//this method is used to change nit
public void setNit(String newNit){
	nit = newNit;
}
	/**
	 * Description this method serves to give address of the vet
	 * @return address
	 */
//this method serves to give address
public String getAddress(){
	return address;
}
	/**
	 * this method is used to change name of the pet
	 * @param newAddress - The new address of the vet
	 */
//this method is used to change address
public void setAddress(String newAddress){
	address = newAddress;
}
	/**
	*Description this method is responsible for search person
	*@param id - id of the person
	*@return object person or null
	*/
//this method is used to find people
public Person searchPerson(String id){
	Person searchObj = null;
	for(int i=0;i<person.size()&&searchObj==null;i++){
		if(id.equals(person.get(i).getId())){
			searchObj = person.get(i);
		}
	}
	return searchObj;
}
	/**
	*Description this method is responsible for search pet
	*@param id - id of the person
	*@param name - name of the owner
	*@return object pet or null
	*/
public Pet searchPet(String id, String name){
	Person objper = searchPerson(id);
	Pet objpet = null;
	if(objper!=null){
		objpet = objper.searchPet(name);
	}
	return objpet;
}
	/**
	*Description this method is responsible for adding a new person
	*<b>post</b>: A new person object is added to the person Array list of the vet
	*@param n - name of the person
	*@param id - id of the person
	*@param a- address of the person
	*@param p- phone of the person
	*@param s- the state of the person
	*@return message confirming that the person was added
	*/
//this method serves to add people
public String addPerson(String n, String id, String a, String p, char s){
	String message="start";
	Person obj= new Person(n, id, a, p, Person.ACTIVE);
	if(searchPerson(id)!=null){
			message="the person you are trying to add already exists";
		}
	else {	
			person.add(obj);
			message="successfully added";
		}
		return message;
}
	/**
	*Description this method is responsible for create  person reports
	*@return the person reports
	*/
//this method serves to make the report of the people
public String makePersonReport(){
	String text="";
	if(person.isEmpty()==true){
	text="there are no people";
	}
	for(int i=0;i<person.size();i++){
		text+="the owner's name is: "+person.get(i).getName()+" the identification number is: "+person.get(i).getId()+" lives in: "+person.get(i).getAddress()+" and the phone number is: "+person.get(i).getPhone()+" and the state is "+person.get(i).getState()+"\n";
	}
	return text;
	}
	/**
	*Description this method is responsible for create  vet report
	*@return the vet report
	*/	
//this method serves to make the report of vet
	public String makeVetReport(){
	String text = " ************                      Welcome To Vet Safe Pet         *******************\n";
		text+="our nit number is:"+nit+" We are located in the neighborhood: "+address+"\n";
		return text;
}
	/**
	*Description this method is responsible for adding a new pet
	*<b>post</b>: A new pet object is added to the pet Array list of the vet
	*@param id - id of the owner
	*@param name - the name of the pet
	*@param typeAnimal - the type animal of the pet
	*@param weight - the weight of the pet
	*@param height - the height of the pet
	*@param age - the age of the pet
	*@return message confirming that the pet was added
	*/
//this method is useful for adding pets
public String addPet(String id,String name, char typeAnimal, double weight, double height, int age){
	String message;
	Person objper=searchPerson(id);
	if(objper==null){
	message="The person does not exist";
		}
	else {	
	message=objper.addPet(name, typeAnimal, weight, height, age);
		}
	return message;
}
	/**
	*Description this method is responsible for create  pet report
	*@param id - id of the owner
	*@return the pet report
	*/	
//this method is used to make the pet report
public String makePetReport(String id){
	String message;
	Person objperson=searchPerson(id);
	if(objperson==null){
	message="The pet does not exist";	
	}
	else {
	message=objperson.makePetReport();	
	}
	return message;
}
	/**
	*Description it serves to verify that people have pets
	*@return boolean true if the person have pet or false if the person not have pet
	*/	
public String verificationPet(){
	String text="";
	if(person.isEmpty()==true){
		text="No client";
	}
	for(int i=0;i<person.size();i++){
		if(person.get(i).verificationPet()==false){
			text += "The client with the name: "+person.get(i).getName()+" Identified with the number "+person.get(i).getId()+" Does not have a pet\n";
		}
		else{
			text="todos los clientes tienen mascota";
		}
}
return text;
}
	/**
	*Description this method is responsible for adding a new pet
	*<b>post</b>: A new pet object is deleted to the pet Array list of the person
	*@param id - id of the owner
	*@param name - the name of the pet
	*@return message confirming that the pet was deleted
	*/
//this method is used to remove pets
public String deletedPet(String id,String name){
	String message;
	Person objperson=searchPerson(id);
	if(objperson==null){
		message="Error";
	}
	else{
		message=objperson.deletedPet(name);
	}
	return message;
}
	/**
	*Description this method serves to change the status of people
	*<b>post</b>: A person have new state
	*@param id - id of the owner
	*@param state - the new state of the person
	*@return message confirming the person state was change
	*/
//
public String changeState(String id,char state){
	String text="";
	Person objperson=searchPerson(id);
	if(objperson==null){
		text="the person does not exist";
	}
	else{
		objperson.setState(state);
		text="the state was successfully changed";
	}
	return text;
}
	/**
	*Description this method is useful to find the mini rooms that are available
	*@return boolean true if available the mini room false if not available mini room
	*/
//
public MiniRoom findAvailableMini(){
	MiniRoom room=null;
	boolean found=false;
	for(int i=0;i<numberOfRooms&&found!=true;i++){
	if(miniroom[i].getAvailability()==true){
		room=miniroom[i];
		found=true;
	}

}
	return room;
}
	/**
	*Description this method serves to hospitalize pets
	*<b>post</b>: pet is add to miniroom
	*@param id - id of the owner
	*@param n - the name of the pet
	*@param t- the type animal of the pet
	*@param w- the weight of the pet
	*@param h - the height of the pet
	*@param a - the age of the pet
	*@param d - days in hospital in the vet
	*@return message confirming the pet is added in a miniroom
	*/
//this method serves to hospitalize pets
public String addPetMini(String id, String n, char t, double w, double h,int a, int d){
	String message;
	Person objperson=searchPerson(id);
	Pet objpet=null;
	if(objperson==null){
	message="The person does not exist";	
	}
	else {
	objpet=objperson.searchPet(n);
	}
	if(objpet==null){
	message="The pet does no exist";
	}
	else{
	MiniRoom room = findAvailableMini();
	if(room==null){
		message="There are no rooms available";
   }
   else{
	   message=room.AddPetOnMini(n, t, w, h,a, d);
   } 
}
return message;
}
	/**
	*Description this method is used to calculate earning of miniroom
	*@return earning of mini room
	*/
//this method is used to calculate profits
public double earningMiniRoom(){
	double total=0;
	for(int i=0;i<numberOfRooms;i++){
	if(miniroom[i].getAvailability()==false){
		total+=miniroom[i].costHospital()+miniroom[i].getPetOnRoom().calculateCostMed();
	}
}
return total;
}
	/**
	*Description this method serves to report the profits
	*@return report of earning of the vet
	*/
//
public String reportEarning(){
	String text="";
	text="the total earnings is "+"$"+totalEarning()+"\n";
	return text;
}
	/**
	*Description this method is used to look for pets that are hospitalized
	*@param id - id of the person
	*@param name - name of the pet
	*@return object pet or null
	*/
//
public Pet searchPh(String id,String name){
	Pet objpeth=null;
	Person objper=searchPerson(id);
	boolean found = false;
	if(objper == null){
		objpeth = null;
	}
	if(objper != null && objper.searchPet(name) != null){
	for(int i=0;i<numberOfRooms && !found ;i++){
	if(miniroom[i].searchPetH(name)!=null){
		if (name.equals(miniroom[i].searchPetH(name).getName())) {	
			objpeth = miniroom[i].searchPetH(name);
		found=true;
		}
	}
	}
	}
	return objpeth;
}
	/**
	*Description this method is used to give the mini room number where the pet is
	*@param id - id of the owner
	*@param name - name of the pet
	*@return a text saying the number of mini-room in the mini-room where the pet is.
	*/
public String searchNumberOfRoom(String id,String name){
	String text="";
	Pet objpeth=searchPh(id,name);
	boolean found = false;
	if(objpeth==null){
		text="the pet does not exist or is not hospitalized";
	}
	for(int i=0;i<numberOfRooms && objpeth!=null && found==false ;i++){
	if(miniroom[i].searchPetH(name)!=null){	
	if(name.equals(miniroom[i].searchPetH(name).getName())){
		objpeth = searchPh(id,name);
		text=" the pet is in the mini room number: "+miniroom[i].getNumberOfRoom()+"\n";
		found = true;
	}
	}
	}	
	return text;
	}
	/**
	*Description this method is used to relased pets
	*<b>post:</b> the pet is eliminated of the mini room
	*@param number - the number of the mini room
	*@param id - id of the person
	*@param name - name of the pet
	*@return text of confirmation
	*/
//this method is used to relased pets
	public String relasedPet(String number , String id, String name){
	String text="Error did not relased";
	MiniRoom objm=null;
	for(int i=0;i<numberOfRooms && objm==null;i++){
	if(searchPh(id,name)!=null && miniroom[i].searchPetH(name)!=null){
	if(name.equals(miniroom[i].searchPetH(name).getName()) && number.equals(miniroom[i].getNumberOfRoom())){
		objm=miniroom[i];
		text=objm.releasedPet(name);
	}	
}
}
return text;
}
	/**
	*Description this method is useful to add clinical histories
	*<b>post:</b> history is added in the Array List history of the pet
	*@param id - id of the person
	*@param name - name of the pet
	*@param s - state of the history
	*@param d - date of admission
	*@param sy - sympton of the vet
	*@param pd - possible diagnosis of the pet
	*@param nh - number of history
	*@return text of confirmation the history was added
	*/
//
public String addHistory(String id,String name, char s, String d, String sy, String pd, String nh){
	String text="";
	Pet obpph=searchPh(id,name);
	if(obpph==null){
		text="the pet does not exist or is not hospitalized";
	}
	else{
		text = obpph.addHistory(s,d, sy, pd,nh);
	}
	return text;
}
	/**
	*Description this method serves to report history
	*@param id -id of the owner
	*@param name - name of the pet
	*@return report of history
	*/
public String reportHistory(String id, String name){
	String text="";
	Pet objp = searchPh(id,name);
	if(objp != null){
		text = objp.makeReportH()+reportNoteS(id,name)+reportNoteD(id,name);
	}
	return text;
}
	/**
	*Description this method calculate price of the service
	*@param typeService - type of the service
	*@return the price of the service
	*/
public double calculatePriceService(String typeService){
	double price = 0;
	if(typeService.equals(AditionalServices.TPETBATHVET)){
		price += AditionalServices.PPETBATHVET;
	}
	if(typeService.equals(AditionalServices.TPETBATHDOM)){
		price += AditionalServices.PPETBATHDOM;
	}
	if(typeService.equals(AditionalServices.TNAILCUT)){
		price += AditionalServices.PNAILCUT;
	}
	if(typeService.equals(AditionalServices.TDENTAL)){
		price += AditionalServices.PDENTAL;
	}
	if(typeService.equals(AditionalServices.TVACCINES)){
		price += AditionalServices.PVACCINES;
	}
	return price;
}
	/**
	*Description this method is useful to add services
	*<b>post:</b> service is added in the Array List service of the pet
	*@param typeService - type of the service
	*@param pid - the owner id
	*@param np - the name of the pet
	*@return text of confirmation the history was added
	*/
public String addServices(String typeService, String pid, String np){
	String text = "";
	Pet objpet =  searchPet(pid, np);
	if(objpet==null){
		text = "the pet does not exist or the data is incorrect";
	}
	if(objpet!=null){
		text = objpet.addServices(typeService,calculatePriceService(typeService),pid,np);
	}
	return text;
}
	/**
	*Description this method is useful to search medicine
	*@param name -name of the medicine
	*@return object medicine
	*/
public Medicine searchMedicine(String name){
	Medicine objm = null;
	boolean confirmation = false;
	for(int i=0; i<numberOfMedicine&&confirmation!=true; i++){
		if(medicine[i]!=null&&name.equalsIgnoreCase(medicine[i].getName())){
			objm = medicine[i];
			confirmation=true;
		}
	}
	return objm;
}
	/**
	*Description this method is useful to medicate a pet
	*<b>post:</b> medicine is added in the Array List medicine of the pet
	*@param id - the id of the person
	*@param name - the name of the pet
	*@param nameM - the name of  the medicine
	*@return text of confirmation the medicine was added
	*/
public String medicatePet(String id,String name, String nameM){
	String text = "";
	Pet objp = searchPh(id,name);
	Medicine objm = searchMedicine(nameM);
	if(objp == null){
		text = "the pet does not exist or is not hospitalized";
	}
	if(objm == null){
		text = "medicine does not exist";
	}
	if(objp!=null && objm!=null){
		text=objp.addMedicine(objm.getName(),objm.getCostPerDose(),objm.getFrequency(),objm.getDose());
	}
	return text;
}
	/**
	*Description This method is used to calculate the cost of medicines for a specific pet
	*@param id - the id of the owner
	*@param name - the name of the pet
	*@return the cost in medicine
	*/
public double calculateIndCostMed(String id,String name){
	Pet objp = searchPh(id,name);
	double total = 0;
	if(objp != null){
		total = objp.calculateCostMed();
	}
	return total;
}
	/**
	*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	*<b>pre</b>: The client was created before.
	*<b>post</b>: The address and /or phone number of the client is updated.
	*@param id - the id of the client to which the data will be changed
	*@param address - The new address of the client. This param could be empty.
	*@param phone - The new phone number of the client. This param could be empty.
	*@return a confirmation message.
	*/
public String newData(String id,String address,String phone){
	String text = "";
	Person objper = searchPerson(id);
	if(objper == null){
		text = "the person to whom you want to change the data does not exist";
	}
	if(objper != null){
		objper.setAddress(address);
		objper.setPhone(phone);
		text = "the data was changed correctly";
	}
	return text;
}
	/**
	*Description This method is responsible for verifying if the note can be added
	*@param id - id of the owner
	*@param name - name of the pet
	*@param note - the note that you want to add
	*@return if the note can not be added it returns an error message otherwise it returns the message of the history object
	*/
public String addNoteD(String id,String name, String note){
	String text ="";
	Pet objp = searchPh(id,name);
	if(objp == null){
		text = "the pet does not exist or is not hospitalized";
	}
	if(objp != null){
		text = objp.addNoteD(note);
	}
	return text;
}
	/**
	*Description this method goes through the notes and creates a report
	@param id - id of the owner
	*@param name - name of the pet
	*@return the report of the notes
	*/
public String reportNoteD(String id,String name){
	String text="";
	Pet objp = searchPh(id,name);
	if(objp == null){
		text = "the pet does not exist or is not hospitalized";
	}
	if(objp != null){
		text = objp.reportNoteD();
	}
	return text;
}
	/**
	*Description This method is responsible for verifying if the note can be added
	*@param id - id of the owner
	*@param name - name of the pet
	*@param note - the note that you want to add
	*@return if the note can not be added it returns an error message otherwise it returns the message of the history object
	*/
public String addNoteS(String id,String name, String note){
	String text ="";
	Pet objp = searchPh(id,name);
	if(objp == null){
		text = "the pet does not exist or is not hospitalized";
	}
	if(objp != null){
		text = objp.addNoteS(note);
	}
	return text;
}
	/**
	*Description this method goes through the notes and creates a report
	@param id - id of the owner
	*@param name - name of the pet
	*@return the report of the notes
	*/
public String reportNoteS(String id,String name){
	String text="";
	Pet objp = searchPh(id,name);
	if(objp == null){
		text = "the pet does not exist or is not hospitalized";
	}
	if(objp != null){
		text = objp.reportNoteS();
	}
	return text;
}
	/**
	*Description this method calculates the earnings for concepts of additional services
	*@return the earning in aditional services
	*/
public double earningAS(){
	double expenses = 0;
	for(int i=0;i<person.size();i++){
		if(person.get(i) != null){
			expenses += person.get(i).expensesAditionalS();
		}
	}
	return expenses;
}
	/**
	*Description this method calculates the total earning of the vet
	*@return the earning in the vet
	*/
public double totalEarning(){
	return earningMiniRoom()+earningAS();
}
	/**
	*Description this method draws an average of earnings per service
	*@param service - type of service
	*@return the average earninig per service
	*/
public double averageServices(String service){
	double total = 0;
	if(service.equals("aditional services")){
		for(int i=0;i<person.size();i++){
			if(counter(service) > 0)
			total += earningAS()/counter(service);
			if(counter(service)==0)
			total = 0;	
		}
	}
	if(service.equals("hospitalization")){
		if(counter(service) > 0)
			total += earningMiniRoom()/counter(service);
	}
	return total;
}
	/**
	*Description count how many times the service was used
	*@param service - type of service
	*@return the number of times a specific service is used
	*/
public int counter(String service){
	int total = 0;
	if(service.equals("aditional services")){
		for(int i=0;i<person.size();i++){
		total += person.get(i).counter(service);
		}
	}
	if(service.equals("hospitalization")){
		for(int i=0;i<numberOfRooms;i++){
		if(miniroom[i].getAvailability() == false){
		total ++;
		}
		}
	}
	return total;
}
}



