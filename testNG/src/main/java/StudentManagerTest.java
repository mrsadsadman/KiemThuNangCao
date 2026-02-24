import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import model.Student;
import model.StudentManager;



public class StudentManagerTest {

    private StudentManager manager;

    /*
     * Chạy trước MỖI test case
     * → đảm bảo các test độc lập với nhau
     */
    @BeforeMethod
    public void setUp() {
        manager = new StudentManager();
        manager.addStudent(new Student("S01", "An", 20, "IT"));
        manager.addStudent(new Student("S02", "Binh", 21, "Business"));
    }

    // ================== TEST addStudent ==================

    @Test
    public void testAddStudent_Success() {
        Student newStudent = new Student("S03", "Cuong", 22, "Design");
        manager.addStudent(newStudent);

        Student result = manager.findStudentById("S03");
        Assert.assertNotNull(result, "Sinh viên phải được thêm thành công");
    }

    // ================== TEST deleteStudent ==================

    @Test
    public void testDeleteStudent_ExistingId() {
        boolean result = manager.deleteStudent("S01");
        Assert.assertTrue(result, "Xóa sinh viên tồn tại phải trả về true");
    }

    @Test
    public void testDeleteStudent_NotExistingId() {
        boolean result = manager.deleteStudent("S99");
        Assert.assertFalse(result, "Xóa sinh viên không tồn tại phải trả về false");
    }

    // ================== TEST updateStudent ==================

    @Test
    public void testUpdateStudent_ExistingId() {
        boolean result = manager.updateStudent(
                "S02", "Binh Updated", 23, "Marketing");

        Assert.assertTrue(result, "Cập nhật sinh viên tồn tại phải thành công");

        Student updated = manager.findStudentById("S02");
        Assert.assertEquals(updated.toString().contains("Binh Updated"), true);
    }

    @Test
    public void testUpdateStudent_NotExistingId() {
        boolean result = manager.updateStudent(
                "S99", "Test", 30, "Test");

        Assert.assertFalse(result, "Cập nhật sinh viên không tồn tại phải thất bại");
    }

    // ================== TEST findStudentById ==================

    @Test
    public void testFindStudentById_ExistingId() {
        Student student = manager.findStudentById("S01");
        Assert.assertNotNull(student, "Phải tìm thấy sinh viên tồn tại");
        Assert.assertEquals(student.getId(), "S01");
    }

    @Test
    public void testFindStudentById_NotExistingId() {
        Student student = manager.findStudentById("S99");
        Assert.assertNull(student, "Không tìm thấy sinh viên → trả về null");
    }

    @Test
    public void testFindStudentById_IgnoreCase() {
        Student student = manager.findStudentById("s01");
        Assert.assertNotNull(student, "Tìm kiếm không phân biệt hoa thường");
    }
}


