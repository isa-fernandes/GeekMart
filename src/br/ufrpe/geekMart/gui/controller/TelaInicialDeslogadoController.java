package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Administrador;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Endereco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class TelaInicialDeslogadoController {


        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData) {
                                if(newScreen.equals("telaInicialDeslogadoScene")) {
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();


                                } }
                });


                updateComboBoxCategorias();
                updateComboBoxLojas();
                admPadrao();
                clientePadrao();

        }

        private void admPadrao(){
                try {
                        Administrador g = new Administrador(
                                "Huan Christopher",
                                "123456",
                                "adm@adm",
                                "123456",
                                true,
                                true,
                                "(81)996074398");

                        fachada.cadastrarUsuario(g);
                } catch (NaoExisteException ee){

                }  catch (ParametroNullException ee){

                } catch (JaExisteException ee){

                }
        }

        private void clientePadrao(){
                try {
                        Endereco end = new Endereco(
                                "Alto do Deodato",
                                "278",
                                "Agua Fria",
                                "Recife",
                                "Pernambuco",
                                "52211500",
                                "Casa");

                        Cliente huan = new Cliente(
                                "Huan Christopher",
                                "huan@gm",
                                "071",
                                "(81)996074398",
                                end,
                                "071",
                                false,
                                true);

                        fachada.cadastrarUsuario(huan);
                } catch (NaoExisteException ee){

                }  catch (ParametroNullException ee){

                } catch (JaExisteException ee){

                }
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
         protected  void btCadastrarAction(ActionEvent e){ Main.trocarTela("cadastrarNovoClienteScene"); }

        @FXML
         protected  void btEntrarAction(ActionEvent e){
        Main.trocarTela("telaLoginScene");
    }



}
