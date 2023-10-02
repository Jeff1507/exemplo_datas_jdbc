package ifpr.pgua.eic.exemplodatas;

import ifpr.pgua.eic.exemplodatas.controllers.CadastrarContato;
import ifpr.pgua.eic.exemplodatas.controllers.Principal;
import ifpr.pgua.eic.exemplodatas.model.daos.ContatoDAO;
import ifpr.pgua.eic.exemplodatas.model.daos.FabricaConexoes;
import ifpr.pgua.eic.exemplodatas.model.daos.JDBCContatoDAO;
import ifpr.pgua.eic.exemplodatas.model.repositories.Repositorio;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());
    private Repositorio repositorio = new Repositorio(dao);
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Agenda de Contatos";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new Principal()));
        registraTela("CADASTRARCONTATO", new ScreenRegistryFXML(App.class, "cadastrar_contato.fxml", o->new CadastrarContato(repositorio)));
    }

}