import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestSavingsAccount {

	private SavingsAccount myobj;
	
	@Before 
	public void setUp()
	{
		myobj = new SavingsAccount();
		String [] acc = new String [10];
		acc[0] = "23456";
		myobj.setAccountNo(acc, 0);
		acc[1] = "67890";
		myobj.setAccountNo(acc, 1);
		acc[2] = "12345";
		myobj.setAccountNo(acc, 2);
		
	}
	
	@Test
	public void PostivetestVerifyAccountNo()				// postive test case
	{

		String posaccno = "12345";
		int temp = 3;
		int expectedResult = 1;
		int result = myobj.verifyAccountNo(posaccno, temp, 0);
		assertEquals(expectedResult,result);
	}
	
	@Test
	public void NegativetestVerifyAccountNo()					// negative test case
	{

		String negaccno = "55444";
		int temp = 3;
		int expectedResult = 0;
		int result = myobj.verifyAccountNo(negaccno, temp, 0);
		assertEquals(expectedResult,result);
	}
	
	

}

