package teplyy.taras.olgaglass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import teplyy.taras.olgaglass.dto.request.ProductCriteriaRequest;
import teplyy.taras.olgaglass.dto.request.ProductRequest;
import teplyy.taras.olgaglass.dto.response.PageResponse;
import teplyy.taras.olgaglass.dto.response.ProductResponse;
import teplyy.taras.olgaglass.entity.Category;
import teplyy.taras.olgaglass.entity.Product;
import teplyy.taras.olgaglass.entity.Subcategory;
import teplyy.taras.olgaglass.exception.WrongInputDataException;
import teplyy.taras.olgaglass.reposotory.ProductRepository;
import teplyy.taras.olgaglass.tool.FileTool;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    //8.04 19.04.19
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubcategoryService subcategoryService;  //правило звератись до інши сервісв а не кожен ра робити новий

    @Autowired
    private FileTool fileTool;

    @Value("${products.img.directory}")
    private String imgDirectory;

    public void create(ProductRequest productRequest) {
        productRepository.save(productRequestToProduct(productRequest, null));
    }

    public ProductResponse update(ProductRequest productRequest, Long id) {
        Product product = productRequestToProduct(productRequest, findOne(id));
        return new ProductResponse(productRepository.save(product)); // передаємо на фрон енд і збрігається
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new).collect(Collectors.toList());
    }

//    public PageResponse<ProductResponse> findAll(ProductCriteriaRequest request) {
//        Page<Product> page = productRepository.findAll(new ProductSpecification(request), request.getPaginationRequest().toPageable());
//        return new PageResponse<>(page.get().map(ProductResponse::new).collect(Collectors.toList()), page.getTotalPages(), page.getTotalElements());
//    }

    public void delete(Long id) {
        productRepository.delete(findOne(id));
    }

    //метод для знаходження продукту по Id
    public Product findOne(Long id) {
        return productRepository
                .findById(id).orElseThrow(() -> new WrongInputDataException("Subcategory with id" + id + "not exit"));
        // приймається інтерфейс який неприймає ніяких параметрів
    }

    //метод перетворення продуктРіквест до продукта
    private Product productRequestToProduct(ProductRequest productRequest, Product product) {
        // продукт в дужках для абдейт методу, передаю продук і за допомогою ріквест оновляю
        // якщо продукта нема тобто нуль поінт то його
        if (product == null) {
            product = new Product();
        }
        product.setName(productRequest.getName());
        product.setHeight(productRequest.getHeight());
        product.setWight(productRequest.getWight());
        product.setDeapt(productRequest.getDeapt());
        product.setDiameter(productRequest.getDiameter());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setWeight(productRequest.getWeight());

        subcategoryService.findOne(productRequest.getSubcategryId());

        if (productRequest.getImages() != null && !productRequest.getImages().isEmpty()) {
            product.setImages(productRequest.getImages().stream().map((Object image) -> saveImage(image)).collect(Collectors.toList()));
        }

        return product;
    }

    private String saveImage(Object image) {
        try {
            return fileTool.saveFile((String) image, imgDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
