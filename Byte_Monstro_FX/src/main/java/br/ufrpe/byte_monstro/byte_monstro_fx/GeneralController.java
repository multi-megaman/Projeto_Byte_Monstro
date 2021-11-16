package br.ufrpe.byte_monstro.byte_monstro_fx;

import com.dlsc.formsfx.model.structure.DateField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.time.format.DateTimeFormatter;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.*;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GeneralController {

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
    private ListView<Aluno> listaUsuarios;

    private ObservableList<Aluno> lista;

    public void initialize(){
        lista = FXCollections.observableArrayList();
        genItems();
        listaUsuarios.setItems(lista);



        //registerEventHandlers();
    }
    private void genItems() {
        for(int i=0;i<10;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);
            //lista.add(new String("Aluno_"+Integer.toString(i)));
            lista.add(new Aluno(randomNum,"Aluno_"+Integer.toString(i),i+10,'M',i+50.6,i*1.70,0.7*(i/2),LocalDate.parse("10/10/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),178*i));
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

    }

    @FXML
    public void btnDeletePressed(ActionEvent eventoacao){
        int id = listaUsuarios.getSelectionModel().getSelectedIndex();
        lista.remove(id);

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

        System.out.println("[DEBUG] Update Pressionado");
    }

    @FXML
    public void btnAddPressed(ActionEvent eventoacao) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);

        System.out.println("[DEBUG] Add Pressionado");


        //AQUI SERIA A FUNÇÃO PADRÃO PARA COLOCAR UM NOVO USUÁRIO NA LISTA
        Aluno alunoNovo = new Aluno((long) randomNum,namePicker.getText(),Integer.parseInt(idadePicker.getText()),Character.toUpperCase(generoPicker.getText().charAt(0)),Double.parseDouble(pesoPicker.getText()),Double.parseDouble(alturaPicker.getText()),Double.parseDouble(gorduraPicker.getText()),matriculaPicker.getValue(),Long.valueOf(idProfPicker.getText()));
        lista.add(alunoNovo);
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
}
