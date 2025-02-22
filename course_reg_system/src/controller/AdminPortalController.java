package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminPortalController {

    @FXML
    void btnCoursesOnAction(ActionEvent event) {

    }

    @FXML
    void btnEnrollmentsOnAction(ActionEvent event) {

    }

    @FXML
    void btnStudentsOnAction(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Admin_StudentPanel.fxml"))));
        stage.setTitle("Student Management Panel");
        stage.show();
    }

}