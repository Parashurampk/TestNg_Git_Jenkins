package TestingDemo;

/*
 	<methods>  
	<exclude name="Mobile.*"/>  
	</methods> 
 
 */
import org.testng.annotations.Test;

public class TestNgRegex {

	@Test
	public void WebLoginCarLoan() {
		System.out.println("WebLoginCarLoan");
	}

	@Test
	public void MobileLoginCarLoan() {
		System.out.println("MobileLoginCarLoan");
	}

	@Test
	public void MobileLoginPersonalLoan() {
		System.out.println("MobileLoginPersonalLoan");
	}

	@Test
	public void MobileLoginHomeLoan() {
		System.out.println("MobileLoginHomeLoan");
	}

	@Test
	public void LoginAPICarLoan() {
		System.out.println("LoginAPICarLoan");
	}
}