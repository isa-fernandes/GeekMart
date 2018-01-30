package br.ufrpe.geekMart.gui.controller;




import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


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
    private static  Scene lojaScene;
    private static  Scene anuncioScene;
    private static  Scene telaInicialDeslogadoScene;
    private static  Scene telaInicialLogadoScene;
    private static  Scene telaLoginScene;
    private static  Scene buscaLojasDeslogado6Scene;
    private static  Scene buscaLojasDeslogado5Scene;
    private static  Scene buscaLojasDeslogado4Scene;
    private static  Scene buscaLojasDeslogado3Scene;
    private static  Scene buscaLojasDeslogado2Scene;
    private static  Scene buscaLojasDeslogado1Scene;
    private static  Scene buscaLojasDeslogado0Scene;
    private static  Scene buscaLojasLogado6Scene;
    private static  Scene buscaLojasLogado5Scene;
    private static  Scene buscaLojasLogado4Scene;
    private static  Scene buscaLojasLogado3Scene;
    private static  Scene buscaLojasLogado2Scene;
    private static  Scene buscaLojasLogado1Scene;
    private static  Scene buscaLojasLogado0Scene;
    private static  Scene meusAnuncios6Scene;
    private static  Scene meusAnuncios5Scene;
    private static  Scene meusAnuncios4Scene;
    private static  Scene meusAnuncios3Scene;
    private static  Scene meusAnuncios2Scene;
    private static  Scene meusAnuncios1Scene;
    private static  Scene meusAnuncios0Scene;
    private static  Scene minhasLojas6Scene;
    private static  Scene minhasLojas5Scene;
    private static  Scene minhasLojas4Scene;
    private static  Scene minhasLojas3Scene;
    private static  Scene minhasLojas2Scene;
    private static  Scene minhasLojas1Scene;
    private static  Scene minhasLojas0Scene;
    private static  Scene resultadoBuscaDeslogado6Scene;
    private static  Scene resultadoBuscaDeslogado5Scene;
    private static  Scene resultadoBuscaDeslogado4Scene;
    private static  Scene resultadoBuscaDeslogado3Scene;
    private static  Scene resultadoBuscaDeslogado2Scene;
    private static  Scene resultadoBuscaDeslogado1Scene;
    private static  Scene resultadoBuscaDeslogado0Scene;
    private static  Scene resultadoBuscaLogado6Scene;
    private static  Scene resultadoBuscaLogado5Scene;
    private static  Scene resultadoBuscaLogado4Scene;
    private static  Scene resultadoBuscaLogado3Scene;
    private static  Scene resultadoBuscaLogado2Scene;
    private static  Scene resultadoBuscaLogado1Scene;
    private static  Scene resultadoBuscaLogado0Scene;
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

    Fachada fachada = Fachada.getInstancia();



    private String AUDIO_URL = getClass().getResource("/audio/HP.mp3").toString();




    @Override
    public void start(Stage primaryStage) throws Exception{




        stage = primaryStage;

        primaryStage.setTitle("GeekMart");

        Parent fxmlAnuncio = FXMLLoader.load(getClass().getResource("../view/Anuncio.fxml"));
        anuncioScene = new Scene(fxmlAnuncio,900,600);

        Parent fxmlLoja = FXMLLoader.load(getClass().getResource("../view/Loja.fxml"));
        lojaScene = new Scene(fxmlLoja,900,600);

        Parent fxmlTelaInicialDeslogado = FXMLLoader.load(getClass().getResource("../view/TelaInicialDeslogado.fxml"));
        telaInicialDeslogadoScene = new Scene(fxmlTelaInicialDeslogado,900,600);

        Parent fxmlTelaInicialLogado = FXMLLoader.load(getClass().getResource("../view/TelaInicialLogado.fxml"));
        telaInicialLogadoScene = new Scene(fxmlTelaInicialLogado,900,600);

        Parent fxmlTelaLogin = FXMLLoader.load(getClass().getResource("../view/TelaLogin.fxml"));
        telaLoginScene = new Scene(fxmlTelaLogin,900,600);

        Parent fxmlResultadoBusca6Logado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado6.fxml"));
        resultadoBuscaLogado6Scene = new Scene(fxmlResultadoBusca6Logado,900,600);

        Parent fxmlResultadoBusca5Logado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado5.fxml"));
        resultadoBuscaLogado5Scene = new Scene(fxmlResultadoBusca5Logado,900,600);

        Parent fxmlResultadoBusca4Logado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado4.fxml"));
        resultadoBuscaLogado4Scene = new Scene(fxmlResultadoBusca4Logado,900,600);

        Parent fxmlResultadoBusca3Logado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado3.fxml"));
        resultadoBuscaLogado3Scene = new Scene(fxmlResultadoBusca3Logado,900,600);

        Parent fxmlResultadoBusca2Logado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado2.fxml"));
       resultadoBuscaLogado2Scene = new Scene(fxmlResultadoBusca2Logado,900,600);

       Parent fxmlResultadoBusca1Logado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado1.fxml"));
       resultadoBuscaLogado1Scene = new Scene(fxmlResultadoBusca1Logado,900,600);

        Parent fxmlResultadoBusca0Logado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaLogado0.fxml"));
        resultadoBuscaLogado0Scene = new Scene(fxmlResultadoBusca0Logado,900,600);

        Parent fxmlResultadoBuscaDeslogado = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado0.fxml"));
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

        Parent fxmlResultadoBuscaDeslogado0 = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado0.fxml"));
        resultadoBuscaDeslogado0Scene = new Scene(fxmlResultadoBuscaDeslogado0,900,600);

        Parent fxmlResultadoBuscaDeslogado1 = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado1.fxml"));
        resultadoBuscaDeslogado1Scene = new Scene(fxmlResultadoBuscaDeslogado1,900,600);

        Parent fxmlResultadoBuscaDeslogado2 = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado2.fxml"));
        resultadoBuscaDeslogado2Scene = new Scene(fxmlResultadoBuscaDeslogado2,900,600);

        Parent fxmlResultadoBuscaDeslogado3 = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado3.fxml"));
        resultadoBuscaDeslogado3Scene = new Scene(fxmlResultadoBuscaDeslogado3,900,600);

        Parent fxmlResultadoBuscaDeslogado4 = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado4.fxml"));
        resultadoBuscaDeslogado4Scene = new Scene(fxmlResultadoBuscaDeslogado4,900,600);

        Parent fxmlResultadoBuscaDeslogado5 = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado5.fxml"));
        resultadoBuscaDeslogado5Scene = new Scene(fxmlResultadoBuscaDeslogado5,900,600);

        Parent fxmlResultadoBuscaDeslogado6 = FXMLLoader.load(getClass().getResource("../view/ResultadoBuscaDeslogado6.fxml"));
        resultadoBuscaDeslogado6Scene = new Scene(fxmlResultadoBuscaDeslogado6,900,600);

        Parent fxmlMinhasLojas0 = FXMLLoader.load(getClass().getResource("../view/MinhasLojas0.fxml"));
        minhasLojas0Scene = new Scene(fxmlMinhasLojas0,900,600);

        Parent fxmlMinhasLojas1 = FXMLLoader.load(getClass().getResource("../view/MinhasLojas1.fxml"));
        minhasLojas1Scene = new Scene(fxmlMinhasLojas1,900,600);

        Parent fxmlMinhasLojas2 = FXMLLoader.load(getClass().getResource("../view/MinhasLojas2.fxml"));
        minhasLojas2Scene = new Scene(fxmlMinhasLojas2,900,600);

        Parent fxmlMinhasLojas3 = FXMLLoader.load(getClass().getResource("../view/MinhasLojas3.fxml"));
        minhasLojas3Scene = new Scene(fxmlMinhasLojas3,900,600);

        Parent fxmlMinhasLojas4 = FXMLLoader.load(getClass().getResource("../view/MinhasLojas4.fxml"));
        minhasLojas4Scene = new Scene(fxmlMinhasLojas4,900,600);

        Parent fxmlMinhasLojas5 = FXMLLoader.load(getClass().getResource("../view/MinhasLojas5.fxml"));
        minhasLojas5Scene = new Scene(fxmlMinhasLojas5,900,600);

        Parent fxmlMinhasLojas6 = FXMLLoader.load(getClass().getResource("../view/MinhasLojas6.fxml"));
        minhasLojas6Scene = new Scene(fxmlMinhasLojas6,900,600);

        Parent fxmlMeusAnuncios0 = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios0.fxml"));
        meusAnuncios0Scene = new Scene(fxmlMeusAnuncios0,900,600);

        Parent fxmlMeusAnuncios1 = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios1.fxml"));
        meusAnuncios1Scene = new Scene(fxmlMeusAnuncios1,900,600);

        Parent fxmlMeusAnuncios2 = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios2.fxml"));
        meusAnuncios2Scene = new Scene(fxmlMeusAnuncios2,900,600);

        Parent fxmlMeusAnuncios3 = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios3.fxml"));
        meusAnuncios3Scene = new Scene(fxmlMeusAnuncios3,900,600);

        Parent fxmlMeusAnuncios4 = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios4.fxml"));
        meusAnuncios4Scene = new Scene(fxmlMeusAnuncios4,900,600);

        Parent fxmlMeusAnuncios5 = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios5.fxml"));
        meusAnuncios0Scene = new Scene(fxmlMeusAnuncios5,900,600);

        Parent fxmlMeusAnuncios6 = FXMLLoader.load(getClass().getResource("../view/MeusAnuncios6.fxml"));
        meusAnuncios6Scene = new Scene(fxmlMeusAnuncios6,900,600);

        Parent fxmlBuscarLojasDeslogado0 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasDeslogado0.fxml"));
        buscaLojasDeslogado0Scene = new Scene(fxmlBuscarLojasDeslogado0,900,600);

        Parent fxmlBuscarLojasDeslogado1 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasDeslogado1.fxml"));
        buscaLojasDeslogado1Scene = new Scene(fxmlBuscarLojasDeslogado1,900,600);

        Parent fxmlBuscarLojasDeslogado2 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasDeslogado2.fxml"));
        buscaLojasDeslogado2Scene = new Scene(fxmlBuscarLojasDeslogado2,900,600);

        Parent fxmlBuscarLojasDeslogado3 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasDeslogado3.fxml"));
        buscaLojasDeslogado3Scene = new Scene(fxmlBuscarLojasDeslogado3,900,600);

        Parent fxmlBuscarLojasDeslogado4 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasDeslogado4.fxml"));
        buscaLojasDeslogado4Scene = new Scene(fxmlBuscarLojasDeslogado4,900,600);

        Parent fxmlBuscarLojasDeslogado5 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasDeslogado5.fxml"));
        buscaLojasDeslogado5Scene = new Scene(fxmlBuscarLojasDeslogado5,900,600);

        Parent fxmlBuscarLojasDeslogado6 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasDeslogado6.fxml"));
        buscaLojasDeslogado6Scene = new Scene(fxmlBuscarLojasDeslogado6,900,600);

        Parent fxmlBuscarLojasLogado0 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasLogado0.fxml"));
        buscaLojasLogado0Scene = new Scene(fxmlBuscarLojasLogado0,900,600);

        Parent fxmlBuscarLojasLogado1 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasLogado1.fxml"));
        buscaLojasLogado1Scene = new Scene(fxmlBuscarLojasLogado1,900,600);

        Parent fxmlBuscarLojasLogado2 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasLogado2.fxml"));
        buscaLojasLogado2Scene = new Scene(fxmlBuscarLojasLogado2,900,600);

        Parent fxmlBuscarLojasLogado3 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasLogado3.fxml"));
        buscaLojasLogado3Scene = new Scene(fxmlBuscarLojasLogado3,900,600);

        Parent fxmlBuscarLojasLogado4 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasLogado4.fxml"));
        buscaLojasLogado4Scene = new Scene(fxmlBuscarLojasLogado4,900,600);

        Parent fxmlBuscarLojasLogado5 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasLogado5.fxml"));
        buscaLojasLogado5Scene = new Scene(fxmlBuscarLojasLogado5,900,600);

        Parent fxmlBuscarLojasLogado6 = FXMLLoader.load(getClass().getResource("../view/BuscaLojasLogado6.fxml"));
        buscaLojasLogado6Scene = new Scene(fxmlBuscarLojasLogado6,900,600);







        AudioClip clip = new AudioClip(AUDIO_URL);// 1
        clip.play(); // 2
        primaryStage.setTitle("GeekMart");
        primaryStage.setResizable(false);
        primaryStage.setScene(telaInicialDeslogadoScene);
        primaryStage.show();
    }





    public static void trocarTela(String trc, Object userData, Object userData2){
        switch (trc){
            case "anuncioScene":
                stage.setScene(anuncioScene);
                notificarAllListeners("anuncioScene", userData,userData2);
                break;
            case "lojaScene":
                stage.setScene(lojaScene);
                notificarAllListeners("lojaScene", userData,userData2);
                break;
            case "telaInicialDeslogadoScene":
                stage.setScene(telaInicialDeslogadoScene);
                notificarAllListeners("telaInicialDeslogadoScene", userData,userData2);
                break;
            case "telaInicialLogadoScene":
                stage.setScene(telaInicialLogadoScene);
                notificarAllListeners("telaInicialLogadoScene", userData,userData2);
                break;
            case "telaLoginScene":
                stage.setScene(telaLoginScene);
                notificarAllListeners("telaLoginScene", userData,userData2);
                break;
            case "resultadoBuscaLogado6Scene":
                stage.setScene(resultadoBuscaLogado6Scene);
                notificarAllListeners("resultadoBuscaLogado6Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado5Scene":
                stage.setScene(resultadoBuscaLogado5Scene);
                notificarAllListeners("resultadoBuscaLogado5Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado4Scene":
                stage.setScene(resultadoBuscaLogado4Scene);
                notificarAllListeners("resultadoBuscaLogado4Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado3Scene":
                stage.setScene(resultadoBuscaLogado3Scene);
                notificarAllListeners("resultadoBuscaLogado2Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado2Scene":
                stage.setScene(resultadoBuscaLogado2Scene);
                notificarAllListeners("resultadoBuscaLogado6Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado1Scene":
                stage.setScene(resultadoBuscaLogado1Scene);
                notificarAllListeners("resultadoBuscaLogado1Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogadoScene":
                stage.setScene(resultadoBuscaDeslogadoScene);
                notificarAllListeners("resultadoBuscaDeslogadoScene", userData,userData2);
                break;
            case "chatScene":
                stage.setScene(chatScene);
                notificarAllListeners("chatScene", userData,userData2);
                break;
            case "cadastrarNovoClienteScene":
                stage.setScene(cadastrarNovoClienteScene);
                notificarAllListeners("cadastrarNovoClienteScene", userData,userData2);
                break;
            case "cadastroClienteScene":
                stage.setScene(cadastroClienteScene);
                notificarAllListeners("cadastroClienteScene", userData,userData2);
                break;
            case "cadastrarNovaLojaScene":
                stage.setScene(cadastrarNovaLojaScene);
                notificarAllListeners("cadastrarNovaLojaScene", userData,userData2);
                break;
            case "cadastrarNovoAnuncioScene":
                stage.setScene(cadastrarNovoAnuncioScene);
                notificarAllListeners("cadastrarNovoAnuncioScene", userData,userData2);
                break;
            case "alterarLojaScene":
                stage.setScene(alterarLojaScene);
                notificarAllListeners("alterarLojaScene", userData,userData2);
                break;
            case "alterarClienteScene":
                stage.setScene(alterarClienteScene);
                notificarAllListeners("alterarClienteScene", userData,userData2);
                break;
            case "alterarAnuncioScene":
                stage.setScene(alterarAnuncioScene);
                notificarAllListeners("alterarAnuncioScene", userData,userData2);
                break;
            case "admDeletarLojaScene":
                stage.setScene(admDeletarLojaScene);
                notificarAllListeners("admDeletarLojaScene", userData,userData2);
                break;
            case "admDeletarAnuncioScene":
                stage.setScene(admDeletarAnuncioScene);
                notificarAllListeners("admDeletarAnuncioScene", userData,userData2);
                break;

            case "admCadastroScene":
                stage.setScene(admCadastroScene);
                notificarAllListeners("admCadastroScene", userData,userData2);
                break;
            case "admCadastrarNovoAdmScene":
                stage.setScene(admCadastrarNovoAdmScene);
                notificarAllListeners("admCadastrarNovoAdmScene", userData,userData2);
                break;
            case "admBloqueioDesbloqueioScene":
                stage.setScene(admBloqueioDesbloqueioScene);
                notificarAllListeners("admBloqueioDesbloqueioScene", userData,userData2);
                break;
            case "admAlterarCadastroScene":
                stage.setScene(admAlterarCadastroScene);
                notificarAllListeners("admAlterarCadastroScene", userData,userData2);
                break;

            case "meusAnunciosScene":
                stage.setScene(meusAnunciosScene);
                notificarAllListeners("meusAnunciosScene", userData,userData2);
                break;
            case "minhasLojasScene":
                stage.setScene(minhasLojasScene);
                notificarAllListeners("minhasLojasScene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado0Scene":
                stage.setScene(resultadoBuscaDeslogado0Scene);
                notificarAllListeners("resultadoBuscaDeslogado0Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado1Scene":
                stage.setScene(resultadoBuscaDeslogado1Scene);
                notificarAllListeners("resultadoBuscaDeslogado1Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado2Scene":
                stage.setScene(resultadoBuscaDeslogado2Scene);
                notificarAllListeners("resultadoBuscaDeslogado2Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado3Scene":
                stage.setScene(resultadoBuscaDeslogado3Scene);
                notificarAllListeners("resultadoBuscaDeslogado3Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado4Scene":
                stage.setScene(resultadoBuscaDeslogado4Scene);
                notificarAllListeners("resultadoBuscaDeslogado4Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado5Scene":
                stage.setScene(resultadoBuscaDeslogado5Scene);
                notificarAllListeners("resultadoBuscaDeslogado5Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado6Scene":
                stage.setScene(resultadoBuscaDeslogado6Scene);
                notificarAllListeners("resultadoBuscaDeslogado6Scene", userData,userData2);
                break;
            case "minhasLojas0Scene":
                stage.setScene(minhasLojas0Scene);
                notificarAllListeners("minhasLojas0Scene", userData,userData2);
                break;
            case "minhasLojas1Scene":
                stage.setScene(minhasLojas1Scene);
                notificarAllListeners("minhasLojas1Scene", userData,userData2);
                break;
            case "minhasLojas2Scene":
                stage.setScene(minhasLojas2Scene);
                notificarAllListeners("minhasLojas2Scene", userData,userData2);
                break;
            case "minhasLojas3Scene":
                stage.setScene(minhasLojas3Scene);
                notificarAllListeners("minhasLojas3Scene", userData,userData2);
                break;
            case "minhasLojas4Scene":
                stage.setScene(minhasLojas4Scene);
                notificarAllListeners("minhasLojas4Scene", userData,userData2);
                break;
            case "minhasLojas5Scene":
                stage.setScene(minhasLojas5Scene);
                notificarAllListeners("minhasLojas5Scene", userData,userData2);
                break;
            case "minhasLojas6Scene":
                stage.setScene(minhasLojas6Scene);
                notificarAllListeners("minhasLojas6Scene", userData,userData2);
                break;
            case "meusAnuncios0Scene":
                stage.setScene(meusAnuncios0Scene);
                notificarAllListeners("meusAnuncios0Scene", userData,userData2);
                break;
            case "meusAnuncios1Scene":
                stage.setScene(meusAnuncios1Scene);
                notificarAllListeners("meusAnuncios1Scene", userData,userData2);
                break;
            case "meusAnuncios2Scene":
                stage.setScene(meusAnuncios2Scene);
                notificarAllListeners("meusAnuncios2Scene", userData,userData2);
                break;
            case "meusAnuncios3Scene":
                stage.setScene(meusAnuncios3Scene);
                notificarAllListeners("meusAnuncios3Scene", userData,userData2);
                break;
            case "meusAnuncios4Scene":
                stage.setScene(meusAnuncios4Scene);
                notificarAllListeners("meusAnuncios4Scene", userData,userData2);
                break;
            case "meusAnuncios5Scene":
                stage.setScene(meusAnuncios5Scene);
                notificarAllListeners("meusAnuncios5Scene", userData,userData2);
                break;
            case "meusAnuncios6Scene":
                stage.setScene(meusAnuncios6Scene);
                notificarAllListeners("meusAnuncios6Scene", userData,userData2);
                break;
            case "buscaLojasLogado0Scene":
                stage.setScene(buscaLojasLogado0Scene);
                notificarAllListeners("buscaLojasLogado0Scene", userData,userData2);
                break;
            case "buscaLojasLogado1Scene":
                stage.setScene(buscaLojasLogado1Scene);
                notificarAllListeners("buscaLojasLogado1Scene", userData,userData2);
                break;
            case "buscaLojasLogado2Scene":
                stage.setScene(buscaLojasLogado2Scene);
                notificarAllListeners("buscaLojasLogado2Scene", userData,userData2);
                break;
            case "buscaLojasLogado3Scene":
                stage.setScene(buscaLojasLogado3Scene);
                notificarAllListeners("buscaLojasLogado3Scene", userData,userData2);
                break;
            case "buscaLojasLogado4Scene":
                stage.setScene(buscaLojasLogado4Scene);
                notificarAllListeners("buscaLojasLogado4Scene", userData,userData2);
                break;
            case "buscaLojasLogado5Scene":
                stage.setScene(buscaLojasLogado5Scene);
                notificarAllListeners("buscaLojasLogado5Scene", userData,userData2);
                break;
            case "buscaLojasLogado6Scene":
                stage.setScene(buscaLojasLogado6Scene);
                notificarAllListeners("buscaLojasLogado6Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado0Scene":
                stage.setScene(buscaLojasDeslogado0Scene);
                notificarAllListeners("buscaLojasDeslogado0Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado1Scene":
                stage.setScene(buscaLojasDeslogado1Scene);
                notificarAllListeners("buscaLojasDeslogado1Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado2Scene":
                stage.setScene(buscaLojasDeslogado2Scene);
                notificarAllListeners("buscaLojasDeslogado2Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado4Scene":
                stage.setScene(buscaLojasDeslogado4Scene);
                notificarAllListeners("buscaLojasDeslogado4Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado3Scene":
                stage.setScene(buscaLojasDeslogado3Scene);
                notificarAllListeners("buscaLojasDeslogado3Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado5Scene":
                stage.setScene(buscaLojasDeslogado5Scene);
                notificarAllListeners("buscaLojasDeslogado5Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado6Scene":
                stage.setScene(buscaLojasDeslogado6Scene);
                notificarAllListeners("buscaLojasDeslogado6Scene", userData,userData2);
                break;



        }

    }

    public static void trocarTela(String trc) {
        trocarTela(trc,null,null);
    }
    public static void trocarTela(String trc, Object userData) {trocarTela(trc,userData,null);
    }
    public static void trocarTela(String trc, ArrayList<Anuncio> userData, Cliente userData2) {
        switch (trc){
            case "anuncioScene":
                stage.setScene(anuncioScene);
                notificarAllListeners("anuncioScene", userData,userData2);
                break;
            case "lojaScene":
                stage.setScene(lojaScene);
                notificarAllListeners("lojaScene", userData,userData2);
                break;
            case "telaInicialDeslogadoScene":
                stage.setScene(telaInicialDeslogadoScene);
                notificarAllListeners("telaInicialDeslogadoScene", userData,userData2);
                break;
            case "telaInicialLogadoScene":
                stage.setScene(telaInicialLogadoScene);
                notificarAllListeners("telaInicialLogadoScene", userData,userData2);
                break;
            case "telaLoginScene":
                stage.setScene(telaLoginScene);
                notificarAllListeners("telaLoginScene", userData,userData2);
                break;
            case "resultadoBuscaLogado6Scene":
                stage.setScene(resultadoBuscaLogado6Scene);
                notificarAllListeners("resultadoBuscaLogado6Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado5Scene":
                stage.setScene(resultadoBuscaLogado5Scene);
                notificarAllListeners("resultadoBuscaLogado5Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado4Scene":
                stage.setScene(resultadoBuscaLogado4Scene);
                notificarAllListeners("resultadoBuscaLogado4Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado3Scene":
                stage.setScene(resultadoBuscaLogado3Scene);
                notificarAllListeners("resultadoBuscaLogado2Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado2Scene":
                stage.setScene(resultadoBuscaLogado2Scene);
                notificarAllListeners("resultadoBuscaLogado6Scene", userData,userData2);
                break;
            case "resultadoBuscaLogado1Scene":
                stage.setScene(resultadoBuscaLogado1Scene);
                notificarAllListeners("resultadoBuscaLogado1Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogadoScene":
                stage.setScene(resultadoBuscaDeslogadoScene);
                notificarAllListeners("resultadoBuscaDeslogadoScene", userData,userData2);
                break;
            case "chatScene":
                stage.setScene(chatScene);
                notificarAllListeners("chatScene", userData,userData2);
                break;
            case "cadastrarNovoClienteScene":
                stage.setScene(cadastrarNovoClienteScene);
                notificarAllListeners("cadastrarNovoClienteScene", userData,userData2);
                break;
            case "cadastroClienteScene":
                stage.setScene(cadastroClienteScene);
                notificarAllListeners("cadastroClienteScene", userData,userData2);
                break;
            case "cadastrarNovaLojaScene":
                stage.setScene(cadastrarNovaLojaScene);
                notificarAllListeners("cadastrarNovaLojaScene", userData,userData2);
                break;
            case "cadastrarNovoAnuncioScene":
                stage.setScene(cadastrarNovoAnuncioScene);
                notificarAllListeners("cadastrarNovoAnuncioScene", userData,userData2);
                break;
            case "alterarLojaScene":
                stage.setScene(alterarLojaScene);
                notificarAllListeners("alterarLojaScene", userData,userData2);
                break;
            case "alterarClienteScene":
                stage.setScene(alterarClienteScene);
                notificarAllListeners("alterarClienteScene", userData,userData2);
                break;
            case "alterarAnuncioScene":
                stage.setScene(alterarAnuncioScene);
                notificarAllListeners("alterarAnuncioScene", userData,userData2);
                break;
            case "admDeletarLojaScene":
                stage.setScene(admDeletarLojaScene);
                notificarAllListeners("admDeletarLojaScene", userData,userData2);
                break;
            case "admDeletarAnuncioScene":
                stage.setScene(admDeletarAnuncioScene);
                notificarAllListeners("admDeletarAnuncioScene", userData,userData2);
                break;

            case "admCadastroScene":
                stage.setScene(admCadastroScene);
                notificarAllListeners("admCadastroScene", userData,userData2);
                break;
            case "admCadastrarNovoAdmScene":
                stage.setScene(admCadastrarNovoAdmScene);
                notificarAllListeners("admCadastrarNovoAdmScene", userData,userData2);
                break;
            case "admBloqueioDesbloqueioScene":
                stage.setScene(admBloqueioDesbloqueioScene);
                notificarAllListeners("admBloqueioDesbloqueioScene", userData,userData2);
                break;
            case "admAlterarCadastroScene":
                stage.setScene(admAlterarCadastroScene);
                notificarAllListeners("admAlterarCadastroScene", userData,userData2);
                break;

            case "meusAnunciosScene":
                stage.setScene(meusAnunciosScene);
                notificarAllListeners("meusAnunciosScene", userData,userData2);
                break;
            case "minhasLojasScene":
                stage.setScene(minhasLojasScene);
                notificarAllListeners("minhasLojasScene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado0Scene":
                stage.setScene(resultadoBuscaDeslogado0Scene);
                notificarAllListeners("resultadoBuscaDeslogado0Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado1Scene":
                stage.setScene(resultadoBuscaDeslogado1Scene);
                notificarAllListeners("resultadoBuscaDeslogado1Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado2Scene":
                stage.setScene(resultadoBuscaDeslogado2Scene);
                notificarAllListeners("resultadoBuscaDeslogado2Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado3Scene":
                stage.setScene(resultadoBuscaDeslogado3Scene);
                notificarAllListeners("resultadoBuscaDeslogado3Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado4Scene":
                stage.setScene(resultadoBuscaDeslogado4Scene);
                notificarAllListeners("resultadoBuscaDeslogado4Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado5Scene":
                stage.setScene(resultadoBuscaDeslogado5Scene);
                notificarAllListeners("resultadoBuscaDeslogado5Scene", userData,userData2);
                break;
            case "resultadoBuscaDeslogado6Scene":
                stage.setScene(resultadoBuscaDeslogado6Scene);
                notificarAllListeners("resultadoBuscaDeslogado6Scene", userData,userData2);
                break;
            case "minhasLojas0Scene":
                stage.setScene(minhasLojas0Scene);
                notificarAllListeners("minhasLojas0Scene", userData,userData2);
                break;
            case "minhasLojas1Scene":
                stage.setScene(minhasLojas1Scene);
                notificarAllListeners("minhasLojas1Scene", userData,userData2);
                break;
            case "minhasLojas2Scene":
                stage.setScene(minhasLojas2Scene);
                notificarAllListeners("minhasLojas2Scene", userData,userData2);
                break;
            case "minhasLojas3Scene":
                stage.setScene(minhasLojas3Scene);
                notificarAllListeners("minhasLojas3Scene", userData,userData2);
                break;
            case "minhasLojas4Scene":
                stage.setScene(minhasLojas4Scene);
                notificarAllListeners("minhasLojas4Scene", userData,userData2);
                break;
            case "minhasLojas5Scene":
                stage.setScene(minhasLojas5Scene);
                notificarAllListeners("minhasLojas5Scene", userData,userData2);
                break;
            case "minhasLojas6Scene":
                stage.setScene(minhasLojas6Scene);
                notificarAllListeners("minhasLojas6Scene", userData,userData2);
                break;
            case "meusAnuncios0Scene":
                stage.setScene(meusAnuncios0Scene);
                notificarAllListeners("meusAnuncios0Scene", userData,userData2);
                break;
            case "meusAnuncios1Scene":
                stage.setScene(meusAnuncios1Scene);
                notificarAllListeners("meusAnuncios1Scene", userData,userData2);
                break;
            case "meusAnuncios2Scene":
                stage.setScene(meusAnuncios2Scene);
                notificarAllListeners("meusAnuncios2Scene", userData,userData2);
                break;
            case "meusAnuncios3Scene":
                stage.setScene(meusAnuncios3Scene);
                notificarAllListeners("meusAnuncios3Scene", userData,userData2);
                break;
            case "meusAnuncios4Scene":
                stage.setScene(meusAnuncios4Scene);
                notificarAllListeners("meusAnuncios4Scene", userData,userData2);
                break;
            case "meusAnuncios5Scene":
                stage.setScene(meusAnuncios5Scene);
                notificarAllListeners("meusAnuncios5Scene", userData,userData2);
                break;
            case "meusAnuncios6Scene":
                stage.setScene(meusAnuncios6Scene);
                notificarAllListeners("meusAnuncios6Scene", userData,userData2);
                break;
            case "buscaLojasLogado0Scene":
                stage.setScene(buscaLojasLogado0Scene);
                notificarAllListeners("buscaLojasLogado0Scene", userData,userData2);
                break;
            case "buscaLojasLogado1Scene":
                stage.setScene(buscaLojasLogado1Scene);
                notificarAllListeners("buscaLojasLogado1Scene", userData,userData2);
                break;
            case "buscaLojasLogado2Scene":
                stage.setScene(buscaLojasLogado2Scene);
                notificarAllListeners("buscaLojasLogado2Scene", userData,userData2);
                break;
            case "buscaLojasLogado3Scene":
                stage.setScene(buscaLojasLogado3Scene);
                notificarAllListeners("buscaLojasLogado3Scene", userData,userData2);
                break;
            case "buscaLojasLogado4Scene":
                stage.setScene(buscaLojasLogado4Scene);
                notificarAllListeners("buscaLojasLogado4Scene", userData,userData2);
                break;
            case "buscaLojasLogado5Scene":
                stage.setScene(buscaLojasLogado5Scene);
                notificarAllListeners("buscaLojasLogado5Scene", userData,userData2);
                break;
            case "buscaLojasLogado6Scene":
                stage.setScene(buscaLojasLogado6Scene);
                notificarAllListeners("buscaLojasLogado6Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado0Scene":
                stage.setScene(buscaLojasDeslogado0Scene);
                notificarAllListeners("buscaLojasDeslogado0Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado1Scene":
                stage.setScene(buscaLojasDeslogado1Scene);
                notificarAllListeners("buscaLojasDeslogado1Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado2Scene":
                stage.setScene(buscaLojasDeslogado2Scene);
                notificarAllListeners("buscaLojasDeslogado2Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado4Scene":
                stage.setScene(buscaLojasDeslogado4Scene);
                notificarAllListeners("buscaLojasDeslogado4Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado3Scene":
                stage.setScene(buscaLojasDeslogado3Scene);
                notificarAllListeners("buscaLojasDeslogado3Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado5Scene":
                stage.setScene(buscaLojasDeslogado5Scene);
                notificarAllListeners("buscaLojasDeslogado5Scene", userData,userData2);
                break;
            case "buscaLojasDeslogado6Scene":
                stage.setScene(buscaLojasDeslogado6Scene);
                notificarAllListeners("buscaLojasDeslogado6Scene", userData,userData2);
                break;



        }
    }

    public static void trocarTela2(String trc, ArrayList<Anuncio> userData) {trocarTela(trc,userData,null);
    }
    public static void trocarTela2(String trc, Cliente userData2) {trocarTela(trc,null, userData2);
    }



    private static ArrayList<OnChangeScreen> listerners = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData, Object userData2) ;
    }

    public static  void addOnChangesScreenListener(OnChangeScreen newListener){
        listerners.add(newListener);
    }

    private static void notificarAllListeners(String newScreen, Object userData, Object userData2){
        for(OnChangeScreen l: listerners)
            l.onScreenChanged(newScreen,userData, userData2);
    }

    //OUTRO

    private static ArrayList<OnChangeScreen2> listerners2 = new ArrayList<>();

    public static interface OnChangeScreen2{
        void onScreenChanged2(String newScreen, ArrayList<Anuncio> userData, Cliente userData2) ;
    }

    public static  void addOnChangesScreenListener(OnChangeScreen2 newListener){
        listerners2.add(newListener);
    }

    private static void notificarAllListeners(String newScreen, ArrayList<Anuncio> userData, Cliente userData2){
        for(OnChangeScreen2 l: listerners2)
            l.onScreenChanged2(newScreen,userData, userData2);
    }




}
