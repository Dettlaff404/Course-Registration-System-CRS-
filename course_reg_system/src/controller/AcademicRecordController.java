package controller;

import dto.EnrollmentDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import service.ServiceFactory;
import service.custom.AcademicRecordService;

public class AcademicRecordController {

    @FXML
    private TableColumn<EnrollmentDto, String> colCourse;

    @FXML
    private TableColumn<EnrollmentDto, String> colCourseID;

    @FXML
    private TableColumn<EnrollmentDto, Character> colGrade;

    @FXML
    private TableColumn<EnrollmentDto, String> colSemester;

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
    private TableView<EnrollmentDto> tblGradedCourses;


    private String student_id;
    private AcademicRecordService academicRecordService = (AcademicRecordService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ACADEMIC_RECORD);

    public void initialize(String student_id) throws Exception {
        this.student_id = student_id;
        
        setLabels();
        System.out.println(academicRecordService.searchCompletedCourseByStudent(student_id));

    }

    public void setLabels() throws Exception {
        lblId.setText(academicRecordService.searchStudent(student_id).getStudent_id());
        lblName.setText(academicRecordService.searchStudent(student_id).getStudent_name());
        lblDob.setText(academicRecordService.searchStudent(student_id).getDob().toString());
        lblYear.setText(academicRecordService.searchStudent(student_id).getYear().toString());
        lblFaculty.setText(academicRecordService.searchStudent(student_id).getProgram_id().toString());
    }

}
