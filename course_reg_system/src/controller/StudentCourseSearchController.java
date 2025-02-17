package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentCourseSearchController {

    @FXML
    private TableColumn<?, ?> colCourseId;

    @FXML
    private TableColumn<?, ?> colCourseName;

    @FXML
    private TableColumn<?, ?> colCredHrs;

    @FXML
    private TableColumn<?, ?> colDepartment;

    @FXML
    private TableColumn<?, ?> colSpotsLeft;

    @FXML
    private TableView<?> tblCourses;

    private String student_id;

    @FXML
    void btnEnrollOnAction(ActionEvent event) {

    }

    public void initialize(String student_id) {
        this.student_id = student_id;
        System.out.println(student_id);
    }

}