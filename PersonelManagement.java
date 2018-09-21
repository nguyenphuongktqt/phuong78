package personelManagement;

import java.io.Serializable;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class PersonelManagement extends Staff implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonelManagement personelManagement;
	Staff staff;
	List<Staff> staffList = new ArrayList<>();
	public InputOutputStream inputOutputStream = new InputOutputStream();

	public PersonelManagement() {

	}

	private List<Staff> getStaffList() {
		return staffList;
	}

	private void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}
	//thêm nhân viên vào danh sách
	public List<Staff> addStaff() {
		System.out.println("Số nhân viên cần thêm: ");
		int add = Integer.parseInt(input().nextLine());
		for (int i = 0; i < add; i++) {
			Staff staff = new Staff();
			System.out.println("Nhân viên thứ " + (i + 1));
			staff.setID(inputID(ID));
			staff.setName(inputName(name));
			staff.setSex(inputSex(sex));
			staff.setAge(inputAge(age));
			staff.setBirthDay(inputBirthDay(birthDay));
			staff.setAddress(inputAddress(address));
			staff.setBasicSalary(inputNumber(basicSalary));
			staffList.add(staff);
		}
		return staffList;
	}
	//hiện thị danh sách nhân viên
	public void showStaff() {
		inputOutputStream.readFile();
		System.out.println("DANH SÁCH NHÂN VIÊN CHÍNH THỨC");
		System.out.println("Số nhân viên: " + staffList.size());
		for (Staff item : staffList) {
			if (item != null) {
				System.out.println(String.format("Mã NV: %d", item.getID()));
				System.out.println(String.format("Tên NV: %s", item.getName()));
				System.out.println(String.format("Giới tính: %s", item.getSex()));
				System.out.println(String.format("Ngày sinh: %s", item.getBirthDay()));
				System.out.println(String.format("Tuổi: %d", item.getAge()));
				System.out.println(String.format("Địa chỉ: %s", item.getAddress()));
				System.out.println(String.format("Lương: %d", item.salary()));
			} else {
				System.out.println("Danh sách rỗng.");
			}
		}
	}
	//sửa thông tin nhân viên
	public List<Staff> editStaff() {
		boolean check = false;
		System.out.print("Nhập mã NV cần tìm: ");
		int id = Integer.parseInt(input().nextLine());
		int size = staffList.size();
		for (int i = 0; i < size; i++) {
			if (staffList.get(i).getID() == id) {
				check = true;
				staffList.get(i).setName(inputName(name));
				staffList.get(i).setAge(inputAge(age));
				staffList.get(i).setSex(inputSex(sex));
				staffList.get(i).setAddress(inputAddress(address));
				staffList.get(i).setBasicSalary(inputNumber(basicSalary));
				break;
			}
		}
		if (!check) {
			System.out.print("Mã " + id + " vừa nhập không tồn tại.");
		} else {
			inputOutputStream.writeFile(staffList);
		}
		return staffList;
	}
	//xóa nhân viên theo id
	public List<Staff> deleteStaff() {
		Staff staff = null;
		int size = staffList.size();
		System.out.print("Nhập mã NV cần xóa: ");
		int id = Integer.parseInt(input().nextLine());
		for (int i = 0; i < size; i++) {
			if (staffList.get(i).getID() == id) {
				staff = staffList.get(i);
				break;
			}
		}
		if (staff != null) {
			staffList.remove(staff);
			inputOutputStream.writeFile(staffList);
			System.out.println("Đã xóa thành công.");
		} else {
			System.out.println("Mã " + id + " không tồn tại.");
		}
		return staffList;
	}
	//lọc nhân viên có ngày sinh trong tháng 9
	public List<Staff> filterList() {
		List<Staff> filterList = new ArrayList<>();
		filterList = new ArrayList<>();
		for (int i = 0; i < staffList.size(); i++) {
			String[] filter = staffList.get(i).getBirthDay().split("/");
			if (filter[1].equals("9")) {
				filterList.add(staffList.get(i));
			}
		}
		return filterList;
	}
	//hiển thị danh sách nhân viên sau khi lọc
	public void showFilterList() {
		System.out.println("DANH SÁCH NV CÓ NGÀY SINH TRONG THÁNG 9");
		System.out.println("Số nhân viên: " + filterList().size());
		for (Staff item : filterList()) {
			System.out.println(String.format("Mã NV: %d", item.getID()));
			System.out.println(String.format("Tên NV: %s", item.getName()));
			System.out.println(String.format("Giới tính: %s", item.getSex()));
			System.out.println(String.format("Tuổi: %d", item.getAge()));
			System.out.println(String.format("Ngày sinh: %s", item.getBirthDay()));
			System.out.println(String.format("Địa chỉ: %s", item.getAddress()));
			System.out.println(String.format("Lương: %d", item.salary()));
		}
	}
	//sắp xếp nhân viên theo tên
	public void sortStaffByName() {
		Collections.sort(staffList, new SortStaffByName());
	}
}
