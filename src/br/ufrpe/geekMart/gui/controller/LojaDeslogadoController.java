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

public class LojaDeslogadoController {



        Fachada fachada = Fachada.getInstancia();
        Loja user;

        @FXML
        protected  void  initialize(){
            Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                @Override
                public void onScreenChanged(String newScreen, Object userData,Object userData2) {
                    if(newScreen.equals("LojaScene")) {
                        user = (Loja)userData;
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
            imCentral.setImage(user.getImage());
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
        protected  void btMeusAnunciosAction(ActionEvent e){ Main.trocarTela("meusAnunciosScene"); }

        @FXML
        protected  void btMinhasLojasAction(ActionEvent e){
            Main.trocarTela("minhasLojasScene");
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
        private TextArea taDescricao;

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

    @FXML
    protected  void btCadastrarAction(ActionEvent e){ Main.trocarTela("cadastrarNovoClienteScene"); }

    @FXML
    protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }







}
