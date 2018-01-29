package br.ufrpe.geekMart.gui.controller;

import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.LoginSemSucessoException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Administrador;
import br.ufrpe.geekMart.negocio.classesBasicas.EnumCategorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TelaLoginController {

        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData) {
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
        protected  void fazerLoginAction(ActionEvent e) throws ParametroNullException,NaoExisteException,LoginSemSucessoException,JaExisteException{
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
