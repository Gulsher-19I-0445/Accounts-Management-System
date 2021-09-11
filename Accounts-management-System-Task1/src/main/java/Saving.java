
public class Saving extends Accounts {
	
	public Saving() {
		// TODO Auto-generated constructor stub
	}

	public Saving(int A, String num) {
		super(A, num);
		// TODO Auto-generated constructor stub
	}
	//--------------------------------------------------------
	//-----------------WithDraw-------------------------------
	
	public void withdraw(int amt) {
		int temp=0;
		temp=account_balance-amt;
		if(temp<0) {
			System.out.println("You are exceeding your current balance limits for you Saving Account. WithDrawal failed. Current Balance: Rs"+account_balance);
		}
		else {
			account_balance=account_balance-amt;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
