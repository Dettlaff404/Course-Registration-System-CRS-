package controller;

import java.util.ArrayList;

import dto.EnrollmentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.AcademicRecordService;

public class AcademicRecordController {

    @FXML
    private TableColumn<EnrollmentDto, String> colCourse;

    @FXML
    private TableColumn<EnrollmentDto, String> colCourseID;

    @FXML
    private TableColumn<EnrollmentDto, Character> colGrade;

    @FXML
    private TableColumn<EnrollmentDto, String> colSemester;

    @FXML
    private Label lblDob;

    @FXML
    private Label lblFaculty;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblYear;

    @FXML
    private TableView<EnrollmentDto> tblGradedCourses;


    private String student_id;
    private AcademicRecordService academicRecordService = (AcademicRecordService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ACADEMIC_RECORD);

    public void initialize(String student_id) throws Exception {
        this.student_id = student_id;

        setLabels();

        setTable();
        colCourseID.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        colSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        colGrade.setStyle("-fx-alignment: CENTER;");
        colSemester.setStyle("-fx-alignment: CENTER;");

    }

    public void setTable() throws Exception {
        ArrayList<EnrollmentDto> completedCourses = academicRecordService.searchCompletedCourseByStudent(student_id);

        ObservableList<EnrollmentDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(completedCourses);
        tblGradedCourses.setItems(observableArrayList);
    }

    public void setLabels() throws Exception {
        lblId.setText(academicRecordService.searchStudent(student_id).getStudent_id());
        lblName.setText(academicRecordService.searchStudent(student_id).getStudent_name());
        lblDob.setText(academicRecordService.searchStudent(student_id).getDob().toString());
        lblYear.setText(academicRecordService.searchStudent(student_id).getYear().toString());
        lblFaculty.setText(academicRecordService.searchStudent(student_id).getProgram_id().toString());
    }

}
