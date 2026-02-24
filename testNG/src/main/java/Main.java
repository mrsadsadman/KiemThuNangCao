import java.util.Scanner;

import model.Student;
import model.StudentManager;

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Sửa sinh viên");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("5. Tìm kiếm sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ngành: ");
                    String major = scanner.nextLine();

                    manager.addStudent(new Student(id, name, age, major));
                    System.out.println("✔ Thêm thành công!");
                    break;

                case 2:
                    System.out.print("Nhập ID cần xóa: ");
                    System.out.println(
                        manager.deleteStudent(scanner.nextLine())
                        ? "✔ Xóa thành công!"
                        : "❌ Không tìm thấy sinh viên!"
                    );
                    break;

                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Tên mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Tuổi mới: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ngành mới: ");
                    String newMajor = scanner.nextLine();

                    System.out.println(
                        manager.updateStudent(updateId, newName, newAge, newMajor)
                        ? "✔ Cập nhật thành công!"
                        : "❌ Không tìm thấy sinh viên!"
                    );
                    break;

                case 4:
                    manager.displayStudents();
                    break;

                case 5:
                    System.out.print("Nhập ID cần tìm: ");
                    Student s = manager.findStudentById(scanner.nextLine());
                    System.out.println(
                        s != null ? s : "❌ Không tìm thấy sinh viên!"
                    );
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình!");
                    return;

                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }
}
