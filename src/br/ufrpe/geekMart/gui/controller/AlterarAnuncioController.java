package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.HaEstoqueException;
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

public class AlterarAnuncioController {

        Anuncio user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData) {
                                if(newScreen.equals("alterarAnuncioScene")) {
                                        user=(Anuncio)userData;
                                        updateComboBoxCategoria();
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();
                                        updateComboBoxEstado();
                                        updateAnuncio();

                                } }
                });
                updateComboBoxEstado();
                updateComboBoxCategoria();
                updateComboBoxCategorias();
                updateComboBoxLojas();


        }

        private  void updateAnuncio(){
                tfTitulo.setText(user.getTitulo());
                tfPreco.setText(user.getPreco());
                tfQuantidade.setText(Integer.toString(user.getQuantidadeProdutos()));
                tfTelefone.setText(user.getTelefone());
                taDescricao.setText(user.getDescricao());
                cbLojas.setValue(user.getEstado());
        }


    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }

    private  void updateComboBoxCategoria(){
        this.cbCategoria.getItems().setAll(EnumCategorias.values());
    }

    private  void updateComboBoxEstado(){
        this.cbEstado.getItems().setAll(EnumEstados.values());
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
        private ComboBox cbEstado;


        @FXML
        private TextField tfPreco;

        @FXML
        private  TextField tfEstado;

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
        private Button btMeusAnuncios;


        @FXML
        private Button btSalvarAnuncio;

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
        protected  void btMeusAnunciosAction(ActionEvent e){ Main.trocarTela("meusAnunciosScene",user); }

        @FXML
        protected  void btMinhasLojasAction(ActionEvent e){
                Main.trocarTela("minhasLojasScene",user);
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
        protected  void alterarAnuncioAction(ActionEvent e) {

                try {
                        if (tfTitulo.getText().isEmpty())
                                throw new RuntimeException("O campo nome não pode ser vazio");
                        if (tfPreco.getText().isEmpty())
                                throw new RuntimeException("O campo cpf não pode ser vazio");
                        if (tfQuantidade.getText().isEmpty())
                                throw new RuntimeException("O campo e-mail não pode ser vazio");
                        if (tfTelefone.getText().isEmpty())
                                throw new RuntimeException("O campo telefone não pode ser vazio");
                        if (cbEstado.getSelectionModel().isEmpty())
                        throw new RuntimeException("O campo estado não pode ser vazio");
                        if (cbCategoria.getSelectionModel().isEmpty())
                                throw new RuntimeException("O campo categoria não pode ser vazio");
                        if (taDescricao.getText().isEmpty())
                                throw new RuntimeException("O campo descrição não pode ser vazio");





                        Anuncio g = new Anuncio(
                                user.getCliente(),
                                tfPreco.getText(),
                                tfTitulo.getText(),
                                taDescricao.getText(),
                                (EnumCategorias) cbCategoria.getSelectionModel().getSelectedItem(),
                                (EnumEstados)cbEstado.getSelectionModel().getSelectedItem(),
                                Integer.parseInt(tfQuantidade.getText()),
                                tfTelefone.getText(),
                                imageV1.getImage(),
                                imageV2.getImage(),
                                imageV3.getImage());


                        fachada.alterarAnuncio(user.getTitulo(),g);
                        user = g;
                        if(Integer.parseInt(tfQuantidade.getText()) == 0){
                                try {
                                        fachada.desativarAnuncioSemEstoque(g);
                                }catch (HaEstoqueException ee){
                                        //TODO
                                }
                        }

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Informação");
                        alert2.setHeaderText("Alteração de Anúncio");
                        alert2.setContentText("Anúncio " + tfTitulo.getText() + " alterado com sucesso!");
                        alert2.showAndWait();



                } catch (RuntimeException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro ao alterar o Anúncio");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                } catch (ParametroNullException exx) {
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao alterar o Anúncio");
                        alertw.setContentText("Não foi possível completara ação!!");
                        alertw.showAndWait();
                } catch (NaoExisteException exx) {
                        Alert alertw = new Alert(Alert.AlertType.ERROR);
                        alertw.setTitle("Erro");
                        alertw.setHeaderText("Erro ao alterar o Anúncio");
                        alertw.setContentText("Esse Anúncio já existe!!!");
                        alertw.showAndWait();
                }
        }

    @FXML
    protected void trocarImagemAction (ActionEvent e) {
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
