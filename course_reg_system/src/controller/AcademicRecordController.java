package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AcademicRecordController {

    @FXML
    private TableColumn<?, ?> colCourse;

    @FXML
    private TableColumn<?, ?> colCourseID;

    @FXML
    private TableColumn<?, ?> colGrade;

    @FXML
    private TableColumn<?, ?> colSemester;

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
    private TableView<?> tblGradedCourses;


    private String student_id;

    public void initialize(String student_id) {
        this.student_id = student_id;


    }

}
