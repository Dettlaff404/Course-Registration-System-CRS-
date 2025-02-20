package controller;

import java.util.ArrayList;

import dto.EnrollmentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.StudentCurrentlyFollowingCoursesService;

public class StudentCurrentlyFollowingCoursesController {

    @FXML
    private Button btnDropCourse;

    @FXML
    private TableColumn<EnrollmentDto, String> colCourse;

    @FXML
    private TableColumn<EnrollmentDto, String> colCourseID;

    @FXML
    private TableColumn<EnrollmentDto, String> colSemester;

    @FXML
    private TableView<EnrollmentDto> tblCurrentlyFollowingCourses;

    private String student_id;
    private StudentCurrentlyFollowingCoursesService studentCurrentlyFollowingCoursesService = (StudentCurrentlyFollowingCoursesService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT_CURRENTLY_FOLLOWING_COURSES);

    public void initialize(String student_id) throws Exception {
        this.student_id = student_id;
        btnDropCourse.setDisable(true);

        setTable();
        colCourseID.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        colSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
    }

    public void setTable() throws Exception {
        ArrayList<EnrollmentDto> followingCourses = studentCurrentlyFollowingCoursesService.searchCurrentlyFollowingCourses(student_id);

        ObservableList<EnrollmentDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(followingCourses);
        tblCurrentlyFollowingCourses.setItems(observableArrayList);
    }

    @FXML
    void btnDropCourseOnAction(ActionEvent event) {

    }

}