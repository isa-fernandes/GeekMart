package br.ufrpe.geekMart.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AdmDeletarAnuncioController {




        @FXML
        private TextField tfTituloDoAnuncio;

        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ComboBox<?> cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private TextField tfBuscar;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private Label lbTelefone;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Button btCHAT;

        @FXML
        private ComboBox<?> cbLojas;

        @FXML
        private Label lbCPF;

        @FXML
        private Label lbEmail;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btDeletarAnuncio;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        private TextField tfCpfDoCliente;

        @FXML
        protected  void btMeuCadastroADMAction(ActionEvent e){
                Main.trocarTela("AdmCadastroScene");
        }

        @FXML
        protected  void btDesbloquearBloquearAction(ActionEvent e){ Main.trocarTela("AdmBloqueioDesbloqueioScene"); }

        @FXML
        protected  void btDeletarAnuncioAction(ActionEvent e){
                Main.trocarTela("AdmDeletarAnuncioScene");
        }

        @FXML
        protected  void btDeletarLojaAction(ActionEvent e){
                Main.trocarTela("AdmDeletarLojaScene");
        }

        @FXML
        protected  void btNovoAdmAction(ActionEvent e){
                Main.trocarTela("AdmCadastrarNovoAdmScene");
        }






}
