package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import service.ServiceFactory;
import service.custom.LogInService;

public class StudentPortalController {

    @FXML
    private Label lblWelcome;

    private String student_id;
    private LogInService logInService = (LogInService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LOGIN);

    public void initialize(String id) throws Exception {
        student_id = id;
        lblWelcome.setText("Welcome " + logInService.searchStudent(id).getStudent_name());
    }

    @FXML
    void btnCoursesOnAction(ActionEvent event) {
        System.out.println(student_id+" Courses");
    }

    @FXML
    void btnStudentReportOnAction(ActionEvent event) {
        System.out.println(student_id+" Report");
    }

    

}