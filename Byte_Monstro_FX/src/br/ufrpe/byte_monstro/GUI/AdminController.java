package br.ufrpe.byte_monstro.GUI;

import br.ufrpe.byte_monstro.Exceptions.UsuarioJaCadastrado;
import br.ufrpe.byte_monstro.Exceptions.UsuarioNaoExiste;
import br.ufrpe.byte_monstro.Negocios.RepositorioManager;
import br.ufrpe.byte_monstro.Negocios.beans.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AdminController {

    @FXML private Tab profissionaisTabPane;
    @FXML private Tab alunosTabPane;
    @FXML private Tab admsTabPane;

    @FXML public TextField searchFieldP;
    @FXML public TextField searchFieldA;
    @FXML public TextField searchFieldAdm;

    @FXML private TextField nomePickerP;
    @FXML private TextField generoPickerP;
    @FXML private TextField idadePickerP;
    @FXML private TextField pesoPickerP;
    @FXML private TextField alturaPickerP;
    @FXML private TextField gorduraPickerP;

    @FXML private TextField nomePickerA;
    @FXML private TextField generoPickerA;
    @FXML private TextField idadePickerA;
    @FXML private TextField pesoPickerA;
    @FXML private TextField alturaPickerA;
    @FXML private TextField gorduraPickerA;
    @FXML private DatePicker matriculaPickerA;

    @FXML private TextField nomePickerAdm;
    @FXML private TextField generoPickerAdm;
    @FXML private TextField idadePickerAdm;
    @FXML private TextField pesoPickerAdm;
    @FXML private TextField alturaPickerAdm;
    @FXML private TextField gorduraPickerAdm;

    @FXML private TextField idProfPicker;
    @FXML public ChoiceBox academiaPicker;
    @FXML public ListView listaAlunosVinculados;
    private ObservableList<Aluno> listaAVObservavel;

    @FXML private TabPane treinosTabPane;

    @FXML private ListView<Aluno> listaUsuarios;
    private ObservableList<Aluno> listaUsuariosObservavel;

    @FXML private ListView<Profissional> listaProfissionais;
    private ObservableList<Profissional> listaProfissionaisObservavel;

    @FXML private ListView<Administrador> listaAdministradores;
    private ObservableList<Administrador> listaAdministradoresObservavel;

    public void atualizarListas() {
        listaUsuariosObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAlunos());
        listaProfissionaisObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarProfissionais());
        listaAdministradoresObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAdministradores());

        listaUsuarios.setItems(listaUsuariosObservavel);
        listaProfissionais.setItems(listaProfissionaisObservavel);
        listaAdministradores.setItems(listaAdministradoresObservavel);
    }

    public void initialize(){
        academiaPicker.setItems(FXCollections.observableArrayList(EnumAcademia.values()));
    }

    public void setListaAlunosVinculados(){
        listaAVObservavel = FXCollections.observableArrayList(listaProfissionais.getSelectionModel().getSelectedItem().getAlunos());
        listaAlunosVinculados.setItems(listaAVObservavel);

    }

    @FXML public void btnBackPressed(ActionEvent event) {
        ScreenManager.getInstance().showMainScreen();
    }


    @FXML public void clickProfissional(){
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
            ListView<Exercicio> listaExercicios = new ListView<Exercicio>();
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


    public void btnCadastrarPressed(ActionEvent actionEvent) throws UsuarioJaCadastrado {
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

    public void btnEditarPressed(ActionEvent actionEvent) throws UsuarioNaoExiste {
        if(profissionaisTabPane.isSelected()){
            Profissional professor = listaProfissionais.getSelectionModel().getSelectedItem();
            professor.setNome(nomePickerP.getText());
            professor.setIdade(Integer.parseInt(idadePickerP.getText()));
            professor.setGenero(Character.toUpperCase(generoPickerP.getText().charAt(0)));
            professor.setPeso(Double.parseDouble(pesoPickerP.getText()));
            professor.setAltura(Double.parseDouble(alturaPickerP.getText()));
            professor.setPercentualGordura(Double.parseDouble(gorduraPickerP.getText()));
            professor.setUnidadeAtual((EnumAcademia) academiaPicker.getValue());

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
            for(Profissional professor : RepositorioManager.getInstance().listarProfissionais()){
                if(professor.getId() == Long.parseLong(idProfPicker.getText())){
                    professor.adicionarAlunoNaLista(aluno);
                }else{
                    throw new UsuarioNaoExiste();
                }
            }
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

    public void btnDeletarPressed(ActionEvent actionEvent) throws UsuarioNaoExiste {
        if(profissionaisTabPane.isSelected()){
            RepositorioManager.getInstance().removerProfissional(listaProfissionais.getSelectionModel().getSelectedItem());
            atualizarListas();
            listaProfissionais.refresh();

        }else if(alunosTabPane.isSelected()){
            RepositorioManager.getInstance().removerAluno(listaUsuarios.getSelectionModel().getSelectedItem());
            atualizarListas();
            listaUsuarios.refresh();

        }else if(admsTabPane.isSelected()){
            RepositorioManager.getInstance().removerAdministrador(listaAdministradores.getSelectionModel().getSelectedItem());
            atualizarListas();
            listaAdministradores.refresh();
        }
    }

    public void btnSearchPressed(ActionEvent actionEvent) {
        String ID;
        if (profissionaisTabPane.isSelected()) {
            ArrayList<Profissional> listaProfissionaisId = new ArrayList<Profissional>();
            for (Profissional i : listaProfissionaisObservavel) {
                ID = String.valueOf(i.getId());
                if (ID.contains(searchFieldP.getText())) {
                    listaProfissionaisId.add(i);
                }
            }
            listaProfissionais.setItems(FXCollections.observableArrayList(listaProfissionaisId));

        } else if (alunosTabPane.isSelected()) {
            ArrayList<Aluno> listaAlunosId = new ArrayList<Aluno>();
            for (Aluno i : listaUsuariosObservavel) {
                ID = String.valueOf(i.getId());
                if (ID.contains(searchFieldA.getText())) {
                    listaAlunosId.add(i);
                }
            }
            listaUsuarios.setItems(FXCollections.observableArrayList(listaAlunosId));

        } else if (admsTabPane.isSelected()) {
            ArrayList<Administrador> listaAdministradoresId = new ArrayList<Administrador>();
            for (Administrador i : listaAdministradoresObservavel) {
                ID = String.valueOf(i.getId());
                if (ID.contains(searchFieldAdm.getText())) {
                    listaAdministradoresId.add(i);
                }
            }
            listaAdministradores.setItems(FXCollections.observableArrayList(listaAdministradoresId));
        }


    }



}
