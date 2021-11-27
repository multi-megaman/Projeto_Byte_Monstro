package br.ufrpe.byte_monstro.byte_monstro_fx;

import br.ufrpe.byte_monstro.byte_monstro_dados.IRepositorioUsuario;
import com.dlsc.formsfx.model.structure.DateField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.concurrent.ThreadLocalRandom;

public class AdminController {

    @FXML
    public Tab profissionaisTabPane;
    @FXML
    private Tab alunosTabPane;
    @FXML
    private Tab admsTabPane;

    @FXML
    public TextField searchFieldP;
    @FXML
    public TextField searchFieldA;
    @FXML
    public TextField searchFieldAdm;

    @FXML
    private TextField nomePickerP;
    @FXML
    private TextField generoPickerP;
    @FXML
    private TextField idadePickerP;
    @FXML
    private TextField pesoPickerP;
    @FXML
    private TextField alturaPickerP;
    @FXML
    private TextField gorduraPickerP;

    @FXML
    private TextField nomePickerA;
    @FXML
    private TextField generoPickerA;
    @FXML
    private TextField idadePickerA;
    @FXML
    private TextField pesoPickerA;
    @FXML
    private TextField alturaPickerA;
    @FXML
    private TextField gorduraPickerA;
    @FXML
    private DatePicker matriculaPickerA;

    @FXML
    private TextField nomePickerAdm;
    @FXML
    private TextField generoPickerAdm;
    @FXML
    private TextField idadePickerAdm;
    @FXML
    private TextField pesoPickerAdm;
    @FXML
    private TextField alturaPickerAdm;
    @FXML
    private TextField gorduraPickerAdm;

    @FXML
    private TextField idProfPicker;
    @FXML
    public ChoiceBox academiaPicker;
    @FXML
    public ListView listaAlunosVinculados;



    @FXML
    private TabPane treinosTabPane;

    @FXML
    private ListView<Aluno> listaUsuarios;
    private ObservableList<Aluno> listaUsuariosObservavel;

    @FXML
    private ListView<Profissional> listaProfissionais;
    private ObservableList<Profissional> listaProfissionaisObservavel;

    @FXML
    private ListView<Administrador> listaAdministradores;
    private ObservableList<Administrador> listaAdministradoresObservavel;



    private void genItems() { //PARA TESTES APENAS
        int numeroNoNomeDoAluno = 0;


        //PROFISSIONAIS ----------
        for(int i=0;i<10;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);
            int randomAcademia = ThreadLocalRandom.current().nextInt(0, EnumAcademias.values().length -1);

            //lista.add(new String("Aluno_"+Integer.toString(i)));
            listaProfissionaisObservavel.add(new Profissional(randomNum,"Professor_"+Integer.toString(i),i+10,'M',i+50.6,i*1.70,0.7*(i/2),"abc" + Integer.toString(i),EnumAcademias.values()[randomAcademia]));

            //ALUNOS -----------
            for(int j=0 + numeroNoNomeDoAluno;j<10 + numeroNoNomeDoAluno;j++){
                int randomNumAluno = ThreadLocalRandom.current().nextInt(1, 1000000);
                int randomQntTreinos = ThreadLocalRandom.current().nextInt(1, 7);

                //lista.add(new String("Aluno_"+Integer.toString(i)));
                listaUsuariosObservavel.add(new Aluno(randomNumAluno,"Aluno_"+Integer.toString(j),j+10,'M',j+50.6,j*1.70,0.7*(j/2),LocalDate.parse("10/10/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),listaProfissionaisObservavel.get(i).getId()));

                for (int l = 0; l < randomQntTreinos; l++) {
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
                    listaUsuariosObservavel.get(j).adicionarTreino(novoTreino);

                }
                listaProfissionaisObservavel.get(i).adicionarAlunoNaLista(listaUsuariosObservavel.get(j));
            }
            numeroNoNomeDoAluno += 10;
        }

        //ADMS
        for(int i=0;i<10;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);

            listaAdministradoresObservavel.add(new Administrador(randomNum,"ADM_"+Integer.toString(i),i+10,'M',i+50.6,i*1.70,0.7*(i/2),"abc123"));

        }
    }

    public void atualizarListas() {
        listaUsuariosObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAlunos());
        listaProfissionaisObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarProfissionais());
        listaAdministradoresObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAdministradores());

        listaUsuarios.setItems(listaUsuariosObservavel);
        listaProfissionais.setItems(listaProfissionaisObservavel);
        listaAdministradores.setItems(listaAdministradoresObservavel);
    }

    public void initialize(){
        academiaPicker.setItems(FXCollections.observableArrayList(EnumAcademias.values()));
        /*listaUsuariosObservavel = FXCollections.observableArrayList();
        listaProfissionaisObservavel = FXCollections.observableArrayList();
        listaAdministradoresObservavel = FXCollections.observableArrayList();
        genItems();
        listaUsuarios.setItems(listaUsuariosObservavel);
        listaProfissionais.setItems(listaProfissionaisObservavel);
        listaAdministradores.setItems(listaAdministradoresObservavel);*/
    }



    @FXML
    public void btnBackPressed(ActionEvent event) {
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



    @FXML
    public void clickProfissional(){
        Profissional professor = listaProfissionais.getSelectionModel().getSelectedItem();
        System.out.println("[DEBUG] Prof: " + professor);
        nomePickerP.setText(professor.getNome());
        generoPickerP.setText(String.valueOf(professor.getGenero()));
        idadePickerP.setText(String.valueOf(professor.getIdade()));
        pesoPickerP.setText(String.valueOf(professor.getPeso()));
        alturaPickerP.setText(String.valueOf(professor.getAltura()));
        gorduraPickerP.setText(String.valueOf(professor.getPercentualGordura()));
        academiaPicker.setValue(professor.getUnidadeAtual());
    }

    @FXML
    public void clickAluno(){
        Aluno aluno = (Aluno) listaUsuarios.getSelectionModel().getSelectedItem();
        System.out.println("[DEBUG] Aluno: " + aluno);
        nomePickerA.setText(aluno.getNome());
        generoPickerA.setText(String.valueOf(aluno.getGenero()));
        idadePickerA.setText(String.valueOf(aluno.getIdade()));
        pesoPickerA.setText(String.valueOf(aluno.getPeso()));
        alturaPickerA.setText(String.valueOf(aluno.getAltura()));
        gorduraPickerA.setText(String.valueOf(aluno.getPercentualGordura()));
        matriculaPickerA.setValue(aluno.getDataMatricula());
        idProfPicker.setText(String.valueOf(aluno.getProfessor()));

        treinosTabPane.getTabs().clear();
        for (int i = 0; i < aluno.getSequenciaDeTreinos().size(); i++) {
            Tab novaTab = new Tab(String.format("Treino %d",i));
            ListView<Exercicios> listaExercicios = new ListView<Exercicios>();
            listaExercicios.setItems(FXCollections.observableArrayList(aluno.getTreinoDiarioEspecifico(i).getExercicios()));
            novaTab.setContent(listaExercicios);
            treinosTabPane.getTabs().add(novaTab);
        }
    }

    @FXML
    public void clickAdministrador(){
        Administrador administrador = listaAdministradores.getSelectionModel().getSelectedItem();
        System.out.println("[DEBUG] Adm: " + administrador);
        nomePickerAdm.setText(administrador.getNome());
        generoPickerAdm.setText(String.valueOf(administrador.getGenero()));
        idadePickerAdm.setText(String.valueOf(administrador.getIdade()));
        pesoPickerAdm.setText(String.valueOf(administrador.getPeso()));
        alturaPickerAdm.setText(String.valueOf(administrador.getAltura()));
        gorduraPickerAdm.setText(String.valueOf(administrador.getPercentualGordura()));

    }



    public void btnCadastrarPressed(ActionEvent actionEvent) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);
        if(profissionaisTabPane.isSelected()){
            Profissional novoProfissional = new Profissional();
            novoProfissional.setId(randomNum);
            novoProfissional.setNome("");
            RepositorioManager.getInstance().adicionarProfissional(novoProfissional);
            atualizarListas();
            //listaProfissionaisObservavel.add(novoProfissional);
        }else if(alunosTabPane.isSelected()){
            Aluno novoAluno = new Aluno();
            novoAluno.setId(randomNum);
            novoAluno.setNome("");
            RepositorioManager.getInstance().adicionarAluno(novoAluno);
            atualizarListas();
            //listaUsuariosObservavel.add(novoAluno);
        }else if(admsTabPane.isSelected()){
            Administrador novoAdministrador = new Administrador();
            novoAdministrador.setId(randomNum);
            novoAdministrador.setNome("");
            RepositorioManager.getInstance().adicionarAdministrador(novoAdministrador);
            atualizarListas();
            //listaAdministradoresObservavel.add(novoAdministrador);
        }
    }

    public void btnEditarPressed(ActionEvent actionEvent) {
        if(profissionaisTabPane.isSelected()){
            Profissional professor = listaProfissionais.getSelectionModel().getSelectedItem();
            professor.setNome(nomePickerP.getText());
            professor.setIdade(Integer.parseInt(idadePickerP.getText()));
            professor.setGenero(Character.toUpperCase(generoPickerP.getText().charAt(0)));
            professor.setPeso(Double.parseDouble(pesoPickerP.getText()));
            professor.setAltura(Double.parseDouble(alturaPickerP.getText()));
            professor.setPercentualGordura(Double.parseDouble(gorduraPickerP.getText()));
            professor.setUnidadeAtual((EnumAcademias) academiaPicker.getValue());

            RepositorioManager.getInstance().atualizarProfissional(professor);
            //atualizarListas();
            listaProfissionais.refresh();

        }else if(alunosTabPane.isSelected()){
            Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
            aluno.setNome(nomePickerA.getText());
            aluno.setIdade(Integer.parseInt(idadePickerA.getText()));
            aluno.setGenero(Character.toUpperCase(generoPickerA.getText().charAt(0)));
            aluno.setPeso(Double.parseDouble(pesoPickerA.getText()));
            aluno.setAltura(Double.parseDouble(alturaPickerA.getText()));
            aluno.setPercentualGordura(Double.parseDouble(gorduraPickerA.getText()));
            aluno.setDataMatricula(matriculaPickerA.getValue());
            aluno.setProfessor(Long.parseLong(idProfPicker.getText()));

            RepositorioManager.getInstance().atualizarAluno(aluno);
            //atualizarListas();

            listaUsuarios.refresh();

        }else if(admsTabPane.isSelected()){
            Administrador administrador = listaAdministradores.getSelectionModel().getSelectedItem();
            administrador.setNome(nomePickerAdm.getText());
            administrador.setIdade(Integer.parseInt(idadePickerAdm.getText()));
            administrador.setGenero(Character.toUpperCase(generoPickerAdm.getText().charAt(0)));
            administrador.setPeso(Double.parseDouble(pesoPickerAdm.getText()));
            administrador.setAltura(Double.parseDouble(alturaPickerAdm.getText()));
            administrador.setPercentualGordura(Double.parseDouble(gorduraPickerAdm.getText()));

            RepositorioManager.getInstance().atualizarAdministrador(administrador);
            //atualizarListas();

            listaAdministradores.refresh();
        }

    }

    public void btnDeletarPressed(ActionEvent actionEvent){
        if(profissionaisTabPane.isSelected()){
            Profissional profissonal = listaProfissionais.getSelectionModel().getSelectedItem();

            RepositorioManager.getInstance().removerProfissional(profissonal);
            //atualizarListas();
            listaProfissionais.refresh();
            //listaProfissionaisObservavel.remove(id);
        }else if(alunosTabPane.isSelected()){
            Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();

            RepositorioManager.getInstance().removerAluno(aluno);
            //atualizarListas();
            listaUsuarios.refresh();
            //listaUsuariosObservavel.remove(id);
        }else if(admsTabPane.isSelected()){
            Administrador administrador = listaAdministradores.getSelectionModel().getSelectedItem();

            RepositorioManager.getInstance().atualizarAdministrador(administrador);
            //atualizarListas();
            listaAdministradores.refresh();
            // listaAdministradoresObservavel.remove(id);
        }
    }

    public void btnSearchPressed(ActionEvent actionEvent) {
        if (profissionaisTabPane.isSelected()) {
            ArrayList<Profissional> listaProfissionaisId = new ArrayList<Profissional>();
            for (Profissional i : listaProfissionaisObservavel) {
                if (i.getId() == Long.parseLong(searchFieldP.getText())) {
                    listaProfissionaisId.add(i);
                }
            }
            if (listaProfissionaisId != null) {
                listaProfissionais.setItems(FXCollections.observableArrayList(listaProfissionaisId));
            }

        } else if (alunosTabPane.isSelected()) {
            ArrayList<Aluno> listaAlunosId = new ArrayList<Aluno>();
            for (Aluno i : listaUsuariosObservavel) {
                if (i.getId() == Long.parseLong(searchFieldA.getText())) {
                    listaAlunosId.add(i);
                }
            }
            if (listaAlunosId != null) {
                listaUsuarios.setItems(FXCollections.observableArrayList(listaAlunosId));
            }
        } else if (admsTabPane.isSelected()) {
            ArrayList<Administrador> listaAdministradoresId = new ArrayList<Administrador>();
            for (Administrador i : listaAdministradoresObservavel) {
                if (i.getId() == Long.parseLong(searchFieldAdm.getText())) {
                    listaAdministradoresId.add(i);
                }
            }
            if (listaAdministradoresId != null) {
                listaAdministradores.setItems(FXCollections.observableArrayList(listaAdministradoresId));
            }
        }


    }



}
