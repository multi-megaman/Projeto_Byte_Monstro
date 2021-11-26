package br.ufrpe.byte_monstro.GUI;

import br.ufrpe.byte_monstro.Negocios.RepositorioManager;
import br.ufrpe.byte_monstro.Negocios.beans.Aluno;
import br.ufrpe.byte_monstro.Negocios.beans.Exercicio;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

    public void atualizarListas() {

    }

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
            ListView<Exercicio> listaExercicios = new ListView<Exercicio>();
            listaExercicios.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Exercicio exercicio = listaExercicios.getSelectionModel().getSelectedItem();
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

        RepositorioManager.getInstance().atualizarAluno(aluno);

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

        RepositorioManager.getInstance().atualizarAluno(aluno);

    }

    @FXML
    public void btnBackPressed(ActionEvent event) {
        System.out.println(aluno.getTreinoDiario());

        ScreenManager.getInstance().showMainScreen();
        /*Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
    }
}
