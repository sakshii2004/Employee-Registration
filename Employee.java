package lab_8_10;

public class Employee { 
	Integer empID;
	String empName;
	Integer empAge;
	String empEmail;
	String empDept;
	
	//constructor
	public Employee(int empID, String empName, int empAge, String empEmail, String empDept) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empAge = empAge;
		this.empEmail = empEmail;
		this.empDept = empDept;
	}

	// getters and setters
	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
}
