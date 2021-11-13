import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestCheckingAccount {

	private CheckingAccount myobj;

	
	@Before
	public void setUp()
	{
		myobj = new CheckingAccount(1);
		String [] acc = {"67890","23456","23332","12345","23344","55343","32323","55633","94944","39922"};
		for(int i=0;i<10;i++)
		{
			myobj.setAccountNo(acc, i);
		}

		
	}

	@Test
	public void PostivetestVerifyAccountNo()				// positive test case
	{

		String posaccno = "94944";
		int temp = 10;
		int expectedResult = 1;
		int result = myobj.verifyAccountNo(posaccno, temp, 0);
		assertEquals(expectedResult,result);
	}
	@Test
	public void NegativetestVerifyAccountNo()					// negative test case
	{

		String negaccno = "78979";
		int temp = 10;
		int expectedResult = 0;
		int result = myobj.verifyAccountNo(negaccno, temp, 0);
		assertEquals(expectedResult,result);
	}
	@Test
	public void testSetCheckingClosingAccount()
	{
		int flag = 10, temp = 4;
		String [] expectedResult = {"67890","23456","23332","12345","55343","32323","55633","94944","39922","39922 "};
		myobj.setCheckingClosingAccount(flag, temp);
		assertArrayEquals(expectedResult,myobj.getAccountNo());
	}
	
	

}
