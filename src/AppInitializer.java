import animatefx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class AppInitializer extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    Parent root;
    double xOffset, yOffset;

    @Override
    public void start(Stage primaryStage) {
        try {
//            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/LoginForm.fxml")));
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/LoginForm.fxml")));
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
            new FadeInDownBig(root).play();
            scene.setFill(Color.TRANSPARENT);
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
