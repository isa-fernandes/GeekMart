package br.ufrpe.geekMart.gui.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class CadastrarNovoClienteController {


        @FXML
        private ComboBox<?> cbEstado;

        @FXML
        private ComboBox<?> cbCategorias;

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
        private ComboBox<?> cbLojas;

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
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialDeslogadoScene");
        }

        @FXML
        protected  void btEntrarAction(ActionEvent e){
                Main.trocarTela("telaLoginScene");
        }


}
