import java.util.Scanner;

/**
 * 
 */

/**
 * @author gulsh
 *
 */
public class Accounts {
	private int Acc_no;
	private int account_balance;
	private int date_created;

	/**
	 * 
	 */
	public Accounts() {
		Acc_no=0;
		account_balance=100;
		date_created=12;
		// TODO Auto-generated constructor stub
	}
	public Accounts(int A,int num) {
		Acc_no=num;
		account_balance=100;
		date_created=12;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 */
	
	//--------------------------------------------------------------------------
	//----------------------------CHECK----------------------------------
	//--------------------------------------------------------------------------
	public void checkBalance() {
		//System.out.println("Your assigned Account Number and Account type is: ");
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
	public void withDraw() {
		
	}
	
	
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
	public void deduction() {
		account_balance=account_balance-10;
	}
	
	//--------------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

