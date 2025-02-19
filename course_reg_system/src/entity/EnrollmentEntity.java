package entity;

public class EnrollmentEntity {
    private String student_id;
    private String course_id;
    private String semester;
    private Character grade;
    private String enrolled_date;
    private Integer id;

    public EnrollmentEntity() {
    }

    public EnrollmentEntity( String student_id, String course_id, String semester, Character grade, String enrolled_date,Integer id) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.semester = semester;
        this.grade = grade;
        this.enrolled_date = enrolled_date;
        this.id = id;
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

    public String getEnrolled_date() {
        return enrolled_date;
    }

    public void setEnrolled_date(String enrolled_date) {
        this.enrolled_date = enrolled_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EnrollmentEntity [student_id=" + student_id + ", course_id=" + course_id + ", semester=" + semester
                + ", grade=" + grade + ", enrolled_date=" + enrolled_date + ", id=" + id + "]";
    }
    
    
}
