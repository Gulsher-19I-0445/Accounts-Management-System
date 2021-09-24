import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	/*public Saving(char A, String num,String name,int b,String date) {
		super(A, num,name,b,date);
		cTr=0;
		// TODO Auto-generated constructor stub
	}*/
	
	//--------------------------------------------------------
	//-----------------WithDraw-------------------------------
	
	public double getZakat() {
		return zakat;
	}

	public void setZakat(double zakat) {
		this.zakat = zakat;
	}

	public void withdraw(int amt) {
		try {
			if(amt<0) {
				throw new IllegalArgumentException();
			}
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
		catch(IllegalArgumentException e){
			
		}
	}
	public double ZakatCalc() {
		if(getBalance()>20000) {
			zakat=(getBalance()*2.5)/100;
			System.out.println("Rs "+zakat+" will be deducted from your account");
			return getZakat();
		}
		else{
			System.out.println("Zakat is not applicable on your Account");
			setZakat(0);
			return 0;
		}
		
	}
	
	public void makeDeposit(int amt) {
		//int amt=-1;
		if(amt>=0) {
		int x=0;
		setBalance(getBalance()+amt);
		System.out.print("Rs"+amt+" added to your balance");
		//int temp1=0;
		setT(getCount(),amt);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		setd(getCount(),dtf.format(now));
		setCount(getCount()+1);
		
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
