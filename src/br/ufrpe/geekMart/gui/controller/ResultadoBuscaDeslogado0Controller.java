package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ResultadoBuscaDeslogado0Controller {

        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData) {
                                if(newScreen.equals("resultadoBuscaDeslogadoScene")) {
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();

                                } }
                });


                updateComboBoxCategorias();
                updateComboBoxLojas();

        }



        private void updateComboBoxCategorias(){
                for(int i = 0; i < fachada.listarCategorias().size(); i++){
                        cbCategorias.getItems().add(i,fachada.listarCategorias().get(i));
                }
        }

        private void updateComboBoxLojas(){
                for(int i = 0; i < fachada.listarCategorias().size(); i++){
                        cbLojas.getItems().add(i,fachada.listarCategorias().get(i));
                }
        }

        @FXML
        private Button btVoltar;

        @FXML
        private Button btProxima;

        @FXML
        private Button btVerAnuncio1;

        @FXML
        private Button btVerAnuncio2;

        @FXML
        private Button btVerAnuncio3;

        @FXML
        private Button btVerAnuncio4;

        @FXML
        private Button btVerAnuncio5;

        @FXML
        private Button btVerAnuncio6;

        @FXML
        private ImageView imBusca1;

        @FXML
        private ImageView imBusca2;

        @FXML
        private ImageView imBusca3;

        @FXML
        private ImageView imBusca4;

        @FXML
        private ImageView imBusca5;

        @FXML
        private ImageView imBusca6;






        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btEntre;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btCadastrar;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private TextField tfBuscar;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private MenuItem menuSobreApp;



        @FXML
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialLogadoScene");
        }

        @FXML
        protected  void btCadastrarAction(ActionEvent e){ Main.trocarTela("cadastrarNovoClienteScene"); }

        @FXML
        protected  void btEntrarAction(ActionEvent e){
                Main.trocarTela("telaLoginScene");
        }




}
