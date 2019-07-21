package teplyy.taras.olgaglass.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teplyy.taras.olgaglass.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
