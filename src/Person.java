import java.util.ArrayList;
import java.util.Date;

public class Person {

	private String fName;	
	private String lName;
	private String address;
	private Date DOB;
	private String bank;
	private String phoneNum;
	private ArrayList<Person> familyMember; 
	
	public Person(String fName, String lName, String address, Date dOB, String bank, String phoneNum) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.DOB = dOB;
		this.bank = bank;
		this.phoneNum = phoneNum;
		this.familyMember = new ArrayList<Person>();
	}
		
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public ArrayList<Person> getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(ArrayList<Person> familyMember) {
		this.familyMember = familyMember;
	}

	
}
