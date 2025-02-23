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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import service.ServiceFactory;
import service.custom.Admin_CoursePanelService;

public class Admin_CoursePanelController {

    @FXML
    private Button btnCourseReport;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGradeCourse;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<CourseDto, Integer> colCredHrs;

    @FXML
    private TableColumn<CourseDto, String> colDepartmentId;

    @FXML
    private TableColumn<CourseDto, Integer> colEnrollCap;

    @FXML
    private TableColumn<CourseDto, String> colId;

    @FXML
    private TableColumn<CourseDto, String> colTitle;

    @FXML
    private TableView<CourseDto> tblCourses;

    @FXML
    private Label lblResponse;

    @FXML
    private TextField txtCourseId;

    @FXML
    private TextField txtCredHrs;

    @FXML
    private TextField txtDepartmentId;

    @FXML
    private TextField txtEnrollCap;

    @FXML
    private TextField txtTitle;

    private Admin_CoursePanelService admin_CoursePanelService = (Admin_CoursePanelService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ADMIN_COURSEPANEL);

    @FXML
    void btnCourseReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnGradeCourseOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            if (admin_CoursePanelService.deleteCourse(txtCourseId.getText())) {
                setTable();
                clearTextFields();
                lblResponse.setText("Deleted Course Data Successfully.");
                lblResponse.setTextFill(Color.GREEN);
            } 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            lblResponse.setText("Error at Deleting Course Data. \nPlease Check Course ID and Try Again.");
            lblResponse.setTextFill(Color.RED);
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        CourseDto courseDto = new CourseDto(
                txtCourseId.getText(),
                txtTitle.getText(),
                Integer.parseInt(txtCredHrs.getText()),
                Integer.parseInt(txtEnrollCap.getText()),
                txtDepartmentId.getText()
                
        );
        try {
            if (admin_CoursePanelService.saveCourse(courseDto)) {
                setTable();
                clearTextFields();
                lblResponse.setText("Saved Course Data Successfully.");
                lblResponse.setTextFill(Color.GREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            lblResponse.setText("Error at Saving Course Data. \nPlease Check Data and Try Again.");
            lblResponse.setTextFill(Color.RED);
        }
    }

    public void initialize() throws Exception {
        setTable();
        colId.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCredHrs.setCellValueFactory(new PropertyValueFactory<>("cred_hrs"));
        colDepartmentId.setCellValueFactory(new PropertyValueFactory<>("department_id"));
        colEnrollCap.setCellValueFactory(new PropertyValueFactory<>("max_enrollcap"));
        colCredHrs.setStyle("-fx-alignment: CENTER;");
        colDepartmentId.setStyle("-fx-alignment: CENTER;");
        colEnrollCap.setStyle("-fx-alignment: CENTER;");
        btnCourseReport.setDisable(true);
        btnGradeCourse.setDisable(true);

        tblCourses.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                setTextFields(newSelection);
                btnCourseReport.setDisable(false);
                btnGradeCourse.setDisable(false);
                lblResponse.setText(null);
            } else {
                clearTextFields();
                btnCourseReport.setDisable(true);
                btnGradeCourse.setDisable(true);
            }
        });
    }

    public void setTable() throws Exception {
        ArrayList<CourseDto> all = admin_CoursePanelService.getAllCourses();  
        
        ObservableList<CourseDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(all);
        tblCourses.setItems(observableArrayList);
    }

    public void clearTextFields(){
        txtCourseId.clear();
        txtCredHrs.clear();
        txtDepartmentId.clear();
        txtEnrollCap.clear();
        txtTitle.clear();
    }

    public void setTextFields(CourseDto courseDto){
        txtCourseId.setText(courseDto.getCourse_id());
        txtCredHrs.setText(String.valueOf(courseDto.getCred_hrs()));
        txtDepartmentId.setText(courseDto.getDepartment_id());
        txtEnrollCap.setText(String.valueOf(courseDto.getMax_enrollcap()));
        txtTitle.setText(courseDto.getTitle());
    }

}