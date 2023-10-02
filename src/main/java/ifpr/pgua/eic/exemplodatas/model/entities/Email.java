package ifpr.pgua.eic.exemplodatas.model.entities;

public class Email {
    private int codigo;
    private String email;
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Email(int codigo, String email) {
        this.codigo = codigo;
        this.email = email;
    }
    public Email(String email) {
        this.email = email;
    }
    
}
