import java.util.Date;

public abstract class Account {
	Customer cust;
	String acctNum;	
	Date openDate;
	Date closeDate;
	boolean active;
	double acctBalance;
	double annualFee;
	String currency;
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}

	public Account(Customer cust, String acctNum, String curr, Date openDate, boolean active, double acctBalance,
			double annualFee) {

		this.cust = cust;
		this.acctNum = acctNum;
		this.openDate = openDate;		
		this.active = active;
		this.acctBalance = acctBalance;
		this.annualFee = annualFee;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(long acctBalance) {
		this.acctBalance = acctBalance;
	}

	public double getAnnualFee() {
		return annualFee;
	}

	public void setAnnualFee(double annualFee) {
		this.annualFee = annualFee;
	}
	
	
	
		
}
