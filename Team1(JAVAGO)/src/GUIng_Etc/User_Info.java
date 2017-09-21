package GUIng_Etc;

/*
 * User_Info class
 * class contains user information
 * only one user's information exists. it's default by developer.
 * class using serialization.
 * */

import java.io.Serializable;
	
public class User_Info implements Serializable {
	private static final long serialVersionUID = 1209L; // it is used to prevent InvalidClassExceptions in the process of serializaion and deserialization.



	private static int id =20170612; //id of the user. you have to type this when you login.
	
	private static String level = "Lv. 1"; // the grade info of user.
	private int[] testresult=new int[3]; //the array of the test score.

	public User_Info() {
		this.imsi();
	}
	
	//imsi(): save the test score of user which is saved in static field into the array.
	public void imsi(){
		for(int i=0;i<3;i++)
			testresult[i]=String_set.get_test(i);
	}
	
	//get_name(): id getter.
	public static int get_name() {
		return id;
	}
	
	//get_level(): level getter.
	public static String get_level() {
		return level;
	}
	
	public int get_imsi_testresult(int i){
		return testresult[i];
	}

}
