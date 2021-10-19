import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author gulsh
 *
 */
public class UITest {
	UI interface1;
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InsufficientBalanceException 
	 * @throws java.lang.Exception
	 */
	//@Before
	public void setUp() throws FileNotFoundException, IOException, InsufficientBalanceException{
		interface1=new UI();
		System.setIn(new ByteArrayInputStream("0".getBytes()));
		interface1.SignUp("1", 'x', "Gulsher");
		System.setIn(new ByteArrayInputStream("0".getBytes()));
		interface1.SignUp("2", 'x', "Rafay");
		System.setIn(new ByteArrayInputStream("0".getBytes()));
		interface1.SignUp("3", 'y', "Ameen");
		System.setIn(new ByteArrayInputStream("0".getBytes()));
		interface1.SignUp("4", 'Y', "Uzair");
	}
	
	

	//TESTS FOR FINDING ACCOUNTS
	
	@Test
	public void findAccTestCheck() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="1";
		int output=interface1.findAccCheck(AccNo);
		int expected_value=0;
		Assert.assertEquals(output, expected_value);//IF account is found Function Returns index of object else it returns -1
		//fail("Not yet implemented");
	}
	@Test
	public void findAccTestSaving() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="3";
		int output=interface1.findAccSaving(AccNo);	//Finding a saving account
		int expected_value=0;
		Assert.assertEquals(output, expected_value);//IF account is found Function Returns index of object else it returns -1
		//fail("Not yet implemented");
	}
	
	@Test
	public void findAccTestChecking_Neg1() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="1";
		int output=interface1.findAccSaving(AccNo);	//Finding a Checking account in array list for Saving should return False
		int expected_value=-1;
		Assert.assertEquals(output, expected_value);//IF account is found Function Returns index of object else it returns -1
		//fail("Not yet implemented");
	}
	
	@Test
	public void findAccTestChecking_Neg2() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="12";
		int output=interface1.findAccCheck(AccNo);	//Finding an Account that does not exist in Checking array list
		int expected_value=-1;
		Assert.assertEquals(output, expected_value);//IF account is found Function Returns index of object else it returns -1
		//fail("Not yet implemented");
	}
	
	@Test
	public void findAccTestSaving_Neg1() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="3";
		int output=interface1.findAccCheck(AccNo);	//Finding a Saving account in array list for Checking should return False
		int expected_value=-1;
		Assert.assertEquals(output, expected_value);//IF account is found Function Returns index of object else it returns -1
		//fail("Not yet implemented");
	}
	
	@Test
	public void findAccTestSaving_Neg2() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="100";
		int output=interface1.findAccSaving(AccNo);	//Finding an Account that does not exist in Savings array list
		int expected_value=-1;
		Assert.assertEquals(output, expected_value);//IF account is found Function Returns index of object else it returns -1
		//fail("Not yet implemented");
	}
	
	
	//TESTS FOR DELETE ACCOUNTS
	@Test
	public void DeleteAccTestChecking() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="1";
		interface1.deleteAcc('x',AccNo);
		int expected_value=-1;
		Assert.assertEquals(interface1.findAccCheck(AccNo), expected_value);
		//fail("Not yet implemented");
	}
	
	@Test
	public void DeleteAccTestSaving() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="3";
		interface1.deleteAcc('y',AccNo);
		int expected_value=-1;
		Assert.assertEquals(interface1.findAccSaving(AccNo), expected_value);
		//fail("Not yet implemented");
	}
	
	@Test
	public void DeleteAccTestSaving_Neg() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="30";
		
		String AccNo1="3";
		String AccNo2="4";
		
		interface1.deleteAcc('y',AccNo);
		int expected_value1=0;
		int expected_value2=1;
		Assert.assertEquals(interface1.findAccSaving(AccNo1), expected_value1);
		Assert.assertEquals(interface1.findAccSaving(AccNo2), expected_value2);
		//fail("Not yet implemented");
	}
	
	@Test
	public void DeleteAccTestChecking_Neg() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUp();
		String AccNo="30";
		
		String AccNo1="1";
		String AccNo2="2";
		
		interface1.deleteAcc('x',AccNo);
		int expected_value1=0;
		int expected_value2=1;
		Assert.assertEquals(interface1.findAccCheck(AccNo1), expected_value1);
		Assert.assertEquals(interface1.findAccCheck(AccNo2), expected_value2);
		//fail("Not yet implemented");
	}
	

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
