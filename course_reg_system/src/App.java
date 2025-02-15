import java.net.URL;

//test imports
// import dao.custom.impl.PrerequisiteDaoIMPL;
// import dao.custom.impl.CourseDaoIMPL;
// import dao.custom.impl.StudentDaoIMPL;
// import entity.PrerequisiteEntity;
// import dao.custom.impl.EnrollmentDaoIMPL;
// import entity.EnrollmentEntity;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    
    //test vars
    //private static CourseDaoIMPL courseDaoIMPL = new CourseDaoIMPL();
    //private static StudentDaoIMPL studentDaoIMPL = new StudentDaoIMPL();
    // private static PrerequisiteDaoIMPL prereqDaoIMPL = new PrerequisiteDaoIMPL();
    // private static EnrollmentDaoIMPL enrollmentDaoIMPL = new EnrollmentDaoIMPL();

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //tests
        //System.out.println(courseDaoIMPL.getAll());
        //System.out.println(studentDaoIMPL.getAll());
        // PrerequisiteEntity prereq = new PrerequisiteEntity("PSY202", "PSY101");
        // System.out.println(prereqDaoIMPL.save(prereq));
        // EnrollmentEntity enrollment = new EnrollmentEntity("E040", "S020", "CHEM202", "Fall2021", 'B');
        // System.out.println(enrollmentDaoIMPL.save(enrollment));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("./view/login.fxml");
        Parent root = FXMLLoader.load(resource);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Course Registration System");
        primaryStage.show();
    }
}
