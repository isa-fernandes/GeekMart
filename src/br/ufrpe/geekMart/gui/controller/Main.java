package br.ufrpe.geekMart.gui.controller;




import br.ufrpe.geekMart.negocio.Fachada;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


import java.util.ArrayList;


public class Main extends Application {

    private static Main instancia;


    public static Main getInstancia(){
        if(instancia == null){
            instancia = new Main();
        }
        return instancia;
    }

    private static Stage stage;
    private static  Scene telaInicialDeslogadoScene;
    private static  Scene telaInicialLogadoScene;
    private static  Scene telaLoginScene;
    private static  Scene resultadoBuscaLogadoScene;
    private static  Scene resultadoBuscaDeslogadoScene;
    private static  Scene chatScene;
    private static  Scene cadastroClienteScene;
    private static  Scene cadastrarNovoClienteScene;
    private static  Scene cadastrarNovaLojaScene;
    private static  Scene cadastrarNovoAnuncioScene;
    private static  Scene alterarLojaScene;
    private static  Scene alterarClienteScene;
    private static  Scene alterarAnuncioScene;
    private static  Scene admDeletarLojaScene;
    private static  Scene admDeletarAnuncioScene;
    private static  Scene admCadastroScene;
    private static  Scene admCadastrarNovoAdmScene;
    private static  Scene admBloqueioDesbloqueioScene;
    private static  Scene admAlterarCadastroScene;
    private static  Scene meusAnunciosScene;
    private static  Scene minhasLojasScene;







    private String AUDIO_URL = getClass().getResource("/audio/HP.mp3").toString();




    @Override
    public void start(Stage primaryStage) throws Exception{





        stage = primaryStage;

        primaryStage.setTitle("GeekMart");

        Parent fxmlTelaInicialDeslogado = FXMLLoader.load(getClass().getResource("../view/TelaInicialDeslogado.fxml"));
        telaInicialDeslogadoScene = new Scene(fxmlTelaInicialDeslogado,900,600);

        Parent fxmlTelaInicialLogado = FXMLLoader.load(getClass().getResource("../view/TelaInicialLogado.fxml"));
        telaInicialLogadoScene = new Scene(fxmlTelaInicialLogado,900,600);

        Parent fxmlTelaLogin = FXMLLoader.load(getClass().getResource("../view/TelaLogin.fxml"));
        telaLoginScene = new Scene(fxmlTelaLogin,900,600);

        Parent fxmlResultadoBuscaLogado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado.fxml"));
        resultadoBuscaLogadoScene = new Scene(fxmlResultadoBuscaLogado,900,600);

        Parent fxmlResultadoBuscaDeslogado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado.fxml"));
        resultadoBuscaDeslogadoScene = new Scene(fxmlResultadoBuscaDeslogado,900,600);

        Parent fxmlChat = FXMLLoader.load(getClass().getResource("../view/Chat.fxml"));
        chatScene = new Scene(fxmlChat,900,600);

        Parent fxmlCadastrarNovoCliente = FXMLLoader.load(getClass().getResource("../view/CadastrarNovoCliente.fxml"));
        cadastrarNovoClienteScene = new Scene(fxmlCadastrarNovoCliente,900,600);

        Parent fxmlCadastroCliente = FXMLLoader.load(getClass().getResource("../view/CadastroCliente.fxml"));
        cadastroClienteScene = new Scene(fxmlCadastroCliente,900,600);

        Parent fxmlCadastrarNovaLoja = FXMLLoader.load(getClass().getResource("../view/CadastrarNovaLoja.fxml"));
        cadastrarNovaLojaScene = new Scene(fxmlCadastrarNovaLoja,900,600);

        Parent fxmlCadastrarNovoAnuncio = FXMLLoader.load(getClass().getResource("../view/CadastrarNovoAnuncio.fxml"));
        cadastrarNovoAnuncioScene = new Scene(fxmlCadastrarNovoAnuncio,900,600);

        Parent fxmlAlterarLoja = FXMLLoader.load(getClass().getResource("../view/AlterarLoja.fxml"));
        alterarLojaScene = new Scene(fxmlAlterarLoja,900,600);

        Parent fxmlAlterarCliente = FXMLLoader.load(getClass().getResource("../view/AlterarCliente.fxml"));
        alterarClienteScene = new Scene(fxmlAlterarCliente,900,600);

        Parent fxmlAlterarAnuncio = FXMLLoader.load(getClass().getResource("../view/AlterarAnuncio.fxml"));
        alterarAnuncioScene = new Scene(fxmlAlterarAnuncio,900,600);

        Parent fxmlAdmDeletarLoja = FXMLLoader.load(getClass().getResource("../view/AdmDeletarLoja.fxml"));
        admDeletarLojaScene = new Scene(fxmlAdmDeletarLoja,900,600);

        Parent fxmlAdmDeletarAnuncio = FXMLLoader.load(getClass().getResource("../view/AdmDeletarAnuncio.fxml"));
        admDeletarAnuncioScene = new Scene(fxmlAdmDeletarAnuncio,900,600);

        Parent fxmlAdmCadastro = FXMLLoader.load(getClass().getResource("../view/AdmCadastro.fxml"));
        admCadastroScene = new Scene(fxmlAdmCadastro,900,600);

        Parent fxmlAdmCadastrarNovoAdm = FXMLLoader.load(getClass().getResource("../view/AdmCadastrarNovoAdm.fxml"));
        admCadastrarNovoAdmScene = new Scene(fxmlAdmCadastrarNovoAdm,900,600);

        Parent fxmlAdmBloqueioDesbloqueio = FXMLLoader.load(getClass().getResource("../view/AdmBloqueioDesbloqueio.fxml"));
        admBloqueioDesbloqueioScene = new Scene(fxmlAdmBloqueioDesbloqueio,900,600);

        Parent fxmlAdmAlterarCadastro = FXMLLoader.load(getClass().getResource("../view/AdmAlterarCadastro.fxml"));
        admAlterarCadastroScene = new Scene(fxmlAdmAlterarCadastro,900,600);

        Parent fxmlMeusAnuncios = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios.fxml"));
        meusAnunciosScene = new Scene(fxmlMeusAnuncios,900,600);

        Parent fxmlMinhasLojas = FXMLLoader.load(getClass().getResource("../view/MinhasLojas.fxml"));
        minhasLojasScene = new Scene(fxmlMinhasLojas,900,600);




        AudioClip clip = new AudioClip(AUDIO_URL);// 1
        clip.play(); // 2
        primaryStage.setTitle("GeekMart");
        primaryStage.setScene(telaInicialDeslogadoScene);
        primaryStage.show();
    }





    public static void trocarTela(String trc, Object userData){
        switch (trc){
            case "telaInicialDeslogadoScene":
                stage.setScene(telaInicialDeslogadoScene);
                notificarAllListeners("telaInicialDeslogadoScene", userData);
                break;
            case "telaInicialLogadoScene":
                stage.setScene(telaInicialLogadoScene);
                notificarAllListeners("telaInicialLogadoScene", userData);
                break;
            case "telaLoginScene":
                stage.setScene(telaLoginScene);
                notificarAllListeners("telaLoginScene", userData);
                break;
            case "resultadoBuscaLogadoScene":
                stage.setScene(resultadoBuscaLogadoScene);
                notificarAllListeners("resultadoBuscaLogadoScene", userData);
                break;
            case "resultadoBuscaDeslogadoScene":
                stage.setScene(resultadoBuscaDeslogadoScene);
                notificarAllListeners("resultadoBuscaDeslogadoScene", userData);
                break;
            case "chatScene":
                stage.setScene(chatScene);
                notificarAllListeners("chatScene", userData);
                break;
            case "cadastrarNovoClienteScene":
                stage.setScene(cadastrarNovoClienteScene);
                notificarAllListeners("cadastrarNovoClienteScene", userData);
                break;
            case "cadastroClienteScene":
                stage.setScene(cadastroClienteScene);
                notificarAllListeners("cadastroClienteScene", userData);
                break;
            case "cadastrarNovaLojaScene":
                stage.setScene(cadastrarNovaLojaScene);
                notificarAllListeners("cadastrarNovaLojaScene", userData);
                break;
            case "cadastrarNovoAnuncioScene":
                stage.setScene(cadastrarNovoAnuncioScene);
                notificarAllListeners("cadastrarNovoAnuncioScene", userData);
                break;
            case "alterarLojaScene":
                stage.setScene(alterarLojaScene);
                notificarAllListeners("alterarLojaScene", userData);
                break;
            case "alterarClienteScene":
                stage.setScene(alterarClienteScene);
                notificarAllListeners("alterarClienteScene", userData);
                break;
            case "alterarAnuncioScene":
                stage.setScene(alterarAnuncioScene);
                notificarAllListeners("alterarAnuncioScene", userData);
                break;
            case "admDeletarLojaScene":
                stage.setScene(admDeletarLojaScene);
                notificarAllListeners("admDeletarLojaScene", userData);
                break;
            case "admDeletarAnuncioScene":
                stage.setScene(admDeletarAnuncioScene);
                notificarAllListeners("admDeletarAnuncioScene", userData);
                break;

            case "admCadastroScene":
                stage.setScene(admCadastroScene);
                notificarAllListeners("admCadastroScene", userData);
                break;
            case "admCadastrarNovoAdmScene":
                stage.setScene(admCadastrarNovoAdmScene);
                notificarAllListeners("admCadastrarNovoAdmScene", userData);
                break;
            case "admBloqueioDesbloqueioScene":
                stage.setScene(admBloqueioDesbloqueioScene);
                notificarAllListeners("admBloqueioDesbloqueioScene", userData);
                break;
            case "admAlterarCadastroScene":
                stage.setScene(admAlterarCadastroScene);
                notificarAllListeners("admAlterarCadastroScene", userData);
                break;

            case "meusAnunciosScene":
                stage.setScene(meusAnunciosScene);
                notificarAllListeners("meusAnunciosScene", userData);
                break;
            case "minhasLojasScene":
                stage.setScene(minhasLojasScene);
                notificarAllListeners("minhasLojasScene", userData);
                break;

        }

    }

    public static void trocarTela(String trc) {
        trocarTela(trc,null);
    }

    private static ArrayList<OnChangeScreen> listerners = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData) ;
    }

    public static  void addOnChangesScreenListener(OnChangeScreen newListener){
        listerners.add(newListener);
    }

    private static void notificarAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l: listerners)
            l.onScreenChanged(newScreen,userData);
    }




}
