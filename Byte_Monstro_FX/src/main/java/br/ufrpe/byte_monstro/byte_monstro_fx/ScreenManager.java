package br.ufrpe.byte_monstro.byte_monstro_fx;


import java.io.IOException;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Profissional;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScreenManager {
    private static ScreenManager instance;
    private Stage mainStage;


    private Scene mainScene;
    private Scene alunoScene;
    private Scene profissionalScene;
    private Scene admScene;

    private AlunoController alunoController;
    //private MainWindowController mainWindowController;
    private ProfessionalController professionalController;
    private AdminController adminController;


    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }

        return instance;
    }

    private ScreenManager() {
        // Construtor privado para evitar instanciação

        try {
            BorderPane mainPane = FXMLLoader.load(getClass().getResource(
                    "MainWindow.fxml"));
            // inicializando cena
            this.mainScene = new Scene(mainPane);


            FXMLLoader loadAluno = new FXMLLoader(getClass().getResource("AlunoWindow.fxml"));
            Parent rootAluno = null;
            try {
                rootAluno = loadAluno.load();
            } catch (IOException t) {
                t.printStackTrace();
            }
            // inicializando cena
            this.alunoScene = new Scene(rootAluno);
            alunoController = loadAluno.getController();


            FXMLLoader loaderProfissional = new FXMLLoader(getClass().getResource("ProfessionalWindow.fxml"));

            Parent rootProfissional = null;
            try {
                rootProfissional = loaderProfissional.load();
            } catch (IOException t) {
                t.printStackTrace();
            }
            professionalController = loaderProfissional.getController();
            this.profissionalScene = new Scene(rootProfissional);


            FXMLLoader loaderAdm = new FXMLLoader(getClass().getResource("AdminWindow.fxml"));

            Parent rootAdm = null;
            try {
                rootAdm = loaderAdm.load();
            } catch (IOException t) {
                t.printStackTrace();
            }
            adminController = loaderAdm.getController();
            this.admScene = new Scene(rootAdm);




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;

        // configurando largura e altura do stage.
        mainStage.setWidth(800);
        mainStage.setHeight(700);

        // configurando título da app
        mainStage.setTitle("Monster Byte");
    }

    public void showMainScreen() {
        this.mainStage.setScene(this.mainScene);
        this.mainStage.show();
    }

    public void showAlunoScreen(Aluno alunoEscolhido) {
        alunoController.setAluno(alunoEscolhido);
        alunoController.genItens();
        this.mainStage.setScene(this.alunoScene);
        this.mainStage.show();
    }

    public void showProfissionalScreen(ObservableList listaAlunos, Profissional profissionalEscolhido) {
        professionalController.setAll(listaAlunos,profissionalEscolhido);
        this.mainStage.setScene(this.profissionalScene);
        this.mainStage.show();
    }

    public void showAdmScreen() {
        this.mainStage.setScene(this.admScene);
        this.mainStage.show();
    }
}
