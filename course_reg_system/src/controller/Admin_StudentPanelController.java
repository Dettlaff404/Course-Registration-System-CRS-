package controller;

import java.util.ArrayList;

import dto.StudentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.Admin_StudentPanelService;

public class Admin_StudentPanelController {

    @FXML
    private Button btnAcademicReport;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<StudentDto, String> colContact;

    @FXML
    private TableColumn<StudentDto, String> colDob;

    @FXML
    private TableColumn<StudentDto, String> colFacultyId;

    @FXML
    private TableColumn<StudentDto, String> colStudentId;

    @FXML
    private TableColumn<StudentDto, String> colStudentName;

    @FXML
    private TableColumn<StudentDto, String> colYear;

    @FXML
    private TableView<StudentDto> tblStudentDetail;

    @FXML
    private TextField txtDoB;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtProgramId;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtYear;

    private Admin_StudentPanelService admin_StudentPanelService = (Admin_StudentPanelService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ADMIN_STUDENTPANEL);

    public void initialize() throws Exception {
        setTable();
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colFacultyId.setCellValueFactory(new PropertyValueFactory<>("program_id"));
        colYear.setStyle("-fx-alignment: CENTER;");
        colDob.setStyle("-fx-alignment: CENTER;");
        colContact.setStyle("-fx-alignment: CENTER;");
        colFacultyId.setStyle("-fx-alignment: CENTER;");
    }

    public void setTable() throws Exception {
        ArrayList<StudentDto> all = admin_StudentPanelService.getAllStudents();  
        
        ObservableList<StudentDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(all);
        tblStudentDetail.setItems(observableArrayList);
    }

    @FXML
    void btnAcacemicReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}