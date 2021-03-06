import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 */

/**
 * @author gulsh
 *
 */
public abstract class Accounts {
	private String Acc_no;
	private char account_typ;
	private int account_balance;
	private String date_created;
	private String name;
	private int transactions[];
	private String tdate[];
	private int countT;
	private String msg;
	int db;

	/**
	 * 
	 */
	public Accounts() {
		Acc_no="0";
		account_balance=100;
		date_created="12";
		// TODO Auto-generated constructor stub
	}
	public Accounts(char A,String num,String name1,int dbn) {
		Acc_no=num;
		account_balance=100;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		name=name1;
		account_typ=A;
		System.out.println("Account  created on date: "+dtf.format(now));
		date_created=dtf.format(now); 
		transactions=new int[10];
		tdate=new String[10];
		for(int i=0;i<10;i++) {
			transactions[i]=0;
		}
		for(int i=0;i<10;i++) {
			tdate[i]="";
		}
		countT=0;
		db=dbn;
		/*try {
			write_to();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// TODO Auto-generated constructor stub
	}
	//--------------------------------------------------------------------
	/*public Accounts(char A,String num,String name1,int balance,String date) {
		Acc_no=num;
		account_balance=balance;
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		//LocalDateTime now = LocalDateTime.now();  
		name=name1;
		account_typ=A;
		//System.out.println("Account created on "+dtf.format(now));
		date_created=date;
		// TODO Auto-generated constructor stub
	}*/
	
	//Abstract
	
	public abstract void makeDeposit(int amt);
	public abstract void withdraw(int amt) throws InsufficientBalanceException;
	
	//
	
	
	
	//
	
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
//-----------------------------------------------	
	public void setAccNum(String n) {
		Acc_no=n;
	}
	
	public String getAccNum() {
		return Acc_no;
	}
	//------------------------------------------
	public void setBalance(int n) {
		account_balance=n;
	}
	
	public int getBalance() {
		return account_balance;
	}
	//---------------------------------------------------------------------------
	public int getT(int k){
		
		return transactions[k];
	}
	public void setT(int k,int t){	//k is index and t is the amount
		if(k>10) {
			k=k%10;
		}
		transactions[k]=t;
	}
	//--------------------------------------------------------------------------
	public String getd(int k){
		
		return tdate[k];
	}
	public void setd(int k,String t){	//k is index and t is the amount
		if(k>10) {
			k=k%10;
		}
		tdate[k]=t;
	}
	//--------------------------------------------------------------------------
	public String getMsg() {
		return msg;
	}
	public void setMsg(String m) {
		msg=m;
	}
	public String getDate() {
		return date_created;
	}
	
	public void setCount(int m) {
		countT=m;
	}
	public int getCount() {
		return countT;
	}
	
	
	
	
	//--------------------------------------------------------------------------
	//----------------------------CHECK----------------------------------
	//--------------------------------------------------------------------------
	public int checkBalance() {
		//System.out.println("Your assigned Account Number and Account type is: ");
		System.out.println("Account ID: "+Acc_no);
		System.out.println("Your account balance is: ");
		System.out.println(account_balance);
		return getBalance();
	}
	//--------------------------------------------------------------------------
	//--------------------------Make Deposits-----------------------------------
	//--------------------------------------------------------------------------
	
	//public abstract void makeDeposit(int amt);
	//--------------------------------------------------------------------------
	//--------------------------------WithDraw----------------------------------
	//--------------------------------------------------------------------------
	/*public void write_to() 
		throws IOException {
		/*BufferedWriter br = new BufferedWriter(new FileWriter("text1.csv"));
		StringBuilder sb = new StringBuilder();
		  
		
		sb.append(Acc_no + "\t");    
		sb.append(account_balance + "\t");
		sb.append("\n");    
		 
		
		  
		br.write(sb.toString());
		br.close();*
	
		String temp="";
		//Date dt1;
		//Date dt1=date_created;
		FileWriter csvWriter = new FileWriter("new.csv",true);
				
		csvWriter.append(Acc_no);
		csvWriter.append(",");
		csvWriter.append(name);
		csvWriter.append(",");
		String s=String.valueOf(account_balance);
		csvWriter.append(s);
		csvWriter.append(",");
		csvWriter.append(date_created);
		csvWriter.append(",");
		if(account_typ=='X'||account_typ=='x') {
			temp="Checking";
		}
		else if(account_typ=='Y'||account_typ=='y') {
			temp="Saving";
		}
		csvWriter.append(temp);
		csvWriter.append(",");
		csvWriter.append("\n");
		
		

		csvWriter.flush();
		csvWriter.close();	  
		  
		
	}*/
	public void PrintStatemet() {
		String temp=" ";
		System.out.println("Generating statement for"+Acc_no);
		System.out.println("Owner Name: "+name);
		System.out.println("Account Number: "+Acc_no);
		System.out.println("Current Balance: Rs"+account_balance);
		if(account_typ=='X'||account_typ=='x') {
			temp="Checking";
		}
		else if(account_typ=='Y'||account_typ=='y') {
			temp="Saving";
		}
		System.out.println("Account Type is "+temp);
		System.out.println("Account was created on "+date_created);
		System.out.println("Generating details of past 9 transactions made....");
		
		for(int i=0;i<10;i++) {
			int x=0;
			String y=" ";
			x=getT(i);
			y=getd(i);
			
			//if(x!=0) {
				if(x>0) {
					System.out.println("Rs"+x+" were deposited in you Account on "+y);
				}
				else if(x<0) {
					System.out.println("Rs"+x+" were withdrawn from you Account"+y);
				}
			//}
		}
		
		System.out.println(msg);
		
	}
	
	public void transfer(int am,Checking k) {
		//System.out.println("Account "+k.getAccNum()+" found");
		/*System.out.println("Enter the amount of money you want to deposit");
		Scanner i1=new Scanner(System.in);
		//int am=0;
		
		/////////////////////////////////////////////////////////
		try
		{
			am=i1.nextInt();
		}
		catch(InputMismatchException exception)
		{
			System.out.println("Not a valid input. Please enter the amount in numbers");
		}*/
		////////////////////////////////////////////////////////
		try {
		if(am<0) {
			throw new IllegalArgumentException();
		}
		account_balance=account_balance-am;
		int newB=k.getBalance()+am;
		k.setBalance(newB);
		
		if(k.db==1) {
			OracleCon myDb =new OracleCon();
			try {
				myDb.UpdateMyDbBalance(k.getBalance(),k.getAccNum());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(k.db==2) {
			MySqlConn mySDb=new MySqlConn();
			try {
				mySDb.UpdateMyDbBalance(k.getBalance(),k.getAccNum());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		System.out.println("An amount of Rs "+am+" was deposited into account "+k.getAccNum()+" owned by "+k.getName()+" on "+dtf.format(now));
		k.setMsg("An amount of Rs "+am+" was deposited into your account by account number "+Acc_no+" owned by "+name+" on "+dtf.format(now));
		}
		catch(IllegalArgumentException e){
			
		}
	
	}
	
	
	public void transfer(int am,Saving k) {
		/*System.out.println("Account "+k.getAccNum()+" found");
		System.out.println("Enter the amount of money you want to deposit");
		Scanner i1=new Scanner(System.in);
		int am=0;
		
		
		try
		{
			am=i1.nextInt();
		}
		catch(InputMismatchException exception)
		{
			System.out.println("Not a valid input. Please enter the amount in numbers");
		}*/
		try {
			if(am<0) {
				throw new IllegalArgumentException();
			}
		
		account_balance=account_balance-am;
		int newB=k.getBalance()+am;
		k.setBalance(newB);
		
		if(k.db==1) {
			OracleCon myDb =new OracleCon();
			try {
				myDb.UpdateMyDbBalance(k.getBalance(),k.getAccNum());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(k.db==2) {
			MySqlConn mySDb=new MySqlConn();
			try {
				mySDb.UpdateMyDbBalance(k.getBalance(),k.getAccNum());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		System.out.println("An amount of Rs "+am+" was deposited into account "+k.getAccNum()+" owned by "+k.getName()+" on "+dtf.format(now));
		k.setMsg("An amount of Rs "+am+" was deposited into your account by account number "+Acc_no+" owned by "+name+" on "+dtf.format(now));
		}
		catch(IllegalArgumentException e){
			
		}
	//logged=(Checking)a.get(index);	
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

