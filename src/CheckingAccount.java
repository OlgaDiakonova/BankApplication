import java.util.Date;

public class CheckingAccount extends Account {

	private double depositLimit;
	private double etransferFee;
	private double overdraft;
	private double overdrFee;
	private int transactionQnty;
	private double withdrawFee;
	
	
	public CheckingAccount(Customer cust, String acctNum, String curr,  Date openDate, boolean active, double acctBalance, double annualFee,
			               double depositLimit, double etransferFee, double overdraft, double overdrFee,
			               int transactionQnty, double withdrawFee) {
		super(cust, acctNum, curr, openDate, active, acctBalance, annualFee);
		this.depositLimit = depositLimit;
		this.etransferFee = etransferFee;
		this.overdraft = overdraft;
		this.overdrFee = overdrFee;
		this.transactionQnty = transactionQnty;
		this.withdrawFee = withdrawFee;
	}


	public double getDepositLimit() {
		return depositLimit;
	}


	public void setDepositLimit(double depositLimit) {
		this.depositLimit = depositLimit;
	}


	public double getEtransferFee() {
		return etransferFee;
	}


	public void setEtransferFee(double etransferFee) {
		this.etransferFee = etransferFee;
	}


	public double getOverdraft() {
		return overdraft;
	}


	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}


	public double getOverdrFee() {
		return overdrFee;
	}


	public void setOverdrFee(double overdrFee) {
		this.overdrFee = overdrFee;
	}


	public int getTransactionQnty() {
		return transactionQnty;
	}


	public void setTransactionQnty(int transactionQnty) {
		this.transactionQnty = transactionQnty;
	}


	public double getWithdrawFee() {
		return withdrawFee;
	}


	public void setWithdrawFee(double withdrawFee) {
		this.withdrawFee = withdrawFee;
	}
	
}
