package teplyy.taras.olgaglass.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teplyy.taras.olgaglass.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

//    @Query("from Product p where p.price between :start and :to")
//    List<Product> findAllByPrice(@Param("to") Integer to, @Param("start") Integer from);
//
//    @Query("from Product p join  p.category c where c.name=:a")
//    List<Product> findAllByCategoryName(@Param("a") String name);
//
//    Product findByName(String name);
//
//    List<Product> findAllByNameLikeAndPriceLessThanEqual(String name, Integer maxPrice);


}
