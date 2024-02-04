package br.edu.iff.acaiteriaWebApp.repository;



import br.edu.iff.acaiteriaWebApp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
