package dto;

public class PrerequisiteDto {
    private String course_id;
    private String prereq_id;
    
    public PrerequisiteDto() {
    }

    public PrerequisiteDto(String course_id, String prereq_id) {
        this.course_id = course_id;
        this.prereq_id = prereq_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getPrereq_id() {
        return prereq_id;
    }

    public void setPrereq_id(String prereq_id) {
        this.prereq_id = prereq_id;
    }

    @Override
    public String toString() {
        return "PrerequisiteDto [course_id=" + course_id + ", prereq_id=" + prereq_id + "]";
    }
}
