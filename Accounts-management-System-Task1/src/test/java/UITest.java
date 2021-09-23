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
	 * @throws java.lang.Exception
	 */
	//@Before
	public void setUp() throws FileNotFoundException, IOException{
		interface1=new UI();
		System.setIn(new ByteArrayInputStream("0".getBytes()));
		interface1.SignUp("1", 'x', "Gulsher");
		System.setIn(new ByteArrayInputStream("0".getBytes()));
		interface1.SignUp("2", 'x', "Rafay");
	}
	
	@Test
	public void findAccTest() throws FileNotFoundException, IOException {
		setUp();
		int output=interface1.findAccCheck("1");
		int expected_value=0;
		Assert.assertEquals(output, expected_value);
		//fail("Not yet implemented");
	}
	
	

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
