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

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.entities.Exemplo;
import ifpr.pgua.eic.exemplodatas.utils.DBUtils;

public class JDBCExemploDAO implements ExemploDAO{
    private FabricaConexoes fabrica;

    


    public JDBCExemploDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Exemplo exemplo) {
        
        try(Connection con=fabrica.getConnection()){
            PreparedStatement pstm = con.prepareStatement("INSERT INTO exemplos(data) VALUES (?)",Statement.RETURN_GENERATED_KEYS);


            pstm.setDate(1, Date.valueOf(exemplo.getData()));

            int ret = pstm.executeUpdate();

            if(ret == 1){
                int id = DBUtils.getLastId(pstm);

                exemplo.setId(id);

                return Resultado.sucesso("Data cadastrada", exemplo);
            }

            return Resultado.erro("Vixe...");

            
        }catch(SQLException e){
            return Resultado.erro(e.getMessage());
        }

    
    }

    @Override
    public Resultado listar() {
        
        try(Connection con=fabrica.getConnection()){
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM exemplos");

            ResultSet rs = pstm.executeQuery();

            ArrayList<Exemplo> lista = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                LocalDate date = rs.getDate("data").toLocalDate();

                Exemplo exemplo = new Exemplo(id, date);
                lista.add(exemplo);

            }
            
            return Resultado.sucesso("Lista carregada", lista);
  
        }catch(SQLException e){
            return Resultado.erro(e.getMessage());
        }

    
    }
    
}
