package br.ufrpe.geekMart.gui.controller;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;
import br.ufrpe.geekMart.negocio.Fachada;
import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;
import br.ufrpe.geekMart.negocio.classesBasicas.Cliente;
import br.ufrpe.geekMart.negocio.classesBasicas.Loja;
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

public class AlterarLojaController {

        Loja user;
        Fachada fachada = Fachada.getInstancia();

        @FXML
        protected  void  initialize(){
                Main.addOnChangesScreenListener(new Main.OnChangeScreen(){
                        @Override
                        public void onScreenChanged(String newScreen, Object userData, ArrayList<Anuncio> userData2,
                                                    ArrayList<Anuncio> userData3, ArrayList<Loja> userData4) {
                            try{
                                if(newScreen.equals("alterarLojaScene")) {
                                        user=(Loja)userData;
                                        updateComboBoxCategorias();
                                        updateComboBoxLojas();
                                        updateComboBoxCategoria();
                                        updateList();
                                        updateList2();
                                        updateLoja();

                                } }catch (NaoExisteException ee){

                            } catch (ParametroNullException ee ){

                            }   catch (JaExisteException ee){

                            }
                        }
                });


                updateComboBoxCategorias();
                updateComboBoxLojas();
                updateComboBoxCategoria();

        }



    private  void  updateComboBoxCategorias(){
        this.cbCategorias.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxLojas(){
        this.cbLojas.getItems().setAll(EnumCategorias.values());
    }

    private void updateComboBoxCategoria(){
        this.cbCategoria.getItems().setAll(EnumCategorias.values());
    }

    private void updateList() throws NaoExisteException, ParametroNullException, JaExisteException {
        lvMeusAnuncios.getItems().clear();
        Cliente cll = (Cliente)fachada.buscaUsuario(user.getCpfCliente());

        for (int i = 0; i < cll.listarAnuncios().size(); i++) {
            lvMeusAnuncios.getItems().add(i, cll.listarAnuncios().get(i));
        }

    }

    private void updateList2() throws NaoExisteException, ParametroNullException, JaExisteException {
        lvAnunciosDaLoja.getItems().clear();
        for (int i = 0; i < user.getAnuncios().size(); i++) {
            lvMeusAnuncios.getItems().add(i, user.getAnuncios().get(i));
        }

    }


    private  void updateLoja(){
        tfTitulo.setText(user.getNome());
        tfTelefone.setText(user.getTelefone());
        taDescricao.setText(user.getDescricao());
        cbCategorias.setValue(user.getCategoria());
    }


        @FXML
        private Button btTrocarImagem2;

        @FXML
        private ImageView imageV2;

        @FXML
        private ComboBox<EnumCategorias> cbCategorias;

        @FXML
         private ComboBox cbCategoria;

        @FXML
        private Button btSalvar;

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
        private ComboBox cbEstado;

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
        protected  void btHomeAction(ActionEvent e){
                Main.trocarTela("telaInicialLogadoScene",user.getCpfCliente());
        }

        @FXML
        protected  void btMeuCadastroAction(ActionEvent e){
                Main.trocarTela("cadastroClienteScene",user.getCpfCliente());
        }

    @FXML
    protected  void btMeusAnunciosAction(ActionEvent e) {
        try {
            Cliente cl = (Cliente) fachada.buscaUsuario(user.getCpfCliente());

            ArrayList<Anuncio> anuncios = cl.getAnuncios();

            if (anuncios.size() < 6 && anuncios.size() >= 0) {

                switch (anuncios.size()) {
                    case 1:
                        Main.trocarTela("meusAnuncios1Scene", user.getCpfCliente(), anuncios);
                        break;
                    case 2:
                        Main.trocarTela("meusAnuncios2Scene", user.getCpfCliente(), anuncios);
                        break;
                    case 3:
                        Main.trocarTela("meusAnuncios3Scene", user.getCpfCliente(), anuncios);
                        break;
                    case 4:
                        Main.trocarTela("meusAnuncios4Scene", user.getCpfCliente(), anuncios);
                        break;
                    case 5:
                        Main.trocarTela("meusAnuncios5Scene", user.getCpfCliente(), anuncios);
                        break;

                    case 0:
                        Main.trocarTela("meusAnuncios0Scene", user.getCpfCliente(), anuncios);
                        break;
                }
            } else if (anuncios.size() >= 6) {
                Main.trocarTela("meusAnuncios6Scene", user.getCpfCliente(), anuncios);
            }


            Main.trocarTela("meusAnunciosScene", user.getCpfCliente(), anuncios);

        } catch (NaoExisteException ee) {

        } catch (ParametroNullException pp) {

        }
    }


        @FXML
        protected  void btMinhasLojasAction(ActionEvent e){
                Main.trocarTela("minhasLojasScene",user.getCpfCliente());
        }

        @FXML
        protected  void btNovoAnuncioAction(ActionEvent e){
                Main.trocarTela("cadastrarNovoAnuncioScene",user.getCpfCliente());
        }

        @FXML
        protected  void btNovaLojaAction(ActionEvent e){
                Main.trocarTela("cadastrarNovaLojaScene",user.getCpfCliente());
        }

        @FXML
        protected  void btChatAction(ActionEvent e){
                Main.trocarTela("chatScene",user.getCpfCliente());
        }

    @FXML
    protected  void alterarLojaAction(ActionEvent e){

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
                    cbCategorias.getSelectionModel().getSelectedItem(),
                    user.getCpfCliente());


            try {

                ArrayList<Anuncio> listaAnuncios = new ArrayList<>();

                for (int i = 0; i < lvAnunciosDaLoja.getItems().size(); i++) {
                    listaAnuncios.add(i, (Anuncio) lvAnunciosDaLoja.getItems().get(i));
                }

                g.setAnuncios(listaAnuncios);

            }catch (NullPointerException exx){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro");
                alert.setContentText("Lista Vazia");
                alert.showAndWait();
            }




            fachada.alterarLoja(user.getNome(),g);
            user = g;

            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Informação");
            alert2.setHeaderText("Alteração de Loja");
            alert2.setContentText("Loja "+tfTitulo.getText()+" alterada com sucesso!");
            alert2.showAndWait();



        } catch (RuntimeException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao criar o Loja!");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        } catch (ParametroNullException exx){
            Alert alertw = new Alert(Alert.AlertType.ERROR);
            alertw.setTitle("Erro");
            alertw.setHeaderText("Erro ao criar o Loja");
            alertw.setContentText("Não foi possível completar o cadastro!!!");
            alertw.showAndWait();
        }
        catch (NaoExisteException exx) {
            Alert alertw = new Alert(Alert.AlertType.ERROR);
            alertw.setTitle("Erro");
            alertw.setHeaderText("Erro ao criar o Loja");
            alertw.setContentText("Esse Loja não existe!");
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
    private ImageView imageV;

    @FXML
    protected void trocarImagem (ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir  arquivo");
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
                alert.setContentText("Arquivo  inválido");
                alert.show();
            }
        }
    }


}
