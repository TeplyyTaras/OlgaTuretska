package teplyy.taras.olgaglass.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import teplyy.taras.olgaglass.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long >, JpaSpecificationExecutor<Order> {
}
