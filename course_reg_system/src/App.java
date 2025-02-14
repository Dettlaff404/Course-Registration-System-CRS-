import java.net.URL;

//test imports
// import dao.custom.impl.PrerequisiteDaoIMPL;
// import dao.custom.impl.CourseDaoIMPL;
// import dao.custom.impl.StudentDaoIMPL;
// import entity.PrerequisiteEntity;

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

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //tests
        //System.out.println(courseDaoIMPL.getAll());
        //System.out.println(studentDaoIMPL.getAll());
        // PrerequisiteEntity prereq = new PrerequisiteEntity("PSY202", "PSY101");
        // System.out.println(prereqDaoIMPL.save(prereq));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("./view/main.fxml");
        Parent root = FXMLLoader.load(resource);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Course Registration System");
        primaryStage.show();
    }
}
