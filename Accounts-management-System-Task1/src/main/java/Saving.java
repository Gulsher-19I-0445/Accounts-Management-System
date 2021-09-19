import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Saving extends Accounts {
	private int cTr;
	private double zakat;
	public Saving() {
		// TODO Auto-generated constructor stub
	}

	public Saving(char A, String num,String name) {
		super(A, num,name);
		// TODO Auto-generated constructor stub
	}
	
	public Saving(char A, String num,String name,int b,String date) {
		super(A, num,name,b,date);
		cTr=0;
		// TODO Auto-generated constructor stub
	}
	
	//--------------------------------------------------------
	//-----------------WithDraw-------------------------------
	
	public void withdraw(int amt) {
		int temp=0;
		temp=getBalance()-amt;
		if(temp<0) {
			System.out.println("You are exceeding your current balance limits for you Saving Account. WithDrawal failed. Current Balance: Rs"+getBalance());
		}
		else {
			setBalance(getBalance()-amt);
		
		
		int temp2=0;
		temp2=amt*(-1);
		setT(cTr,temp2);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		setd(cTr,dtf.format(now));
		cTr++;
		}
	}
	public void ZakatCalc() {
		if(getBalance()>20000) {
			zakat=(getBalance()*2.5)/100;
			System.out.println("Rs "+zakat+" will be deducted from your account");
		}
		else{
			System.out.println("Zakat is not applicable on your Account");
		}
	}
	
	public void makeDeposit() {
		int amt=-1;
		int x=0;
		Scanner i1;
		System.out.println("Enter the amount to Deposit");
		i1=new Scanner(System.in);
		amt=i1.nextInt();
		while(amt<0) {
		//if(x>0) {
			//Scanner i1=new Scanner(System.in);
			System.out.println("Please Enter a Valid ammount");
			//x++;
		//}
		i1=new Scanner(System.in);
		amt=i1.nextInt();
		}
		setBalance(getBalance()+amt);
		System.out.print("Rs"+amt+" added to your balance");
		//int temp1=0;
		setT(getCount(),amt);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		setd(getCount(),dtf.format(now));
		setCount(getCount()+1);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
