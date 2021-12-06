import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

	public static void main(String[] args) {
		//insertData();
		//updateData();
		 selectData();
		List<Student> studentsList = getStudentData();
		for (Student stu : studentsList) {
			System.out.println("Id: " + stu.getId() + " Name:" + stu.getName());
		}

	}

	private static void insertData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root9999");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			int noRowsUpdated = stmt.executeUpdate("insert into stu_tbl(Id,Name) values (41,'qreajjm')");
			System.out.println("noRowsUpdated ==>>" + noRowsUpdated);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void selectData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root9999");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from stu_tbl");
			while (rs.next())
				System.out.println("Id:" + rs.getInt(1) + " Name:" + rs.getString(2));
			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void updateData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root9999");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			int noRowsUpdated = stmt.executeUpdate("update stu_tbl set Name = 'krishna' where Id=2");
			// System.out.println("noRowsUpdated ==>>" + noRowsUpdated);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static List<Student> getStudentData() {
		List<Student> studentsList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root9999");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from stu_tbl1");

			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				studentsList.add(stu);
			}
//				System.out.println("Id:" + rs.getInt(1) + " Name:" + rs.getString(2));
			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentsList;
	}

}
