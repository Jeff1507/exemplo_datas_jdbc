package ifpr.pgua.eic.exemplodatas.controllers;

import ifpr.pgua.eic.exemplodatas.App;
import javafx.fxml.FXML;

public class Principal{
    @FXML
    public void cadastrarContato(){
        App.pushScreen("CADASTRARCONTATO");
    }
    @FXML
    public void listar(){
        App.pushScreen("LISTAR");
    }
    @FXML
    public void alterar(){
        App.pushScreen("ALTERAR");
    }
    @FXML
    public void excluir(){
        App.pushScreen("EXCLUIR");
    }
}