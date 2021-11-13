import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Saving extends Accounts {
	private int cTr;
	private double zakat;
	public Saving() {
		// TODO Auto-generated constructor stub
	}

	public Saving(char A, String num,String name,int dbn) {
		super(A, num,name,dbn);
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

	public void withdraw(int amt) throws InsufficientBalanceException {
		try {
			if(amt<0) {
				throw new IllegalArgumentException();
			}
		int temp=0;
		temp=getBalance()-amt;
		if(temp<0) {
			throw new InsufficientBalanceException("You are exceeding your current balance limits for you Saving Account. WithDrawal failed. Current Balance: Rs"+getBalance());
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
	
	
	public void ToDataBase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			
			String sql="INSERT INTO accounts(Acc_id,Name,Balance,Acc_typ,dt_created) VALUES (?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1,this.getAccNum());
			statement.setString(2,this.getName());
			statement.setInt(3, this.getBalance());
			statement.setString(4, "Saving");
			statement.setString(5, this.getDate());
			statement.executeUpdate();
			//int i=statement.executeUpdate();
			//con.commit();
			//con.close();
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	}
	
	@Override
	public String toString() {
        return new StringBuffer(" Name: ").append(this.getName())
                .append(" Account Number : ").append(this.getAccNum()).append(" Current Balance : ").append(this.getBalance()).append("Account Type: Saving").append(" Account Created on : ").append(this.getDate()).toString();
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//@Override


}
