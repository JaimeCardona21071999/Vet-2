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
public class History{
//constants
public final static char OPEN ='O';
public final static char CLOSE='C';
//attributes
private char state;
private String dateOfAdmssion;
private String symptom;
private String possibleDiagnosis;
private String numberOfHistory;
	/**
	* Description: The method is responsible for creating a history
	* <b>pos</b>: create a new history
	* @param s - the state of the history
	* @param d - the date of admission of the pet
	* @param sy - the symptom of the pet
	* @param pd - the posible diagnosis of the pet
	* @param nh - the number pf history
	*/
//constructor
public History(char s, String d, String sy, String pd, String nh){
	state = s;
	dateOfAdmssion = d;
	symptom = sy;
	possibleDiagnosis = pd;
	numberOfHistory = nh;
	noteD = new String[10];
	noteS = new String[10];
}
//relations
private String []noteD;
private String []noteS;
//methods
	/**
	 * Description this method serves to give state of the history
	 * @return state
	 */
public char getState(){
	return state;
}
	/**
	 * Description this method is used to change the state of history
	 * @param newState - the new state of the history
	 */
public void setState(char newState){
	state = newState;
}
	/**
	 * Description this method serves to give the date of admission of the pet
	 * @return date of admission 
	 */
public String getDateOfAdmission(){
	return dateOfAdmssion;
}
	/**
	 * Description this method is used to change the date of admission
	 * @param newDateOfAdmission - the new date of admission
	 */
public void setDateOfAdmission(String newDateOfAdmission){
	dateOfAdmssion = newDateOfAdmission;
}
	/**
	 * Description this method serves to give the symptom of the pet
	 * @return symptom
	 */
public String getSympton(){
	return symptom;
}
	/**
	 * Description this method is used to change the symptom
	 * @param newSympton - the new symptom
	 */
public void setSympton(String newSympton){
	symptom = newSympton;
}
	/**
	 * Description this method serves to give the posible diagnosis of the pet
	 * @return posible diagnosis
	 */
public String getPossibleDiagnosis(){
	return possibleDiagnosis;
}
	/**
	 * Description this method is used to change the possible diagnosis
	 * @param newPossibleDiagnosis - the new possible Diagnosis
	 */
public void setPossibleDiagnosis(String newPossibleDiagnosis){
	possibleDiagnosis = newPossibleDiagnosis;
}
	/**
	 * Description this method serves to give the number of the history
	 * @return number of history
	 */
public String getNumberHistory(){
	return numberOfHistory;
}
	/**
	 * Description this method is used to change the number Of History
	 * @param newNumberHistory - the new number of history
	 */
//this method is used to change number history
public void setNumberHistory(String newNumberHistory){
	numberOfHistory = newNumberHistory;
}
	/**
	*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
	*<b>pre:</b> The patient clinic story must be not null.
	*<b>post:</b> New notes were added to the possible diagnostic in the patient clinic story.
	*@param note - The notes of possible diagnostic. This param must be not null.
	*@return returns a text saying that the note was added successfully
	*/
public String addNotesD(String note){
	String text ="Could not add note";
	boolean add = false;
	for(int i=0;i<10 && add != true;i++){
		if(noteD[i] == null){
			noteD[i] = new String(note);
			add = true;
			text = "it was added successfully";
		}
	}
	return text;
}
	/**
	*Description This method goes through all the notes and makes a report
	*@return the report of the notes
	*/
public String reportNotesD(){
	String text ="";
	for(int i=0;i<10;i++){
		if(noteD[i] != null){
			text += "Notes Diagnostic # "+i+":"+noteD[i]+"\n";
		}
	}
	return text;
}
	/**
	*Description This method allows to add new notes to the possible symptom during the hospitalization at the patient stories.
	*<b>pre:</b> The patient clinic story must be not null.
	*<b>post:</b> New notes were added to the  in the patient clinic story.
	*@param note - The notes of new symptom. This param must be not null.
	*@return returns a text saying that the note was added successfully
	*/
public String addNoteS(String note){
	String text ="Could not add note";
	boolean add = false;
	for(int i=0;i<10 && add != true;i++){
		if(noteS[i] == null){
			noteS[i] = new String(note);
			add = true;
			text = "it was added successfully";
		}
	}
	return text;
}
	/**
	*Description This method goes through all the notes and makes a report
	*@return the report of the notes
	*/
public String reportNotesS(){
	String text ="";
	for(int i=0;i<10;i++){
		if(noteS[i] != null){
			text += "Notes symptom # "+i+":"+noteS[i]+"\n";
		}
	}
	return text;
}
}


