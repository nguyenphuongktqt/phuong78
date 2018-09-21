package personelManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class InputOutputStream {
	private static final String EMPLOYEES_FILE = "E:\\EmployeesManagement";

	public void writeFile(List<Staff> staffList) {
		FileOutputStream fos = null;
		ObjectOutput oos = null;
		try {
			fos = new FileOutputStream(new File(EMPLOYEES_FILE));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(staffList);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Staff> readFile() {
		List<Staff> staffList = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInput ois = null;
		try {
			fis = new FileInputStream(new File(EMPLOYEES_FILE));
			ois = new ObjectInputStream(fis);
			staffList = (List<Staff>) ois.readObject();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			closeInStream(fis);
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return staffList;
	}

	private void closeInStream(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void closeOutStream(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
