import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
	private String p_word;
	
	
	
	
	//----------------------------------------------------------------
	//----------------------Constructor--------------------------------
	//-----------------------------------------------------------------
	public UI() throws FileNotFoundException, IOException {
		
		unique1=0;
		unique2=0;
		p_word="1234";

		// TODO Auto-generated constructor stub
	}
	

	
	//----------------------------------------------------------------
		//-----------------------Accounts Detail--------------------------
		//----------------------------------------------------------------
		public void Operations(int i,char atyp) {
			//Checking b=;
			int c1=0;
			//Checking b=(Checking)a.get(i);
			
			char opt='M';
			//try {
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
				Scanner i1=new Scanner(System.in);
				opt=i1.next().charAt(0);
				/////////////////////////////////////////////////////////
				while(true) {
					if (Character.toString(opt).matches("^[a-eA-E0]*$")) {
				         //System.out.println("valid input");
				         break;
				    }else{
				         System.out.println("Enter Valid invalid");
				         opt=i1.next().charAt(0);
				    }
					}
				/////////////////////////////////////////////////////////
				
				if(opt=='A'||opt=='a') {
					
					int amt1=0;
					Scanner i10;
					System.out.println("Enter the amount to Deposit");
					i10=new Scanner(System.in);
					amt1=i10.nextInt();
					while(amt1<0) {
					//if(x>0) {
						//Scanner i1=new Scanner(System.in);
						System.out.println("Please Enter a Valid ammount");
						//x++;
					//}
					i10=new Scanner(System.in);
					amt1=i10.nextInt();
					}
					
					b.makeDeposit(amt1);
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
					while(am<0) {
						//if(x>0) {
							//Scanner i1=new Scanner(System.in);
							System.out.println("Please Enter a Valid ammount");
							//x++;
						//}
						i2=new Scanner(System.in);
						am=i2.nextInt();
						}
					b.withdraw(am);
				}
				
				if(opt=='C'||opt=='c') {
				b.checkBalance();
				}
				if(opt=='D'||opt=='d') {
					b.PrintStatemet();
					}
				if(opt=='E'||opt=='e') {
					TransferTo(b);
					}
				
			}
			//-----------------------------
			//try {
			if(atyp=='Y'||atyp=='y') {
				//
				Saving c=null;
				//try
				//{
					c=(Saving)s.get(i);
				//}
				//catch(IndexOutOfBoundsException exception)
				//{
					//System.out.println("DOES NOT EXITS");
				//}
				
				
				//
				//Saving c=(Saving)s.get(i);
				
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
				//System.out.println("(G)Display all deductions");
				Scanner i1=new Scanner(System.in);
				
				opt=i1.next().charAt(0);
				
				while(true) {
					if (Character.toString(opt).matches("^[a-eA-E0]*$")) {
				         //System.out.println("valid input");
				         break;
				    }else{
				         System.out.println("Enter Valid invalid");
				         opt=i1.next().charAt(0);
				    }
					}
				
				if(opt=='A'||opt=='a') {
					int amt1=0;
					Scanner i10;
					System.out.println("Enter the amount to Deposit");
					i10=new Scanner(System.in);
					amt1=i10.nextInt();
					while(amt1<0) {
					//if(x>0) {
						//Scanner i1=new Scanner(System.in);
						System.out.println("Please Enter a Valid ammount");
						//x++;
					//}
					i10=new Scanner(System.in);
					amt1=i10.nextInt();
					}
					
					c.makeDeposit(amt1);
					
					}
				
				if(opt=='B'||opt=='b') {
					int am;
					Scanner i2=new Scanner(System.in);
					System.out.println("Enter the amount you want to withDraw");
					am=i2.nextInt();
					while(am<0) {
						//if(x>0) {
							//Scanner i1=new Scanner(System.in);
							System.out.println("Please Enter a Valid ammount");
							//x++;
						//}
						i1=new Scanner(System.in);
						am=i1.nextInt();
						}
					c.withdraw(am);
				}
				
				if(opt=='C'||opt=='c') {
				c.checkBalance();
				}
				
				if(opt=='D'||opt=='d') {
					c.PrintStatemet();
				}
				
				if(opt=='E'||opt=='e') {
					TransferTo(c);
				}
				
				if(opt=='F'||opt=='f') {
					c.ZakatCalc();
				}
				
				
			}
			//}
			
			
			//
			
		}
		//}
			//catch(IndexOutOfBoundsException exception)
			//{
				//System.out.println("This account does not exist");
			//}	
		//
			
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
		///////////////////////////////////////////////////////
		while(true) {
			if (Character.toString(AccT).matches("^[x-yX-Y]*$")) {
		         //System.out.println("valid input");
		         break;
		    }else{
		         System.out.println("Enter Valid invalid");
		         AccT=i1.next().charAt(0);
		    }
			}
		/////////////////////////////////////////////////
		
		if(AccT=='X'||AccT=='x') {
			String uniqueID = UUID.randomUUID().toString();
			
			a.add(new Checking(AccT,uniqueID,name));
			
			System.out.println("Account successfully Created\n"+"Your Account ID is: "+uniqueID+"\n Remember this ID to Access your account and keep it secure\n");
			Operations(unique1,AccT);
			unique1++;
		}
		else if(AccT=='Y'||AccT=='y') {
			String uniqueID = UUID.randomUUID().toString();
			System.out.println(uniqueID);
			s.add(new Saving(AccT,uniqueID,name));
			System.out.println("Account successfully Created\n"+"Your Account ID is: "+uniqueID+"\n Remember this ID to Access your account and keep it secure\n");
			Operations(unique2,AccT);
			unique2++;
		}
		
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------				LOGIN				--------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------
	public void Login() {
		int index=-1;
		Scanner i1=new Scanner(System.in);
		System.out.println("Select your Account Type");
		System.out.println("Press X for Checking Account");
		System.out.println("Press Y for Saving Account");
		char AccT=i1.next().charAt(0);
		while(true) {
		if (Character.toString(AccT).matches("^[x-yX-Y]*$")) {
	         //System.out.println("valid input");
	         break;
	    }else{
	         System.out.println("Enter Valid invalid");
	         AccT=i1.next().charAt(0);
	    }
		}
		
		Checking logged;
		Saving logged1;
		//Checking logged;
		Scanner i9=new Scanner(System.in);
		System.out.println("Enter your Account number");
		String u_res=i9.next();
		
		if(AccT=='X'||AccT=='x') {
			index=findAccCheck(u_res);
		}
		else if(AccT=='Y'||AccT=='y') {
			index=findAccSaving(u_res);
		}
		//else {
		try {
		Operations(index,AccT);
		}
		catch(IndexOutOfBoundsException Exception) {
			System.out.println("Enter an existing account");
		}
		//}
		
		
	}
	
	
	
	
	//----------------------------------------------------------------
	//----------------------TRANSFER TOO------------------
	//----------------------------------------------------------------
	
	public void Show(int n) {
		//aChecking b=(Checking)a.get(n);
		//b.Display();
	}
	
		//----------------------FOR CHECKING------------------------------------------
	
	public void TransferTo(Checking c1) {
		int check=2;		//1 for checjing and 2 for saving
		String num=" ";		//Account number
		int index=0;
		int i=0;
		int j=0;
		System.out.println("Enter the account number of the account you want to transfer money to");
		Scanner i1=new Scanner(System.in);
		num=i1.next();
		Checking logged;
		Saving logged1;
		for(i=0;i<a.size();i++) {
			
			logged=(Checking)a.get(i);
			
			if(num.equals(logged.getAccNum())) {
			
				index=i;
				check=1;
				break;
			}
			
			
			
		}
		for(j=0;j<s.size();j++) {
			logged1=(Saving)s.get(j);
			if(num.equals(logged1.getAccNum())) {
			
				index=j;
				check=0;
				break;
			}
		}
		//if(index==a.size()) {
			//sSystem.out.println("This account does not exits");
		//}
		//else if(index==s.size()) {
			//System.out.println("This account does not exits");
		//}
		//else {
			if(check==1) {
			logged=(Checking)a.get(index);
			System.out.println("Account "+logged.getAccNum()+" found");
			System.out.println("Enter the amount of money you want to deposit");
			int amt1=0;
			Scanner i10;
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			while(amt1<0) {
			//if(x>0) {
				//Scanner i1=new Scanner(System.in);
				System.out.println("Please Enter a Valid ammount");
				//x++;
			//}
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			}
			
			
			c1.transfer(amt1,logged);
			}
			else if(check==0) {
			logged1=(Saving)s.get(index);
			
			System.out.println("Account "+logged1.getAccNum()+" found");
			System.out.println("Enter the amount of money you want to deposit");
			int amt1=0;
			Scanner i10;
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			while(amt1<0) {
			//if(x>0) {
				//Scanner i1=new Scanner(System.in);
				System.out.println("Please Enter a Valid ammount");
				//x++;
			//}
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			}
			
			c1.transfer(amt1,logged1);
			}
			
		//}
	}
	
		//--------------------FOR SAVING------------------------------------------
	public void TransferTo(Saving s1) {
		int check=2;		//1 for checKing and 2 for saving
		String num=" ";		//Account number
		int index=0;
		int i=0;
		int j=0;
		System.out.println("Enter the account number of the account you want to transfer money to");
		Scanner i1=new Scanner(System.in);
		num=i1.next();
		Checking logged;
		Saving logged1;
		for(i=0;i<a.size();i++) {
			
			logged=(Checking)a.get(i);
			
			if(num.equals(logged.getAccNum())) {
			
				index=i;
				check=1;
				break;
			}
			
			
			
		}
		for(j=0;j<s.size();j++) {
			logged1=(Saving)s.get(j);
			if(num.equals(logged1.getAccNum())) {
			
				index=j;
				check=0;
				break;
			}
		}
		//if(index==a.size()) {
			//System.out.println("This account does not exits");
		//}
		//else if(index==s.size()) {
			//System.out.println("This account does not exits");
		//}
		//else {
			if(check==1) {
			logged=(Checking)a.get(index);
			
			System.out.println("Account "+logged.getAccNum()+" found");
			System.out.println("Enter the amount of money you want to deposit");
			int amt1=0;
			Scanner i10;
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			while(amt1<0) {
			//if(x>0) {
				//Scanner i1=new Scanner(System.in);
				System.out.println("Please Enter a Valid ammount");
				//x++;
			//}
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			}
			
			s1.transfer(amt1,logged);
			}
			else if(check==0) {
			logged1=(Saving)s.get(index);
			
			System.out.println("Account "+logged1.getAccNum()+" found");
			System.out.println("Enter the amount of money you want to deposit");
			int amt1=0;
			Scanner i10;
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			while(amt1<0) {
			//if(x>0) {
				//Scanner i1=new Scanner(System.in);
				System.out.println("Please Enter a Valid ammount");
				//x++;
			//}
			i10=new Scanner(System.in);
			amt1=i10.nextInt();
			}
			
			s1.transfer(amt1,logged1);
			}
			
		}
	//}
	
	//FIND Account Function
	
	public int findAcc(String to_find) {
		//---------------------------
		int check=2;		//1 for checKing and 2 for saving
		String num=to_find;		//Account number
		int index=-1;
		int i=0;
		int j=0;
		Checking logged = null;
		Saving logged1=null;
		//---------------------------
	//	try{
		for(i=0;i<a.size();i++) {
			
			logged=(Checking)a.get(i);
			
			if(num.equals(logged.getAccNum())) {
			
				index=i;
				check=1;
				i=a.size()+1;
				break;
			}
			
			
			
			
		}
		for(j=0;j<s.size();j++) {
			logged1=(Saving)s.get(j);
			if(num.equals(logged1.getAccNum())) {
				//System.out.println("Hello");
				index=j;
				check=0;
				j=s.size()+1;
				break;
			}
		}
		//if(j==0) {
			//System.out.println("This account does not exits");
			//return -1;
		//}
		//else if(index==0) {
			//System.out.println("This account does not exits");
		//	return -1;
		//}

		
		return index;
		}
		//catch(IndexOutOfBoundsException Exception){
			//System.out.println("Account does not exist");
			//return -1;
			
		//}
	
	public int findAccCheck(String to_find) {
		//---------------------------
		int check=2;		//1 for checKing and 2 for saving
		String num=to_find;		//Account number
		int index=-1;
		int i=0;
		int j=0;
		Checking logged = null;
		//Saving logged1=null;
		//---------------------------
	//	try{
		for(i=0;i<a.size();i++) {
			
			logged=(Checking)a.get(i);
			
			if(num.equals(logged.getAccNum())) {
			
				index=i;
				check=1;
				i=a.size()+1;
				break;
			}
			
			
			
			
		}
		
		//if(j==0) {
			//System.out.println("This account does not exits");
			//return -1;
		//}
		//else if(index==0) {
			//System.out.println("This account does not exits");
		//	return -1;
		//}

		
		return index;
		}
	
	
	public int findAccSaving(String to_find) {
		//---------------------------
		int check=2;		//1 for checKing and 2 for saving
		String num=to_find;		//Account number
		int index=-1;
		int i=0;
		int j=0;
		Checking logged = null;
		Saving logged1=null;
		//---------------------------
	//	try{

		for(j=0;j<s.size();j++) {
			logged1=(Saving)s.get(j);
			if(num.equals(logged1.getAccNum())) {
				//System.out.println("Hello");
				index=j;
				check=0;
				j=s.size()+1;
			}
		}
		//if(j==0) {
			//System.out.println("This account does not exits");
			//return -1;
		//}
		//else if(index==0) {
			//System.out.println("This account does not exits");
		//	return -1;
		//}

		
		return index;
		}
	
	
	
	
	
	
	
		
	//public boolean containsAcc(String num) {
		
	//}
	//}
	
	//-----------------------------Admin-------------------------------------------------
	public void admin(String pass) {
		if(pass.equals(p_word)) {
			adminMenu();
		}
	}
	
	//----------------------------------------------------------------
	public void deleteAcc() {
		int ind=-1;
		Scanner i1=new Scanner(System.in);
		System.out.println("Select your Account Type");
		System.out.println("Press X for Checking Account");
		System.out.println("Press Y for Saving Account");
		char AccT=i1.next().charAt(0);
		Checking acc1=null;
		Saving acc2=null;
		while(true) {
		if (Character.toString(AccT).matches("^[x-yX-Y]*$")) {
	         //System.out.println("valid input");
	         break;
	    }else{
	         System.out.println("Enter Valid invalid");
	         AccT=i1.next().charAt(0);
	    }
		}
		//-----------------
		System.out.println("Enter the account number of the account you want to delete");
		Scanner i5=new Scanner(System.in);
		String num=i5.next();
		//-----------------
		
		if(AccT=='X'||AccT=='x') {
			ind=findAccCheck(num);
			try {
			acc1=a.get(ind);
			System.out.println("Account with ID "+acc1.getAccNum()+ "owned by "+acc1.getName()+" is removed");
			a.remove(ind);
			unique1--;
			}
			catch(IndexOutOfBoundsException exception) {
				System.out.println("Account does not exits");	
			}
		}
		else if(AccT=='Y'||AccT=='y') {
			try {
				ind=findAccSaving(num);
				acc2=s.get(ind);
				System.out.println("Account with ID "+acc2.getAccNum()+ "owned by "+acc2.getName()+" is removed");
				s.remove(ind);
				unique2--;
			}
			catch(IndexOutOfBoundsException exception) {
				System.out.println("Account does not exits");	
			}
		}
		
		
	}
	
	//----------------------------------------------------------------
	
	public void ShowAll() {
		System.out.println("Showing Checking accounts");
		System.out.println("Account Numbers				|   Owner Names		|	Date Created	");
		Checking acc1=null;
		Saving acc2=null;
		for(int i=0;i<a.size();i++) {
			acc1=a.get(i);
			
			System.out.println(acc1.getAccNum()+"	|	"+acc1.getName()+"	 |	"+acc1.getDate());
			
		}
		
		System.out.println("Showing Saving accounts");
		System.out.println("Account Numbers				|   Owner Names		|	Date Created	");
		
		for(int i=0;i<s.size();i++) {
			acc2=s.get(i);
			
			System.out.println(acc2.getAccNum()+"	|	"+acc2.getName()+"	|	"+acc2.getDate());
			
		}
		
		
	}
	
	
	//----------------------------------------------------------------
	
	public void adminMenu() {
		char opt = 'z';
	//	while(opt!='f'||opt!='F') {
		Scanner i1=new Scanner(System.in);
		System.out.println("Select the Options below to proceed");
		System.out.println("Press (A) to remove an account");
		System.out.println("Press (B) to Log In");
		opt=i1.next().charAt(0);
		
		while(true) {
			if (Character.toString(opt).matches("^[a-fA-F]*$")) {
		         //System.out.println("valid input");
		         break;
		    }else{
		         System.out.println("Enter Valid input");
		         opt=i1.next().charAt(0);
		    }
		}
		
		if(opt=='a'||opt=='A') {
			deleteAcc();
		}
		
		if(opt=='b'||opt=='B') {
			ShowAll();
		}
		
		if(opt=='f'||opt=='F') {
		//	break;
		}
		
		
	//}

	}
	
	
	//----------------------------------------------------------------
	//----------------------Int Main----------------------------------
	//----------------------------------------------------------------
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//------------------------------------------------------------

		UI interface1=new UI();
		
		int id=0;//unique identifier for new comers
		char option='z';//To make menu
		//------------------------------------------------------------
		System.out.println("Welcome to bank account management system");
		while(option!='e'||option!='E') {
		Scanner i1=new Scanner(System.in);
		System.out.println("Select the Options below to proceed");
		System.out.println("Press (A) to Register an Account");
		System.out.println("Press (B) to Log In");
		System.out.println("Press (C) to access Access Admin");
		option=i1.next().charAt(0);
		
		while(true) {
			if (Character.toString(option).matches("^[a-cA-C]*$")) {
		         //System.out.println("valid input");
		         break;
		    }else{
		         System.out.println("Enter Valid input");
		         option=i1.next().charAt(0);
		    }
			}
		
		if(option=='a'||option=='A')
		interface1.SignUp();
		
		
		id++;
		if(option=='b'||option=='B') {
			interface1.Login();
		}
		
		if(option=='c'||option=='C') {
			
			System.out.println("Enter the password");
			Scanner i5=new Scanner(System.in);
			String num=i5.next();
			
			interface1.adminMenu();
		}
		
		// TODO Auto-generated method stub
		}
	}

}
