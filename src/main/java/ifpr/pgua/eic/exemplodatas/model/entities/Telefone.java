package ifpr.pgua.eic.exemplodatas.model.entities;

public class Telefone {
    private int codigo;
    private int telefone;
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public Telefone(int codigo, int telefone) {
        this.codigo = codigo;
        this.telefone = telefone;
    }
    public Telefone(int telefone) {
        this.telefone = telefone;
    }
    
}
