package personelManagement;

import java.util.*;

public class Person implements java.io.Serializable {
	public String name;
	public int age;
	public String sex;
	public String address;
	public String birthDay;
	Person person;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public Person() {

	}
	
	public Person(String name, int age, String sex, String address,String birthDay) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.birthDay = birthDay;
	}

	public Scanner input() {
		Scanner input = new Scanner(System.in);
		return input;
	}

	public String inputName(String name) {
		System.out.print("Nhập tên NV:");
		name = input().nextLine();
		return name;
	}

	public int inputAge(int age) {
		System.out.print("Vui lòng nhập tuổi: ");
		while (true) {
			try {
				age = Integer.parseInt(input().nextLine());
				if (age < 0 && age > 80) {
					throw new NumberFormatException();
				}
				return age;
			} catch (NumberFormatException ex) {
				System.out.print("Tuổi vừa nhập không hợp lệ.Vui lòng nhập lại: ");
			}
		}
	}
	public String inputBirthDay(String birthDay) {
		System.out.println("Nhập ngày sinh(ngày/tháng/năm): ");
		birthDay = input().nextLine();
		return birthDay;
	}
	public String inputSex(String sex) {
		System.out.print("Nhập giới tính(Nam/Nữ): ");
		sex = input().nextLine();
		return sex;
	}

	public String inputAddress(String address) {
		System.out.print("Nhập địa chỉ: ");
		address = input().nextLine();
		return address;
	}

	public void inputPerson() {
		Person perSon = new Person();
		perSon.setName(inputName(name));
		perSon.setAge(inputAge(age));
		perSon.setBirthDay(birthDay);
		perSon.setSex(inputSex(sex));
		perSon.setAddress(inputAddress(address));
	}

	public void displayPerson() {
		System.out.println(String.format("Họ tên: %s", person.getName()));
		System.out.println(String.format("Tuổi: %s", person.getAge()));
		System.out.println(String.format("Giới tính: %s", person.getSex()));
		System.out.println(String.format("Địa chỉ: %s", person.getAddress()));
	}

}
