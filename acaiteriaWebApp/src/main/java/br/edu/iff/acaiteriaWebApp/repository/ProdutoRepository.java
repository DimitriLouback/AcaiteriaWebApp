package br.edu.iff.acaiteriaWebApp.repository;



import br.edu.iff.acaiteriaWebApp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
