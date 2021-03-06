package br.ufrpe.byte_monstro.GUI;

import br.ufrpe.byte_monstro.Exceptions.UsuarioJaCadastrado;
import br.ufrpe.byte_monstro.Exceptions.UsuarioNaoExiste;
import br.ufrpe.byte_monstro.Negocios.RepositorioManager;
import br.ufrpe.byte_monstro.Negocios.beans.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
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


    /*private ControladorRepositorioAluno repositorioAluno;

    private ControladorRepositorioProfissional repositorioProfissional;

    private ControladorRepositorioAdministrador repositorioAdministrador;*/


    public void atualizarListas() {
        listaUsuariosObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAlunos());
        listaProfissionaisObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarProfissionais());
        listaAdministradoresObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAdministradores());

        //genItems();
        listaUsuarios.setItems(listaUsuariosObservavel);
        listaProfissionais.setItems(listaProfissionaisObservavel);
        listaAdministradores.setItems(listaAdministradoresObservavel);
    }

    public void initialize(){

        /*repositorioAluno = new ControladorRepositorioAluno();
        repositorioProfissional = new ControladorRepositorioProfissional();
        repositorioAdministrador = new ControladorRepositorioAdministrador();*/




        listaUsuariosObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAlunos());
        listaProfissionaisObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarProfissionais());
        listaAdministradoresObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAdministradores());

        //genItems();
        listaUsuarios.setItems(listaUsuariosObservavel);
        listaProfissionais.setItems(listaProfissionaisObservavel);
        listaAdministradores.setItems(listaAdministradoresObservavel);
    }
    private void genItems() throws UsuarioJaCadastrado, UsuarioNaoExiste { //PARA TESTES APENAS
        int numeroNoNomeDoAluno = 0;


        //PROFISSIONAIS ----------
        for(int i=0;i<10;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);
            int randomAcademia = ThreadLocalRandom.current().nextInt(0, EnumAcademia.values().length -1);

            //lista.add(new String("Aluno_"+Integer.toString(i)));
            RepositorioManager.getInstance().adicionarProfissional(new Profissional(randomNum,"Professor_"+Integer.toString(i),i+10,'M',i+50.6,i*1.70,0.7*(i/2),"1", EnumAcademia.values()[randomAcademia]));
            listaProfissionaisObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarProfissionais());


            //ALUNOS -----------
            for(int j=0 + numeroNoNomeDoAluno;j<10 + numeroNoNomeDoAluno;j++){
                int randomNumAluno = ThreadLocalRandom.current().nextInt(1, 1000000);
                int randomQntTreinos = ThreadLocalRandom.current().nextInt(1, 7);

                //lista.add(new String("Aluno_"+Integer.toString(i)));
                RepositorioManager.getInstance().adicionarAluno(new Aluno(randomNumAluno,"Aluno_"+Integer.toString(j),j+10,'M',j+50.6,j*1.70,0.7*(j/2),LocalDate.parse("10/10/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),listaProfissionaisObservavel.get(i).getId()));
                listaUsuariosObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAlunos());

                for (int l = 0; l < randomQntTreinos; l++) {
                    TreinoDiario novoTreino = new TreinoDiario();
                    int randomQntExercicios = ThreadLocalRandom.current().nextInt(1, 10);

                    for (int k = 0; k < randomQntExercicios; k++){
                        int randomIdEnumExercicio = ThreadLocalRandom.current().nextInt(0, EnumExercicio.values().length - 1);
                        int randomQntSeries = ThreadLocalRandom.current().nextInt(1, 6);
                        int randomQntRepeticoes = ThreadLocalRandom.current().nextInt(8, 15);
                        int randomCarga = ThreadLocalRandom.current().nextInt(10, 150);

                        Exercicio novoExercicio = new Exercicio(EnumExercicio.values()[randomIdEnumExercicio],randomQntSeries,String.valueOf(randomQntRepeticoes),randomCarga);
                        novoTreino.adicionarExercicio(novoExercicio);
                    }
                    listaUsuariosObservavel.get(j).adicionarTreino(novoTreino);
                    RepositorioManager.getInstance().atualizarAluno(listaUsuariosObservavel.get(j));

                }
                listaProfissionaisObservavel.get(i).adicionarAlunoNaLista(listaUsuariosObservavel.get(j));
                RepositorioManager.getInstance().atualizarProfissional(listaProfissionaisObservavel.get(i));
                listaProfissionaisObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarProfissionais());

            }
            numeroNoNomeDoAluno += 10;
            }

            //ADMS
        for(int i=0;i<10;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000000);

            RepositorioManager.getInstance().adicionarAdministrador(new Administrador(randomNum,"ADM_"+Integer.toString(i),i+10,'M',i+50.6,i*1.70,0.7*(i/2),"2"));
            listaAdministradoresObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAdministradores());

        }
    }


    //PARA TESTE APENAS
    /*@FXML
    public void btnTestePressed(ActionEvent acaoevento) throws UsuarioNaoExiste, UsuarioJaCadastrado {
        //PARA TESTE APENAS
        //repositorioProfissional.adicionarProfissional(new Profissional(1010,"Professor_Teste",10+10,'M',10+50.6,10*1.70,0.7*(10/2),"1",EnumAcademias.values()[1]));
        genItems();

        listaUsuariosObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAlunos());
        listaUsuarios.setItems(listaUsuariosObservavel);

        listaProfissionaisObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarProfissionais());
        listaProfissionais.setItems(listaProfissionaisObservavel);


        //repositorioAdministrador.adicionarAdministrador(new Administrador(1010,"ADM_Teste",10+10,'F',10+50.6,10*1.70,0.7*(10/2),"1"));

        listaAdministradoresObservavel = FXCollections.observableArrayList(RepositorioManager.getInstance().listarAdministradores());
        listaAdministradores.setItems(listaAdministradoresObservavel);

    }
    */
    @FXML
    public void clickAluno()  {

        //IR PARA A JANELA DO ALUNO-------------------


                            /*FXMLLoader loadAluno = new FXMLLoader(getClass().getResource("AlunoWindow.fxml"));


                            Parent rootAluno = loadAluno.load();


                            AlunoController alunoController = loadAluno.getController();
                            alunoController.setAluno(alunoEscolhido);


                            Stage stage = (Stage)((Node)ev.getSource()).getScene().getWindow();
                            Scene scene = new Scene(rootAluno);
                            stage.setScene(scene);
                            stage.show();


                            System.out.println("[DEBUG] ir para a tela do Aluno.");*/

        listaUsuarios.setOnMouseClicked(new EventHandler<MouseEvent>() {




            @Override
            public void handle(MouseEvent click) {

                //AtomicBoolean confirmar = new AtomicBoolean(false);


                if (click.getClickCount() == 2) {
                    //POPUP----------------------------

                    Aluno alunoEscolhido = listaUsuarios.getSelectionModel().getSelectedItem();
                    //System.out.println(alunoEscolhido);
                        ScreenManager.getInstance().showAlunoScreen(alunoEscolhido);
                            //-------------------

                            //Stage stageAtual = (Stage) listaUsuarios.getScene().getWindow();
                            //stageAtual.close();
                            /*FXMLLoader loaderAluno = new FXMLLoader(getClass().getResource("AlunoWindow.fxml"));

                            Parent rootAluno = null;
                            try {
                                rootAluno = loaderAluno.load();
                            } catch (IOException t) {
                                t.printStackTrace();
                            }

                            AlunoController alunoController = loaderAluno.getController();
                            alunoController.setAluno(alunoEscolhido);
                            alunoController.genItens();
                            Stage stage = (Stage)((Node)click.getSource()).getScene().getWindow();
                            Scene scene = new Scene(rootAluno);
                            stage.setScene(scene);
                            stage.show();


                            System.out.println("[DEBUG] ir para a tela do Aluno. ");*/

                        }

                        //confirmar.set(true);
                        //System.out.print("[DEBUG] FOI PARA A TELA DE PROFISSIONAL");
                    }
                    /*btnConfirmar.setOnAction(new EventHandler<ActionEvent>() {
                    });*/



                    //---------------------------------


        });
    }


    @FXML
    public void clickProfissional() throws  IOException {




        listaProfissionais.setOnMouseClicked(new EventHandler<MouseEvent>() {



            @Override
            public void handle(MouseEvent click) {

                //AtomicBoolean confirmar = new AtomicBoolean(false);


                if (click.getClickCount() == 2) {
                    //POPUP----------------------------
                    Profissional profissionalEscolhido = listaProfissionais.getSelectionModel().getSelectedItem();

                    Label labelPopUp = new Label("Digite sua senha:");
                    Button btnConfirmar = new Button("Fazer Login");
                    PasswordField senhaInput = new PasswordField();


                    btnConfirmar.setOnAction(e -> {
                                System.out.println("[DEBUG] senha digitada: "+ senhaInput.getText());
                                if(profissionalEscolhido.getSenha().equals(senhaInput.getText())) {
                                    //IR PARA A JANELA DO PROFiSSIONAL-------------------
                                    Stage stageAtual = (Stage) btnConfirmar.getScene().getWindow();
                                    stageAtual.close();

                                    ScreenManager.getInstance().showProfissionalScreen(FXCollections.observableArrayList(profissionalEscolhido.getAlunos()),profissionalEscolhido);
                                    /*
                                        FXMLLoader loaderProfissional = new FXMLLoader(getClass().getResource("ProfessionalWindow.fxml"));

                                        Parent rootProfissional = null;
                                        try {
                                            rootProfissional = loaderProfissional.load();
                                        } catch (IOException t) {
                                            t.printStackTrace();
                                        }

                                        ProfessionalController professionalController = loaderProfissional.getController();
                                        professionalController.setAll(FXCollections.observableArrayList(profissionalEscolhido.getAlunos()),profissionalEscolhido);

                                        Stage stage = (Stage)((Node)click.getSource()).getScene().getWindow();
                                        Scene scene = new Scene(rootProfissional);
                                        stage.setScene(scene);
                                        stage.show();


                                        System.out.println("[DEBUG] ir para a tela do professor. lista: " + FXCollections.observableArrayList(profissionalEscolhido.getAlunos()));*/

                                    }
                                else {
                                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                                    errorAlert.setHeaderText("!SENHA INCORRETA!");
                                    errorAlert.setContentText("A SENHA DIGITADA EST?? INCORRETA, TENTE NOVAMENTE");
                                    errorAlert.showAndWait();
                                }


                                //confirmar.set(true);
                                //System.out.print("[DEBUG] FOI PARA A TELA DE PROFISSIONAL");
                            });
                    /*btnConfirmar.setOnAction(new EventHandler<ActionEvent>() {
                    });*/

                    FlowPane flowPane = new FlowPane();
                    flowPane.getChildren().addAll(labelPopUp,senhaInput,btnConfirmar);
                    flowPane.setPadding(new Insets(20));
                    flowPane.setVgap(20);

                    Scene popUpLogin = new Scene(flowPane,250,150);
                    Stage stagePopUp = new Stage();
                    stagePopUp.initModality(Modality.APPLICATION_MODAL);
                    stagePopUp.setScene(popUpLogin);
                    stagePopUp.show();


                    //---------------------------------




                }
            }

        });
    }


    @FXML
    public void clickAdm() throws IOException{

        listaAdministradores.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                //AtomicBoolean confirmar = new AtomicBoolean(false);+
                if (click.getClickCount() == 2) {
                    //POPUP----------------------------
                    Administrador admEscolhido = listaAdministradores.getSelectionModel().getSelectedItem();

                    Label labelPopUp = new Label("Digite sua senha:");
                    Button btnConfirmar = new Button("Fazer Login");
                    PasswordField senhaInput = new PasswordField();
                    btnConfirmar.setOnAction(e -> {
                        System.out.println("[DEBUG] senha digitada: "+ senhaInput.getText());
                        if(admEscolhido.getSenha().equals(senhaInput.getText())) {
                            //IR PARA A JANELA DO PROFiSSIONAL-------------------
                            Stage stageAtual = (Stage) btnConfirmar.getScene().getWindow();
                            stageAtual.close();

                            ScreenManager.getInstance().showAdmScreen();
                        }
                        else {
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setHeaderText("!SENHA INCORRETA!");
                            errorAlert.setContentText("A SENHA DIGITADA EST?? INCORRETA, TENTE NOVAMENTE");
                            errorAlert.showAndWait();
                        }
                    });

                    FlowPane flowPane = new FlowPane();
                    flowPane.getChildren().addAll(labelPopUp,senhaInput,btnConfirmar);
                    flowPane.setPadding(new Insets(20));
                    flowPane.setVgap(20);

                    Scene popUpLogin = new Scene(flowPane,250,150);
                    Stage stagePopUp = new Stage();
                    stagePopUp.initModality(Modality.APPLICATION_MODAL);
                    stagePopUp.setScene(popUpLogin);
                    stagePopUp.show();

                }
            }
        });
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
