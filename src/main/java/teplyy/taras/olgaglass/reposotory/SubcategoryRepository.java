package teplyy.taras.olgaglass.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teplyy.taras.olgaglass.entity.Subcategory;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    List<Subcategory> findAllByCategoryId(Long categoryId);


}
