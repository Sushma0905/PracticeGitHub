package salesForce;

public class Example1 {
	public boolean validRule(int RegFees, String courseOptions){
		boolean value = false;
		if(courseOptions.equals("Admin")|| courseOptions.equals("Developer")||courseOptions.equals("BigData")){
			return false;
		}else{
			if(RegFees<5000){
				return true;
			}
			else{
				return false;
			}
		}	
	}
}
