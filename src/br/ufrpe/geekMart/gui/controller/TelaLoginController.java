package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.LoginSemSucessoException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class TelaLoginController {

        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                                if(newScreen.equals("telaLoginScene")) {
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();

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
        private PasswordField tfSenha;

        @FXML
        private Button btEntrar;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private TextField tfBuscar;

        @FXML
        private Button btHome;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private TextField tfCPF;

        @FXML
        private Button btEntre;

        @FXML
        private Button btCadastrar;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialDeslogadoScene");
        }

        @FXML
        protected  void btCadastrarAction(ActionEvent e){ Main.trocarTela("cadastrarNovoClienteScene"); }

        @FXML
        protected  void fazerLoginAction(ActionEvent e) throws ParametroNullException {
                try {
                        if(tfCPF.getText().isEmpty())
                                throw new RuntimeException("O campo cpf não pode ser vazio");
                        if(tfSenha.getText().isEmpty())
                                throw new RuntimeException("O campo senha não pode ser vazio");

                                if (fachada.autenticarLogin(tfSenha.getText(), tfCPF.getText())) {
                                        if (fachada.buscaUsuario(tfCPF.getText()).isAdm()) {
                                                Administrador adm = (Administrador)fachada.buscaUsuario(tfCPF.getText());
                                                Main.trocarTela("admCadastroScene",adm);
                                        } else {
                                                Cliente cliente = (Cliente)fachada.buscaUsuario(tfCPF.getText());
                                                fachada.salvarMemoryCardCliente(cliente);
                                                Main.trocarTela("cadastroClienteScene",cliente);
                                        }

                                }

                } catch (RuntimeException ex){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao tentar logar");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                } catch (LoginSemSucessoException es){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao tentar logar");
                        alert.setContentText("Senha ou CPF errados");
                        alert.showAndWait();

                } catch (NaoExisteException er){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao tentar logar");
                        alert.setContentText("Senha ou CPF não cadastrados");
                        alert.showAndWait();
                }

        }


}
