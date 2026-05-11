import database.DatabaseConnection;
import repository.ContatoRepository;
import repository.impl.ContatoJdbcRepository;
import service.ContatoService;
import ui.AgendaConsole;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.inicializarBanco();
        ContatoRepository repository = new ContatoJdbcRepository();
        ContatoService service = new ContatoService(repository);
        AgendaConsole menu = new AgendaConsole(service);
        menu.exibirMenu();
    }
}