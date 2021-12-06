import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dboperations {

	public static void insertData() {
		try {
			Connection con = JDBCConnection.getConnection();
			Statement stmt = con.createStatement();
			int noRowsUpdated = stmt.executeUpdate("insert into stu_tbl(Id,Name) values (41,'qreajjm')");
			System.out.println("noRowsUpdated ==>>" + noRowsUpdated);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void selectData() {
		try {
			Connection con = JDBCConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from stu_tbl");
			while (rs.next())
				System.out.println("Id:" + rs.getInt(1) + " Name:" + rs.getString(2));
			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void updateData() {
		try {
			Connection con = JDBCConnection.getConnection();
			Statement stmt = con.createStatement();
			int noRowsUpdated = stmt.executeUpdate("update stu_tbl set Name = 'krishna' where Id=2");
			// System.out.println("noRowsUpdated ==>>" + noRowsUpdated);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static List<Student> getStudentData() {
		List<Student> studentsList = new ArrayList<>();
		try {
			Connection con = JDBCConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from stu_tbl1");

			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				studentsList.add(stu);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentsList;
	}

}
