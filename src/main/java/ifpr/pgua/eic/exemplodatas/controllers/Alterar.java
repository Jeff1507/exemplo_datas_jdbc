package ifpr.pgua.eic.exemplodatas.controllers;

import java.util.ArrayList;

import ifpr.pgua.eic.exemplodatas.model.entities.Email;
import ifpr.pgua.eic.exemplodatas.model.entities.Telefone;
import ifpr.pgua.eic.exemplodatas.model.repositories.Repositorio;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Alterar {
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    private ArrayList<Email> emails;

    @FXML
    private TextField tfTelefone;

    private ArrayList<Telefone> telefones;

    private Repositorio repositorio;

    public Alterar(){
        this.repositorio=repositorio;
    }

    
}
