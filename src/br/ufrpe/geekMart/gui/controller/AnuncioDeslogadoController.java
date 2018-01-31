package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumEstrelas;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class AnuncioDeslogadoController {




        Fachada fachada = Fachada.getInstancia();
        Anuncio user;
        Image image = new Image("/imagens/estrela.png");

        @FXML
        protected  void  initialize(){
            Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                @Override
                public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                            ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                    if(newScreen.equals("anuncioDeslogadoScene")) {
                        user = (Anuncio)userData;
                        updateComboBoxCategorias();
                        updateComboBoxLojas();
                        updateAnuncio();

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



        private void updateAnuncio(){
            imCentral.setImage(user.getImagem1());
            im2.setImage(user.getImagem2());
            im3.setImage(user.getImagem3());
            lbPreco.setText(user.getPreco());
            lbQtdade.setText(Integer.toString(user.getQuantidadeProdutos()));
            lbTitulo.setText(user.getTitulo());
            lbCategoria.setText(user.getCategoria().toString());
            lbEstado.setText(user.getEstado().toString());
            lbDataInicio.setText(user.getData().toString());
            lbDataExpira.setText(user.getData().toString());
            String ativo;
            if(user.isAtivo()){
                ativo = "Ativo";
            } else {
                ativo = "Falso";
            }
            lbAtivo.setText(ativo);
            if(user.getEstrela() <= 1){
                estrela1.setImage(image);
            } if(user.getEstrela() <= 2){
                estrela1.setImage(image);
                estrela2.setImage(image);
            } if(user.getEstrela() <= 3){
                estrela1.setImage(image);
                estrela2.setImage(image);
                estrela3.setImage(image);
            } if(user.getEstrela() <= 4){
                estrela1.setImage(image);
                estrela2.setImage(image);
                estrela3.setImage(image);
                estrela4.setImage(image);
            } if(user.getEstrela() <= 5){
                estrela1.setImage(image);
                estrela2.setImage(image);
                estrela3.setImage(image);
                estrela4.setImage(image);
                estrela5.setImage(image);
            }
            taDescricao.setText(user.getDescricao());

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
                        Main.trocarTela("resultadoBuscaDeslogado4Scene", resultado);
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
    protected  void btCadastrarAction(ActionEvent e){ Main.trocarTela("cadastrarNovoClienteScene"); }

    @FXML
    protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }

        @FXML
        protected  void btHomeAction(ActionEvent e){
            Main.trocarTela("telaInicialLogadoScene");
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
        protected  void qualificarAction(ActionEvent qa){
            try {
                int valor = Integer.parseInt(cbEstrelas.getSelectionModel().toString());
                fachada.avaliarProduto(user, valor);
                updateAnuncio();
            } catch (ParametroNullException ee){
                Alert alertw = new Alert(Alert.AlertType.WARNING);
                alertw.setTitle("Aviso");
                alertw.setContentText(ee.getMessage());
                alertw.showAndWait();

            } catch (NaoExisteException ww){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setContentText(ww.getMessage());
                alert.show();

            }

        }




        @FXML
        private Text taDescricao;

        @FXML
        private Label lbPreco;

        @FXML
        private Label lbDataInicio;

        @FXML
        private Label lbCategoria;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private ImageView im3;

        @FXML
        private ImageView im2;

        @FXML
        private Button btMinhasLojas;


        @FXML
        private Label lbEstado;

        @FXML
        private Button btCHAT;

        @FXML
        private ComboBox cbEstrelas;

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
        private Label lbAtivo;

        @FXML
        private ImageView imCentral;

        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ImageView estrela1;

        @FXML
        private TextField tfBuscar;

        @FXML
        private ImageView estrela5;

        @FXML
        private ImageView estrela4;

        @FXML
        private Button btHome;

        @FXML
        private ImageView estrela3;

        @FXML
        private ImageView estrela2;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Label lbTitulo;

        @FXML
        private Label lbDataExpira;

        @FXML
        private ComboBox cbLojas;





}
