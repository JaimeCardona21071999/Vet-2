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

public class MiniRoom{
//attributes
private boolean availability;
private String numberOfRoom;
private int daysInHospital;
	/**
	* Description The method is responsible for creating a mini room
	* <b>pre</b>: that numberOfRoom is between 1 and 8, that daysInHospital is greater than 0
	* <b>pos</b>: create a new mini room
	* @param a - if there is room availability
	* @param n - the room number
	* @param d - the days of hospitalization
	*/
//constructor
public MiniRoom(boolean a, String n, int d){
	availability = a;
	numberOfRoom = n;
	daysInHospital = d;
}
//relations
private Pet petOnRoom;
//methods
	/**
	 * Description this method serves to give availability
	 * @return availability
	 */
public boolean getAvailability(){
	return availability;
}
	/**
	 * Description this method serves to give petOnRoom
	 * @return pet On Room
	 */
public Pet getPetOnRoom(){
	return petOnRoom;
}
	/**
	 * Description this method is used to change availability
	 * @param newAvailability - new Availability
	 */
public void setAvailability(boolean newAvailability){
	availability = newAvailability;
}
	/**
	 * Description this method serves to give number of room
	 * @return number of room
	 */
public String getNumberOfRoom(){
	return numberOfRoom;
}
	/**
	 * Description this method is used to change number of room
	 * @param newNumberOfRoom - new number of room
	 */
public void setNumberOfRoom(String newNumberOfRoom){
	numberOfRoom = newNumberOfRoom;
}
	/**
	 * Description this method serves to give days in hospital
	 * @return daysInHospital
	 */
public int getdaysInHospital(){
	return daysInHospital;
}
	/**
	 * Description this method is used to change days in hospital
	 * @param newDaysInHospital - new days in hospital
	 */
public void setDaysInHospital(int newDaysInHospital){
	daysInHospital = newDaysInHospital;
}
public Pet givePetOnRoom(){
	return petOnRoom;
}
	/**
	*Description Add a pet to the Mini Room
	*<b>pos</b>: introduce a pet to the mini-room
	*@param n - the name of the pet
	*@param t - the type of pet
	*@param w - the weight of the pet
	*@param h - the height of the pet
	*@param a - the age of the pet
	*@param d - the number of days of hospitalization
	*@return message to notify the user if it was added correctly
	*/
public String AddPetOnMini(String n, char t, double w, double h, int a, int d){
	String message="could not be added";
	if(petOnRoom==null){
	petOnRoom = new Pet(n, t, w, h, a);
	setAvailability(false);
	setDaysInHospital(d);
	message="it was added successfully";
	}
	return message;
	}
	/**
	*Description Calculate the cost of the hospitalization of the pet from the type and number of days
	*@return the cost of hospitalization
	*/	
public double costHospital(){
	double total=0;
	if(petOnRoom.getTypeAnimal()==petOnRoom.CAT){
		if(petOnRoom.getWeight()>=1 && petOnRoom.getWeight()<=3){
			total=10000*daysInHospital;
		}
			if(petOnRoom.getWeight()>=3.1 && petOnRoom.getWeight()<=10){
				total=12000*daysInHospital;
				}
					if(petOnRoom.getWeight()>=10.1 && petOnRoom.getWeight()<=20){
						total=15000*daysInHospital;
						}
						if(petOnRoom.getWeight()>20){
							total = 20000*daysInHospital;
							}							
		}
		if(petOnRoom.getTypeAnimal()==petOnRoom.DOG){
		if(petOnRoom.getWeight()>=1 && petOnRoom.getWeight()<=3){
			total=15000*daysInHospital;
		}
			if(petOnRoom.getWeight()>=3.1 && petOnRoom.getWeight()<=10){
				total=17000*daysInHospital;
				}
					if(petOnRoom.getWeight()>=10.1 && petOnRoom.getWeight()<=20){
						total=20000*daysInHospital;
						}
						if(petOnRoom.getWeight()>20){
							total = 25000*daysInHospital;
							}							
		}
		if(petOnRoom.getTypeAnimal()==petOnRoom.BIRD){
		if(petOnRoom.getWeight()>=1 && petOnRoom.getWeight()<=3){
			total=10000*daysInHospital;
		}
			if(petOnRoom.getWeight()>=3.1 && petOnRoom.getWeight()<=10){
				total=12000*daysInHospital;
				}
					if(petOnRoom.getWeight()>=10.1 && petOnRoom.getWeight()<=20){
						total=20000*daysInHospital;
						}
						if(petOnRoom.getWeight()>20){
							total = 25000*daysInHospital;
							}							
		}
		if(petOnRoom.getTypeAnimal()==petOnRoom.OTHER){
		if(petOnRoom.getWeight()>=1 && petOnRoom.getWeight()<=3){
			total=10000*daysInHospital;
		}
			if(petOnRoom.getWeight()>=3.1 && petOnRoom.getWeight()<=10){
				total=17000*daysInHospital;
				}
					if(petOnRoom.getWeight()>=10.1 && petOnRoom.getWeight()<=20){
						total=30000*daysInHospital;
						}
						if(petOnRoom.getWeight()>20){
							total = 33000*daysInHospital;
							}							
		}
		return total;
	}
	/**
	* Description look up a pet's history from its name
	* @param name - the name of the pet
	* @return an object of the class pet
	*/
public Pet searchPetH(String name){
	Pet objpeth=null;
	if(petOnRoom!=null){
		if(name.equalsIgnoreCase(petOnRoom.getName())){
			objpeth = petOnRoom;
		}	

	}
	return objpeth;
}
	/**
	*Description serves to relased pets
	*<b>post</b>:the pet relationship with miniroom is eliminated
	*@param name - the name of the pet that is expected to be removed
	*@return message confirming that the pet was eliminated
	*/
//
public String releasedPet(String name){
	String text="could not be relased";
	if(petOnRoom != null && name.equalsIgnoreCase(petOnRoom.getName())){
		petOnRoom = null;
		setAvailability(true);
		text="was discharged";
	}
	return text;
	}
}

	
