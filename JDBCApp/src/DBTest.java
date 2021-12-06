import java.util.List;

public class DBTest {

	public static void main(String[] args) {
		List<Student> students = Dboperations.getStudentData();
		for (Student stu : students) {
			System.out.println("Id::" + stu.getId() + " Name::" + stu.getName());
		}
	}

}
