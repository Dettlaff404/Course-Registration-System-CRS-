package controller;

import dto.StudentDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Admin_StudentPanelController {

    @FXML
    private Button btnAcademicReport;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<StudentDto, String> colContact;

    @FXML
    private TableColumn<StudentDto, String> colDob;

    @FXML
    private TableColumn<StudentDto, String> colFacultyId;

    @FXML
    private TableColumn<StudentDto, String> colStudentId;

    @FXML
    private TableColumn<StudentDto, String> colStudentName;

    @FXML
    private TableColumn<StudentDto, String> colYear;

    @FXML
    private TableView<StudentDto> tblStudentDetail;

    @FXML
    private TextField txtDoB;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtProgramId;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtYear;

    @FXML
    void btnAcacemicReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}