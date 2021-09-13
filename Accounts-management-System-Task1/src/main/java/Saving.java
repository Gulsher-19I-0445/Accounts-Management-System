
public class Saving extends Accounts {
	
	public Saving() {
		// TODO Auto-generated constructor stub
	}

	public Saving(char A, String num,String name) {
		super(A, num,name);
		// TODO Auto-generated constructor stub
	}
	
	public Saving(char A, String num,String name,int b,String date) {
		super(A, num,name,b,date);
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
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
