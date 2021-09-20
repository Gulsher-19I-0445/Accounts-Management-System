import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Checking extends Accounts {
	int free_count;
	int fee;
	int cTr;

	public Checking() {
		free_count=2;
		fee=10;
		// TODO Auto-generated constructor stub
	}

	public Checking(char A, String num,String name) {
		super(A, num,name);
		free_count=2;
		fee=10;
		cTr=0;
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------
	public Checking(char A, String num,String name,int b,String date) {
		super(A, num,name,b,date);
		free_count=2;
		fee=10;
		// TODO Auto-generated constructor stub
	}
	
	//-----------------------------------------------------------------
	//-------------------Withdraw Checking-----------------------------
	//-----------------------------------------------------------------
	
	public void withdraw(int amt) {
		int temp;
		temp=getBalance()-amt;
		if(temp<-5000) {
			System.out.println("You have reached withdrawal limit. Please clear remaining charges first");
		}
		else{
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
	
	public void makeDeposit(int amt) {
		//int amt=-1;
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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
