package teplyy.taras.olgaglass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teplyy.taras.olgaglass.dto.request.ProductCriteriaRequest;
import teplyy.taras.olgaglass.dto.request.ProductRequest;
import teplyy.taras.olgaglass.dto.response.PageResponse;
import teplyy.taras.olgaglass.dto.response.ProductResponse;
import teplyy.taras.olgaglass.service.ProductService;

import javax.validation.Valid;
import java.util.List;

import static teplyy.taras.olgaglass.tool.Constants.PRODUCT_URL;

@RestController
@RequestMapping(PRODUCT_URL)
//@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    //25.05

    @Autowired
    private ProductService productService;

    @PostMapping
    public void create(@Valid @RequestBody ProductRequest productRequest) {
        productService.create(productRequest);
    }


    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll(); //набір елементів

    }

//    @GetMapping("/page")
//    public PageResponse<ProductResponse> findAllByCriteria(ProductCriteriaRequest productRequest) {
//        return productService.findAll(productRequest);
//    }

//    @PutMapping
//    public void update(Long id, @Valid @RequestBody ProductRequest request) {
//        productService.update(id, request);
//    }

    @PutMapping
    //28/08. 19.04.19
    public ProductResponse update(@Valid Long id, @RequestBody ProductRequest productRequest) {
        return productService.update(productRequest, id); //
    }

//    @DeleteMapping
//    public void delete(Long id) {
//        productService.delete(id);
//    }

    @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
