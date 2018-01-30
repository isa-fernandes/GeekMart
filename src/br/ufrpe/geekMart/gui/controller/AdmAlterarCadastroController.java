package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Administrador;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;


public class AdmAlterarCadastroController {

        Administrador user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                                if(newScreen.equals("admAlterarCadastroScene")) {
                                        user=(Administrador)userData;
                                        updateCadastroTela();


                                } }
                });




        }

        private void updateCadastroTela(){
                lbNome.setText(user.getNome());
                lbCPF.setText(user.getCpf());
                tfEmail.setText(user.getEmail());
                tfTelefone.setText(user.getTelefone());



        }

        @FXML
        protected  void btAlterarADMAction(ActionEvent e){
                try {

                        if (tfEmail.getText().isEmpty())
                                throw new RuntimeException("O campo e-mail não pode ser vazio");
                        if (tfTelefone.getText().isEmpty())
                                throw new RuntimeException("O campo telefone não pode ser vazio");
                        if (pwfSenha.getText().isEmpty())
                                throw new RuntimeException("O campo senha não pode ser vazio");


                        Administrador g = new Administrador(
                                user.getNome(),
                                user.getCpf(),
                                tfEmail.getText(),
                                pwfSenha.getText(),
                                true,
                                true,
                                tfTelefone.getText());

                        fachada.alterarUsuario(user, g);
                        user = g;

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Informação");
                        alert2.setHeaderText("Alteração de ADM");
                        alert2.setContentText("Asm "+g.getNome()+" alterado com sucesso!");
                        alert2.showAndWait();


                } catch (RuntimeException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao alterar o Adm!!");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                } catch (ParametroNullException es){

                } catch (NaoExisteException rr){

                }

        }




        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ComboBox<?> cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private TextField tfEmail;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private TextField tfBuscar;

        @FXML
        private PasswordField pwfSenha;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private Label lbBairro;

        @FXML
        private TextField tfTelefone;

        @FXML
        private Button btAlterarCadastro;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Label lbEstado;

        @FXML
        private Button btCHAT;

        @FXML
        private Label lbLogradouro;

        @FXML
        private Label lbNome;

        @FXML
        private ComboBox<?> cbLojas;

        @FXML
        private Label lbCPF;

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





}
