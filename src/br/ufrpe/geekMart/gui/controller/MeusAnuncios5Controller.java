package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MeusAnuncios5Controller {
    Fachada fachada = Fachada.getInstancia();
    Cliente user;
    ArrayList<Anuncio> user1, user2;
    ArrayList<Anuncio> proxima;
    ArrayList<Anuncio> voltar;


    @FXML
    protected  void  initialize(){
        Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                        ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                if(newScreen.equals("meusAnuncios5Scene")) {
                    user = fachada.loadMemoryCardCliente();
                    user1 = userData2;
                    user2 = userData3;
                    updateComboBoxCategorias();
                    updateComboBoxLojas();
                    updateTela();

                } }
        });


        updateComboBoxCategorias();
        updateComboBoxLojas();

    }

    private  void  updateTela() {

        imBusca1.setImage(user1.get(0).getImagem1());
        imBusca2.setImage(user1.get(1).getImagem1());
        imBusca3.setImage(user1.get(2).getImagem1());
        imBusca4.setImage(user1.get(3).getImagem1());
        imBusca5.setImage(user1.get(4).getImagem1());
        lbTituroII1.setText(user1.get(0).getTitulo());
        lbTituroII2.setText(user1.get(1).getTitulo());
        lbTituroII3.setText(user1.get(2).getTitulo());
        lbTituroII4.setText(user1.get(3).getTitulo());
        lbTituroII5.setText(user1.get(4).getTitulo());
        lbPrecoII1.setText(user1.get(0).getPreco());
        lbPrecoII2.setText(user1.get(1).getPreco());
        lbPrecoII3.setText(user1.get(2).getPreco());
        lbPrecoII4.setText(user1.get(3).getPreco());
        lbPrecoII5.setText(user1.get(4).getPreco());


    }


    //IR PARA ANUNCIO

    @FXML
    protected  void irParaAnuncioAction1(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(0));
        Main.trocarTela("anuncioScene",user1.get(0));

    }

    @FXML
    protected  void irParaAnuncioAction2(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(1));
        Main.trocarTela("anuncioScene",user1.get(1));

    }

    @FXML
    protected  void irParaAnuncioAction3(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(2));
        Main.trocarTela("anuncioScene",user1.get(2));

    }

    @FXML
    protected  void irParaAnuncioAction4(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(3));
        Main.trocarTela("anuncioScene",user1.get(3));

    }

    @FXML
    protected  void irParaAnuncioAction5(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(4));
        Main.trocarTela("anuncioScene",user1.get(4));

    }



    // EDITAR ANUNCIO

    @FXML
    protected  void editarAnuncioAction1(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(0));
        Main.trocarTela("alterarAnuncioScene",user1.get(0));

    }

    @FXML
    protected  void editarAnuncioAction2(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(1));
        Main.trocarTela("alterarAnuncioScene",user1.get(1));

    }

    @FXML
    protected  void editarAnuncioAction3(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(2));
        Main.trocarTela("alterarAnuncioScene",user1.get(2));

    }

    @FXML
    protected  void editarAnuncioAction4(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(3));
        Main.trocarTela("alterarAnuncioScene",user1.get(3));

    }

    @FXML
    protected  void editarAnuncioAction5(ActionEvent e){
        fachada.saveMemoryCardAnuncio(user.getAnuncios().get(4));
        Main.trocarTela("alterarAnuncioScene",user1.get(4));

    }




    @FXML
    protected  void voltarAction(ActionEvent e){
        if(user2 != null) {
            user1.add(0, user2.get(0));
            user1.add(1, user2.get(1));
            user1.add(2, user2.get(2));
            user1.add(3, user2.get(3));
            user1.add(4, user2.get(4));


            Main.trocarTela("meusAnuncios6Scene", user1);
        }else{
            Alert alertw = new Alert(Alert.AlertType.ERROR);
            alertw.setTitle("Erro");
            alertw.setHeaderText("Erro");
            alertw.setContentText("Não há mais anuncios para essa busca");
            alertw.showAndWait();

        }


    }


    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }

    @FXML
    private Button btVoltar;

    @FXML
    private Button btProxima;

    @FXML
    private Button btVerAnuncio1;

    @FXML
    private Button btVerAnuncio2;

    @FXML
    private Button btVerAnuncio3;

    @FXML
    private Button btVerAnuncio4;

    @FXML
    private Button btVerAnuncio5;

    @FXML
    private Button btVerAnuncio6;

    @FXML
    private ImageView imBusca1;

    @FXML
    private ImageView imBusca2;

    @FXML
    private ImageView imBusca3;

    @FXML
    private ImageView imBusca4;

    @FXML
    private ImageView imBusca5;

    @FXML
    private ImageView imBusca6;

    @FXML
    private  Button Editar1;

    @FXML
    private  Button Editar2;

    @FXML
    private  Button Editar3;

    @FXML
    private  Button Editar4;

    @FXML
    private  Button Editar5;

    @FXML
    private  Button Editar6;


    @FXML
    private Button btHome;

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
    private Button btMinhasLojas;

    @FXML
    private MenuItem menuSair;

    @FXML
    private MenuItem menuLoginCliente;

    @FXML
    private Button btCHAT;

    @FXML
    private ComboBox cbLojas;

    @FXML
    private Button btNovaLoja;


    @FXML
    private MenuItem menuLoginAdm;

    @FXML
    private Button btNovoAnuncio;

    @FXML
    private MenuItem menuSobreApp;

    @FXML
    private Label lbPrecoII1;

    @FXML
    private Label lbTituroII1;

    @FXML
    private Label lbPrecoII2;

    @FXML
    private Label lbTituroII2;

    @FXML
    private Label lbPrecoII3;

    @FXML
    private Label lbTituroII3;

    @FXML
    private Label lbPrecoII4;

    @FXML
    private Label lbTituroII4;

    @FXML
    private Label lbPrecoII5;

    @FXML
    private Label lbTituroII5;

    @FXML
    private Label lbPrecoII6;

    @FXML
    private Label lbTituroII6;

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

        ArrayList<Anuncio> anuncios = user.getAnuncios();

        if(anuncios.size()<6 && anuncios.size()>=0) {

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

        ArrayList<Loja> lojas = user.getLojas();

        if(lojas.size()<6 && lojas.size()>=0) {

            switch (lojas.size()) {
                case 1:
                    Main.trocarTela("minhasLojas1Scene", user);
                    break;
                case 2:
                    Main.trocarTela("minhasLojas2Scene",user);
                    break;
                case 3:
                    Main.trocarTela("minhasLojas3Scene",user);
                    break;
                case 4:
                    Main.trocarTela("minhasLojas4Scene",user);
                    break;
                case 5:
                    Main.trocarTela("minhasLojas5Scene", user);
                    break;

                case 0:
                    Main.trocarTela("minhasLojas0Scene",user);
                    break;
            }
        } else if(lojas.size() >= 6) {
            Main.trocarTela("minhasLojas6Scene",user);
        }


    }

    @FXML
    protected  void btNovoAnuncioAction(ActionEvent e){
        Main.trocarTela("cadastrarNovoAnuncioScene");
    }

    @FXML
    protected  void btNovaLojaAction(ActionEvent e){
        Main.trocarTela("cadastrarNovaLojaScene");
    }

    @FXML
    protected  void btChatAction(ActionEvent e){
        Main.trocarTela("chatScene");
    }

    @FXML
    protected  void buscaAnunciosPorTituloOrdenadoPorPreço(ActionEvent e){

        String palavra = tfBuscar.getText();
        ArrayList<Anuncio> resultado = fachada.buscarAnuncioPorTituloOrdenadoPeloPreco(palavra);



        if(resultado.size()<6 && resultado.size()>=0) {

            switch (resultado.size()) {
                case 1:
                    Main.trocarTela("resultadoBuscaLogado1Scene", resultado);
                    break;
                case 2:
                    Main.trocarTela("resultadoBuscaLogado2Scene", resultado);
                    break;
                case 3:
                    Main.trocarTela("resultadoBuscaLogado3Scene", resultado);
                    break;
                case 4:
                    Main.trocarTela("resultadoBuscaLogado4Scene", resultado);
                    break;
                case 5:
                    Main.trocarTela("resultadoBuscaLogado5Scene", resultado);
                    break;

                case 0:
                    Main.trocarTela("resultadoBuscaLogado0Scene", resultado);
                    break;
            }
        } else if(resultado.size() >= 6) {
            Main.trocarTela("resultadoBuscaLogado6Scene", resultado);
        }


    }

    @FXML
    protected  void buscaAnunciosPorCategoria(ActionEvent e){

        String palavra = cbCategorias.getSelectionModel().toString();
        ArrayList<Loja> anuncios = fachada.buscarLojaPorCategoria(palavra);


        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
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



}
