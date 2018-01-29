package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;


public class CadastrarNovaLojaController {

        Cliente user;
        Fachada fachada = Fachada.getInstancia();


        @FXML
        protected  void  initialize()  {
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData)  {
                            try{
                                if(newScreen.equals("cadastrarNovaLojaScene")) {
                                        user = (Cliente)userData;
                                        updateComboBoxCategorias();
                                        updateComboBoxCategoria();
                                        updateComboBoxLojas();
                                        updateList();

                                } } catch (NaoExisteException ee){

                            } catch (ParametroNullException ee ){

                            }   catch (JaExisteException ee){

                            }
                        }
                });


                updateComboBoxCategorias();
                updateComboBoxCategoria();
                updateComboBoxLojas();


        }

        @FXML
        private  void  updateComboBoxCategorias(){
            this.cbCategorias.getItems().setAll(EnumCategorias.values());
        }

        @FXML
        private void updateComboBoxLojas(){
            this.cbLojas.getItems().setAll(EnumCategorias.values());
        }

        @FXML
        private void updateComboBoxCategoria(){
            this.cbCategoria.getItems().setAll(EnumCategorias.values());
        }

        @FXML
        private void updateComboBoxEstados(){
            this.cbEstado.getItems().setAll(EnumEstados.values());
        }


        private void updateList() throws NaoExisteException, ParametroNullException, JaExisteException{
                lvMeusAnuncios.getItems().clear();
                Cliente cll = (Cliente)fachada.buscaUsuario(user.getCpf());

                for (int i = 0; i < cll.listarAnuncios().size(); i++) {
                        lvMeusAnuncios.getItems().add(i, cll.listarAnuncios().get(i));
                }

        }

         @FXML
         private ComboBox cbEstado;

        @FXML
        private Button btTrocarImagem;

        @FXML
        private ImageView imageV;

        @FXML
        private ComboBox cbCategorias;

        @FXML
        private Button btBuscar;

        @FXML
        private Button btMeuCadastro;

        @FXML
        private Button btMinhasLojas;

        @FXML
        private TextArea taDescricao;

        @FXML
        private TextField tfTitulo;

        @FXML
        private Button btCriarLoja;

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
        private Button btMeusAnuncios;

        @FXML
        private Button btDeletar;

        @FXML
        private ComboBox<EnumCategorias> cbCategoria;

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
        private Button btAdd;

        @FXML
        private ListView lvMeusAnuncios;

        @FXML
        private ListView lvAnunciosDaLoja;

        @FXML
        private ComboBox cbLojas;

        @FXML
        private Button btCancelar;

        @FXML
        protected  void btHomeAction(ActionEvent e) {
                Main.trocarTela("telaInicialLogadoScene",user);
        }

        @FXML
        protected  void btMeuCadastroAction(ActionEvent e){
                Main.trocarTela("cadastroClienteScene",user);
        }

        @FXML
        protected  void btMeusAnunciosAction(ActionEvent e){ Main.trocarTela("meusAnunciosScene",user); }

        @FXML
        protected  void btMinhasLojasAction(ActionEvent e){
                Main.trocarTela("minhasLojasScene",user);
        }

        @FXML
        protected  void btNovoAnuncioAction(ActionEvent e) {
                Main.trocarTela("cadastrarNovoAnuncioScene",user);
        }

        @FXML
        protected  void btNovaLojaAction(ActionEvent e){
                Main.trocarTela("cadastrarNovaLojaScene",user);
        }

        @FXML
        protected  void btChatAction(ActionEvent e){
                Main.trocarTela("chatScene",user);
        }

        @FXML
        protected  void cadastrarNovaLojaAction(ActionEvent e){

                try {
                        if(tfTitulo.getText().isEmpty())
                                throw new RuntimeException("O campo nome não pode ser vazio");
                        if(tfTelefone.getText().isEmpty())
                                throw new RuntimeException("O campo telefone não pode ser vazio");
                        if(taDescricao.getText().isEmpty())
                                throw new RuntimeException("O campo descrição não pode ser vazio");
                        if(cbCategoria.getSelectionModel().isEmpty())
                                throw new RuntimeException("O campo categoria não pode ser vazio");






                        Loja g = new Loja(
                                tfTitulo.getText(),
                                tfTelefone.getText(),
                                taDescricao.getText(),
                                cbCategoria.getSelectionModel().getSelectedItem(),
                                user);
                        if (this.imageV != null) {
                            g.setImage(this.imageV.getImage());
                        }


                    try {

                        ArrayList<Anuncio> listaAnuncios = new ArrayList<>();

                        for (int i = 0; i < lvAnunciosDaLoja.getItems().size(); i++) {
                            listaAnuncios.add(i, (Anuncio) lvAnunciosDaLoja.getItems().get(i));
                        }

                        g.setAnuncios(listaAnuncios);

                    }catch (NullPointerException exx){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao realizar cadastro de presentes!");
                        alert.setContentText("Lista Vazia");
                        alert.showAndWait();
                    }




                        fachada.cadastrarLoja(g);

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Informação");
                        alert2.setHeaderText("Criação de Anúncio");
                        alert2.setContentText("Loja "+tfTitulo.getText()+" criada com sucesso!");
                        alert2.showAndWait();


                        tfTitulo.setText("");
                        taDescricao.setText("");
                        tfTelefone.setText("");

                } catch (RuntimeException ex){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao criar o Loja");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                } catch (ParametroNullException exx){
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Loja");
                        alertw.setContentText("Não foi possível completar o cadastro!!");
                        alertw.showAndWait();
                } catch (JaExisteException exx) {
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao criar o Loja");
                        alertw.setContentText("Esse Loja já existe!");
                        alertw.showAndWait();
                }



        }

    @FXML
    protected void btAddPersonAction(ActionEvent e){
        if(lvMeusAnuncios.getSelectionModel().getSelectedItem() != null) {
            lvAnunciosDaLoja.getItems().add(lvMeusAnuncios.getSelectionModel().getSelectedItem());
        }

    }
    @FXML
    protected void btDelPersonAction(ActionEvent e) {
        lvAnunciosDaLoja.getItems().remove(lvAnunciosDaLoja.getSelectionModel().getSelectedItem());
    }

    @FXML
    protected  void btCancelsAction(ActionEvent e){
        lvAnunciosDaLoja.getItems().clear();
        tfTitulo.setText("");
        taDescricao.setText("");
        tfTelefone.setText("");

    }

        @FXML
        protected void trocarImagem (ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Abrir arquivo");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images",
                                "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png"));
                File file = fileChooser.showOpenDialog(new Stage());
                if (file != null) {
                        try {
                                BufferedImage bufferedImage = ImageIO.read(file);
                                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                                this.imageV.setImage(image);
                        } catch (IOException ioException) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Erro");
                                alert.setContentText("Arquivo inválido");
                                alert.show();
                        }
                }
        }
}
