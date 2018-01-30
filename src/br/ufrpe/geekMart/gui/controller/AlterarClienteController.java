package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AlterarClienteController {

        Cliente user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, Object userData2) {
                                if(newScreen.equals("alterarClienteScene")) {
                                        user=(Cliente)userData;
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();
                                        updateCadastroTela();
                                        updateComboBoxEstados();

                                } }
                });


                updateComboBoxCategorias();
                updateComboBoxLojas();
                updateComboBoxEstados();


        }


        private void updateCadastroTela(){
                lbNome.setText(user.getNome());
                lbCPF.setText(user.getCpf());
                tfEmail.setText(user.getEmail());
                tfTelefone.setText(user.getTelefone());
                tfLogradouro.setText(user.getEndereco().getLogradouro());
                tfNumero.setText(user.getEndereco().getNumero());
                tfBairro.setText(user.getEndereco().getBairro());
                tfCidade.setText(user.getEndereco().getCidade());
                tfCEP.setText(user.getEndereco().getCep());
                cbEstado.setValue(user.getEndereco().getEstado().toString());
                tfComplemento.setText(user.getEndereco().getComplemento());

        }

        @FXML
        protected  void AlterarClienteAction(ActionEvent e){
                try {

                        if(tfEmail.getText().isEmpty())
                                throw new RuntimeException("O campo e-mail não pode ser vazio");
                        if(tfTelefone.getText().isEmpty())
                                throw new RuntimeException("O campo telefone não pode ser vazio");
                        if(tfLogradouro.getText().isEmpty())
                                throw new RuntimeException("O campo logradouro não pode ser vazio");
                        if(tfNumero.getText().isEmpty())
                                throw new RuntimeException("O campo número não pode ser vazio");
                        if(tfBairro.getText().isEmpty())
                                throw new RuntimeException("O campo bairro não pode ser vazio");
                        if(tfCidade.getText().isEmpty())
                                throw new RuntimeException("O campo cidade não pode ser vazio");
                        if(tfCEP.getText().isEmpty())
                                throw new RuntimeException("O campo cep não pode ser vazio");
                        if(tfComplemento.getText().isEmpty())
                                throw new RuntimeException("O campo complemento não pode ser vazio");
                        if(pqSenha.getText().isEmpty())
                                throw new RuntimeException("O campo senha não pode ser vazio");
                        if (cbEstado.getSelectionModel().isEmpty())
                                throw new RuntimeException("O campo estado não pode ser vazio");



                        Endereco c = new Endereco(
                                tfLogradouro.getText(),
                                tfNumero.getText(),
                                tfBairro.getText(),
                                tfCidade.getText(),
                                (EnumEstados) cbEstado.getSelectionModel().getSelectedItem(),
                                tfCEP.getText(),
                                tfComplemento.getText());

                        boolean a = false;
                        boolean b = true;

                        Cliente g = new Cliente(
                                lbNome.getText(),
                                tfEmail.getText(),
                                lbCPF.getText(),
                                tfTelefone.getText(),
                                c,
                                pqSenha.getText(),
                                a, b);



                        fachada.alterarUsuario(user,g);
                        user = g;


                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Informação");
                        alert2.setHeaderText("Alteração de Usuário");
                        alert2.setContentText("Usuário "+lbNome.getText()+" alterado com sucesso!");
                        alert2.showAndWait();

                } catch (RuntimeException ex){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao alterar o Usuário");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                } catch (ParametroNullException parException) {
                        //TODO
                } catch (NaoExisteException nExisExcep) {
                        //TODO
                }



        }

        @FXML
        protected  void cancelarAction(ActionEvent ee){
                tfLogradouro.setText("");
                tfNumero.setText("");
                tfBairro.setText("");
                tfCidade.setText("");
                tfCEP.setText("");
                tfComplemento.setText("");
                tfEmail.setText("");
                tfTelefone.setText("");
                pqSenha.setText("");
        }




        private  void  updateComboBoxCategorias(){
                this.cbCategorias.getItems().setAll(EnumCategorias.values());
        }

        private void updateComboBoxLojas(){
                this.cbLojas.getItems().setAll(EnumCategorias.values());
        }

        private void updateComboBoxEstados(){
                this.cbEstado.getItems().setAll(EnumEstados.values());
        }





        @FXML
        private ComboBox cbCategorias;

        @FXML
        private ComboBox cbEstado;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private Button btCHAT;

        @FXML
        private PasswordField pqSenha;

        @FXML
        private Label lbCPF;

        @FXML
        private TextField tfComplemento;
        @FXML
        private TextField tfEstado;
        @FXML
        private TextField tfBairro;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        private Button btMeusAnuncios;


        @FXML
        private Button btAlterarCliente;

        @FXML
        private TextField tfEmail;

        @FXML
        private TextField tfBuscar;

        @FXML
        private Button btHome;

        @FXML
        private TextField tfCEP;

        @FXML
        private TextField tfNumero;

        @FXML
        private TextField tfTelefone;

        @FXML
        private MenuItem menuSair;

        @FXML
        private TextField tfLogradouro;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private TextField tfCidade;

        @FXML
        private Label lbNome;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private Button btCancelar;

        @FXML
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialLogadoScene",user);
        }

        @FXML
        protected  void btMeuCadastroAction(ActionEvent e){
                Main.trocarTela("cadastroClienteScene",user);
        }

        @FXML
        protected  void btMeusAnunciosAction(ActionEvent e){ Main.trocarTela("meusAnunciosScene",user); }

        @FXML
        protected  void btMinhasLojasAction(ActionEvent e){
                Main.trocarTela("minhasLojasScene",user);
        }

        @FXML
        protected  void btNovoAnuncioAction(ActionEvent e){
                Main.trocarTela("cadastrarNovoAnuncioScene",user);
        }

        @FXML
        protected  void btNovaLojaAction(ActionEvent e){
                Main.trocarTela("cadastrarNovaLojaScene",user);
        }

        @FXML
        protected  void btChatAction(ActionEvent e){
                Main.trocarTela("chatScene",user);
        }



}
