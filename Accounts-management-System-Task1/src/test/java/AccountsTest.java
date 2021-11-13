import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class AccountsTest {
	private Checking c1;
	private Checking c2;
	private Saving s1;
	private Saving s2;
	//private UI u;
	//@BeforeClass
	public void setUp() throws FileNotFoundException, IOException {
		c1=new Checking('x',"abd","name", 0);
		//u=new UI();
		
	}
	
	public void setUpS() throws FileNotFoundException, IOException {
		s1=new Saving('y',"abd","name", 0);
		//u=new UI();
		
	}
	
	public void setUpTransfer1() throws FileNotFoundException, IOException {	//Transfer to Checking
		c1=new Checking('x',"123","name", 0);
		c2=new Checking('x',"456","name2", 0);
		//u=new UI();
		
	}
	
	public void setUpTransfer2() throws FileNotFoundException, IOException {	//Transfer to Saving
		s1=new Saving('y',"789","name3", 0);
		s2=new Saving('Y',"111","name4", 0);
		//u=new UI();
		
	}
	public void setUpCrossTransfer() throws FileNotFoundException, IOException {	//Transfer to Saving
		s1=new Saving('y',"789","name5", 0);
		c1=new Checking('x',"111","name6", 0);
		//u=new UI();
		
	}
	
	@Test
	
	/*public void testGet() {
		setUp();
		int b=a.getBalance();
		int expected_value=100;
		Assert.assertEquals(b, expected_value);
	//	fail("Not yet implemented");
	}
	*/
	
	/*public void testFindBal() {
		setUp();
		int b=a.getBalance();
		int expected_value=100;
		Assert.assertEquals(b, expected_value);
	//	fail("Not yet implemented");
	}*/
	
	/*public void testFindAcc() throws FileNotFoundException, IOException {
		setUp();
		int expected_value=-1;
		u.SignUp();
		int output=u.findAccCheck("x");
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	*/
	
	//TESTING DEPOSITS
	public void testDeposit() throws FileNotFoundException, IOException {
		setUp();
		int expected_value=112;
		c1.makeDeposit(12);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void testDepositSaving() throws FileNotFoundException, IOException {
		setUpS();
		int expected_value=1100;
		s1.makeDeposit(1000);
		int output=s1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	//NEGS
	@Test
	public void testDeposit_Neg1() throws FileNotFoundException, IOException {
		setUp();
		int expected_value=100;
		c1.makeDeposit(-12);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testDepositSaving_Neg2() throws FileNotFoundException, IOException {
		setUpS();
		int expected_value=100;
		s1.makeDeposit(-15);
		int output=s1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	
	
	
	@Test//(expected=IllegalArgumentException.class)
	
	//Transfer to Checking Account
	public void testTransfer1() throws FileNotFoundException, IOException {
		setUpTransfer1();
		int expected_value=200;
		c1.transfer(100,c2);
		int output=c2.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void testTransfer2() throws FileNotFoundException, IOException {
		setUpTransfer1();
		int expected_value=101;
		c2.transfer(1,c1);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void InvalidtestTransfer1() throws FileNotFoundException, IOException {
		setUpTransfer1();
		int expected_value=100;
		c2.transfer(-1,c1);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	@Test
	public void InvalidtestTransfer2() throws FileNotFoundException, IOException {
		setUpTransfer1();
		int expected_value=100;
		c1.transfer(-50,c2);
		int output=c2.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	//Transfer to Saving Account
	@Test
	public void testTransferC1() throws FileNotFoundException, IOException {
		setUpTransfer2();
		int expected_value=200;
		s1.transfer(100,s2);
		int output=s2.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void testTransferC2() throws FileNotFoundException, IOException {
		setUpTransfer2();
		int expected_value=101;
		s2.transfer(1,s1);
		int output=s1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void InvalidtestTransferC1() throws FileNotFoundException, IOException {
		setUpTransfer2();
		int expected_value=100;
		s1.transfer(-1,s2);
		int output=s2.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	@Test
	public void InvalidtestTransferC2() throws FileNotFoundException, IOException {
		setUpTransfer2();
		int expected_value=100;
		s2.transfer(-50,s1);
		int output=s1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	//Transfer from Checking to Saving
	@Test
	public void testCrossTransfer1() throws FileNotFoundException, IOException {
		setUpCrossTransfer();
		int expected_value=150;
		c1.transfer(50,s1);
		int output=s1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void testCrossTransfer2() throws FileNotFoundException, IOException {
		setUpCrossTransfer();
		int expected_value=150;
		s1.transfer(50,c1);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void InvalidtestCrossTransfer1() throws FileNotFoundException, IOException {
		setUpCrossTransfer();
		int expected_value=100;
		c1.transfer(-50,s1);
		int output=s1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	@Test
	public void InvalidtestCrossTransfer2() throws FileNotFoundException, IOException {
		setUpCrossTransfer();
		int expected_value=100;
		s1.transfer(-90,c1);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value);
	//	fail("Not yet implemented");
	}
	
	
	//TESTS FOR WITHDRAW
	@Test//(expected= InsufficientBalanceException.class)
	public void withDrawTestS() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUpS();
		int output=0;
		int expected_value1=100;
		int expected_value2=10;
		try {
			s1.withdraw(-90);
			output=s1.getBalance();
			//int expected_value=100;
			Assert.assertEquals(output, expected_value1);	
		}
		catch(InsufficientBalanceException e) {
			
		}
		
		s1.withdraw(90);
		output=s1.getBalance();
		Assert.assertEquals(output, expected_value2);
		
		
	//	fail("Not yet implemented");
	}
	
	@Test(expected= InsufficientBalanceException.class)
	public void withDrawTestS_WithdrawIMIT() throws FileNotFoundException, IOException, InsufficientBalanceException {
		setUpS();
		int expected_value1=100;
		int expected_value2=1;
		s1.withdraw(101);
		int output=s1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value1);
		s1.withdraw(90);
		output=s1.getBalance();
		Assert.assertEquals(output, expected_value2);
		
		
	//	fail("Not yet implemented");
	}
	
	
	@Test
	public void withDrawTestC() throws FileNotFoundException, IOException {
		setUp();
		int expected_value1=100;
		int expected_value2=10;
		c1.withdraw(-90);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value1);
		c1.withdraw(90);
		output=c1.getBalance();
		Assert.assertEquals(output, expected_value2);
		
		
	//	fail("Not yet implemented");
	}
	
	@Test
	public void withDrawTestC_WithdrawLIMIT() throws FileNotFoundException, IOException {
		setUp();
		int expected_value1=100;
		int expected_value2=10;
		c1.withdraw(6000);
		int output=c1.getBalance();
		//int expected_value=100;
		Assert.assertEquals(output, expected_value1);
		c1.withdraw(90);
		output=c1.getBalance();
		Assert.assertEquals(output, expected_value2);
		
		
	//	fail("Not yet implemented");
	}
	
	
	
	
	
	
	
	
	
	
	//TESTING CHECK BALANCE
	@Test
	public void ViewBalance() throws FileNotFoundException, IOException {
		setUpTransfer1();	//Using this function to make 2 accounts and check their balance
		int expected_value1=100;
		int expected_value2=150;
		//s1.withdraw(-90);
		int output=c1.checkBalance();
		Assert.assertEquals(output, expected_value1);
		c1.makeDeposit(50);
		int output2=c1.checkBalance();
		Assert.assertEquals(output2, expected_value2);
		
		
	//	fail("Not yet implemented");
	}
	
	//ZAKAT
	@Test
	public void Zakat() throws FileNotFoundException, IOException {
		setUpS();							//For customer with zakat not applied
		double expected_value1=0;
		double output1=s1.ZakatCalc();	
		Assert.assertEquals(output1, expected_value1,0.01);
	}
	@Test
	public void Zakat2() throws FileNotFoundException, IOException {
		setUpS();
		double expected_value1=1252.5;		//For customer with zakat applied
		s1.makeDeposit(50000);
		double output1=s1.ZakatCalc();
		Assert.assertEquals(output1, expected_value1,0.01);
	}
	
	
	
	
	public void test() {
		fail("Not yet implemented");
	}

}
