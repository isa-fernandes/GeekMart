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

public class BuscaLojasLogado6Controller {

    Fachada fachada = Fachada.getInstancia();
    Cliente user;
    ArrayList<Loja> stores;
    ArrayList<Loja> proxima;


    @FXML
    protected  void  initialize(){
        Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                        ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                if(newScreen.equals("buscasLojasLogado6Scene")) {
                    user = (Cliente)userData;
                    stores = userData4;
                    updateComboBoxCategorias();
                    updateComboBoxLojas();
                    updateTela();

                } }
        });


        updateComboBoxCategorias();
        updateComboBoxLojas();

    }

    private  void  updateTela() {

        imBusca1.setImage(stores.get(0).getImage());
        imBusca2.setImage(stores.get(1).getImage());
        imBusca3.setImage(stores.get(2).getImage());
        imBusca4.setImage(stores.get(3).getImage());
        imBusca5.setImage(stores.get(4).getImage());
        imBusca6.setImage(stores.get(5).getImage());
        lbTituroII1.setText(stores.get(0).getNome());
        lbTituroII2.setText(stores.get(1).getNome());
        lbTituroII3.setText(stores.get(2).getNome());
        lbTituroII4.setText(stores.get(3).getNome());
        lbTituroII5.setText(stores.get(4).getNome());
        lbTituroII6.setText(stores.get(5).getNome());
        lbPrecoII1.setText(stores.get(0).getCategoria().toString());
        lbPrecoII2.setText(stores.get(1).getCategoria().toString());
        lbPrecoII3.setText(stores.get(2).getCategoria().toString());
        lbPrecoII4.setText(stores.get(3).getCategoria().toString());
        lbPrecoII5.setText(stores.get(4).getCategoria().toString());
        lbPrecoII6.setText(stores.get(5).getCategoria().toString());

    }


    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }

    @FXML
    protected  void proximaAction(ActionEvent e){

        stores.remove(0);
        stores.remove(0);
        stores.remove(0);
        stores.remove(0);
        stores.remove(0);
        stores.remove(0);


        if(stores.size() - 6 >= 6){
            Main.trocarTela("buscaLojasLogado6Scene",stores);
        }

        if(stores.size() - 6 <6){
            switch (stores.size() - 6) {
                case 1:
                    Main.trocarTela("buscaLojasLogado1Scene",stores);
                    break;
                case 2:
                    Main.trocarTela("buscaLojasLogado2Scene",stores);
                    break;
                case 3:
                    Main.trocarTela("buscaLojasLogado3Scene",stores);
                    break;
                case 4:
                    Main.trocarTela("buscaLojasLogado4Scene",stores);
                    break;
                case 5:
                    Main.trocarTela("buscaLojasLogado5Scene",stores);
                    break;
                case 0:
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Informação");
                    alert2.setHeaderText("Lojas");
                    alert2.setContentText("Não há mais Lojas");
                    alert2.showAndWait();
                    break;
            }
        }

    }

    @FXML
    protected  void irParaAnuncioAction1(ActionEvent e){
        Main.trocarTela("lojaScene",stores.get(0));

    }

    @FXML
    protected  void irParaAnuncioAction2(ActionEvent e){
        Main.trocarTela("lojaScene",stores.get(1));

    }

    @FXML
    protected  void irParaAnuncioAction3(ActionEvent e){
        Main.trocarTela("lojaScene",stores.get(2));

    }

    @FXML
    protected  void irParaAnuncioAction4(ActionEvent e){
        Main.trocarTela("lojaScene",stores.get(3));

    }

    @FXML
    protected  void irParaAnuncioAction5(ActionEvent e){
        Main.trocarTela("lojaScene",stores.get(4));

    }

    @FXML
    protected  void irParaAnuncioAction6(ActionEvent e){
        Main.trocarTela("lojaScene",stores.get(5));

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

    @FXML
    private Button btVoltar;

    @FXML
    private Button btProxima;

    @FXML
    private Button btVerLoja1;

    @FXML
    private Button btVerLoja2;

    @FXML
    private Button btVerLoja3;

    @FXML
    private Button btVerLoja4;

    @FXML
    private Button btVerLoja5;

    @FXML
    private Button btVerLoja6;

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

}
