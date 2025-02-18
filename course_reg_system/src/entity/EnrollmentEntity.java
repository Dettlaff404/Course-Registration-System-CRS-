package entity;

public class EnrollmentEntity {
    private String enrollment_id;
    private String student_id;
    private String course_id;
    private String semester;
    private Character grade;
    private String enrolled_date;

    public EnrollmentEntity() {
    }

    public EnrollmentEntity(String enrollment_id, String student_id, String course_id, String semester, Character grade, String enrolled_date) {
        this.enrollment_id = enrollment_id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.semester = semester;
        this.grade = grade;
        this.enrolled_date = enrolled_date;
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

    @Override
    public String toString() {
        return "EnrollmentEntity [enrollment_id=" + enrollment_id + ", student_id=" + student_id + ", course_id="
                + course_id + ", semester=" + semester + ", grade=" + grade + "]";
    }

    public String getEnrolled_date() {
        return enrolled_date;
    }

    public void setEnrolled_date(String enrolled_date) {
        this.enrolled_date = enrolled_date;
    }
    
    
}
