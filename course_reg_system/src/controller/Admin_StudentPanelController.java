package controller;

import java.util.ArrayList;

import dto.StudentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
    private TextField txtContact;

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

    @FXML
    private Label lblResponse;

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
        colStudentId.setStyle("-fx-alignment: CENTER;");

        tblStudentDetail.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                setFeilds(newSelection);
                btnAcademicReport.setDisable(false);
                lblResponse.setText(null);
            } else {
                clearFields();
                btnAcademicReport.setDisable(true);
            }

        });
    }

    public void setTable() throws Exception {
        ArrayList<StudentDto> all = admin_StudentPanelService.getAllStudents();  
        
        ObservableList<StudentDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(all);
        tblStudentDetail.setItems(observableArrayList);
    }

    public void clearFields() {
        txtStudentId.setText(null);
        txtStudentName.setText(null);
        txtDoB.setText(null);
        txtYear.setText(null);
        txtProgramId.setText(null);
        txtPassword.setText(null);
        txtContact.setText(null);
    }

    public void setFeilds(StudentDto studentDto) {
        txtStudentId.setText(studentDto.getStudent_id());
        txtStudentName.setText(studentDto.getStudent_name());
        txtDoB.setText(studentDto.getDob());
        txtYear.setText(studentDto.getYear());
        txtProgramId.setText(studentDto.getProgram_id());
        txtContact.setText(studentDto.getContact());
    }

    @FXML
    void btnAcacemicReportOnAction(ActionEvent event){
        try{
            Stage stage2 = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AcademicRecord.fxml"));
            stage2.setScene(new Scene(loader.load()));
            AcademicRecordController academicRecordController = loader.getController();
            academicRecordController.initialize(txtStudentId.getText());
            stage2.setTitle("Academic Record");
            stage2.show();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            lblResponse.setText("Error at Getting Academic Record. \nPlease Contact Administration.");
            lblResponse.setTextFill(Color.RED);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            if (admin_StudentPanelService.deleteStudent(txtStudentId.getText())) {
                setTable();
                clearFields();
                lblResponse.setText("Deleted Student Data Successfully.");
                lblResponse.setTextFill(Color.GREEN);
            } 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            lblResponse.setText("Error at Deleting Student Data. \nPlease Check Student ID and Try Again.");
            lblResponse.setTextFill(Color.RED);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        StudentDto studentDto = new StudentDto(
                txtStudentId.getText(),
                txtStudentName.getText(),
                txtDoB.getText(),
                txtYear.getText(),
                txtContact.getText(),
                txtProgramId.getText()
        );
        String password = (txtPassword.getText() == null || txtPassword.getText().equals("")) ? "123456" : txtPassword.getText();
        try {
            if (admin_StudentPanelService.saveStudent(studentDto, password)){
                setTable();
                clearFields();
                lblResponse.setText("Saved Student Data Successfully.");
                lblResponse.setTextFill(Color.GREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            lblResponse.setText("Error at Saving Student Data. \nPlease Check Data and Try Again.");
            lblResponse.setTextFill(Color.RED);
        }
    }

}