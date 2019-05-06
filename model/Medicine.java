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
public class Medicine{
//attributes
private String name;
private double costPerDose;
private int frequency;
private double dose;
	/**
	* Description: The method is responsible for creating a medicine
	* <b>pre</b>: the costPerDose, frequency and dose they have to be positive numbers  
	* <b>pos</b>: create a new medicine
	* @param n - the name of the medicine
	* @param c - the cost per dose of the medicine
	* @param f - the frequency of the medicine
	* @param d - the dose of the medicine
	*/
//constructor
public Medicine(String n, double c, int f, double d){
	name = n;
	costPerDose = c;
	frequency = f;
	dose = d;
}
//methods
	/**
	 * Description this method serves to give name of the medicine
	 * @return name
	 */
public String getName(){
	return name;
}
	/**
	 * Description this method is used to change the name of the medicine
	 * @param newName - the new name of the medicine
	 */
public void setName(String newName){
	name = newName;
}
	/**
	 * Description this method serves to give cost per dose of the medicine
	 * @return costPerDose
	 */
public double getCostPerDose(){
	return costPerDose;
}
	/**
	 * Description this method is used to change the cost per dose of the medicine
	 * @param newCostPerDose - the new cost per dose of the medicine
	 */
public void setCostPerDose(double newCostPerDose){
	costPerDose = newCostPerDose;
}
	/**
	 * Description this method serves to give frequency of the medicine
	 * @return frequency
	 */
public int getFrequency(){
	return frequency;
}
	/**
	 * Description this method is used to change the frequency of the medicine
	 * @param newFrequency - the new frequency of the medicine
	 */
public void setFrequency(int newFrequency){
	frequency = newFrequency;
}
	/**
	 * Description this method serves to give dose of the medicine
	 * @return dose
	 */
public double getDose(){
	return dose;
}
	/**
	 * Description this method is used to change the phone of the person
	 * @param newDose - the new dose of the medicine
	 */
public void setDose(double newDose){
	dose = newDose;
}
	/**
	 * Description this method is used to calculate the cost of the medicine
	 * @return the cost of the medicine
	 */
public double costMedicine(){
	return costPerDose*dose;
}
}