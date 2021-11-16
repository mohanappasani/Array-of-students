import java.util.Scanner;
public class Main

{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Student arr[] = new Student[2];
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		for(int i=0;i<arr.length;i++){
		    Student s = new Student();
            System.out.println("Enter id:");
            String id =scanner.nextLine() ;  // Read user input
            System.out.println("Enter username");
            String userName = scanner.nextLine();
		    s.id=id;
		    s.name=userName;
		    arr[i]= s;
		}
		System.out.println("Display user info");
		for(int i=0;i<arr.length;i++){
		    Student s1 =  arr[i];
		    System.out.println("Id::"+s1.id + " Name::"+ s1.name);
		}
	}
}
class Student{
    String id;
    String name;
}
