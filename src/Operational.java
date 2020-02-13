public interface Operational {
	
	public void openCreditLine(Customer c);
	public void openCheckingAccnt(Customer c);
	public void openSavingAccnt(Customer c);
	public boolean withdrawFromAccnt(Customer c, String acctNum, double sum);
	public boolean depositToAccnt(Customer c, String acctNum, double sum);
	public boolean transferBetweenAccnts(Customer c, String acctFrom, String acctTo, double sum);
	
}