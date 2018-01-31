package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class TelaInicialDeslogadoController {


        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                                if(newScreen.equals("telaInicialDeslogadoScene")) {
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();


                                } }
                });


                updateComboBoxCategorias();
                updateComboBoxLojas();
                admPadrao();
                clientePadrao();

        }

        private void admPadrao(){
                try {
                        Administrador g = new Administrador(
                                "Huan Christopher",
                                "123456",
                                "adm@adm",
                                "123456",
                                true,
                                true,
                                "(81)996074398");

                        fachada.cadastrarUsuario(g);
                } catch (NaoExisteException ee){

                }  catch (ParametroNullException ee){

                } catch (JaExisteException ee){

                }
        }

        private void clientePadrao(){
                try {

                        Endereco end = new Endereco(
                                "Alto do Deodato",
                                "278",
                                "Agua Fria",
                                "Recife",
                                EnumEstados.PE,
                                "52211500",
                                "Casa");

                        Cliente huan = new Cliente(
                                "Huan Christopher",
                                "071",
                                "huan@gm",
                                "(81)996074398",
                                end,
                                "071",
                                false,
                                true);

                        Image image1 = new Image("/imagens/estrela.png");
                        Image image2 = new Image("/imagens/estrela.png");
                        Image image3 = new Image("/imagens/estrela.png");
                        Anuncio an = new Anuncio(
                                huan,
                                "69",
                                "teste",
                                "Teste",
                                EnumCategorias.FIGURAS_ESTÁTUAS_E_BONECOS,
                                EnumEstados.PE,
                                3,
                                "996074398",
                                image1,
                                image2,
                                image3);

                        Anuncio an2 = new Anuncio(
                                huan,
                                "89",
                                "Teste2",
                                "Teste2",
                                EnumCategorias.FIGURAS_ESTÁTUAS_E_BONECOS,
                                EnumEstados.PE,
                                3,
                                "996074398",
                                image1,
                                image2,
                                image3);

                        Anuncio an3 = new Anuncio(
                                huan,
                                "100",
                                "Teste3",
                                "Teste3",
                                EnumCategorias.FIGURAS_ESTÁTUAS_E_BONECOS,
                                EnumEstados.PE,
                                3,
                                "996074398",
                                image1,
                                image2,
                                image3);

                        Loja lj = new Loja(
                                "Loja Cloth Myth",
                                "123456",
                                "Loja Teste da GeekMart",
                                EnumCategorias.CAMISAS,
                                huan.getCpf());

                        lj.getAnuncios().add(an); lj.getAnuncios().add(an2); lj.getAnuncios().add(an3);
                        huan.getLojas().add(lj);
                        huan.getAnuncios().add(an);
                        huan.getAnuncios().add(an2);
                        huan.getAnuncios().add(an3);
                        fachada.cadastrarLoja(lj);
                        fachada.cadastrarAnuncio(an); fachada.cadastrarAnuncio(an2);fachada.cadastrarAnuncio(an3);
                        fachada.cadastrarUsuario(huan);
                } catch (NaoExisteException ee){

                    System.out.println("1");
                    ee.printStackTrace();
                }  catch (ParametroNullException ee){

                    System.out.println("2");
                    ee.printStackTrace();
                } catch (JaExisteException ee){

                    System.out.println("3");
                    ee.printStackTrace();
                }
        }

        private void clientePadrao2(){
                try {

                        Endereco end2 = new Endereco(
                                "Av.Conde da Boa Vista",
                                "665",
                                "Boa Vista",
                                "Recife",
                                EnumEstados.PE,
                                "52211500",
                                "Ap");

                        Cliente isa = new Cliente(
                                "Isabella",
                                "is@bella",
                                "123",
                                "(81)996074398",
                                end2,
                                "123",
                                false,
                                true);

                        Image image1 = new Image("/imagens/estrela.png");
                        Image image2 = new Image("/imagens/estrela.png");
                        Image image3 = new Image("/imagens/estrela.png");
                        Anuncio an2 = new Anuncio(
                                isa,
                                "89",
                                "teste2",
                                "Teste2",
                                EnumCategorias.FIGURAS_ESTÁTUAS_E_BONECOS,
                                EnumEstados.PE,
                                3,
                                "996074398",
                                image1,
                                image2,
                                image3);


                        Loja lj2 = new Loja(
                                "Loja Teste2",
                                "1234526",
                                "Loja Teste da GeekMart2",
                                EnumCategorias.CAMISAS,
                                isa.getCpf());


                        isa.getLojas().add(lj2);
                        isa.getAnuncios().add(an2);
                        fachada.cadastrarLoja(lj2);
                        fachada.cadastrarAnuncio(an2);
                        fachada.cadastrarUsuario(isa);
                } catch (NaoExisteException ee){

                }  catch (ParametroNullException ee){

                } catch (JaExisteException ee){

                }
        }





        private  void  updateComboBoxCategorias(){
                this.cbCategorias.getItems().setAll(EnumCategorias.values());
        }

        private void updateComboBoxLojas(){
                this.cbLojas.getItems().setAll(EnumCategorias.values());
        }

        @FXML
        protected  void buscaAnunciosPorTituloOrdenadoPorPreço(ActionEvent e){

                String palavra = tfBuscar.getText();
                ArrayList<Anuncio> resultado = fachada.buscarAnuncioPorTituloOrdenadoPeloPreco(palavra);


                Anuncio[] anuncios = fachada.listarAnuncios();

                if(resultado.size()<6 && resultado.size()>=0) {

                        switch (resultado.size()) {
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
                } else if(resultado.size() >= 6) {
                        Main.trocarTela("resultadoBuscaDeslogado6Scene", anuncios);
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
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private ComboBox cbCategorias;


        @FXML
        private Button btBuscar;


        @FXML
        private ComboBox cbLojas;

        @FXML
        private TextField tfBuscar;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        private Button btEntre;

        @FXML
        private Button btCadastrar;

        @FXML
         protected  void btCadastrarAction(ActionEvent e){
                Main.trocarTela("cadastrarNovoClienteScene"); }

        @FXML
         protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }



}
