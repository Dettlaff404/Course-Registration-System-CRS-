package controller;

import java.util.ArrayList;
import java.util.Arrays;

import dto.CourseDto;
import dto.EnrollmentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.Admin_CoursePanelService;

public class Admin_CourseReportController {

    @FXML
    private TableColumn<EnrollmentDto, Integer> colEnrollmentId;

    @FXML
    private TableColumn<EnrollmentDto, Character> colGrade;

    @FXML
    private TableColumn<EnrollmentDto, String> colSemester;

    @FXML
    private TableColumn<EnrollmentDto, String> colStudentId;

    @FXML
    private TableColumn<EnrollmentDto, String> colStudentName;

    @FXML
    private TableView<EnrollmentDto> tblGradedEnrollments;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblDepartmentId;

    @FXML
    private Label lblEnrollmentCap;

    @FXML
    private Label lblPassRate;

    @FXML
    private Label lblTotalGradedStudents;

    private Admin_CoursePanelService admin_CoursePanelService = (Admin_CoursePanelService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ADMIN_COURSEPANEL);
    private String courseId;
    Integer totalGradedEnrollments;
    Float passRate;
    Character[] passedArray = {'A', 'B', 'C', 'P'};

    public void initialize(String courseId) throws Exception{
        this.courseId = courseId;

        setTable();
        colEnrollmentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        colSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        colEnrollmentId.setStyle("-fx-alignment: CENTER;");
        colStudentId.setStyle("-fx-alignment: CENTER;");
        colSemester.setStyle("-fx-alignment: CENTER;");
        colGrade.setStyle("-fx-alignment: CENTER;");

        setLabels();

    }

    public void setTable() throws Exception {
        ArrayList<EnrollmentDto> all = admin_CoursePanelService.getCompletedEnrollments(courseId);  

        totalGradedEnrollments = all.size();
        int counter = 0;
        for(EnrollmentDto enrollmentDto : all){
            if(Arrays.asList(passedArray).contains(enrollmentDto.getGrade())){
                counter++;
            }
        }
        passRate = (float) counter / totalGradedEnrollments * 100;

        ObservableList<EnrollmentDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(all);
        tblGradedEnrollments.setItems(observableArrayList);
    }

    public void setLabels() throws Exception{
        CourseDto courseDto = admin_CoursePanelService.searchCourse(courseId);
        lblCourseId.setText(courseId);
        lblCourseName.setText(courseDto.getTitle());
        lblDepartmentId.setText(courseDto.getDepartment_id());
        lblEnrollmentCap.setText(String.valueOf(courseDto.getMax_enrollcap()));
        lblPassRate.setText(String.valueOf(passRate) + "%");
        lblTotalGradedStudents.setText(String.valueOf(totalGradedEnrollments));
    }

}