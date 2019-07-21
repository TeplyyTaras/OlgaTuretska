package teplyy.taras.olgaglass.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teplyy.taras.olgaglass.entity.Review;
import teplyy.taras.olgaglass.entity.User;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProductId(Long productId);

    List<Review> findAllByProductIdAndShowIsTrue(Long productId);
}
