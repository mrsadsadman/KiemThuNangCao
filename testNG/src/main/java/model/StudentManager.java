package model;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    // Thêm sinh viên
    public void addStudent(Student student) {
        students.add(student);
    }

    // Xóa sinh viên theo ID
    public boolean deleteStudent(String id) {
        return students.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }

    // Sửa thông tin sinh viên
    public boolean updateStudent(String id, String newName, int newAge, String newMajor) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                s.setName(newName);
                s.setAge(newAge);
                s.setMajor(newMajor);
                return true;
            }
        }
        return false;
    }

    // Hiển thị danh sách sinh viên
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Tìm kiếm sinh viên theo ID
    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}
