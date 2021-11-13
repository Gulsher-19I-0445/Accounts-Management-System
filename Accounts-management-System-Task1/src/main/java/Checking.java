import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checking extends Accounts {
	private int free_count;
	private int fee;
	private int cTr;

	public Checking() {
		free_count=2;
		fee=10;
		// TODO Auto-generated constructor stub
	}

	public Checking(char A, String num,String name,int dbn) {
		super(A, num,name,dbn);
		setFree_count(2);
		setFee(10);
		setcTr(0);
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------
	/*public Checking(char A, String num,String name,int b,String date) {
		super(A, num,name,b,date);
		free_count=2;
		fee=10;
		// TODO Auto-generated constructor stub
	}*/
	
	
	
	
	
	
	public int getFree_count() {
		return free_count;
	}

	public void setFree_count(int free_count) {
		this.free_count = free_count;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getcTr() {
		return cTr;
	}

	public void setcTr(int cTr) {
		this.cTr = cTr;
	}
	

	
	/*public void serializeAddressJDK7() {

		try (ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("c:\\temp\\address2.ser"))) {

			oos.writeObject(address);
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}*/
	
	
	
	

	
	//-----------------------------------------------------------------
		//-------------------Withdraw Checking-----------------------------
		//-----------------------------------------------------------------
	
	public void withdraw(int amt) {
		try {
			if(amt<0) {
				throw new IllegalArgumentException();
			}
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
		catch(IllegalArgumentException e){
			
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
			statement.setString(4, "Checking");
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
	
	public void UpdateMyDbBalance(int balance,String MyID) throws SQLException, ClassNotFoundException {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		String sql="UPDATE accounts SET Balance =? WHERE Acc_id=?";
		PreparedStatement statement= con.prepareStatement(sql);
		statement.setString(2, MyID);
		statement.setInt(1, balance);
		statement.executeUpdate();
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
        return new StringBuffer("Name: ").append(this.getName())
                .append("| Account Number : ").append(this.getAccNum()).append("| Current Balance : ").append(this.getBalance()).append("| Account Type: Checking").append("| Account Created on : ").append(this.getDate()).toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
