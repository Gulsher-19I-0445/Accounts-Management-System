import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author gulsh
 *
 */
public class Accounts {
	protected String Acc_no;
	protected int account_balance;
	private String date_created;
	private String name;

	/**
	 * 
	 */
	public Accounts() {
		Acc_no="0";
		account_balance=100;
		date_created="12";
		// TODO Auto-generated constructor stub
	}
	public Accounts(char A,String num,String name1) {
		Acc_no=num;
		account_balance=100;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		name=name1;
		System.out.println("Account created on "+dtf.format(now));
		date_created=dtf.format(now);
		try {
			write_to();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	//--------------------------------------------------------------------
	public Accounts(char A,String num,String name1,String date) {
		Acc_no=num;
		account_balance=100;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		name=name1;
		System.out.println("Account created on "+dtf.format(now));
		date_created=date;
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @param args
	 */
	//Getter and setters
	public void setName(String n) {
		name=n;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	
	
	//--------------------------------------------------------------------------
	//----------------------------CHECK----------------------------------
	//--------------------------------------------------------------------------
	public void checkBalance() {
		//System.out.println("Your assigned Account Number and Account type is: ");
		System.out.println("Account ID: "+Acc_no);
		System.out.println("Your account balance is: ");
		System.out.println(account_balance);
	}
	//--------------------------------------------------------------------------
	//--------------------------Make Deposits-----------------------------------
	//--------------------------------------------------------------------------
	
	public void makeDeposit() {
		System.out.println("Enter the amount to Deposit");
		Scanner i1=new Scanner(System.in);
		int amt=i1.nextInt();
		account_balance=account_balance+amt;
		System.out.print("Rs"+amt+" added to your balance");
	}
	//--------------------------------------------------------------------------
	//--------------------------------WithDraw----------------------------------
	//--------------------------------------------------------------------------
	public void write_to() 
		throws IOException {
		/*BufferedWriter br = new BufferedWriter(new FileWriter("text1.csv"));
		StringBuilder sb = new StringBuilder();
		  
		
		sb.append(Acc_no + "\t");    
		sb.append(account_balance + "\t");
		sb.append("\n");    
		 
		
		  
		br.write(sb.toString());
		br.close();*/
	

		FileWriter csvWriter = new FileWriter("new.csv",true);
				
		csvWriter.append(Acc_no);
		csvWriter.append(",");
		csvWriter.append(name);
		csvWriter.append(",");
		String s=String.valueOf(account_balance);//Now it will return "10" 
		csvWriter.append(s);
		csvWriter.append(",");
		csvWriter.append(date_created);
		csvWriter.append(",");
		csvWriter.append("\n");
		
		

		csvWriter.flush();
		csvWriter.close();	  
		  
		
	}
	
	

	
	
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	public void deduction() {
		account_balance=account_balance-10;
	}
	
	//--------------------------------------------------------------------------
//	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

}

