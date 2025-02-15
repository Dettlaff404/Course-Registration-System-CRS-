package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LogInController {
    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnStudentIdSearch;

    @FXML
    private Label lblEnterId;

    @FXML
    private AnchorPane lblDetails;

    @FXML
    private Label lblEnterPassword;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtStudentId;

    @FXML
    void btnLogInOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        System.out.println("btnSearchOnAction");
    }

}
