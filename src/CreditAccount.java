import java.util.Date;

public class CreditAccount extends Account {

	private double transSumLimit;
	private double creditLimit;
	private double withdrawFee;
	private double minimumPayment;
	private Date duePaymentDay;
	private double interestRate;
	
	public CreditAccount(Customer cust, String acctNum, String curr, Date openDate, boolean active, double acctBalance, double creditLimit,
			double annualFee, double transSumLimit, double withdrawFee, double minimumPayment,	double interestRate) {
		super(cust, acctNum, curr, openDate, active, acctBalance, annualFee);
		this.transSumLimit = transSumLimit;
		this.setCreditLimit(creditLimit);
		this.withdrawFee = withdrawFee;
		this.minimumPayment = minimumPayment;
		this.interestRate = interestRate;
	}

	public double getTransSumLimit() {
		return transSumLimit;
	}

	public void setTransSumLimit(double transSumLimit) {
		this.transSumLimit = transSumLimit;
	}

	public double getWithdrawFee() {
		return withdrawFee;
	}

	public void setWithdrawFee(double withdrawFee) {
		this.withdrawFee = withdrawFee;
	}

	public double getMinimumPayment() {
		return minimumPayment;
	}

	public void setMinimumPayment(double minimumPayment) {
		this.minimumPayment = minimumPayment;
	}

	public Date getDuePaymentDay() {
		return duePaymentDay;
	}

	public void setDuePaymentDay(Date duePaymentDay) {
		this.duePaymentDay = duePaymentDay;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}	
	
	
	
	
}
