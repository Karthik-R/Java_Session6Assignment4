package javaSession6Assignment4;

import java.util.Scanner;
//BankAtm class to handle withdraw and deposit
// Correct naming conventions used
class BankAtm{
	private int atmId;
	private String bankName,location;
	static double balance=100000;
	public int getAtmId() {
		return atmId;
	}
	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	void withdraw(double amt){
		try{
			balance-=amt;
		if(balance <= 10000){
			throw new BankATMException(amt, balance);
		} else if(balance-amt < 10000)
			throw new BankATMException(amt, balance);
		else{
			System.out.println("Cash Withdrawn: "+amt);
			System.out.println("ATM Balance: "+balance);
		}
		}catch(BankATMException e){
			System.out.println(e);
		}
	}
	void deposit(double amt){
		balance += amt;
	}
}
//User defined exception
// Correct naming conventions used
class BankATMException extends Exception{
	/**
	 * Default versionUID
	 */
	private static final long serialVersionUID = 1L;
	double x,y;
	BankATMException(double a, double b){
		x=a;
		y=b;
	}
	public String toString(){
		if(y <= 10000 || y-x < 10000)
		return "Amount entered: "+x+", Error Code 0016: Insufficient Funds";
		else
		return "Sucessful Withrawal";
	}
}
//main class
// Correct naming conventions used
public class Bank {

	public static void main(String[] args) {
		System.out.println("Initial ATM Balance: "+BankAtm.balance);
		BankAtm atm1 = new BankAtm(); // 1st instance of BankAtm
		atm1.withdraw(30000);
		BankAtm atm2 = new BankAtm(); // 2nd instance of BankAtm
		atm2.withdraw(20000);
		BankAtm atm3 = new BankAtm(); // 3rd instance of BankAtm
		atm3.withdraw(50000);

	}

}
