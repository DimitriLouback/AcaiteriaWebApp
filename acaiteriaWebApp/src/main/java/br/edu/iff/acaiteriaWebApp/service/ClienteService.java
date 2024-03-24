package br.edu.iff.acaiteriaWebApp.service;

import br.edu.iff.acaiteriaWebApp.model.Cliente;
import br.edu.iff.acaiteriaWebApp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(String nome, String telefone, String endereco, String senha) {
        Cliente novoCliente = new Cliente(nome, telefone, endereco, senha);
        clienteRepository.save(novoCliente);
        return novoCliente;
    }

    public String atualizarCliente(Long id, String nome, String telefone, String endereco) {
        Cliente clienteExistente = buscarCliente(id);

        if (clienteExistente != null) {
            clienteExistente.setNome(nome);
            clienteExistente.setTelefone(telefone);
            clienteExistente.setEndereco(endereco);
            clienteRepository.save(clienteExistente);
            return "Cliente atualizado com sucesso.";
        } else {
            return "Cliente não encontrado.";
        }
    }

    public String deletarCliente(Long id) {
        Cliente clienteExistente = buscarCliente(id);

        if (clienteExistente != null) {
            clienteRepository.delete(clienteExistente);
            return "Cliente deletado com sucesso.";
        } else {
            return "Cliente não encontrado.";
        }
    }

    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente autenticarCliente(String nome, String senha) {
        Cliente cliente = clienteRepository.findByNomeAndSenha(nome, senha);

        if (cliente != null && cliente.getSenha().equals(senha)) {
            return cliente;
        } else {
            return null; // Cliente não encontrado ou senha incorreta.
        }
    }
}
