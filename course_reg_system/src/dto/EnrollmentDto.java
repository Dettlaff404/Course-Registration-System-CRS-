package dto;

public class EnrollmentDto {
    private String student_id;
    private String course_id;
    private String course_name;
    private String semester;
    private Character grade;
    private Integer id;

    public EnrollmentDto() {
    }

    public EnrollmentDto(String student_id, String course_id, String course_name, String semester,Character grade, Integer id) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.semester = semester;
        this.grade = grade;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EnrollmentDto [student_id=" + student_id + ", course_id=" + course_id + ", course_name=" + course_name
                + ", semester=" + semester + ", grade=" + grade + ", id=" + id + "]";
    }

    
}
