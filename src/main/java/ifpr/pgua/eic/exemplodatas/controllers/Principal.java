package ifpr.pgua.eic.exemplodatas.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.repositories.Repositorio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class Principal implements Initializable {

    @FXML
    private DatePicker datePicker;

    @FXML
    private ListView<LocalDate> lstDatas;

    private Repositorio repositorio;

    public Principal(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @FXML
    private void incluir() {
        LocalDate data = datePicker.getValue();

        Resultado resultado = repositorio.criar(data);

        Alert alert = new Alert(AlertType.INFORMATION, resultado.getMsg());
        alert.showAndWait();

        if(resultado.foiSucesso()){
            atualizarLista();
        }
    }

    private void atualizarLista() {
        Resultado resultado = repositorio.lista();

        if (resultado.foiSucesso()) {
            List<LocalDate> lista = (List) resultado.comoSucesso().getObj();
            lstDatas.getItems().clear();
            lstDatas.getItems().addAll(lista);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        atualizarLista();
    }

}
