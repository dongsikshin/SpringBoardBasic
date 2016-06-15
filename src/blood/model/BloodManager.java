//this class is web?? application? 
//this is for both....or every platform !!
package blood.model;

public class BloodManager {
	
	public String getAdvice(String blood) {
		String msg = null;

		if (blood.equals("A")) {
			msg = "sensitive and smart..";
		} else if (blood.equals("B")) {
			msg = "strong";
		} else if (blood.equals("O")) {
			msg = "friendly";
		} else if (blood.equals("AB")) {
			msg = "changable";
		}
		return msg;
	}
	
}
