package teplyy.taras.olgaglass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teplyy.taras.olgaglass.dto.request.SubcategoryRequest;
import teplyy.taras.olgaglass.dto.response.SubcategoryResponse;
import teplyy.taras.olgaglass.service.SubcategoryService;

import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

import static teplyy.taras.olgaglass.tool.Constants.SUBCATEGORY_URL;

@CrossOrigin
@RestController
@RequestMapping(SUBCATEGORY_URL)
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public void create(@Valid @RequestBody SubcategoryRequest request) throws IOException {
        subcategoryService.save(request);
    }

    @GetMapping
    public List<SubcategoryResponse> findAll() {
        return subcategoryService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody SubcategoryRequest request) throws IOException {
        subcategoryService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        subcategoryService.delete(id);
    }
}
