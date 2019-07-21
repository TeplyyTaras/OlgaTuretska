package teplyy.taras.olgaglass.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teplyy.taras.olgaglass.entity.ProductForOrder;

@Repository
public interface ProductForOrderRepository extends JpaRepository<ProductForOrder, Long> {
}
