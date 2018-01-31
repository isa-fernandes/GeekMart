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


public class CadastrarNovoAnuncioController {

        Cliente user;

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                                if(newScreen.equals("cadastrarNovoAnuncioScene")) {
                                        user = (Cliente)userData;
                                        System.out.println("");
                                        System.out.println(user);
                                        updateComboBoxCategoriaAnuncio();
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();
                                        updateComboBoxEstado();

                                } }
                });

                updateComboBoxCategoriaAnuncio();
                updateComboBoxCategorias();
                updateComboBoxLojas();
                updateComboBoxEstado();
        }



    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxCategoriaAnuncio(){

        this.cbCategoria.getItems().setAll(EnumCategorias.values());
    }

    private  void updateComboBoxEstado(){
        this.cbEstado.getItems().setAll(EnumEstados.values());
    }

        Fachada fachada = Fachada.getInstancia();


        @FXML
        private TextField tfPreco;

        @FXML
        private Button btTrocarImagem1;

        @FXML
        private ComboBox cbCategoria;

        @FXML
        private ComboBox cbEstado;

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
        protected  void btNovoAnuncioAction(ActionEvent e){
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
        protected  void cadastrarNovoAnuncioAction(ActionEvent e) {

            try {
                if (tfTitulo.getText().isEmpty())
                    throw new RuntimeException("O campo nome não pode ser vazio");
                if (tfPreco.getText().isEmpty())
                    throw new RuntimeException("O campo cpf não pode ser vazio");
                if (tfQuantidade.getText().isEmpty())
                    throw new RuntimeException("O campo e-mail não pode ser vazio");
                if (tfTelefone.getText().isEmpty())
                    throw new RuntimeException("O campo telefone não pode ser vazio");
                if (cbCategoria.getSelectionModel().isEmpty())
                    throw new RuntimeException("O campo categoria não pode ser vazio");
                if (cbEstado.getSelectionModel().isEmpty())
                    throw new RuntimeException("O campo categoria não pode ser vazio");
                if (taDescricao.getText().isEmpty())
                    throw new RuntimeException("O campo descrição não pode ser vazio");





                Anuncio g = new Anuncio(
                        user.getCpf(),
                        tfPreco.getText(),
                        tfTitulo.getText(),
                        taDescricao.getText(),
                        (EnumCategorias) cbCategoria.getSelectionModel().getSelectedItem(),
                        (EnumEstados) cbEstado.getSelectionModel().getSelectedItem(),
                        Integer.parseInt(tfQuantidade.getText()),
                        tfTelefone.getText(),
                        imageV1.getImage(),
                        imageV2.getImage(),
                        imageV3.getImage());


                fachada.cadastrarAnuncio(g);
                user.getAnuncios().add(g);
                fachada.alterarUsuario(fachada.buscaUsuario(user.getCpf()),user);
                System.out.println(user.getAnuncios());
                Cliente cll = (Cliente)fachada.buscaUsuario(user.getCpf());
                System.out.println(cll.getAnuncios());


                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText("Criação de Anúncio");
                alert2.setContentText("Anúncio " + tfTitulo.getText() + " criado com sucesso!");
                alert2.showAndWait();

                tfPreco.setText("");
                tfTitulo.setText("");
                taDescricao.setText("");
                tfQuantidade.setText("");
                tfTelefone.setText("");

            } catch (RuntimeException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao criar o Anúncio");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            } catch (ParametroNullException exx) {
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
            } catch (NaoExisteException exx) {
                Alert alertw = new Alert(Alert.AlertType.ERROR);
                alertw.setTitle("Erro");
                alertw.setHeaderText("Erro ao criar o Anúncio");
                alertw.setContentText("Esse Anúncio já existe!!!");
                alertw.showAndWait();
            }
        }

        @FXML
        protected  void cancelarAction(ActionEvent e){
                tfPreco.setText("");
                tfTitulo.setText("");
                taDescricao.setText("");
                tfQuantidade.setText("");
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
                    if (e.getSource() == this.btTrocarImagem1) {
                        this.imageV1.setImage(image);
                    } else if (e.getSource() == this.btTrocarImagem2) {
                        this.imageV2.setImage(image);
                    } else if (e.getSource() == this.btTrocarImagem3) {
                        this.imageV3.setImage(image);
                    }
                } catch (IOException ioException) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Arquivo inválido");
                    alert.show();
                }
            }
        }
}
