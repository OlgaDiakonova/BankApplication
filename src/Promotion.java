import java.util.Date;

public class Promotion implements Promotionable {
	
	
	//this promotion dismisses the withdraw fee for checking account and rise deposit limit to 10000 if account balance is 3500CAD
	@Override
	public boolean getPromotionforCheckingAccnt(Customer c, String acctNum) {
		boolean success = false;
		
		for (int i = 0; i < c.getProducts().size(); i++) {
			if (c.getProducts().get(i) instanceof CheckingAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				CheckingAccount checkAccnt = (CheckingAccount) c.getProducts().get(i);
				if(checkAccnt.getAcctBalance() >= 3500.00) {
					checkAccnt.setWithdrawFee(0);
					checkAccnt.setDepositLimit(10000.00);
					System.out.println("Promotion has been successfully applied!");
					success = true;
				}else {
					System.out.println("The account balance is not enough for this promotion");
				}
			}else if(!(c.getProducts().get(i) instanceof CheckingAccount) && c.getProducts().get(i).getAcctNum() == acctNum) {
				System.out.println("Wrong account type!This promotion is for Checking Accounts ONLY!");
			}
		}
		
		return success;
	}

	//this promotion rises customer credit limit on 1000CAD if he/she spent 3000CAD first month
	@Override
	public boolean getPromotionforCreditAccnt(Customer c, String acctNum, double monthSpentSum) {
		boolean success = false;
		for (int i = 0; i < c.getProducts().size(); i++) {
			if (c.getProducts().get(i) instanceof CreditAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				CreditAccount creditAccnt = (CreditAccount) c.getProducts().get(i);
				if(monthSpentSum >= 3000) {
					creditAccnt.setCreditLimit(creditAccnt.getCreditLimit() + 1000.00);
					System.out.println("Promotion has been successfully applied!Credit limit was raised on 1000 CAD. New credit limit is " + creditAccnt.getCreditLimit());
					success = true;
				}else {
					System.out.println("The monthly spent amount is not enough for this promotion");
				}
			}else if(!(c.getProducts().get(i) instanceof CreditAccount) && c.getProducts().get(i).getAcctNum() == acctNum){
				System.out.println("Wrong account type!This promotion is for Credit Accounts ONLY!");
			}
		}

		return success;
	}

	//this promotion gives interest rate to 1.95% every new customer if he/she opens account with min 3000 CAD 
	@Override
	public boolean getPromotionforSavingAccnt(Customer c, String acctNum) {
		boolean success = false;
		for (int i = 0; i < c.getProducts().size(); i++) {
			if (c.getProducts().get(i) instanceof SavingAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				SavingAccount savigAccnt = (SavingAccount) c.getProducts().get(i);	
				if(savigAccnt.getOpenDate().equals(new Date()) && savigAccnt.getAcctBalance() >= 3000.00 ) {
					savigAccnt.setInterestRate(0.0195);
					System.out.println("Promotion has been successfully applied!Your interest rate is 1.95%.");
					success = true;
				}else {
					System.out.println("The deposit amount is not enough for this promotion or customer is not new");
				}
			}else if(!(c.getProducts().get(i) instanceof SavingAccount) && c.getProducts().get(i).getAcctNum() == acctNum){
				System.out.println("Wrong account type!This promotion is for Saving Accounts ONLY!");
			}
		}		
		return success;
		
	}

}
