package service;

import model.Contato;
import repository.ContatoRepository;

import java.util.List;

public class ContatoService {
    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public void salvarContato(Contato contato) {
        if (contato.getNome() == null || contato.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }
        repository.salvar(contato);
    }

    public List<Contato> listarContatos() {
        return repository.listarTodos();
    }

    public void atualizarContato(Contato contato) {
        repository.atualizar(contato);
    }

    public void excluirContato(Long id) {
        repository.excluir(id);
    }

    public Contato buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }
}