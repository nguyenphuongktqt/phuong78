package personelManagement;

import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		PersonelManagement personelManagement = new PersonelManagement();
		List<Staff> staffList = new ArrayList<>();
		InputOutputStream inputOutputStream = new InputOutputStream();
		Main main = new Main();
		int choose;
		main.menu();
		while (true) {
			choose = input.nextInt();
			switch (choose) {
			case 1:
				List<Staff> nhanViens = personelManagement.addStaff();
				System.out.println("####nhanViens:" + nhanViens.size());
				inputOutputStream.writeFile(nhanViens);
				break;
			case 2:
				List<Staff> nhanViens1 = personelManagement.editStaff();
				inputOutputStream.writeFile(nhanViens1);
				break;
			case 3:
				List<Staff> nhanViens2 = personelManagement.deleteStaff();
				inputOutputStream.writeFile(nhanViens2);
				break;
			case 4:
				personelManagement.showStaff();
				inputOutputStream.readFile();
				break;	
			case 5:
				personelManagement.filterList();
				personelManagement.showFilterList();
				break;
			case 6:
				personelManagement.sortStaffByName();
				break;
			default:
				System.out.println("Thao tác không hợp lệ.Vui lòng chọn lại.");
				break;
			case 0:
				System.exit(0);
			}
			main.menu();
		}

	}

	public void menu() {
		System.out.println("CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN");
		System.out.println("1.Thêm nhân viên.");
		System.out.println("2.Sửa thông tin nhân viên.");
		System.out.println("3.Xóa nhân viên.");
		System.out.println("4.Hiển thị danh sách nhân viên.");
		System.out.println("5.Lọc danh sách NV theo tháng sinh.");
		System.out.println("6.Sắp xếp danh sách theo tên.");
		System.out.println("0.Thoát chương trình.");
		System.out.println("-------------------------------");
		System.out.print("Vui lòng chọn: ");
	}
}
