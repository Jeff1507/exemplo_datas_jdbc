package ifpr.pgua.eic.exemplodatas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.App;
import ifpr.pgua.eic.exemplodatas.model.entities.Contato;
import ifpr.pgua.eic.exemplodatas.model.repositories.Repositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class Listar implements Initializable{

    @FXML
    private ListView<Contato> lstContatos;

    private Repositorio repositorio;

    public Listar(Repositorio repositorio){
        this.repositorio=repositorio;
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstContatos.getItems().clear();
        Resultado resultado=repositorio.listar();

        if(resultado.foiErro()){
            Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
            alert.showAndWait();
        }
        else{
            List<Contato> lista = (List)resultado.comoSucesso().getObj();
            lstContatos.getItems().addAll(lista);
        }
    }

}

