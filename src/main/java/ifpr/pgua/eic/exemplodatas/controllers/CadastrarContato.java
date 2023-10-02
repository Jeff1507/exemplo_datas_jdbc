package ifpr.pgua.eic.exemplodatas.controllers;

import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.App;
import ifpr.pgua.eic.exemplodatas.model.entities.Email;
import ifpr.pgua.eic.exemplodatas.model.entities.Telefone;
import ifpr.pgua.eic.exemplodatas.model.repositories.Repositorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastrarContato {
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    private ArrayList<Email> emails=new ArrayList<>();

    @FXML
    private ListView<Email> lstEmails;

    @FXML
    private TextField tfTelefone;

    private ArrayList<Telefone> telefones=new ArrayList<>();

    @FXML
    private ListView<Telefone> lstTelefones;

    private Repositorio repositorio;

    public CadastrarContato(Repositorio repositorio){
        this.repositorio=repositorio;
    }

    @FXML
    void cadastrar(ActionEvent event){
        String nome=tfNome.getText();
        ArrayList<Email> emailsSelecionados=new ArrayList<>(emails);
        ArrayList<Telefone> telefonesSelecionados=new ArrayList<>(telefones);

        Resultado resultado=repositorio.criar(nome, emailsSelecionados, telefonesSelecionados);

        if(resultado.foiErro()){
            Alert alert=new Alert(AlertType.ERROR, resultado.getMsg());
            alert.showAndWait();
            return;
        }
        else{
            tfNome.clear();
            tfEmail.clear();
            tfTelefone.clear();
            Alert alert=new Alert(AlertType.INFORMATION,resultado.getMsg());
            alert.showAndWait();
        
        }

    }
    @FXML
    void adicionarEmail(ActionEvent event){
        String endereco=tfEmail.getText();
        Email email=new Email(endereco);
        emails.add(email);
        tfEmail.clear();
        Alert alert=new Alert(AlertType.INFORMATION, "E-mail adicionado!");
        alert.showAndWait();
        System.out.println(emails.size());
    }
    @FXML
    void adicionarTelefone(ActionEvent event){
        String sTelefone=tfTelefone.getText();
        int numero=Integer.valueOf(sTelefone);
        Telefone telefone=new Telefone(numero);
        telefones.add(telefone);
        tfTelefone.clear();
        Alert alert=new Alert(AlertType.INFORMATION, "Telefone adicionado!");
        alert.showAndWait();
        System.out.println(telefones.size());
    }
    @FXML
    void voltar(){
        App.popScreen();
    }
}
