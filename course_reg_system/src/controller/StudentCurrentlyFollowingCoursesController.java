package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentCurrentlyFollowingCoursesController {

    @FXML
    private Button btnDropCourse;

    @FXML
    private TableColumn<?, ?> colCourse;

    @FXML
    private TableColumn<?, ?> colCourseID;

    @FXML
    private TableColumn<?, ?> colSemester;

    @FXML
    private TableView<?> tblCurrentlyFollowingCourses;

    private String student_id;

    public void initialize(String student_id) {
        this.student_id = student_id;
    }

    @FXML
    void btnDropCourseOnAction(ActionEvent event) {

    }

}