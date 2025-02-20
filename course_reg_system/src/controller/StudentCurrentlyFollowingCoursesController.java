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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import service.ServiceFactory;
import service.custom.StudentCurrentlyFollowingCoursesService;

public class StudentCurrentlyFollowingCoursesController {

    @FXML
    private Button btnDropCourse;

    @FXML
    private Label lblResponse;

    @FXML
    private TableColumn<EnrollmentDto, String> colCourse;

    @FXML
    private TableColumn<EnrollmentDto, String> colCourseID;

    @FXML
    private TableColumn<EnrollmentDto, String> colSemester;

    @FXML
    private TableView<EnrollmentDto> tblCurrentlyFollowingCourses;

    private String student_id;
    private int enrollment_id;
    private StudentCurrentlyFollowingCoursesService studentCurrentlyFollowingCoursesService = (StudentCurrentlyFollowingCoursesService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT_CURRENTLY_FOLLOWING_COURSES);

    public void initialize(String student_id) throws Exception {
        this.student_id = student_id;
        btnDropCourse.setDisable(true);

        setTable();
        colCourseID.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        colSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        colSemester.setStyle("-fx-alignment: CENTER;");

        tblCurrentlyFollowingCourses.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            try {
                if(newSelection!=null && (studentCurrentlyFollowingCoursesService.canDropCourse(newSelection.getId()))){
                    enrollment_id = newSelection.getId();
                    btnDropCourse.setDisable(false);
                    lblResponse.setText("");
                } else if(newSelection == null){
                    lblResponse.setText("");
                    btnDropCourse.setDisable(true);
                } else {
                    btnDropCourse.setDisable(true);
                    lblResponse.setText("You Can't Drop This Course. \nSelect another course.");
                    lblResponse.setTextFill(Color.RED);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                lblResponse.setText("Error at Checking Course Dropping Requirements. \nPlease Contact Administration.");
                lblResponse.setTextFill(Color.RED);
            }

        });
    }

    public void setTable() throws Exception {
        ArrayList<EnrollmentDto> followingCourses = studentCurrentlyFollowingCoursesService.searchCurrentlyFollowingCourses(student_id);

        ObservableList<EnrollmentDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(followingCourses);
        tblCurrentlyFollowingCourses.setItems(observableArrayList);
    }

    @FXML
    void btnDropCourseOnAction(ActionEvent event) throws Exception {
        if (studentCurrentlyFollowingCoursesService.dropCourse(enrollment_id)) {
            setTable();
            lblResponse.setText("Successfully Dropped the course.");
            lblResponse.setTextFill(Color.GREEN);
        } else {
            lblResponse.setText("Uncable to Drop Course.");
            lblResponse.setTextFill(Color.RED);
        }
    }

}