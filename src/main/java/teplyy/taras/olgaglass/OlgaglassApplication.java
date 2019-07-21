package teplyy.taras.olgaglass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import teplyy.taras.olgaglass.entity.Category;
import teplyy.taras.olgaglass.entity.Product;
import teplyy.taras.olgaglass.reposotory.CategoryRepository;
import teplyy.taras.olgaglass.reposotory.ProductRepository;

import javax.annotation.PostConstruct;
import javax.naming.Name;

@SpringBootApplication
public class OlgaglassApplication {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void post() throws IllegalAccessException {

//        productRepository.findAllByPrice(400, 200).forEach(System.out::println);
//        productRepository.findAllByCategoryName("plates").forEach(System.out::println);
//        Product byName = productRepository.findByName("Plate Squares");
//        System.out.println(byName);
//        productRepository.findAllByNameLikeAndPriceLessThanEqual("%plate%", 220)
//                .forEach(System.out::println);


//        CategoryRequest category1 = categoryRepository.findById(2L).orElseThrow(IllegalAccessException::new);
////
//        Product prod4 = Product.builder()
//                .name("Flower Plate")
//                .category(category1)
//                .diameter(28.5)
//                .deapt(3.5)
//                .price(250)
//                .description("Fused glas art plate 'Flower' ")
//                .build();
//        Product prod5 = Product.builder()
//                .name("Plate Squares")
//                .category(category1)
//                .diameter(28.5)
//                .deapt(3.5)
//                .price(220)
//                .descrption("Fused glas art plate 'Plate Squares' ")
//                .build();
//        Product prod6 = Product.builder()
//                .name("Warm Rhombus Plate")
//                .category(category1)
//                .diameter(26.5)
//                .deapt(5.0)
//                .price(120)
//                .descrption("Fused glas art plate 'Warm Rhombus' ")
//                .build();
//
//        productRepository.save(prod4);
//        productRepository.save(prod5);
//        productRepository.save(prod6);
//
//
//        CategoryRequest category = categoryRepository.findById(1L).orElseThrow(IllegalAccessException::new);
//
//        Product prod1 = Product.builder()
//                .name("Garden")
//                .category(category)
//                .height(38.5)
//                .wight(68.5)
//                .price(420)
//                .descrption("This is art glass work called 'Garden' ")
//                .build();
//        Product prod2 = Product.builder()
//                .name("House in the forest")
//                .category(category)
//                .height(40.0)
//                .wight(55.0)
//                .price(420)
//                .descrption("This is art glass work called 'House in the forest' ")
//                .build();
//        Product prod3 = Product.builder()
//                .name("Fall")
//                .category(category)
//                .height(40.0)
//                .wight(55.0)
//                .price(420)
//                .descrption("This is art glass work called 'Fall' ")
//                .build();
//
//        productRepository.save(prod1);
//        productRepository.save(prod2);
//        productRepository.save(prod3);



//        CategoryRequest category = new CategoryRequest();
//        category.setName("Jewelry");
//        categoryRepository.save(category);

//        categoryRepository.findAll().forEach(System.out::println); // знаходить всі категорії
//        productRepository.findAll().forEach(System.out::println);
//        categoryRepository.trs("%e%").forEach(System.out::println); //з використанням методу з репозиторія

    }

    public static void main(String[] args) {
        SpringApplication.run(OlgaglassApplication.class, args);
    }

}
