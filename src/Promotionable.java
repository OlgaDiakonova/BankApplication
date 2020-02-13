
public interface Promotionable {//make an interface for all types of promotions
	public boolean getPromotionforCheckingAccnt(Customer c, String accntNum);
	public boolean getPromotionforCreditAccnt(Customer c, String accntNum, double monthSpentSum);
	public boolean getPromotionforSavingAccnt(Customer c, String accntNum);
	
}
