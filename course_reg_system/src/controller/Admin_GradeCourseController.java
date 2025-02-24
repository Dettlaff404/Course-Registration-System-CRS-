package controller;


import java.util.ArrayList;

import dto.EnrollmentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.Admin_CoursePanelService;

public class Admin_GradeCourseController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<EnrollmentDto, Integer> colEnrollmentId;

    @FXML
    private TableColumn<EnrollmentDto, String> colSemester;

    @FXML
    private TableColumn<EnrollmentDto, String> colStudentId;

    @FXML
    private TableColumn<EnrollmentDto, String> colStudentName;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblResponse;

    @FXML
    private Label lblSemester;

    @FXML
    private Label lblStudentId;

    @FXML
    private Label lblStudentName;

    @FXML
    private TableView<EnrollmentDto> tblGradeCourse;

    @FXML
    private TextField txtGrade;

    private String course_id;
    private Admin_CoursePanelService admin_CoursePanelService = (Admin_CoursePanelService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ADMIN_COURSEPANEL);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    public void initialize(String course_id) throws Exception {
        this.course_id = course_id;
        clearData();

        setTable();
        colEnrollmentId.setCellValueFactory(new PropertyValueFactory<>("id")); 
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        colSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
    }

    public void setTable() throws Exception {
        ArrayList<EnrollmentDto> coursesToBeGrade = admin_CoursePanelService.getCoursesToBeGraded(course_id);

        ObservableList<EnrollmentDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(coursesToBeGrade);
        tblGradeCourse.setItems(observableArrayList);
    }

    public void selectData(EnrollmentDto enrollmentDto) {
        lblCourseId.setText(enrollmentDto.getCourse_id());
        lblCourseName.setText(enrollmentDto.getCourse_name());
        lblSemester.setText(enrollmentDto.getSemester());
        lblStudentId.setText(enrollmentDto.getStudent_id());
        lblStudentName.setText(enrollmentDto.getStudent_name());
        txtGrade.setDisable(false);
    }

    public void clearData(){
        lblCourseId.setText(null);
        lblCourseName.setText(null);
        lblStudentId.setText(null);
        lblStudentName.setText(null);
        lblSemester.setText(null);
        txtGrade.setText(null);
        txtGrade.setDisable(true);
    }

}