package personelManagement;

import java.io.Serializable;
import java.util.*;

public class Staff extends Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final float COEFFICIENT_SALALRY = (float) 3.2;
	public int basicSalary;
	public int ID;
	Person person;
	Staff staff ;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Staff() {
		super();
	}

	public Staff(int basicSalary, int ID, Person person) {
		super();
		this.basicSalary = basicSalary;
		this.ID = ID;
		this.person = person;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int salary() {
		return basicSalary * (int)COEFFICIENT_SALALRY;
	}
	
	public int inputNumber(int basicSalary) {
		System.out.print("Nhập lương cơ bản: ");
		while(true) {
			try {
				basicSalary = Integer.parseInt(input().nextLine());
				return basicSalary;
			} catch(NumberFormatException ex) {
				System.out.print("Số vừa nhập không hợp lê.Vui lòng nhập lại: ");
			}
		}
	}

	public int inputID(int ID) {
		System.out.print("Nhập mã nhân viên: ");
		while(true) {
			try {
				ID = Integer.parseInt(input().nextLine());
				return ID;
			} catch(NumberFormatException ex) {
				System.out.print("Mã vừa nhập không hợp lê.Vui lòng nhập lại: ");
			}
		}
	}

	public void inputStaff() {
		staff = new Staff();
		staff.setID(inputID(ID));
		super.inputPerson();
		staff.setBasicSalary(inputNumber(basicSalary));
	}

	public void displayStaff() {
		super.displayPerson();
		System.out.println(String.format("ID nhân viên: %s", staff.getID()));
		System.out.println(String.format("Lương : %s", staff.salary()));
	}

}