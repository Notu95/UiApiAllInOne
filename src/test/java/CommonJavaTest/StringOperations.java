package CommonJavaTest;

public class StringOperations {

	public static void main(java.lang.String[] args) {
		StringOperations.splitString("Sourav.Ghosh");

	}
	
	public static void splitString(String str) {
		String[] str1=str.split("\\.");
		System.out.println(str1[1]);
		System.out.println(str1[0]);
	}
	

}
