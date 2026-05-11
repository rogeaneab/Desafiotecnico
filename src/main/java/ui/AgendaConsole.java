package ui;

import model.Contato;
import service.ContatoService;

import java.util.List;
import java.util.Scanner;

public class AgendaConsole {
    private final ContatoService service;
    private final Scanner scanner = new Scanner(System.in);

    public AgendaConsole(ContatoService service) {
        this.service = service;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 7) {
            System.out.println("\n===== AGENDA DE CONTATOS =====");
            System.out.println("1. Cadastrar Contato");
            System.out.println("2. Listar Todos os Contatos");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Atualizar Contato");
            System.out.println("5. Remover Contato");
            System.out.println("6. Listar por Categoria");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listarTodos();
                case 3 -> buscar();
                case 4 -> atualizar();
                case 5 -> remover();
                case 6 -> listarPorCategoria();
                case 7 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Categoria (Amigo/Trabalho/Família/Outro): ");
        String categoria = scanner.nextLine();

        Contato c = new Contato(nome, telefone, email, categoria);
        service.salvarContato(c);
        System.out.println("Contato cadastrado com sucesso!");
    }

    private void listarTodos() {
        List<Contato> contatos = service.listarContatos();
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
            return;
        }
        System.out.printf("%-5s %-20s %-15s %-25s %-10s%n", "ID", "Nome", "Telefone", "Email", "Categoria");
        System.out.println("-".repeat(80));
        for (Contato c : contatos) {
            System.out.printf("%-5d %-20s %-15s %-25s %-10s%n",
                    c.getId(), c.getNome(), c.getTelefone(), c.getEmail(), c.getCategoria());
        }
    }

    private void buscar() {
        System.out.print("Digite nome ou email: ");
        String termo = scanner.nextLine();
        service.listarContatos().stream()
                .filter(c -> c.getNome().toLowerCase().contains(termo.toLowerCase())
                        || termo.equalsIgnoreCase(c.getEmail()))
                .forEach(c -> System.out.println(c.getId() + " - " + c.getNome() + " | " + c.getEmail()));
    }

    private void atualizar() {
        System.out.print("ID do contato a atualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        Contato c = service.buscarPorId(id);
        if (c == null) { System.out.println("Contato não encontrado!"); return; }

        System.out.print("Novo nome (" + c.getNome() + "): ");
        String nome = scanner.nextLine();
        System.out.print("Novo telefone (" + c.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        System.out.print("Novo email (" + c.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Nova categoria (" + c.getCategoria() + "): ");
        String categoria = scanner.nextLine();

        if (!nome.isBlank()) c.setNome(nome);
        if (!telefone.isBlank()) c.setTelefone(telefone);
        if (!email.isBlank()) c.setEmail(email);
        if (!categoria.isBlank()) c.setCategoria(categoria);

        service.atualizarContato(c);
        System.out.println("Contato atualizado!");
    }

    private void remover() {
        System.out.print("ID do contato a remover: ");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.print("Confirma remoção? (s/n): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("s")) {
            service.excluirContato(id);
            System.out.println("Contato removido!");
        }
    }

    private void listarPorCategoria() {
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        service.listarContatos().stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
    }
}