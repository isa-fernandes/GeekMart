package br.ufrpe.geekMart.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLoginController {





        @FXML
        private PasswordField tfSenha;

        @FXML
        private Button btEntrar;

        @FXML
        private ComboBox<?> cbCategorias;

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
        private ComboBox<?> cbLojas;

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


}
