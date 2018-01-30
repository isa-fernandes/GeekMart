package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AdmDeletarLojaController {


        Administrador user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, Object userData2) {
                                if(newScreen.equals("admDeletarLojaScene")) {
                                        user=(Administrador)userData;


                                } }
                });




        }

        @FXML
        protected  void deletarLojaAction(ActionEvent e) {

                try {
                        if(tfCpfCliente.getText().isEmpty())
                                throw new RuntimeException("O campo CPF não pode ser vazio");
                        if(tfTituloDaLoja.getText().isEmpty())
                                throw new RuntimeException("O campo Título não pode ser vazio");

                        fachada.removerLoja(tfTituloDaLoja.getText(), tfCpfCliente.getText());
                } catch (ParametroNullException ss){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setContentText("Dados informados estão errados");
                        alert.show();
                } catch (NaoExisteException hh) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setContentText("Cliente ou Loja não existem ");
                        alert.show();
                } catch (NullPointerException ex){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao deletar o loja!!");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                }

        }

        @FXML
        private Button btMeusAnuncios;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btDeletarLoja;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private TextField tfBuscar;

        @FXML
        private TextField tfCpfCliente;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private Label lbTelefone;

        @FXML
        private TextField tfTituloDaLoja;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private Button btCHAT;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private Label lbPrecoII3;;

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
                Main.trocarTela("admCadastroScene",user);
        }

        @FXML
        protected  void btDesbloquearBloquearAction(ActionEvent e){ Main.trocarTela("admBloqueioDesbloqueioScene",user); }

        @FXML
        protected  void btDeletarAnuncioAction(ActionEvent e){
                Main.trocarTela("admDeletarAnuncioScene",user);
        }

        @FXML
        protected  void btDeletarLojaAction(ActionEvent e){
                Main.trocarTela("admDeletarLojaScene",user);
        }

        @FXML
        protected  void btNovoAdmAction(ActionEvent e){
                Main.trocarTela("admCadastrarNovoAdmScene",user);
        }





}
