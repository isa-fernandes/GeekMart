package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
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
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4)  {

                                if (newScreen.equals("cadastrarNovaLojaScene")) {
                                    user = fachada.loadMemoryCardCliente();
                                    updateComboBoxCategorias();
                                    updateComboBoxCategoria();
                                    updateComboBoxLojas();
                                    updateList();

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


        private void updateList() {
                lvMeusAnuncios.getItems().clear();

                for (int i = 0; i < user.getAnuncios().size(); i++) {
                        lvMeusAnuncios.getItems().addAll(user.getAnuncios());
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
        private ListView<Anuncio> lvMeusAnuncios;

        @FXML
        private ListView<Anuncio> lvAnunciosDaLoja;

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
    protected  void btMeusAnunciosAction(ActionEvent e){

        ArrayList<Anuncio> anuncios = user.getAnuncios();

        if(anuncios.size()<6 && anuncios.size()>=0) {

            switch (anuncios.size()) {
                case 1:
                    Main.trocarTela("meusAnuncios1Scene", user,anuncios);
                    break;
                case 2:
                    Main.trocarTela("meusAnuncios2Scene",user, anuncios);
                    break;
                case 3:
                    Main.trocarTela("meusAnuncios3Scene",user, anuncios);
                    break;
                case 4:
                    Main.trocarTela("meusAnuncios4Scene",user, anuncios);
                    break;
                case 5:
                    Main.trocarTela("meusAnuncios5Scene", user,anuncios);
                    break;

                case 0:
                    Main.trocarTela("meusAnuncios0Scene",user, anuncios);
                    break;
            }
        } else if(anuncios.size() >= 6) {
            Main.trocarTela("meusAnuncios6Scene",user, anuncios);
        }


    }

    @FXML
    protected  void btMinhasLojasAction(ActionEvent e){

        ArrayList<Loja> lojas = user.getLojas();

        if(lojas.size()<6 && lojas.size()>=0) {

            switch (lojas.size()) {
                case 1:
                    Main.trocarTela("minhasLojas1Scene", user);
                    break;
                case 2:
                    Main.trocarTela("minhasLojas2Scene",user);
                    break;
                case 3:
                    Main.trocarTela("minhasLojas3Scene",user);
                    break;
                case 4:
                    Main.trocarTela("minhasLojas4Scene",user);
                    break;
                case 5:
                    Main.trocarTela("minhasLojas5Scene", user);
                    break;

                case 0:
                    Main.trocarTela("minhasLojas0Scene",user);
                    break;
            }
        } else if(lojas.size() >= 6) {
            Main.trocarTela("minhasLojas6Scene",user);
        }


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
                                user.getCpf());
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
                        alert2.setHeaderText("Criação de Loja");
                        alert2.setContentText("Loja "+tfTitulo.getText()+" criada com sucesso!");
                        alert2.showAndWait();


                        tfTitulo.setText("");
                        taDescricao.setText("");
                        tfTelefone.setText("");
                        lvAnunciosDaLoja.getItems().clear();

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
            Anuncio anuncio = lvMeusAnuncios.getSelectionModel().getSelectedItem();
            lvAnunciosDaLoja.getItems().add(anuncio);
            lvMeusAnuncios.getItems().remove(anuncio);
        }

    }
    @FXML
    protected void btDelPersonAction(ActionEvent e) {
            Anuncio anuncio = lvAnunciosDaLoja.getSelectionModel().getSelectedItem();
        lvAnunciosDaLoja.getItems().remove(anuncio);
        lvMeusAnuncios.getItems().add(anuncio);
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
