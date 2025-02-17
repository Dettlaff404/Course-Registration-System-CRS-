package controller;

import java.util.ArrayList;

import dto.CourseDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    private String student_id;
    private StudentCourseSearchService studentCourseSearchService = (StudentCourseSearchService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT_COURSE_SEARCH);

    @FXML
    void btnEnrollOnAction(ActionEvent event) {

    }

    public void initialize(String student_id) throws Exception {
        this.student_id = student_id;
        System.out.println(student_id);

        setTable();
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCredHrs.setCellValueFactory(new PropertyValueFactory<>("cred_hrs"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("department_id"));
        colSpotsLeft.setCellValueFactory(new PropertyValueFactory<>("max_enrollcap"));
        colCredHrs.setStyle("-fx-alignment: CENTER;");
        colDepartment.setStyle("-fx-alignment: CENTER;");
        colSpotsLeft.setStyle("-fx-alignment: CENTER;");
    }

    public void setTable() throws Exception {
        ArrayList<CourseDto> allCourses = studentCourseSearchService.getAllCourses();

        ObservableList<CourseDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(allCourses);
        tblCourses.setItems(observableArrayList);
    }

}