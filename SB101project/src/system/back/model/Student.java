package system.back.model;

public class Student {
	
	private int roll;
	private String sname;
	private String saddress;
	private String seamil;
	private String passward;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String sname, String saddress, String seamil, String passward) {
		super();
		this.roll = roll;
		this.sname = sname;
		this.saddress = saddress;
		this.seamil = seamil;
		this.passward = passward;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSeamil() {
		return seamil;
	}

	public void setSeamil(String seamil) {
		this.seamil = seamil;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", sname=" + sname + ", saddress=" + saddress + ", seamil=" + seamil
				+ ", passward=" + passward + "]";
	}

	
	
	

}
