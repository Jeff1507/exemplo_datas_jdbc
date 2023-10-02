package ifpr.pgua.eic.exemplodatas.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.entities.Contato;
import ifpr.pgua.eic.exemplodatas.model.entities.Email;
import ifpr.pgua.eic.exemplodatas.model.entities.Telefone;

public interface ContatoDAO {
    Resultado criar(Contato contato);
    Resultado buscar();
    Resultado alterar(int id, Contato novoContato);
    Resultado excluir(int id);
}
