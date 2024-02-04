package br.edu.iff.acaiteriaWebApp.repository;



import br.edu.iff.acaiteriaWebApp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
