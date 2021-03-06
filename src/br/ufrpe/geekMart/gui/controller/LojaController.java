package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class LojaController {

    Fachada fachada = Fachada.getInstancia();
    Loja user;
    Image image = new Image("/imagens/logoloja1.png");

    @FXML
    protected  void  initialize(){
        Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                        ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                if(newScreen.equals("lojaScene")) {
                    user = fachada.loadMemoryCardLoja();
                    updateComboBoxCategorias();
                    updateComboBoxLojas();
                    updateLoja();

                } }
        });


        updateComboBoxCategorias();
        updateComboBoxLojas();

    }

    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }

    private  void updateLoja(){
        lbCategoria.setText(user.getCategoria().toString());
        lbTitulo.setText(user.getNome());
        lbPreco.setText(user.getTelefone());
        System.out.println("ok");
        imCentral.setImage(image);
    }

    @FXML
    protected  void listarAnunciosDaLoja(ActionEvent la){

        ArrayList<Anuncio> anun = user.getAnuncios();

        if(anun.size()<6 && anun.size()>=0) {

            switch (anun.size()) {
                case 1:
                    Main.trocarTela("resultadoBuscaLogado1Scene", anun);
                    break;
                case 2:
                    Main.trocarTela("resultadoBuscaLogado2Scene", anun);
                    break;
                case 3:
                    Main.trocarTela("resultadoBuscaLogado3Scene", anun);
                    break;
                case 4:
                    Main.trocarTela("resultadoBuscaLogado4Scene", anun);
                    break;
                case 5:
                    Main.trocarTela("resultadoBuscaLogado5Scene", anun);
                    break;

                case 0:
                    Main.trocarTela("resultadoBuscaLogado0Scene", anun);
                    break;
            }
        } else if(anun.size() >= 6) {
            Main.trocarTela("resultadoBuscaLogado6Scene", anun);
        }

    }

    @FXML
    protected  void buscaAnunciosPorTituloOrdenadoPorPreço(ActionEvent e){

        String palavra = tfBuscar.getText();
        ArrayList<Anuncio> resultado = fachada.buscarAnuncioPorTituloOrdenadoPeloPreco(palavra);


        Anuncio[] anuncios = fachada.listarAnuncios();

        if(resultado.size()<6 && resultado.size()>=0) {

            switch (resultado.size()) {
                case 1:
                    Main.trocarTela("resultadoBuscaLogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("resultadoBuscaLogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("resultadoBuscaLogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("resultadoBuscaLogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("resultadoBuscaLogado5Scene", anuncios);
                    break;

                case 0:
                    Main.trocarTela("resultadoBuscaLogado0Scene", anuncios);
                    break;
            }
        } else if(resultado.size() >= 6) {
            Main.trocarTela("resultadoBuscaLogado6Scene", anuncios);
        }


    }
    @FXML
    protected  void buscaAnunciosPorCategoria(ActionEvent e){

        String palavra = cbCategorias.getSelectionModel().toString();
        ArrayList<Loja> anuncios = fachada.buscarLojaPorCategoria(palavra);


        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("buscasLojasLogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("buscasLojasLogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("buscasLojasLogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("buscasLojasLogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("buscasLojasLogado5Scene", anuncios);
                    break;

                case 0:
                    Main.trocarTela("buscasLojasLogado0Scene", anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("resultadoBuscaLogado6Scene", anuncios);
        }


    }




    @FXML
    protected  void buscaLojasPorCategoria(ActionEvent e){

        String palavra = cbCategorias.getSelectionModel().toString();
        ArrayList<Loja> anuncios = fachada.buscarLojaPorTitulo(palavra);


        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("buscasLojasLogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("buscasLojasLogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("buscasLojasLogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("buscasLojasLogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("buscasLojasLogado5Scene", anuncios);
                    break;

                case 0:
                    Main.trocarTela("buscasLojasLogado0Scene", anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("resultadoBuscaLogado6Scene", anuncios);
        }



    }


    @FXML
    protected  void btHomeAction(ActionEvent e){
        Main.trocarTela("telaInicialLogadoScene");
    }

    @FXML
    protected  void btMeuCadastroAction(ActionEvent e){
        Main.trocarTela("cadastroClienteScene");
    }

    @FXML
    protected  void btMeusAnunciosAction(ActionEvent e){
        Cliente c = fachada.loadMemoryCardCliente();
        ArrayList<Anuncio> anuncios = c.getAnuncios();

        if(anuncios.size()<6) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("meusAnuncios1Scene", user,anuncios);
                    break;
                case 2:
                    Main.trocarTela("meusAnuncios2Scene",user, anuncios);
                    break;
                case 3:
                    Main.trocarTela("meusAnuncios3Scene",user, anuncios);
                    break;
                case 4:
                    Main.trocarTela("meusAnuncios4Scene",user, anuncios);
                    break;
                case 5:
                    Main.trocarTela("meusAnuncios5Scene", user,anuncios);
                    break;

                case 0:
                    Main.trocarTela("meusAnuncios0Scene",user, anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("meusAnuncios6Scene",user, anuncios);
        }


        }

    @FXML
    protected  void btMinhasLojasAction(ActionEvent e){

            Cliente cli = fachada.loadMemoryCardCliente();

            ArrayList<Loja> lojas = cli.getLojas();

            if (lojas.size() < 6) {

                switch (lojas.size()) {
                    case 1:
                        Main.trocarTela("minhasLojas1Scene", cli);
                        break;
                    case 2:
                        Main.trocarTela("minhasLojas2Scene", cli);
                        break;
                    case 3:
                        Main.trocarTela("minhasLojas3Scene", cli);
                        break;
                    case 4:
                        Main.trocarTela("minhasLojas4Scene", cli);
                        break;
                    case 5:
                        Main.trocarTela("minhasLojas5Scene", cli);
                        break;

                    case 0:
                        Main.trocarTela("minhasLojas0Scene", cli);
                        break;
                }
            } else if (lojas.size() >= 6) {
                Main.trocarTela("minhasLojas6Scene", cli);
            }



    }

    @FXML
    protected  void btNovoAnuncioAction(ActionEvent e){
        Main.trocarTela("cadastrarNovoAnuncioScene");
    }

    @FXML
    protected  void btNovaLojaAction(ActionEvent e){
        try {
            Cliente cliente = (Cliente) Fachada.getInstancia().buscaUsuario(user.getCpfCliente());
            Main.trocarTela("cadastrarNovaLojaScene", cliente);
        } catch (ParametroNullException eParam) {
            Alert alertw = new Alert(Alert.AlertType.WARNING);
            alertw.setTitle("Aviso");
            alertw.setContentText(eParam.getMessage());
            alertw.showAndWait();
        } catch (NaoExisteException eNEx) {
            Alert alertw = new Alert(Alert.AlertType.ERROR);
            alertw.setTitle("Erro");
            alertw.setContentText(eNEx.getMessage());
            alertw.showAndWait();
        }

    }

    @FXML
    protected  void btChatAction(ActionEvent e){
        Main.trocarTela("chatScene");
    }


@FXML
private Text taDescricao;


    @FXML
        private ImageView imCentral;

        @FXML
        private Label lbPreco;

        @FXML
        private Label lbCategoria;

        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private TextField tfBuscar;

        @FXML
        private Button btHome;

        @FXML
        private Button btMinhasLojas;


        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Label lbEstado;

        @FXML
        private Button btCHAT;

        @FXML
        private Label lbTitulo;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private Label lbQtdade;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        private Button btAnuncios;







}
