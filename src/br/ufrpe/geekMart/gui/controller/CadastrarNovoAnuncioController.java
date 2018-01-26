package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Categorias;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Endereco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;


public class CadastrarNovoAnuncioController {

        Cliente user;

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData) {
                                if(newScreen.equals("cadastrarNovoAnuncioScene")) {
                                        user = (Cliente)userData;
                                        System.out.println("");
                                        System.out.println(user);
                                        updateComboBoxCategoriaAnuncio();
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();

                                } }
                });

                updateComboBoxCategoriaAnuncio();
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

    private void updateComboBoxCategoriaAnuncio(){

        for(int i = 0; i < fachada.listarCategorias().size(); i++){
            cbCategoria.getItems().add(i,fachada.listarCategorias().get(i));
        }
    }

        Fachada fachada = Fachada.getInstancia();


        @FXML
        private TextField tfPreco;

        @FXML
        private Button btTrocarImagem1;

        @FXML
        private ComboBox cbCategoria;

        @FXML
        private Button btTrocarImagem2;

        @FXML
        private ImageView imageV2;

        @FXML
        private ImageView imageV1;

        @FXML
        private Button btTrocarImagem3;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private ImageView imageV3;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private TextArea taDescricao;

        @FXML
        private TextField tfTitulo;

        @FXML
        private Button btCriarAnuncio;

        @FXML
        private Button btCHAT;

        @FXML
        private Button btNovaLoja;

        @FXML
        private MenuItem menuLoginAdm;

        @FXML
        private Button btNovoAnuncio;

        @FXML
        private MenuItem menuSobreApp;

        @FXML
        private TextField tfQuantidade;

        @FXML
        private TextField tfEstado;


        @FXML
        private Button btMeusAnuncios;


        @FXML
        private TextField tfBuscar;

        @FXML
        private Button btHome;

        @FXML
        private TextField tfTelefone;

        @FXML
        private MenuItem menuSair;

        @FXML
        private MenuItem menuLoginCliente;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private Button btCancelar;

        @FXML
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialLogadoScene");
        }

        @FXML
        protected  void btMeuCadastroAction(ActionEvent e){
                Main.trocarTela("cadastroClienteScene");
        }

        @FXML
        protected  void btMeusAnunciosAction(ActionEvent e){ Main.trocarTela("meusAnunciosScene"); }

        @FXML
        protected  void btMinhasLojasAction(ActionEvent e){
                Main.trocarTela("minhasLojasScene");
        }

        @FXML
        protected  void btNovoAnuncioAction(ActionEvent e){
                Main.trocarTela("cadastrarNovoAnuncioScene");
        }

        @FXML
        protected  void btNovaLojaAction(ActionEvent e){
                Main.trocarTela("cadastrarNovaLojaScene");
        }

        @FXML
        protected  void btChatAction(ActionEvent e){
                Main.trocarTela("chatScene");
        }

        @FXML
        protected  void cadastrarNovoAnuncioAction(ActionEvent e){

        try {
                if(tfTitulo.getText().isEmpty())
                        throw new RuntimeException("O campo nome não pode ser vazio");
                if(tfPreco.getText().isEmpty())
                        throw new RuntimeException("O campo cpf não pode ser vazio");
                if(tfQuantidade.getText().isEmpty())
                        throw new RuntimeException("O campo e-mail não pode ser vazio");
                if(tfTelefone.getText().isEmpty())
                        throw new RuntimeException("O campo telefone não pode ser vazio");
                if(tfEstado.getText().isEmpty())
                        throw new RuntimeException("O campo estado não pode ser vazio");
                if(cbCategoria.getSelectionModel().isEmpty())
                        throw new RuntimeException("O campo categoria não pode ser vazio");
                if(taDescricao.getText().isEmpty())
                        throw new RuntimeException("O campo descrição não pode ser vazio");


                Endereco c = new Endereco(tfEstado.getText());



                Anuncio g = new Anuncio(
                        user,
                        tfPreco.getText(),
                        tfTitulo.getText(),
                        taDescricao.getText(),
                        (String)cbCategoria.getSelectionModel().getSelectedItem(),
                        c,
                        Integer.parseInt(tfQuantidade.getText()),
                        tfTelefone.getText());




                fachada.cadastrarAnuncio(g);

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText("Criação de Anúncio");
                alert2.setContentText("Anúncio "+tfTitulo.getText()+" criado com sucesso!");
                alert2.showAndWait();

            tfPreco.setText("");
            tfTitulo.setText("");
            taDescricao.setText("");
            tfQuantidade.setText("");
            tfEstado.setText("");
            tfTelefone.setText("");

        } catch (RuntimeException ex){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao criar o Anúncio");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
        } catch (ParametroNullException exx){
                Alert alertw = new Alert(Alert.AlertType.ERROR);
                alertw.setTitle("Erro");
                alertw.setHeaderText("Erro ao criar o Anúncio");
                alertw.setContentText("Não foi possível completar o cadastro!!");
                alertw.showAndWait();
        } catch (JaExisteException exx) {
                Alert alertw = new Alert(Alert.AlertType.ERROR);
                alertw.setTitle("Erro");
                alertw.setHeaderText("Erro ao criar o Anúncio");
                alertw.setContentText("Esse Anúncio já existe!");
                alertw.showAndWait();
        }



}

        @FXML
        protected  void cancelarAction(ActionEvent ee){
                tfPreco.setText("");
                tfTitulo.setText("");
                taDescricao.setText("");
                tfQuantidade.setText("");
                tfEstado.setText("");
                tfTelefone.setText("");
        }


}
