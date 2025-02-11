package entity;

public class CourseEntity {
    private String course_id;
    private String title;
    private int cred_hrs;
    private int max_enrollcap;
    private String department_id;

    public CourseEntity() {
    }

    public CourseEntity(String course_id, String title, int cred_hrs, int max_enrollcap, String department_id) {
        this.course_id = course_id;
        this.title = title;
        this.cred_hrs = cred_hrs;
        this.max_enrollcap = max_enrollcap;
        this.department_id = department_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCred_hrs() {
        return cred_hrs;
    }

    public void setCred_hrs(int cred_hrs) {
        this.cred_hrs = cred_hrs;
    }

    public int getMax_enrollcap() {
        return max_enrollcap;
    }

    public void setMax_enrollcap(int max_enrollcap) {
        this.max_enrollcap = max_enrollcap;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "CourseEntity [course_id=" + course_id + ", title=" + title + ", cred_hrs=" + cred_hrs
                + ", max_enrollcap=" + max_enrollcap + ", department_id=" + department_id + "]";
    }
    
    

}
