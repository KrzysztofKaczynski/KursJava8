package methodReference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by davit.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class JavaFXMain extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override public void start(Stage primaryStage) throws Exception {

    Button button = new Button("Przycisk");
    Scene scene = new Scene(button);
    primaryStage.setScene(scene);
    primaryStage.show();


    button.setOnAction(e->{
      System.out.println("Jestem przycisk");
    });

    button.setOnMouseEntered(this::onMouseEntered);

  }
  private void onMouseEntered(MouseEvent mouseEvent) {
    System.out.println("Jestem przycisk z referencji metody");
  }












}
