package GUIng_Etc;
/* String_set class
 * create static field
 * 
 * */

public class String_set {
	public static int info_image; //save image number get from login page
	private static int[] testresult = { 0, 0, 0 };
	private static int main_ch; //chapter static variable
	
	public static int getMain_ch() {
		return main_ch;
	}

	public static void setMain_ch(int main_ch) {
		String_set.main_ch = main_ch;
	}

	private static int score; //test score static variable

	// sub_ch_name : store the title of each sub chapters
	public static final String[][] sub_ch_name = {
			{"About OOP Language","About JAVA"},{"About Class","About Object"},{"About Variable","About Method"}
	};
	
	// set_test(int main_ch, int score): test score setter.
	public static void set_test(int main_ch, int score) {
		String_set.main_ch = main_ch;
		testresult[String_set.main_ch] = score;
	}
	
	// get_test(int main_ch): test score getter.
	public static int get_test(int main_ch) {
		String_set.main_ch = main_ch;
		return testresult[String_set.main_ch];
	}

}
