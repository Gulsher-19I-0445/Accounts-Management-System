import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UI {
	
	///----------------------------------------------------------------
	//--------------------Declarations--------------------------------
	//----------------------------------------------------------------
	private String UserNames;
	private ArrayList<Checking> a=new ArrayList<Checking>();
	private ArrayList<Saving> s=new ArrayList<Saving>();
	int unique1;
	int unique2;
	//Accounts a=new Accounts();
	
	
	
	//----------------------------------------------------------------
	//----------------------Constructor--------------------------------
	//-----------------------------------------------------------------
	public UI() throws FileNotFoundException, IOException {
		//a.add(new Accounts());
		//System.out.println("Hello");
		unique1=0;
		unique2=0;

		// TODO Auto-generated constructor stub
	}
	
	public void  UIRead() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("new.csv"))) {

		    // List to collect Employee objects
		   // List<Employee> employees = new ArrayList<Employee>();
			int i=0;
			char temp1='0';
		    // Read file line by line
		    String line = "";
		    while ((line = br.readLine()) != null) {
		       // Parse line to extract individual fields
		    	System.out.println("lol");
		       String[] data ;
		    	data=line.split(",");
		    	if(i>0) {
		       // Create new Employee object
		    	//if(data[2])
		    	if(data[4].equals("Checking")) {
		    		temp1='X';
		    	}
		    	else if(data[4].equals("Saving")) {
		    		temp1='Y';
		    	}
		       a.add(new Checking(temp1,data[0],data[1],Integer.valueOf(data[2]),data[3]));
		       //Checking employee = new Checking();
		    	}
		    	i++;
		       // Add object to list
		       //employees.add(employee);
		    }

		    // Further process your Employee objects...
		}
	}
	
	//----------------------------------------------------------------
		//-----------------------Accounts Detail--------------------------
		//----------------------------------------------------------------
		public void Operations(int i,char atyp) {
			//Checking b=;
			int c1=0;
			//Checking b=(Checking)a.get(i);
			
			char opt='M';
			while(opt!='0') {
			if(atyp=='X'||atyp=='x') {
				Checking b=(Checking)a.get(i);
				if(c1==0) {
					System.out.println("Welcome "+b.getName());
					c1++;
				}
				
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
					int am;
					Scanner i2=new Scanner(System.in);
					System.out.println("Enter the amount you want to withDraw");
					am=i2.nextInt();
					b.withdraw(am);
				}
				
				if(opt=='C'||opt=='c') {
				b.checkBalance();
				}
				if(opt=='D'||opt=='d') {
					b.PrintStatemet();
					}
				
			}
			//-----------------------------
			if(atyp=='Y'||atyp=='y') {
				Saving c=(Saving)s.get(i);
				if(c1==0) {
					System.out.println("Welcome "+c.getName());
					c1++;
				}
				c1++;
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
					c.makeDeposit();
					//if(b.free_count==0) {
					//	System.out.println("\nYour free monthly deposit has ended");
						//b.deduction();
					//}
					//b.free_count--;
					}
				
				if(opt=='B'||opt=='b') {
					int am;
					Scanner i2=new Scanner(System.in);
					System.out.println("Enter the amount you want to withDraw");
					am=i2.nextInt();
					c.withdraw(am);
				}
				
				if(opt=='C'||opt=='c') {
				c.checkBalance();
				}
				
				if(opt=='D'||opt=='d') {
					c.PrintStatemet();
				}
				if(opt=='F'||opt=='f') {
					c.ZakatCalc();
				}
				
				
			}
			
		}
			
		}
	
	
	
	
	//----------------------------------------------------------------
	//----------------------Sign Up-----------------------------------
	//--------------------Create Account------------------------------
	public void SignUp() {			//Create Account Module
		Scanner i5=new Scanner(System.in);
		System.out.println("Please enter your name");
		String name=i5.next();
		Scanner i1=new Scanner(System.in);
		System.out.println("Select Account type");
		System.out.println("Press X for Checking");
		System.out.println("Press Y for Saving");
		char AccT=i1.next().charAt(0);
		if(AccT=='X'||AccT=='x') {
			String uniqueID = UUID.randomUUID().toString();
			//System.out.println(uniqueID);
			a.add(new Checking(AccT,uniqueID,name));
			
			System.out.println("Account successfully Created\n"+"Your Account ID is: "+uniqueID+"\n Remember this ID to Access your account and keep it secure\n");
			Operations(unique1,AccT);
			unique1++;
		}
		else if(AccT=='Y'||AccT=='y') {
			String uniqueID = UUID.randomUUID().toString();
			System.out.println(uniqueID);
			s.add(new Saving(AccT,uniqueID,name));
			Operations(unique2,AccT);
			unique2++;
		}
		//System.out.println("Enter Account Number");
		//int accNum=i1.nextInt();
		//a.add(new Accounts(AccT,unique));
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------				LOGIN				--------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------
	public void Login() {
		int index=0;
		Scanner i1=new Scanner(System.in);
		System.out.println("Select your Account Type");
		System.out.println("Press X for Checking Account");
		System.out.println("Press Y for Saving Account");
		char AccT=i1.next().charAt(0);
		Checking logged;
		Saving logged1;
		//Checking logged;
		if(AccT=='X') {
			Scanner i9=new Scanner(System.in);
			System.out.println("Enter your Account number");
			String u_res=i9.next();
			for(int i=0;i<a.size();i++) {
				logged=(Checking)a.get(i);
				//ASystem.out.println(logged.Acc_no+" |");
				//System.out.println(u_res+" |");
				if(u_res.equals(logged.getAccNum())) {
					//System.out.println("llllllllllllllllllllllllll");
					index=i;
					break;
				}
			}
		//logged=(Checking)a.get(index);	
		}
		else if(AccT=='Y') {
			System.out.println("Enter your Account number");
			String u_res=i1.next();
			for(int i=0;i<s.size();i++) {
				logged1=(Saving)s.get(i);
				if(u_res.equals(logged1.getAccNum())) {
					index=i;
					break;
				}
			}
		//logged=(Checking)a.get(index);
		}
		System.out.println("Index is :"+index);
		//System.out.println("Welcome "+getName());
		Operations(index,AccT);
		
		
		
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
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//------------------------------------------------------------

		UI interface1=new UI();
		//interface1.UIRead();
		int id=0;//unique identifier for new comers
		char option='z';//To make menu
		//------------------------------------------------------------
		System.out.println("Welcome to bank account management system");
		while(option!='e'||option!='E') {
		Scanner i1=new Scanner(System.in);
		System.out.println("Select the Options below to proceed");
		System.out.println("Press (A) to sign up");
		System.out.println("Press (B) to sign in");
		option=i1.next().charAt(0);
		if(option=='a'||option=='A')
		interface1.SignUp();
		
		//interface1.Show(id);
		id++;
		if(option=='b'||option=='B') {
			interface1.Login();
		}
		// TODO Auto-generated method stub
		}
	}

}
