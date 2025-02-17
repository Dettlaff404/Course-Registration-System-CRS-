package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
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
    void btnAcademicRecordOnAction(ActionEvent event) throws Exception {

        Stage stage2 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AcademicRecord.fxml"));
        stage2.setScene(new Scene(loader.load()));
        AcademicRecordController academicRecordController = loader.getController();
        academicRecordController.initialize(student_id);
        stage2.setTitle("Academic Record");
        stage2.show();
    }

    @FXML
    void btnCurrentlyFollowingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchCoursesOnAction(ActionEvent event) {

    }
}