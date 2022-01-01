package juaracoding.com.utils;

public enum TestCases {
	
	T1("Register"),
	T2("Login"),
	T3("Cart"),
	T4("Checkout");
	
	
	private String testName;
	
	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}

}
