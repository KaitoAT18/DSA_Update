package LinkedList;

import java.util.Objects;

/**
 * Bài 3. Tạo danh sách liên kết đôi generic lưu trữ các đối tượng kiểu sinh viên. Trong đó thông tin
 * sinh viên gồm: mã sinh viên, họ và tên, địa chỉ, email, tuổi, điểm trung bình. Cập nhật email và
 * điểm trung bình cho sinh viên có mã x nào đó. Sau khi cập nhật trả về true nếu cập nhật thành
 * công và false nếu cập nhật thất bại.
 */

public class Student implements Comparable<Student> {
    private String id;
    private String fullName;
    private String address;
    private String email;
    private int age;
    private double gpa;

    public Student() {
    }

    public Student(String id, String fullName, String address, String email, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gpa = gpa;
    }

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo (Student other) {
        return 0;
    }
}
