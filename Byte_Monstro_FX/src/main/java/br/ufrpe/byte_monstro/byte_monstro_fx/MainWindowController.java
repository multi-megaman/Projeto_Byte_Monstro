package br.ufrpe.byte_monstro.byte_monstro_fx;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.*;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainWindowController {


    @FXML
    private TextField searchIdTextField;


    @FXML
    private ListView<Aluno> listaUsuarios;
    private ObservableList<Aluno> listaUsuariosObservavel;


    @FXML
    private ListView<Profissional> listaProfissionais;
    private ObservableList<Profissional> listaProfissionaisObservavel;



    @FXML
    private ListView<Administrador> listaAdministradores;
    private ObservableList<Administrador> listaAdministradoresObservavel;


    public void initialize(){

        listaUsuariosObservavel = FXCollections.observableArrayList();
        listaProfissionaisObservavel = FXCollections.observableArrayList();
        listaAdministradoresObservavel = FXCollections.observableArrayList();

        genItems();
        listaUsuarios.setItems(listaUsuariosObservavel);
        listaProfissionais.setItems(listaProfissionaisObservavel);
        listaAdministradores.setItems(listaAdministradoresObservavel);




        //registerEventHandlers();
    }
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
                    listaProfissionaisObservavel.get(i).adicionarAlunoNaLista(listaUsuariosObservavel.get(j));
                }
            }
            numeroNoNomeDoAluno += 10;
            }

            //ADMS
        for(int i=0;i<10;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);

            listaAdministradoresObservavel.add(new Administrador(randomNum,"ADM_"+Integer.toString(i),i+10,'M',i+50.6,i*1.70,0.7*(i/2),"abc123"));

        }
    }


    @FXML
    public void clickAluno(){
        Aluno aluno = listaUsuarios.getSelectionModel().getSelectedItem();
        System.out.println("[DEBUG] Aluno: " + aluno);

    }

   /* public void IrParaTelaDeLoginDoProfissional(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProfessionalWindow.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    public void clickProfissional() throws  IOException {

        Profissional profissionalEscolhido = listaProfissionais.getSelectionModel().getSelectedItem();

        listaProfissionais.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    System.out.println("[DEBUG] ir para a proxima tela");
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("ProfessionalWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage stage = (Stage)((Node)click.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
            }
        });
    }


    @FXML
    public void clickAdm() {

    }
    @FXML
    public void btnSearchPressed(ActionEvent acaoevento) {
        ArrayList<Aluno> listaAlunosId = new ArrayList<Aluno>();
        ArrayList<Profissional> listaProfissionaisId = new ArrayList<Profissional>();
        ArrayList<Administrador> listaAdministradoresId = new ArrayList<Administrador>();

        for (Aluno i : listaUsuariosObservavel) {
            if (i.getId() == Long.valueOf(searchIdTextField.getText())) {
                listaAlunosId.add(i);
            }
        }
        if (listaAlunosId != null) {
            listaUsuarios.setItems(FXCollections.observableArrayList(listaAlunosId));
        }

        for (Profissional i : listaProfissionaisObservavel) {
            if (i.getId() == Long.valueOf(searchIdTextField.getText())) {
                listaProfissionaisId.add(i);
            }
        }
        if (listaProfissionaisId != null) {
            listaProfissionais.setItems(FXCollections.observableArrayList(listaProfissionaisId));
        }

        for (Administrador i : listaAdministradoresObservavel) {
            if (i.getId() == Long.valueOf(searchIdTextField.getText())) {
                listaAdministradoresId.add(i);
            }
        }
        if (listaAdministradoresId != null) {
            listaAdministradores.setItems(FXCollections.observableArrayList(listaAdministradoresId));
        }

    }

    @FXML
    public void btnResetPressed(ActionEvent eventoacao) {
        listaUsuarios.setItems(listaUsuariosObservavel);
        listaProfissionais.setItems(listaProfissionaisObservavel);
        listaAdministradores.setItems(listaAdministradoresObservavel);
    }



}
