package br.ufrpe.byte_monstro.byte_monstro_fx;

import com.dlsc.formsfx.model.structure.DateField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.*;

import java.time.LocalDate;

import java.util.concurrent.ThreadLocalRandom;

public class GeneralController {

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
    public void btnOkPressed(ActionEvent eventoacao) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);

        System.out.println("OK pressionado");

        String nomeAluno = namePicker.getText();
        int idadeAluno =Integer.parseInt(idadePicker.getText());
        char generoAluno = generoPicker.getText().charAt(0);
        double pesoAluno = Double.parseDouble(pesoPicker.getText());
        double alturaAluno = Double.parseDouble(alturaPicker.getText());
        double gorduraAluno = Double.parseDouble(gorduraPicker.getText());
        LocalDate matriculaAluno = matriculaPicker.getValue();


        System.out.println(nomeAluno +" "+ idadeAluno);

        //AQUI SERIA A FUNÇÃO PADRÃO PARA COLOCAR UM NOVO USUÁRIO NA LISTA
        //Aluno alunoNovo = new Aluno(randomNum,nomeAluno,idadeAluno,generoAluno,pesoAluno,alturaAluno,gorduraAluno,matriculaAluno);

    }
}
