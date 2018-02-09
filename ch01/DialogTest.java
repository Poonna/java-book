import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogTest extends Application
{
    @Override
    public void start(Stage stage)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("Here's a message for you: " + (byte)1234);
        alert.showAndWait();

        //stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
