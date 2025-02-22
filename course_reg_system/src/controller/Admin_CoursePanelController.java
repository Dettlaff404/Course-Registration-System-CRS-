package controller;

import dto.CourseDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Admin_CoursePanelController {

    @FXML
    private Button btnAcademicReport;

    @FXML
    private Button btnAcademicReport1;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<CourseDto, Integer> colCredHrs;

    @FXML
    private TableColumn<CourseDto, String> colDepartmentId;

    @FXML
    private TableColumn<CourseDto, Integer> colEnrollCap;

    @FXML
    private TableColumn<CourseDto, String> colId;

    @FXML
    private TableColumn<CourseDto, String> colTitle;

    @FXML
    private TableView<CourseDto> tblCourses;

    @FXML
    private Label lblResponse;

    @FXML
    private TextField txtCourseId;

    @FXML
    private TextField txtCredHrs;

    @FXML
    private TextField txtDepartmentId;

    @FXML
    private TextField txtEnrollCap;

    @FXML
    private TextField txtTitle;

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