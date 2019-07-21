package teplyy.taras.olgaglass.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teplyy.taras.olgaglass.entity.Cart;

@Repository
public interface CartRepositiry extends JpaRepository<Cart, Long > {
}
