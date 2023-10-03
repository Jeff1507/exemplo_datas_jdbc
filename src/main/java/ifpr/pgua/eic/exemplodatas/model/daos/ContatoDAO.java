package ifpr.pgua.eic.exemplodatas.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.entities.Contato;

public interface ContatoDAO {
    Resultado criar(Contato contato);
    Resultado buscar();
    Resultado alterar(int id, Contato novoContato);
    Resultado excluir(int id);
}
