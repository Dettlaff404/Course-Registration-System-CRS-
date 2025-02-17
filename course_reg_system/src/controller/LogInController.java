package controller;

import dto.AdminDto;
import dto.StudentDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import service.ServiceFactory;
import service.custom.LogInService;

public class LogInController {
    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSearch;

    @FXML
    private Label lblDetails;

    @FXML
    private Label lblEnterId;

    @FXML
    private Label lblEnterPassword;

    @FXML
    private AnchorPane logInScreen;

    @FXML
    private TextField txtID;

    @FXML
    private PasswordField txtPassword;

    private LogInService logInService = (LogInService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LOGIN);

    @FXML
    void btnLogInOnAction(ActionEvent event) throws Exception {
        if (txtID.getText().charAt(0) == 'S' && logInService.studentLogIn(txtID.getText(), txtPassword.getText())) {
            System.out.println("Student Login successful!");
            // logInScreen.getScene().getWindow().hide();
        } else if(txtID.getText().charAt(0) == 'A' && logInService.adminLogIn(txtID.getText(), txtPassword.getText())) {
            System.out.println("Admin Login successful!");
            // logInScreen.getScene().getWindow().hide();
        } else {
            lblDetails.setText("\nPassword incorrect. Try again...");
            lblDetails.setTextFill(Color.RED);
            lblDetails.setVisible(true);
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        try {
            if (!txtID.getText().isEmpty()) {
                cleanDetails();

                if (txtID.getText().charAt(0) == 'S') {
                    StudentDto studentDto = logInService.searchStudent(txtID.getText());
                    if (studentDto != null) {
                        lblDetails.setText("- STUDENT ("+ studentDto.getProgram_id() + ") -" + "\nName : "+ studentDto.getStudent_name() + "\nYear : "+ studentDto.getYear());
                        lblDetails.setTextFill(Color.GREEN);
                        passwordSetVisible();
                    } else {
                        lblDetails.setText("\nStudent not found. Try again...");
                        lblDetails.setTextFill(Color.RED);
                        passwordSetInvisible();
                    }
                } else if (txtID.getText().charAt(0) == 'A') {
                    AdminDto adminDto = logInService.searchAdmin(txtID.getText());
                    if (adminDto != null) {
                        lblDetails.setText("- STAFF ("+adminDto.getPost()+")\nWelcome " + adminDto.getTitle() + adminDto.getFull_name());
                        lblDetails.setTextFill(Color.GREEN);
                        passwordSetVisible();
                    } else {
                        lblDetails.setText("\nStaff/Admin not found. Try again...");
                        lblDetails.setTextFill(Color.RED);
                        passwordSetInvisible();
                    }
                } else {
                    lblDetails.setTextFill(Color.RED);
                    lblDetails.setText("\nEnter a valid ID to search...");
                    passwordSetInvisible();
                }
            }else{
                lblDetails.setTextFill(Color.RED);
                lblDetails.setText("\nEnter the ID to search...");
                passwordSetInvisible();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            
            lblDetails.setTextFill(Color.RED);
            lblDetails.setText("\nEnter a valid ID to search!");
        }

        lblDetails.setVisible(true);
    }

    public void cleanDetails(){
        lblDetails.setVisible(false);
        lblDetails.setTextFill(Color.BLACK);
        lblDetails.setText("");
    }

    public void passwordSetVisible(){
        lblEnterPassword.setVisible(true);
        txtPassword.setVisible(true);
        btnLogIn.setVisible(true);
    }

    public void passwordSetInvisible(){
        lblEnterPassword.setVisible(false);
        txtPassword.setVisible(false);
        btnLogIn.setVisible(false);
    }

}
