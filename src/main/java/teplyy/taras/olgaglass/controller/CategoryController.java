package teplyy.taras.olgaglass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teplyy.taras.olgaglass.dto.request.CategoryRequest;
import teplyy.taras.olgaglass.dto.response.CategoryResponse;
import teplyy.taras.olgaglass.service.CategoryService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static teplyy.taras.olgaglass.tool.Constants.CATEGORY_URL;

@RestController //для анотації сторіни
@RequestMapping(CATEGORY_URL) //("/category") //вказівка посилання для всіх внутрішніх мапінгів
@CrossOrigin

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void create(@Valid @RequestBody CategoryRequest categoryRequest) throws IOException {
        categoryService.save(categoryRequest);

        // 14.51 . 17.04.2019
    }

    @GetMapping
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody CategoryRequest request) throws IOException {
        categoryService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryService.delete(id);
    }
}
