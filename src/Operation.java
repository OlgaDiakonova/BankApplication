import java.util.Date;

public class Operation implements Operational{

	@Override
	public void openCreditLine(Customer cust) {
		if (!cust.hasCheckingAccnt()) {
			System.out.println("Customer doesn't have a checking account in the bank. Create a checking account first!");
		}else {
			if (cust.getCreditScore() < 600) {
				System.out.println("Credit score is too low for credit line!");
			}else {
				String acctNum = "45600000" + (int)(Math.random()*1000);				

				CreditAccount accnt = new CreditAccount(cust, acctNum, "cad", new Date(), true, 0.00, 1000.00, 50.00, 500.00, 0.01, 10.00, 19.99);
				
				cust.setProducts(accnt);
				
				System.out.println("Credit account has been successfully created!");
			}
		}
		
	}

	@Override
	public void openCheckingAccnt(Customer cust) {
		String acctNum = "12300000" + (int)(Math.random()*1000);
		
		CheckingAccount accnt = new CheckingAccount(cust, acctNum, "cad", new Date(), true, 0.00, 35.00, 5000.00,
				    0.01, 100.00, 0.05, 12, 0.01);
		
		cust.setProducts(accnt);
		
		System.out.println("Checking account has been successfully created");
		
	}

	@Override
	public void openSavingAccnt(Customer cust) {
        String acctNum = "78900000" + (int)(Math.random()*1000);        
		  
  
		SavingAccount accnt = new SavingAccount(cust, acctNum, "cad", new Date(), true, 0.00, 35.00, 7000.00, 25000.00, 0.01, 0.0175);
		
		cust.setProducts(accnt);
		
		System.out.println("Saving account has been successfully created");
		
	}

	@Override
	public boolean withdrawFromAccnt(Customer c, String acctNum, double sum) {
		boolean success = false;

		for (int i = 0; i < c.getProducts().size(); i++) {
			if (c.getProducts().get(i) instanceof CheckingAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				CheckingAccount checkAccnt = (CheckingAccount) c.getProducts().get(i);
				double withdrawSum = sum + sum*checkAccnt.getWithdrawFee();
				double newBalance = checkAccnt.getAcctBalance() - withdrawSum;
				if (newBalance < 0 && checkAccnt.getOverdraft() > 0) {
					double overdraftSum = (newBalance) * checkAccnt.getOverdrFee();
					if ((-(newBalance + overdraftSum)) < checkAccnt.getOverdraft()) {						
						checkAccnt.setAcctBalance(newBalance + overdraftSum);						
						System.out.printf("You withdraw money successfully. New balance is %.2f with overdraft of %.2f \n",
								checkAccnt.getAcctBalance(),checkAccnt.getOverdraft());
						success = true;
					} else {
						System.out.println("Not enough money!");
					}
				} else {
					checkAccnt.setAcctBalance(newBalance);
					System.out.println("You withdraw money successfully. New balance is " + newBalance);
					success = true;
				}

			} else if (c.getProducts().get(i) instanceof CreditAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				CreditAccount creditAccnt = (CreditAccount) c.getProducts().get(i);
				double withdrawSum = sum + sum*creditAccnt.getWithdrawFee();
				double availableSum = creditAccnt.getCreditLimit() - creditAccnt.getAcctBalance() - withdrawSum; //sum that left after withdrawal
				if (availableSum < 0) {

					System.out.println("Not enough money!");

				} else {
					double newBalance = withdrawSum + creditAccnt.getAcctBalance();
					creditAccnt.setAcctBalance(newBalance);
					System.out.println("You withdraw money successfully. New balance is " + newBalance + ". Available credit limit is " + availableSum);
					success = true;
				}
			} else if (c.getProducts().get(i) instanceof SavingAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				SavingAccount savigAccnt = (SavingAccount) c.getProducts().get(i);				
				double withdrawSum = sum + sum*savigAccnt.getWithdrawFee();
				double newBalance = savigAccnt.acctBalance - withdrawSum;
				if (newBalance < 0 || withdrawSum > savigAccnt.getWithdrawLimit()) {

					System.out.printf("Not enough money!Your balance is %.2f and your withdraw limit is %.2f",savigAccnt.getAcctBalance(), savigAccnt.getWithdrawLimit());

				} else {
					savigAccnt.setAcctBalance(newBalance);
					System.out.println("You withdraw money successfully. New balance is " + newBalance);
					success = true;
				}				
			}

		}

		return success;
	}

	@Override
	public boolean depositToAccnt(Customer c, String acctNum, double sum) {
		
		boolean success = false;
		
		for (int i = 0; i < c.getProducts().size(); i++) {
			if (c.getProducts().get(i) instanceof CheckingAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				CheckingAccount checkAccnt = (CheckingAccount) c.getProducts().get(i);
				
				if (sum <= checkAccnt.getDepositLimit()) {
					
						checkAccnt.setAcctBalance(checkAccnt.acctBalance + sum);
						
						System.out.println(
								"You deposited money successfully. New balance is " + checkAccnt.getAcctBalance());
						success = true;
					
				} else {
					
					System.out.println("You are trying to deposit more money than your limit is. You can deposit " + checkAccnt.getDepositLimit());
				}

			} else if (c.getProducts().get(i) instanceof CreditAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				CreditAccount creditAccnt = (CreditAccount) c.getProducts().get(i);
				if (sum >= creditAccnt.getMinimumPayment()) {
					
					creditAccnt.setAcctBalance(creditAccnt.getAcctBalance() - sum);
					double creditSum = creditAccnt.getCreditLimit() - creditAccnt.getAcctBalance();
					System.out.println("You deposited money successfully. New balance is " + creditAccnt.getAcctBalance() + ". Available credit is " + creditSum);
					success = true;
				
				} else {
				
					System.out.println("You are trying to deposit less money than your minimum payment is. You need to deposit " + creditAccnt.getMinimumPayment());
				}
			} else if (c.getProducts().get(i) instanceof SavingAccount && c.getProducts().get(i).getAcctNum() == acctNum) {
				SavingAccount savigAccnt = (SavingAccount) c.getProducts().get(i);					
				if (sum <= savigAccnt.getDepositSumLimit()) {
					
					savigAccnt.setAcctBalance(savigAccnt.acctBalance + sum);
						
						System.out.println("You deposited money successfully. New balance is " + savigAccnt.getAcctBalance());
						success = true;
					
				} else {
					
					System.out.println("You are trying to deposit more money than your limit is. You can deposit " + savigAccnt.getDepositSumLimit());
				}			
			}

		}

		return success;
	}

	@Override
	public boolean transferBetweenAccnts(Customer c, String acctFrom, String acctTo, double sum) {
		boolean success = false;
		for (int i = 0; i < c.getProducts().size(); i++) {
			if (c.getProducts().get(i) instanceof CheckingAccount && c.getProducts().get(i).getAcctNum() == acctFrom) {
				if (withdrawFromAccnt(c, acctFrom, sum)) {

					success = depositToAccnt(c, acctTo, sum);
				}

			} else if (c.getProducts().get(i) instanceof CreditAccount
					&& c.getProducts().get(i).getAcctNum() == acctFrom) {

				System.out.println("You cannot transfer money from credit accounts");

			} else if (c.getProducts().get(i) instanceof SavingAccount
					&& c.getProducts().get(i).getAcctNum() == acctFrom) {
				if (withdrawFromAccnt(c, acctFrom, sum)) {
					success = depositToAccnt(c, acctTo, sum);
				}
			}

		}
		return success;
	}
	
	
}
