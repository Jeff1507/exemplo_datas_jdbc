package ifpr.pgua.eic.exemplodatas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.entities.Contato;
import ifpr.pgua.eic.exemplodatas.model.entities.Email;
import ifpr.pgua.eic.exemplodatas.model.entities.Telefone;
import ifpr.pgua.eic.exemplodatas.utils.DBUtils;

public class JDBCContatoDAO implements ContatoDAO{
    private FabricaConexoes fabrica;

    public JDBCContatoDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Contato contato) {
        try (Connection con=fabrica.getConnection()) {
            PreparedStatement pstm=con.prepareStatement("INSERT INTO C_agenda(nome) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, contato.getNome());
            int ret=pstm.executeUpdate();
            if(ret==1){
                int codigo=DBUtils.getLastId(pstm);
                contato.setCodigo(codigo);

                PreparedStatement pstm2=con.prepareStatement("INSERT INTO C_email(codigo, email) VALUES (?,?)");
                for (Email emails : contato.getEmails()) {
                    pstm2.setInt(1, codigo);
                    pstm2.setString(2, emails.getEmail());
                    pstm2.executeUpdate();
                }
                PreparedStatement pstm3=con.prepareStatement("INSERT INTO C_telefone(codigo, telefone) VALUES (?,?)");
                for (Telefone telefones : contato.getTelefones()) {
                    pstm3.setInt(1, codigo);
                    pstm3.setInt(2, telefones.getTelefone());
                    pstm3.executeUpdate();

                }
                return Resultado.sucesso("Contato cadastrado!", contato);
                
            }
            return Resultado.erro("Erro desconhecido!");

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscar() {
        try (Connection con=fabrica.getConnection()) {
            PreparedStatement pstm=con.prepareStatement("SELECT * FROM C_agenda");

            ResultSet rs=pstm.executeQuery();
            List<Contato> lista=new ArrayList<>();
            while(rs.next()){
                int codigo=rs.getInt("codigo");
                String nome=rs.getString("nome");

                Contato contato=new Contato(codigo, nome);
                lista.add(contato);

            }
            return Resultado.sucesso("Lista Carregada", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado alterar(int id, Contato novoContato) {
        try (Connection con=fabrica.getConnection()) {
            PreparedStatement pstm=con.prepareStatement("UPDATE C_agenda SET nome=? WHERE codigo=?");
            pstm.setString(1, novoContato.getNome());
            pstm.setInt(2, id);

            int ret=pstm.executeUpdate();

            if(ret==1){
                PreparedStatement pstm2=con.prepareStatement("UPDATE C_email SET email=? WHERE codigo=?");
                ArrayList<Email> lista=new ArrayList<>(novoContato.getEmails());
                for (Email emails : lista) {
                    pstm2.setString(1, emails.getEmail());
                    pstm2.setInt(2, id);
                    pstm2.executeUpdate();
                }
                novoContato.setEmails(lista);

                PreparedStatement pstm3=con.prepareStatement("UPDATE C_telefone SET telefone=? WHERE codigo=?");
                ArrayList<Telefone> lista2=new ArrayList<>(novoContato.getTelefones());
                for (Telefone telefones : novoContato.getTelefones()) {
                    pstm3.setInt(1, telefones.getTelefone());
                    pstm3.setInt(2, id);
                    pstm3.executeUpdate();
                }
                novoContato.setTelefones(lista2);
                
                return Resultado.sucesso("Contato atualizado", novoContato);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    
    
}
