package ifpr.pgua.eic.exemplodatas.model.entities;

import java.util.List;

public class Contato {
    private int codigo;
    private String nome;
    private List<Telefone> telefones;
    private List<Email> emails;

    public Contato(String nome) {
        this.nome = nome;
    }
    public Contato(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Telefone> getTelefones() {
        return telefones;
    }
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    public List<Email> getEmails() {
        return emails;
    }
    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
    @Override
    public String toString() {
        return "Contato " + codigo + ", Nome = " + nome;
    }
    

}
