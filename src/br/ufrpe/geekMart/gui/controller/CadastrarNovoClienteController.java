package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class CadastrarNovoClienteController {

        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, Object userData2) {
                                if(newScreen.equals("cadastrarNovoClienteScene")) {
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();
                                        updateComboBoxEstado();

                                } }
                });


                updateComboBoxCategorias();
                updateComboBoxLojas();
                updateComboBoxEstado();

        }



        private  void  updateComboBoxCategorias(){
                this.cbCategorias.getItems().setAll(EnumCategorias.values());
        }

        private void updateComboBoxLojas(){
                this.cbLojas.getItems().setAll(EnumCategorias.values());
        }

        private void updateComboBoxEstado(){
                this.cbEstado.getItems().setAll(EnumEstados.values());
        }

        @FXML
        private TextField tfEstado;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private ComboBox cbEstado;

        @FXML
        private Button btSalvar;

        @FXML
        private Button btBuscar;

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
        private TextField tfCPF;

        @FXML
        private Button btEntre;

        @FXML
        private TextField tfCidade;

        @FXML
        private PasswordField pqSenha;

        @FXML
        private Button btCadastrar;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private TextField tfComplemento;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        private TextField tfNome;

        @FXML
        private Button btCancelar;

        @FXML
        private TextField tfBairro;

        @FXML
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialDeslogadoScene");
        }

        @FXML
        protected  void btEntrarAction(ActionEvent e){
                Main.trocarTela("telaLoginScene");
        }

        @FXML
        protected  void cancelarAction(ActionEvent ee){
                tfLogradouro.setText("");
                tfNumero.setText("");
                tfBairro.setText("");
                tfCidade.setText("");

                tfCEP.setText("");
                tfComplemento.setText("");
                tfNome.setText("");
                tfCPF.setText("");
                tfEmail.setText("");
                tfTelefone.setText("");
                pqSenha.setText("");
        }

        @FXML
        protected  void cadastrarNovoClienteAction(ActionEvent e){
                try {
                        if(tfNome.getText().isEmpty())
                                throw new RuntimeException("O campo nome não pode ser vazio");
                        if(tfCPF.getText().isEmpty())
                                throw new RuntimeException("O campo cpf não pode ser vazio");
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
                        if(tfEstado.getText().isEmpty())
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
                                tfNome.getText(),
                                tfEmail.getText(),
                                tfCPF.getText(),
                                cbEstado.getSelectionModel().toString(),
                                 c,
                                pqSenha.getText(),
                                a, b);



                        fachada.cadastrarUsuario(g);
                        System.out.println(fachada.buscaUsuario(g.getCpf()));

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Informação");
                        alert2.setHeaderText("Cadastro de Usuário");
                        alert2.setContentText("Usuário "+tfNome.getText()+" cadastrado com sucesso!");
                        alert2.showAndWait();

                } catch (RuntimeException ex){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao criar o Usuário");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                } catch (ParametroNullException exx){
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Usuário");
                        alertw.setContentText("Não foi possível completar o cadastro!!");
                        alertw.showAndWait();
                } catch (NaoExisteException exx){
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Usuário");
                        alertw.setContentText("Não foi possível completar o cadastro!");
                        alertw.showAndWait();
                } catch (JaExisteException exx) {
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Usuário");
                        alertw.setContentText("Esse usuário já existe!");
                        alertw.showAndWait();
                }

                        tfLogradouro.setText("");
                        tfNumero.setText("");
                        tfBairro.setText("");
                        tfCidade.setText("");

                        tfCEP.setText("");
                        tfComplemento.setText("");
                        tfNome.setText("");
                        tfCPF.setText("");
                        tfEmail.setText("");
                        tfTelefone.setText("");
                        pqSenha.setText("");

        }

}
