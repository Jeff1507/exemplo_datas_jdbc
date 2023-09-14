package ifpr.pgua.eic.exemplodatas.model.repositories;

import java.time.LocalDate;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.exemplodatas.model.daos.ExemploDAO;
import ifpr.pgua.eic.exemplodatas.model.entities.Exemplo;

public class Repositorio {
    

    private ExemploDAO dao;

    public Repositorio(ExemploDAO dao) {
        this.dao = dao;
    }

    public Resultado criar(LocalDate data){
        if(data.isBefore(LocalDate.now())){
            return Resultado.erro("Data inválida!");
        }

        Exemplo exemplo = new Exemplo(data);

        return dao.criar(exemplo);
    }

    public Resultado lista(){
        return dao.listar();
    }
}
