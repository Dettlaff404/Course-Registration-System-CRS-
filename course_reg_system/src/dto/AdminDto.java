package dto;

public class AdminDto {
    private String admin_id;
    private String title;
    private String full_name;
    private String password;
    private String post;

    public AdminDto() {
    }

    public AdminDto(String admin_id, String title, String full_name, String password, String post) {
        this.admin_id = admin_id;
        this.title = title;
        this.full_name = full_name;
        this.password = password;
        this.post = post;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDto [admin_id=" + admin_id + ", title=" + title + ", full_name=" + full_name + ", password="
                + password + ", post=" + post + "]";
    }

    

    

}
