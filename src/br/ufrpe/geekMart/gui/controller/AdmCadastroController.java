package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Administrador;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class AdmCadastroController {

        Administrador user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData) {
                                if(newScreen.equals("admCadastroScene")) {
                                        user=(Administrador)userData;
                                        updateCadastroTela();

                                } }
                });




        }

        private void updateCadastroTela(){
                lbNome.setText(user.getNome());
                lbCPF.setText(user.getCpf());
                lbEmail.setText(user.getEmail());
                lbTelefone.setText(user.getTelefone());
                lbNdeUsuarios.setText(Integer.toString(fachada.getProximaUsuario()));
                lbNdeAnuncios.setText(Integer.toString(fachada.getProximaAnuncio()));
                lbndeLojas.setText(Integer.toString(fachada.getProximaLoja()));

        }



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
        private Label lbNdeAnuncios;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private Label lbTelefone;

        @FXML
        private Button btAlterarCadastro;

        @FXML
        private MenuItem menuSair;

        @FXML
        private Label lbNdeUsuarios;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Button btCHAT;

        @FXML
        private Label lbNome;

        @FXML
        private Label lbndeLojas;


        @FXML
        private Label lbCPF;

        @FXML
        private Label lbEmail;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        protected  void btMeuCadastroADMAction(ActionEvent e){
                Main.trocarTela("admCadastroScene");
        }

        @FXML
        protected  void btDesbloquearBloquearAction(ActionEvent e){ Main.trocarTela("admBloqueioDesbloqueioScene"); }

        @FXML
        protected  void btDeletarAnuncioAction(ActionEvent e){
                Main.trocarTela("admDeletarAnuncioScene");
        }

        @FXML
        protected  void btDeletarLojaAction(ActionEvent e){
                Main.trocarTela("admDeletarLojaScene");
        }

        @FXML
        protected  void btNovoAdmAction(ActionEvent e){
                Main.trocarTela("admCadastrarNovoAdmScene");
        }

        @FXML
        protected  void btAlterarAdmAction(ActionEvent e){
        Main.trocarTela("admAlterarCadastroScene",user);
    }




}
