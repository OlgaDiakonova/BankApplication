import java.util.Date;


public class Test {

	public static void main(String[] args) {
		/* creating a customer */
		
		Customer cust1 = new Customer("John", "Doe", "95 Steels Street, Toronto", new Date(1987-01-01), "TD", "4169875648", 001, 720, true);
		Operation oper1 = new Operation();
		Promotion prom1 = new Promotion();
		//creating accounts for customer
		System.out.println("Creating accounts:");
		oper1.openCheckingAccnt(cust1);
		prom1.getPromotionforCheckingAccnt(cust1, cust1.getProducts().get(0).getAcctNum());
		oper1.openCreditLine(cust1);
		prom1.getPromotionforCreditAccnt(cust1, cust1.getProducts().get(1).getAcctNum(), 5000);
		oper1.openSavingAccnt(cust1);
		prom1.getPromotionforSavingAccnt(cust1, cust1.getProducts().get(0).getAcctNum());
		prom1.getPromotionforSavingAccnt(cust1, cust1.getProducts().get(2).getAcctNum());
		
		//deposit and withdraw from Checking
		System.out.println("\nDeposit and Withdraw from Checking accounts:");
		oper1.depositToAccnt(cust1, cust1.getProducts().get(0).getAcctNum(), 4000.0);
		oper1.withdrawFromAccnt(cust1, cust1.getProducts().get(0).getAcctNum(), 50.0);
		prom1.getPromotionforCheckingAccnt(cust1, cust1.getProducts().get(0).getAcctNum());
		oper1.withdrawFromAccnt(cust1, cust1.getProducts().get(0).getAcctNum(), 50.0);
		
		//deposit and withdraw from Credit
		System.out.println("\nDeposit and Withdraw from Credit accounts:");
		oper1.withdrawFromAccnt(cust1, cust1.getProducts().get(1).getAcctNum(), 500.0);
		oper1.depositToAccnt(cust1, cust1.getProducts().get(1).getAcctNum(), 10.0);
		
		//deposit and withdraw from Saving + promotion which shoudn't work after creation as the balance was 0.00		
		System.out.println("\nDeposit and Withdraw from Saving accounts:");
		oper1.depositToAccnt(cust1, cust1.getProducts().get(2).getAcctNum(), 7000);
		oper1.withdrawFromAccnt(cust1, cust1.getProducts().get(2).getAcctNum(), 1090.0);
		prom1.getPromotionforSavingAccnt(cust1, cust1.getProducts().get(2).getAcctNum());
		
		//transfer between accounts
		System.out.println("\nTransfer money between accounts:");
		oper1.transferBetweenAccnts(cust1, cust1.getProducts().get(0).getAcctNum(), cust1.getProducts().get(1).getAcctNum(), 50.00);
	    oper1.transferBetweenAccnts(cust1, cust1.getProducts().get(1).getAcctNum(), cust1.getProducts().get(0).getAcctNum(), 50.00);		
		

	}

}
