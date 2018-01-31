package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ResultadoBuscaDeslogado5Controller {

    ArrayList<Anuncio> user1, user2;
    Fachada fachada = Fachada.getInstancia();
    ArrayList<Anuncio> proxima;
    ArrayList<Anuncio> voltar;


    @FXML
    protected  void  initialize(){
        Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData,
                                        ArrayList<Anuncio> userData2,ArrayList<Anuncio>userData3,ArrayList<Loja>userData4) {
                if(newScreen.equals("resultadoBuscaDeslogado5Scene")) {
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


    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }


    @FXML
    protected  void irParaAnuncioAction1(ActionEvent e){
        Main.trocarTela("anuncioDeslogadoScene",user1.get(0));

    }

    @FXML
    protected  void irParaAnuncioAction2(ActionEvent e){
        Main.trocarTela("anuncioDeslogadoScene",user1.get(1));

    }

    @FXML
    protected  void irParaAnuncioAction3(ActionEvent e){
        Main.trocarTela("anuncioDeslogadoScene",user1.get(2));

    }

    @FXML
    protected  void irParaAnuncioAction4(ActionEvent e){
        Main.trocarTela("anuncioDeslogadoScene",user1.get(3));

    }

    @FXML
    protected  void irParaAnuncioAction5(ActionEvent e){
        Main.trocarTela("anuncioDeslogadoScene",user1.get(4));

    }




    @FXML
    protected  void voltarAction(ActionEvent e){
        if(user2 != null) {
            user1.add(0, user2.get(0));
            user1.add(1, user2.get(1));
            user1.add(2, user2.get(2));
            user1.add(3, user2.get(3));
            user1.add(4, user2.get(4));

            Main.trocarTela("resultadoBuscaDeslogado6Scene", user1);
        }else{
            Alert alertw = new Alert(Alert.AlertType.ERROR);
            alertw.setTitle("Erro");
            alertw.setHeaderText("Erro");
            alertw.setContentText("Não há mais anuncios para essa busca");
            alertw.showAndWait();

        }


    }

    @FXML
    protected  void buscaAnunciosPorTituloOrdenadoPorPreço(ActionEvent e){

        String palavra = tfBuscar.getText();
        ArrayList<Anuncio> resultado = fachada.buscarAnuncioPorTituloOrdenadoPeloPreco(palavra);



        if(resultado.size()<6 && resultado.size()>=0) {

            switch (resultado.size()) {
                case 1:
                    Main.trocarTela("resultadoBuscaDeslogado1Scene", resultado);
                    break;
                case 2:
                    Main.trocarTela("resultadoBuscaDeslogado2Scene", resultado);
                    break;
                case 3:
                    Main.trocarTela("resultadoBuscaDeslogado3Scene", resultado);
                    break;
                case 4:
                    Main.trocarTela("resultadoBuscaDeslogado4Scene", resultado);
                    break;
                case 5:
                    Main.trocarTela("resultadoBuscaDeslogado5Scene", resultado);
                    break;

                case 0:
                    Main.trocarTela("resultadoBuscaDeslogado6Scene", resultado);
                    break;
            }
        } else if(resultado.size() >= 6) {
            Main.trocarTela("resultadoBuscaDeslogado6Scene", resultado);
        }


    }

    @FXML
    protected  void buscaAnunciosPorCategoria(ActionEvent e){

        String palavra = cbCategorias.getSelectionModel().toString();
        ArrayList<Loja> anuncios = fachada.buscarLojaPorCategoria(palavra);


        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("resultadoBuscaDeslogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("resultadoBuscaDeslogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("resultadoBuscaDeslogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("resultadoBuscaDeslogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("resultadoBuscaDeslogado5Scene", anuncios);
                    break;

                case 0:
                    Main.trocarTela("resultadoBuscaDeslogado0Scene", anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("resultadoBuscaDeslogado6Scene", anuncios);
        }


    }




    @FXML
    protected  void buscaLojasPorCategoria(ActionEvent e){

        String palavra = cbCategorias.getSelectionModel().toString();
        ArrayList<Loja> lojas = fachada.buscarLojaPorTitulo(palavra);


        if(lojas.size()<6 && lojas.size()>=0) {

            switch (lojas.size()) {
                case 1:
                    Main.trocarTela("buscaLojasDeslogado1Scene", lojas);
                    break;
                case 2:
                    Main.trocarTela("buscaLojasDeslogado2Scene", lojas);
                    break;
                case 3:
                    Main.trocarTela("buscaLojasDeslogado3Scene", lojas);
                    break;
                case 4:
                    Main.trocarTela("buscaLojasDeslogado4Scene", lojas);
                    break;
                case 5:
                    Main.trocarTela("buscaLojasDeslogado5Scene", lojas);
                    break;

                case 0:
                    Main.trocarTela("buscaLojasDeslogado0Scene", lojas);
                    break;
            }
        } else if(lojas.size() >= 6) {
            Main.trocarTela("buscaLojasDeslogado6Scene", lojas);
        }



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
    private  Button btHome;

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
    protected  void btCadastrarAction(ActionEvent e){
        Main.trocarTela("cadastrarNovoClienteScene"); }

    @FXML
    protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }


}
