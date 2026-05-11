package repository;

import model.Contato;
import java.util.List;

public interface ContatoRepository {
    void salvar(Contato contato);
    List<Contato> listarTodos();
    void atualizar(Contato contato);
    void excluir(Long id);
    Contato buscarPorId(Long id);
}