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
public class Person{
//constants
public final static char ACTIVE='A';
public final static char INACTIVE='I';
//attributes
private String name;
private String id;
private String address;
private String phone;
private char state;
//relations
private ArrayList<Pet>pet;
	/**
	* Description: The method is responsible for creating a person
	* <b>pos</b>: create a new person
	* @param n - is the name of the person
	* @param id - is the id of the person
	* @param a - is the address of the person
	* @param p - is the phone of the person
	* @param s - is the state of the person
	*/
//constructor
public Person(String n, String id, String a, String p, char s){
	pet = new ArrayList <Pet>();
	name = n;
	this.id = id;
	address = a;
	phone = p;
	state = s;
}
//methods
	/**
	 * Description this method serves to give name of the person
	 * @return name
	 */
public String getName(){
	return name;
}
	/**
	 * Description this method is used to change the name of the person
	 * @param newName - the new name of the person
	 */
public void setName(String newName){
	name = newName;
}
	/**
	 * Description this method serves to give id of the person
	 * @return id
	 */
public String getId(){
	return id;
}
	/**
	 * this method is used to change the id of the person
	 * @param newId - the new id of the person
	 */
public void setId(String newId){
	id = newId;
}
	/**
	 * Description this method serves to give address of the person
	 * @return address
	 */
public String getAddress(){
	return address;
}	
	/**
	 * this method is used to change the address of the person
	 * @param newAddress - the new address of the person
	 */
public void setAddress(String newAddress){
	address = newAddress;
}
	/**
	 * Description this method serves to give phone of the person
	 * @return phone
	 */
public String getPhone(){
	return phone;
}
	/**
	 * this method is used to change the phone of the person
	 * @param newPhone - the new phone of the person
	 */
public void setPhone(String newPhone){
	phone = newPhone;
}
	/**
	 * Description this method serves to give the state of the person
	 * @return state
	 */
public char getState(){
	return state;
}
	/**
	 * this method is used to change the state of the person
	 * @param newState - the new state of the person
	 */
public void setState(char newState){
	state=newState;
}
	/**
	*Description this method is responsible for search pet
	*@param name - name of the pet
	*@return object pet
	*/
public Pet searchPet(String name){
	Pet objPet=null;
	for(int i=0;i<pet.size()&&objPet==null;i++){
		if(name.equalsIgnoreCase(pet.get(i).getName())){
			objPet=pet.get(i);
		}
	}
	return objPet;
}
	/**
	*Description this method is responsible for adding a new pet to the person
	*<b>post:</b> a new pet is added to the pet Array List
	*@param n - name of the pet
	*@param t - is the type of animal of the pet
	*@param w - is the weight of the pet
	*@param h - is the height of the pet
	*@param a - is the age of the pet
	*@return message confirming that the pet was added
	*/
public String addPet(String n, char t, double w, double h ,int a){
	String message="";
	Pet obj = new Pet(n, t, w, h, a);
	if(searchPet(n)!=null){
	message="the pet already exists";
	}
	else{
		pet.add(obj);
		 message="it was added successfully";
	}
		return message;
	}
	/**
	*Description this method is responsible for making the report of the pet
	*@return the report of the pet
	*/
public String makePetReport(){
	String text="";
	if(pet.isEmpty()==true){
		text="No pet";
	}
	for(int i=0;i<pet.size();i++){
		text+=" The name of the owner is "+getName()+" the name of the pet is "+pet.get(i).getName()+" is of the animal type "+pet.get(i).getTypeAnimal()+" the weight is "+pet.get(i).getWeight()+" the age is "+pet.get(i).getAge()+"\n";
	}
	return text;	
}
	/**
	*Description this method is responsible for verifying if the person has registered pets
	*@return returns true if the person has at least one pet and false if he does not have any
	*/
public boolean verificationPet(){
     boolean verification = true;
	 if(pet.isEmpty()==true){
		 verification = false;
	 }

	return verification;
}
	/**
	*Description this method is responsible for adding a new story to the pet
	*<b>post:</b> a pet is removed from the pet Array List
	*@param name - name of the pet
	*@return message confirming that the pet is removed
	*/
public String deletedPet(String name){
	String text="";
	if(pet.isEmpty()==true){
		text= "there are no pets";
	}
	for(int i=0;i<pet.size();i++){
		if(pet.get(i).getName().equalsIgnoreCase(name)){
			pet.remove(i);
			text= "it was successfully eliminated";
		}
		else{
			text="Error";
		}
	}
	return text;
}
	/**
	*Description the expense for additional services of the pet
	*@return expense for additional services of the pet
	*/
public double expensesAditionalS(){
	double expenses = 0;
	for(int i=0;i<pet.size();i++){
		if(pet.get(i) != null){
			expenses += pet.get(i).expensesAditionalS(); 
		}
	}
	return expenses;
}
	/**
	*Description count how many times the pet used a especific service
	*@param service - the service that you want to get the account
	*@return the number of times an especific services was used
	*/
public int counter(String service){
	int total = 0;
	if (service.equals("aditional services")){
	for(int i=0;i<pet.size();i++){
		if(pet.get(i) != null  ){
			total += pet.get(i).counterAS(); 
		}
}
}
return total;
}
}