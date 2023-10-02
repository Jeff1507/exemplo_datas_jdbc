package ifpr.pgua.eic.exemplodatas.model.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public Resultado alterar(int id, Contato novaAgenda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public Resultado excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    
    
}
