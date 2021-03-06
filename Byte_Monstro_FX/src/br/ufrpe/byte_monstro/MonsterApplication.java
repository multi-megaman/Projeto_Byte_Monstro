package br.ufrpe.byte_monstro;

import br.ufrpe.byte_monstro.GUI.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MonsterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //RepositorioManager.getInstance();
        ScreenManager.getInstance().setMainStage(stage);
        ScreenManager.getInstance().showMainScreen();

        /*FXMLLoader fxmlLoader = new FXMLLoader(MonsterApplication.class.getResource("MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 750);
        stage.setTitle("01011000");
        stage.setScene(scene);*/
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}