import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	
	///----------------------------------------------------------------
	//--------------------Declarations--------------------------------
	//----------------------------------------------------------------
	private String UserNames;
	private ArrayList<Checking> a=new ArrayList<Checking>();
	//Accounts a=new Accounts();
	
	
	
	//----------------------------------------------------------------
	//----------------------Constructor--------------------------------
	//-----------------------------------------------------------------
	public UI() {
		//a.add(new Accounts());
		System.out.println("Hello");
		// TODO Auto-generated constructor stub
	}
	
	//----------------------------------------------------------------
		//-----------------------Accounts Detail--------------------------
		//----------------------------------------------------------------
		public void Operations(int i,char atyp) {
			//Checking b=;
			char opt='M';
			while(opt!='0') {
			if(atyp=='X'||atyp=='x') {
				Checking b=(Checking)a.get(i);
				System.out.println("Select what you want to do");
				System.out.println("(A) Deposit Money");
				System.out.println("(B) Withdraw Money");
				System.out.println("(C)Check Balance");
				System.out.println("(D)PrintStatement");
				System.out.println("(E)Transfer Money");
				System.out.println("(F)Calculate Zakat");
				System.out.println("(G)Display all deductions");
				Scanner i1=new Scanner(System.in);
				opt=i1.next().charAt(0);
				if(opt=='A'||opt=='a') {
					b.makeDeposit();
					if(b.free_count==0) {
						System.out.println("\nYour free monthly deposit has ended");
						b.deduction();
					}
					b.free_count--;
					}
				
				if(opt=='B'||opt=='b') {
					
				}
				
				if(opt=='C'||opt=='c') {
				b.checkBalance();
				}
			}
		}
			
		}
	
	
	
	
	//----------------------------------------------------------------
	//----------------------Sign Up-----------------------------------
	//--------------------Create Account------------------------------
	public void SignUp(int unique) {			//Create Account Module
		Scanner i1=new Scanner(System.in);
		System.out.println("Select Account type");
		System.out.println("Press X for Checking");
		System.out.println("Press Y for Saving");
		char AccT=i1.next().charAt(0);
		if(AccT=='X'||AccT=='x') {
			a.add(new Checking(AccT,unique));
			Operations(unique,AccT);
		}
		//System.out.println("Enter Account Number");
		//int accNum=i1.nextInt();
		//a.add(new Accounts(AccT,unique));
	}
	
	
	
	
	//----------------------------------------------------------------
	//----------------------Initial Display Function------------------
	//----------------------------------------------------------------
	
	public void Show(int n) {
		//aChecking b=(Checking)a.get(n);
		//b.Display();
	}
	
	//----------------------------------------------------------------
	//----------------------Int Main----------------------------------
	//----------------------------------------------------------------
	
	public static void main(String[] args) {
		//------------------------------------------------------------
		UI interface1=new UI();
		int id=0;//unique identifier for new comers
		char option='z';//To make menu
		//------------------------------------------------------------
		while(option!='e'||option!='E') {
		Scanner i1=new Scanner(System.in);
		System.out.println("Select the Options below to proceed");
		option=i1.next().charAt(0);
		if(option=='a'||option=='A')
		interface1.SignUp(id);
		
		//interface1.Show(id);
		id++;
		// TODO Auto-generated method stub
		}
	}

}
