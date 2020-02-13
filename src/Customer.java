
import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person {

	private int custId;
	private int creditScore;
	private boolean resident;
	private ArrayList<Account> products;
	
//

//	@Override
//	public boolean getPromotions(Account accnt, Promotion prom) {
//		if(accnt.getAcctBalance() >= 5000) {
//			accnt.setPromo(prom);
//			return true;			
//		}
//		else {
//			return false;
//		}
//	}
	

	public int getCustId() {
		return custId;
	}

	public ArrayList<Account> getProducts() {
		return products;
	}

	public void setProducts(Account product) {
		this.products.add(product);
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public boolean isResident() {
		return resident;
	}

	public void setResident(boolean resident) {
		this.resident = resident;
	}

	
	public Customer(String fName, String lName, String address, Date dOB, String bank, String phoneNum,
			        int custId, int creditScore, boolean resident) {
		super(fName, lName, address, dOB, bank, phoneNum);
		this.custId = custId;
		this.creditScore = creditScore;
		this.resident = resident;
		this.products = new ArrayList<Account>();
		
	}
	
	public boolean hasCheckingAccnt() {
		
		boolean checkingExist = false;
		
		for(int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof CheckingAccount) {
				checkingExist = true;
			}
		}
		return checkingExist;
	}

}
