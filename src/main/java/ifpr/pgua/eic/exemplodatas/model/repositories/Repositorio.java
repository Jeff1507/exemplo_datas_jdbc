package ifpr.pgua.eic.exemplodatas.model.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.daos.ContatoDAO;
import ifpr.pgua.eic.exemplodatas.model.entities.Contato;
import ifpr.pgua.eic.exemplodatas.model.entities.Email;
import ifpr.pgua.eic.exemplodatas.model.entities.Telefone;

public class Repositorio {
    

    private ContatoDAO dao;

    public Repositorio(ContatoDAO dao) {
        this.dao = dao;
    }

    public Resultado criar(String nome, ArrayList<Email> emails, ArrayList<Telefone> telefones){
        if(nome.isBlank() || nome.isEmpty()){
            return Resultado.erro("Nome em branco!");
        }
        if(emails.size()==0){
            return Resultado.erro("Nenhum E-mail cadastrado!");
        }
        if(telefones.size()==0){
            return Resultado.erro("Nenhum telefone cadastrado!");
        }
        Contato contato=new Contato(nome);
        contato.setEmails(emails);
        contato.setTelefones(telefones);

        return dao.criar(contato);
    }

    public Resultado listar(){
        return dao.buscar();
    }

    public String alterar(int id, String nome){
        Contato novo=new Contato(id, nome);

        Resultado resultado = dao.alterar(id, novo);

        return resultado.getMsg();
    }
}
