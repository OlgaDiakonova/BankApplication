
import java.util.Date;

public class SavingAccount extends Account {

	private double depositSumLimit;
	private double withdrawLimit;
	private double withdrawFee;		
	private double interestRate;	
	
	public SavingAccount(Customer cust, String acctNum, String curr, Date openDate, boolean active, double acctBalance,
			double annualFee, double depositSumLimit, double withdrawLimit, double withdrawFee, double interestRate) {
		super(cust, acctNum, curr, openDate, active, acctBalance, annualFee);
		this.depositSumLimit = depositSumLimit;
		this.withdrawFee = withdrawFee;
		this.interestRate = interestRate;
		this.withdrawLimit = withdrawLimit;
	}

	public double getDepositSumLimit() {
		return depositSumLimit;
	}

	public void setDepositSumLimit(double depositSumLimit) {
		this.depositSumLimit = depositSumLimit;
	}

	public double getWithdrawFee() {
		return withdrawFee;
	}

	public void setWithdrawFee(double withdrawFee) {
		this.withdrawFee = withdrawFee;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}	
	
	
	
}
