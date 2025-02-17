package dto;

public class EnrollmentDto {
    private String enrollment_id;
    private String student_id;
    private String course_id;
    private String course_name;
    private String semester;
    private Character grade;

    public EnrollmentDto() {
    }

    public EnrollmentDto(String enrollment_id, String student_id, String course_id, String course_name, String semester,Character grade) {
        this.enrollment_id = enrollment_id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.semester = semester;
        this.grade = grade;
    }

    public String getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(String enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    
}
