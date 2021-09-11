
public class Checking extends Accounts {
	int free_count;
	int fee;

	public Checking() {
		free_count=2;
		fee=10;
		// TODO Auto-generated constructor stub
	}

	public Checking(int A, String num) {
		super(A, num);
		free_count=2;
		fee=10;
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------
	//-------------------Withdraw Checking-----------------------------
	//-----------------------------------------------------------------
	
	public void withdraw(int amt) {
		int temp;
		temp=account_balance-amt;
		if(temp<-5000) {
			System.out.println("You have reached withdrawal limit. Please clear remaining charges first");
		}
		else{
			account_balance=account_balance-amt;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
