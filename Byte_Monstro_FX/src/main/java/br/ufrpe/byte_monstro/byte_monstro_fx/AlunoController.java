package br.ufrpe.byte_monstro.byte_monstro_fx;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.EnumExercicios;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Exercicios;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.TreinoDiario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class AlunoController {

    //ArrayList<String> lista_teste = new ArrayList<String>();

    @FXML
    private Button deleteButton;

    @FXML
    private Label Tpercorridos;

    @FXML
    private Label trocaTreinoTF;

    @FXML
    private TabPane treinosTabPane;

    private Aluno aluno;

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void initialize() {

        //System.out.println(aluno);

    }



    public void genItens() {
        treinosTabPane.getTabs().clear();
        Tpercorridos.setText(String.format("Treino %d/%d",aluno.getQntTreinosPercorridos(),aluno.getQntMaximaDeSequencia()));

        if (aluno.getPedirTrocaDoTreino()) {
            trocaTreinoTF.setText("Pedido para a troca dos treinos feita.");
        }
        else {
            trocaTreinoTF.setText(String.format("Ainda faltam %d treinos para sua troca de treinos",aluno.getQntMaximaDeSequencia()-aluno.getQntTreinosPercorridos()));
        }

        for (int i = 0; i < aluno.getSequenciaDeTreinos().size(); i++) {
            Tab novaTab = new Tab(String.format("Treino %d",i));
            ListView<Exercicios> listaExercicios = new ListView<Exercicios>();
            listaExercicios.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Exercicios exercicio = listaExercicios.getSelectionModel().getSelectedItem();
                }
            });


            listaExercicios.setItems(FXCollections.observableArrayList(aluno.getTreinoDiarioEspecifico(i).getExercicios()));
            novaTab.setContent(listaExercicios);
            treinosTabPane.getTabs().add(novaTab);
        }
    }

    @FXML
    public void btnImprimirPressed() {
        aluno.setQntTreinosPercorridos(aluno.getQntTreinosPercorridos()+1);

        if (aluno.getQntTreinosPercorridos() >= aluno.getQntMaximaDeSequencia()) {
            aluno.setPedirTrocaDoTreino(true);
        }

        if (aluno.getPedirTrocaDoTreino()) {
            trocaTreinoTF.setText("Pedido para a troca dos treinos feita.");
        }
        else {
            trocaTreinoTF.setText(String.format("Ainda faltam %d treinos para sua troca de treinos",aluno.getQntMaximaDeSequencia()-aluno.getQntTreinosPercorridos()));
        }

        Tpercorridos.setText(String.format("Treino %d/%d",aluno.getQntTreinosPercorridos(),aluno.getQntMaximaDeSequencia()));

        Alert warningAlert = new Alert(Alert.AlertType.WARNING);
        warningAlert.setHeaderText("SIMULAÇÃO DE IMPRESSÂO DE FICHA DE TREINO");
        warningAlert.setContentText("RETIRE SUA FICHA DE TREINO NA MAQUINETA");
        warningAlert.showAndWait();
    }

    @FXML
    public void btnTrocaDeTreinoPressed() {
        aluno.setQntTreinosPercorridos(aluno.getQntMaximaDeSequencia());
        aluno.setPedirTrocaDoTreino(true);
        Tpercorridos.setText(String.format("Treino %d/%d",aluno.getQntTreinosPercorridos(),aluno.getQntMaximaDeSequencia()));
        trocaTreinoTF.setText("Pedido para a troca dos treinos feita.");

    }

    @FXML
    public void btnBackPressed(ActionEvent event) {
        System.out.println(aluno);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
