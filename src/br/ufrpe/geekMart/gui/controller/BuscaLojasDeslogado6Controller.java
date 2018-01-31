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

public class BuscaLojasDeslogado6Controller {

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
                if(newScreen.equals("buscasLojasDeslogado6Scene")) {
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
            Main.trocarTela("buscaLojasDeslogado6Scene",stores);
        }

        if(stores.size() - 6 <6){
            switch (stores.size() - 6) {
                case 1:
                    Main.trocarTela("buscaLojasDeslogado1Scene",stores);
                    break;
                case 2:
                    Main.trocarTela("buscaLojasDeslogado2Scene",stores);
                    break;
                case 3:
                    Main.trocarTela("buscaLojasDeslogado3Scene",stores);
                    break;
                case 4:
                    Main.trocarTela("buscaLojasDeslogado4Scene",stores);
                    break;
                case 5:
                    Main.trocarTela("buscaLojasDeslogado5Scene",stores);
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
        Main.trocarTela("lojaDeslogadoScene",stores.get(0));

    }

    @FXML
    protected  void irParaAnuncioAction2(ActionEvent e){
        Main.trocarTela("lojaDeslogadoScene",stores.get(1));

    }

    @FXML
    protected  void irParaAnuncioAction3(ActionEvent e){
        Main.trocarTela("lojaDeslogadoScene",stores.get(2));

    }

    @FXML
    protected  void irParaAnuncioAction4(ActionEvent e){
        Main.trocarTela("lojaDeslogadoScene",stores.get(3));

    }

    @FXML
    protected  void irParaAnuncioAction5(ActionEvent e){
        Main.trocarTela("lojaDeslogadoScene",stores.get(4));

    }

    @FXML
    protected  void irParaAnuncioAction6(ActionEvent e){
        Main.trocarTela("lojaDeslogadoScene",stores.get(5));

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
                    Main.trocarTela("resultadoBuscaDeslogado0Scene", resultado);
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
        ArrayList<Loja> anuncios = fachada.buscarLojaPorTitulo(palavra);


        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("buscasLojasDeslogado1Scene", anuncios);
                    break;
                case 2:
                    Main.trocarTela("buscasLojasDeslogado2Scene", anuncios);
                    break;
                case 3:
                    Main.trocarTela("buscasLojasDeslogado3Scene", anuncios);
                    break;
                case 4:
                    Main.trocarTela("buscasLojasDeslogado4Scene", anuncios);
                    break;
                case 5:
                    Main.trocarTela("buscasLojasDeslogado5Scene", anuncios);
                    break;

                case 0:
                    Main.trocarTela("buscasLojasDeslogado0Scene", anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("buscasLojasDeslogado6Scene", anuncios);
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
    protected  void btCadastrarAction(ActionEvent e){
        Main.trocarTela("cadastrarNovoClienteScene"); }

    @FXML
    protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }

}
