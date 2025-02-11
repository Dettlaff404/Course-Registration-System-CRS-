package dto;

public class StudentDto {
    private String student_id;
    private String student_name;
    private String dob;
    private String year;
    private String contact;
    private String password;
    private String program_id;

    public StudentDto(){

    } 

    public StudentDto(String student_id, String student_name, String dob, String year, String contact, String password, String program_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.dob = dob;
        this.year = year;
        this.contact = contact;
        this.password = password;
        this.program_id = program_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }

    @Override
    public String toString() {
        return "StudentDto [student_id=" + student_id + ", student_name=" + student_name + ", dob=" + dob + ", year="
                + year + ", contact=" + contact + ", password=" + password + ", program_id=" + program_id + "]";
    }
}
