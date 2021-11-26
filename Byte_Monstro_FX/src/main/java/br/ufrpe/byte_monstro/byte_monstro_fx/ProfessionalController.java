package br.ufrpe.byte_monstro.byte_monstro_fx;

import com.dlsc.formsfx.model.structure.DateField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.concurrent.ThreadLocalRandom;

public class ProfessionalController {

    //ArrayList<String> lista_teste = new ArrayList<String>();

    @FXML
    private Button deleteButton;

    @FXML
    private TextField namePicker;

    @FXML
    private TextField generoPicker;

    @FXML
    private TextField idadePicker;

    @FXML
    private TextField pesoPicker;

    @FXML
    private TextField alturaPicker;

    @FXML
    private TextField gorduraPicker;

    @FXML
    private DatePicker matriculaPicker;

    @FXML
    private TextField idProfPicker;

    @FXML
    private ComboBox exercicioEnumComboBox;

    @FXML
    private TextField seriePicker;

    @FXML
    private TextField repeticaoPicker;

    @FXML
    private TextField cargaPicker;

    @FXML
    private ListView<Aluno> listaUsuarios;

    private ObservableList<Aluno> listaUsuariosObservavel;

    @FXML
    private TabPane treinosTabPane;

    @FXML
    private TextField searchTextFIeld;

    private Profissional profissionalEscolhido;

    private ControladorRepositorioAluno repositorioAluno;
    private ControladorRepositorioProfissional repositorioProfissional;


    public void setAll(ObservableList<Aluno> lista, Profissional profissional) {
        listaUsuariosObservavel = lista;
        listaUsuarios.setItems(listaUsuariosObservavel);
        profissionalEscolhido = profissional;

        idProfPicker.setEditable(false);
        idProfPicker.setText(String.valueOf(profissionalEscolhido.getId()));
    }

    public void initialize(){
        exercicioEnumComboBox.getItems().setAll(EnumExercicios.values());

        repositorioAluno = new ControladorRepositorioAluno();
        repositorioProfissional = new ControladorRepositorioProfissional();


    }
    private void genItems() { //PARA TESTES APENAS
        for(int i=0;i<10;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);
            int randomQntTreinos = ThreadLocalRandom.current().nextInt(1, 7);

            //lista.add(new String("Aluno_"+Integer.toString(i)));
            listaUsuariosObservavel.add(new Aluno(randomNum,"Aluno_"+Integer.toString(i),i+10,'M',i+50.6,i*1.70,0.7*(i/2),LocalDate.parse("10/10/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),178*i));

            for (int j = 0; j < randomQntTreinos; j++) {
                TreinoDiario novoTreino = new TreinoDiario();
                int randomQntExercicios = ThreadLocalRandom.current().nextInt(1, 10);

                for (int k = 0; k < randomQntExercicios; k++){
                    int randomIdEnumExercicio = ThreadLocalRandom.current().nextInt(0, EnumExercicios.values().length - 1);
                    int randomQntSeries = ThreadLocalRandom.current().nextInt(1, 6);
                    int randomQntRepeticoes = ThreadLocalRandom.current().nextInt(8, 15);
                    int randomCarga = ThreadLocalRandom.current().nextInt(10, 150);

                    Exercicios novoExercicio = new Exercicios(EnumExercicios.values()[randomIdEnumExercicio],randomQntSeries,String.valueOf(randomQntRepeticoes),randomCarga);
                    novoTreino.adicionarExercicio(novoExercicio);
                }
                listaUsuariosObservavel.get(i).adicionarTreino(novoTreino);
            }
        }
    }

    @FXML
    public void clickAluno(){
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        System.out.println("[DEBUG] Aluno: " + aluno);
        namePicker.setText(aluno.getNome());
        generoPicker.setText(String.valueOf(aluno.getGenero()));
        idadePicker.setText(String.valueOf(aluno.getIdade()));
        pesoPicker.setText(String.valueOf(aluno.getPeso()));
        alturaPicker.setText(String.valueOf(aluno.getAltura()));
        gorduraPicker.setText(String.valueOf(aluno.getPercentualGordura()));
        matriculaPicker.setValue(aluno.getDataMatricula());
        idProfPicker.setText(String.valueOf(aluno.getProfessor()));

        treinosTabPane.getTabs().clear();
        for (int i = 0; i < aluno.getSequenciaDeTreinos().size(); i++) {
            Tab novaTab = new Tab(String.format("Treino %d",i));
            ListView<Exercicios> listaExercicios = new ListView<Exercicios>();
            listaExercicios.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                                  @Override
                                                  public void handle(MouseEvent mouseEvent) {
                                                      Exercicios exercicio = listaExercicios.getSelectionModel().getSelectedItem();
                                                      exercicioEnumComboBox.setValue(exercicio.getTipo());
                                                      seriePicker.setText(String.valueOf(exercicio.getSerie()));
                                                      repeticaoPicker.setText(String.valueOf(exercicio.getRepeticao()));
                                                      cargaPicker.setText(String.valueOf(exercicio.getCarga()));
                                                  }
                                              });


                    listaExercicios.setItems(FXCollections.observableArrayList(aluno.getTreinoDiarioEspecifico(i).getExercicios()));
            novaTab.setContent(listaExercicios);
            treinosTabPane.getTabs().add(novaTab);
        }
        /*Tab novaTab = new Tab("Exercicio1");
        novaTab.setContent(listaUsuarios);
        treinosTabPane.getTabs().add(novaTab);*/

    }


    @FXML
    public void btnDeletePressed(ActionEvent eventoacao){
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        //int id = listaUsuarios.getSelectionModel().getSelectedIndex();
        listaUsuariosObservavel.remove(aluno);

        repositorioAluno.removerAluno(aluno);
        repositorioProfissional.atualizarProfissional(profissionalEscolhido);

        System.out.println("[DEBUG] Delete Pressionado");
    }



    @FXML
    public void btnUpdatePressed(ActionEvent eventoacao) {
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        aluno.setNome(namePicker.getText());
        aluno.setIdade(Integer.parseInt(idadePicker.getText()));
        aluno.setGenero(Character.toUpperCase(generoPicker.getText().charAt(0)));
        aluno.setPeso(Double.parseDouble(pesoPicker.getText()));
        aluno.setAltura(Double.parseDouble(alturaPicker.getText()));
        aluno.setPercentualGordura(Double.parseDouble(gorduraPicker.getText()));
        aluno.setDataMatricula(matriculaPicker.getValue());
        aluno.setProfessor(Long.valueOf(idProfPicker.getText()));

        aluno.adicionarPesoAoHistorico(Double.parseDouble(pesoPicker.getText()));
        aluno.adicionarGorudraAoHistorico(Double.parseDouble(gorduraPicker.getText()));

        repositorioAluno.atualizarAluno(aluno);

        
        listaUsuarios.setItems(listaUsuariosObservavel);
        System.out.println("[DEBUG] Update Pressionado");

        aluno.verHistoricos();
    }

    @FXML
    public void btnAddPressed(ActionEvent eventoacao) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);

        System.out.println("[DEBUG] Add Pressionado");


        //AQUI SERIA A FUNÇÃO PADRÃO PARA COLOCAR UM NOVO USUÁRIO NA LISTA
        Aluno alunoNovo = new Aluno((long) randomNum,namePicker.getText(),Integer.parseInt(idadePicker.getText()),Character.toUpperCase(generoPicker.getText().charAt(0)),Double.parseDouble(pesoPicker.getText()),Double.parseDouble(alturaPicker.getText()),Double.parseDouble(gorduraPicker.getText()),matriculaPicker.getValue(),Long.valueOf(idProfPicker.getText()));
        listaUsuariosObservavel.add(alunoNovo);

        repositorioAluno.adicionarAluno(alunoNovo);
        repositorioProfissional.atualizarProfissional(profissionalEscolhido);
    }

    @FXML
    public void btnClearPressed(ActionEvent eventoacao){
        namePicker.setText(null);
        idadePicker.setText(null);
        generoPicker.setText(null);
        pesoPicker.setText(null);
        alturaPicker.setText(null);
        gorduraPicker.setText(null);
        matriculaPicker.setValue(null);
        idProfPicker.setText(null);
        System.out.println("[DEBUG] Clear Pressionado");
    }

    @FXML
    public void btnNewPressed(ActionEvent eventoacao) {

        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        ObservableList<Tab> tabs = treinosTabPane.getTabs();
        int numeroExercicioNovo = 0;

        for (int i = 0; i < tabs.size(); i++ ) {
            numeroExercicioNovo += 1;
        }

        Tab novaTab = new Tab(String.format("Treino %d",numeroExercicioNovo));
        ListView<Exercicios> listaExercicios = new ListView<Exercicios>();
        aluno.adicionarTreino(new TreinoDiario());

        listaExercicios.setItems(FXCollections.observableArrayList(aluno.getTreinoDiarioEspecifico(aluno.getTreinoDiario().size() -1).getExercicios()));
        novaTab.setContent(listaExercicios);

        treinosTabPane.getTabs().add(novaTab);


    }

    @FXML
    public void btnRemovePressed(ActionEvent eventoacao) {
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        int tabAtualId = treinosTabPane.getSelectionModel().getSelectedIndex();
        Tab tabAtual = treinosTabPane.getSelectionModel().getSelectedItem();

        aluno.removerTreino(aluno.getTreinoDiarioEspecifico(tabAtualId));

        treinosTabPane.getTabs().remove(tabAtual);
    }

    @FXML
    public void btnAlterPressed(ActionEvent eventoacao) {
        Tab tabAtual = treinosTabPane.getSelectionModel().getSelectedItem();
        ListView<Exercicios> listaExercicios = (ListView<Exercicios>) tabAtual.getContent();
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        int tabAtualId = treinosTabPane.getSelectionModel().getSelectedIndex();

        Exercicios exercicioSelecionado = listaExercicios.getSelectionModel().getSelectedItem();

        exercicioSelecionado.setTipo(EnumExercicios.values()[exercicioEnumComboBox.getSelectionModel().getSelectedIndex()]);
        exercicioSelecionado.setSerie(Integer.parseInt(seriePicker.getText()));
        exercicioSelecionado.setRepeticao(repeticaoPicker.getText());
        exercicioSelecionado.setCarga(Integer.parseInt(cargaPicker.getText()));

        listaExercicios.setItems(FXCollections.observableArrayList(aluno.getTreinoDiarioEspecifico(tabAtualId).getExercicios()));

        tabAtual.setContent(listaExercicios);
    }

    @FXML
    public void btnInsertPressed(ActionEvent eventoacao) {
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        int tabAtualId = treinosTabPane.getSelectionModel().getSelectedIndex();
        Tab tabAtual = treinosTabPane.getSelectionModel().getSelectedItem();

        aluno.getTreinoDiarioEspecifico(tabAtualId).adicionarExercicio(new Exercicios(EnumExercicios.values()[exercicioEnumComboBox.getSelectionModel().getSelectedIndex()],Integer.parseInt(seriePicker.getText()),repeticaoPicker.getText(),Integer.parseInt(cargaPicker.getText())));

        System.out.print("[DEBUG] treinos do aluno: " + aluno.getTreinoDiarioEspecifico(tabAtualId));

        ListView<Exercicios> listaExercicios = new ListView<Exercicios>();
        listaExercicios.setItems(FXCollections.observableArrayList(aluno.getTreinoDiarioEspecifico(tabAtualId).getExercicios()));

        tabAtual.setContent(listaExercicios);

    }

    @FXML
    public void btnErasePressed(ActionEvent eventoacao) {
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        int tabAtualId = treinosTabPane.getSelectionModel().getSelectedIndex();
        Tab tabAtual = treinosTabPane.getSelectionModel().getSelectedItem();
        ListView<Exercicios> listaExercicios = (ListView<Exercicios>) tabAtual.getContent();
        Exercicios exercicioSelecionado = listaExercicios.getSelectionModel().getSelectedItem();

        System.out.print("[DEBUG] Exercicio do aluno: " + exercicioSelecionado + "\n");


        aluno.getTreinoDiarioEspecifico(tabAtualId).retirarExercicio(exercicioSelecionado);

        System.out.print("[DEBUG] treinos do aluno: " + aluno.getTreinoDiarioEspecifico(tabAtualId) + "\n");



        //listaExercicios.getItems().remove(exercicioSelecionado);
        listaExercicios.setItems(FXCollections.observableArrayList(aluno.getTreinoDiarioEspecifico(tabAtualId).getExercicios()));

        tabAtual.setContent(listaExercicios);

    }

    @FXML
    public void btnBackPressed(ActionEvent event) {

        ScreenManager.getInstance().showMainScreen();
        /*FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = null;
        try {
            root = loaderMain.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
    }

    @FXML
    public void btnSearchPressed(ActionEvent eventoacao) {
        ArrayList<Aluno> listaAlunosIDCompativel = new ArrayList<Aluno>();

        for (Aluno i : profissionalEscolhido.getAlunos()) {
            if ((i.getId() == Long.valueOf(searchTextFIeld.getText())) &&(searchTextFIeld.getText() != null && searchTextFIeld.getText() != "")) {
                listaAlunosIDCompativel.add(i);
            }
        }

        if (listaAlunosIDCompativel != null) {
            listaUsuariosObservavel.setAll(listaAlunosIDCompativel);
            listaUsuarios.setItems(listaUsuariosObservavel);
        }



    }

    @FXML
    public void btnListAllPressed(ActionEvent eventoacao) {
        listaUsuariosObservavel.setAll(profissionalEscolhido.getAlunos());
        listaUsuarios.setItems(listaUsuariosObservavel);

    }

    @FXML
    public void btnLstPendingPressed(ActionEvent eventoacao) {
        ArrayList<Aluno> listaAlunosPendente = new ArrayList<Aluno>();

        for (Aluno i : profissionalEscolhido.getAlunos()) {
            if (i.getPedirTrocaDoTreino()) {
                listaAlunosPendente.add(i);
            }
        }

        if (listaAlunosPendente != null) {
            listaUsuariosObservavel.setAll(listaAlunosPendente);
            listaUsuarios.setItems(listaUsuariosObservavel);
        }
    }

}
