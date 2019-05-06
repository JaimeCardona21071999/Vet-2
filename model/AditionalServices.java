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
 public class AditionalServices{
//constants
public final static double PPETBATHVET = 20000;
public final static double PPETBATHDOM = 30000;
public final static double PNAILCUT = 8000;
public final static double PDENTAL = 12000;
public final static double PVACCINES = 45000;
public final static String TPETBATHVET = "Pet bath vet";
public final static String TPETBATHDOM = "Pet bath dom";
public final static String TNAILCUT = "Nail cut";
public final static String TDENTAL = "Dental";
public final static String TVACCINES = "Vaccines";
 //atributes
private String typeService;
private double price;
private String personId;
private String petName;
	/**
	* Description: The method is responsible for creating a AditionalServices
	* <b>pre</b>: type of service must be one of the constants, the price have to positive 
	* <b>pos</b>: create a new AditionalServices
	* @param t - the type of the service
	* @param p - the price of the service
	* @param pid - the person id
	* @param np - the name of the pet
	*/
//constructor
public AditionalServices(String t, double p, String pid, String np){
	typeService = t;
	price = p;
	personId = pid;
	petName = np;
}
	/**
	 * Description this method serves to give type of service
	 * @return typeService
	 */
public String getTypeService(){
	return typeService;
}
	/**
	 * Description this method is used to change the type of service
	 * @param newType - the new type pf service
	 */
public void setTypeService(String newType){
	typeService = newType;
}
	/**
	 * Description this method serves to give the price of the service
	 * @return price
	 */
public double getPrice(){
	return price;
}
	/**
	 * Description this method is used to change the price of service
	 * @param newPrice - the new price of service
	 */
public void setPrice(double newPrice){
	price = newPrice;
}
	/**
	 * Description this method serves to give the person id
	 * @return personId
	 */
public String getPersonId(){
	return personId;
}
	/**
	 * Description this method is used to change the person id
	 * @param newPersonId - the new person id
	 */
public void setPersonId(String newPersonId){
	personId = newPersonId;
}
	/**
	 * Description this method serves to give the pet name
	 * @return petName
	 */
public String getPetName(){
	return petName;
}
	/**
	 * Description this method is used to change the pet name
	 * @param newPetName - the new pet name
	 */
public void setPetName(String newPetName){
	petName = newPetName;
}
}