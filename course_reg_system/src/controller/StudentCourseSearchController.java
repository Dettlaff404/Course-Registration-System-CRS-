package controller;

import java.util.ArrayList;

import dto.CourseDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import service.ServiceFactory;
import service.custom.StudentCourseSearchService;

public class StudentCourseSearchController {

    @FXML
    private TableColumn<CourseDto, String> colCourseId;

    @FXML
    private TableColumn<CourseDto, String> colCourseName;

    @FXML
    private TableColumn<CourseDto, Integer> colCredHrs;

    @FXML
    private TableColumn<CourseDto, String> colDepartment;

    @FXML
    private TableColumn<CourseDto, Integer> colSpotsLeft;

    @FXML
    private TableView<CourseDto> tblCourses;

     @FXML
    private Button btnEnroll;

    @FXML
    private Label lblResponse;

    private String student_id;
    private String course_id;
    private StudentCourseSearchService studentCourseSearchService = (StudentCourseSearchService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT_COURSE_SEARCH);

    @FXML
    void btnEnrollOnAction(ActionEvent event) {
        try {
            String response = studentCourseSearchService.enrollCourse(student_id, course_id);
            lblResponse.setText(response);
            if (response.contains("Enrolled Successfully")) {
                setTable();
                lblResponse.setTextFill(Color.GREEN);
            } else {
                lblResponse.setTextFill(Color.RED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            lblResponse.setText("Error at Enrolling. \nPlease Contact Administration.");
            lblResponse.setTextFill(Color.RED);
        }
    }

    public void initialize(String student_id) throws Exception {
        this.student_id = student_id;
        btnEnroll.setDisable(true);

        setTable();
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCredHrs.setCellValueFactory(new PropertyValueFactory<>("cred_hrs"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department_id"));
        colSpotsLeft.setCellValueFactory(new PropertyValueFactory<>("max_enrollcap"));
        colCredHrs.setStyle("-fx-alignment: CENTER;");
        colDepartment.setStyle("-fx-alignment: CENTER;");
        colSpotsLeft.setStyle("-fx-alignment: CENTER;");

        tblCourses.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            course_id = newSelection.getCourse_id();
            try {
                if(newSelection!=null && studentCourseSearchService.canEnroll(student_id, newSelection.getCourse_id())){
                    btnEnroll.setDisable(false);
                    lblResponse.setText("");
                } else {
                    btnEnroll.setDisable(true);
                    lblResponse.setText("Enrollment Reqirements not met. \nSelect another course.");
                    lblResponse.setTextFill(Color.RED);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                lblResponse.setText("Error at Checking Enrollment Requirements. \nPlease Contact Administration.");
                lblResponse.setTextFill(Color.RED);
            }

        });
    }

    public void setTable() throws Exception {
        ArrayList<CourseDto> allCourses = studentCourseSearchService.getAllCourses();

        ObservableList<CourseDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(allCourses);
        tblCourses.setItems(observableArrayList);
    }

}