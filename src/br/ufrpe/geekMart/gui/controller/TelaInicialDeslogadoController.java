package br.ufrpe.geekMart.gui.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class TelaInicialDeslogadoController {



        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private ComboBox<?> cbCategorias;

        @FXML
        private Button btEntre;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btCadastrar;

        @FXML
        private ComboBox<?> cbLojas;

        @FXML
        private TextField tfBuscar;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
         protected  void btCadastrarAction(ActionEvent e){ Main.trocarTela("cadastrarNovoClienteScene"); }

        @FXML
         protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }



}
