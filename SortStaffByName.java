package personelManagement;
import java.util.Comparator;

public class SortStaffByName implements Comparator<Staff> {

	@Override
	public int compare(Staff staff1, Staff staff2) {
		// TODO Auto-generated method stub
		return staff1.getName().compareToIgnoreCase(staff2.getName());
	}

}
