package teplyy.taras.olgaglass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import teplyy.taras.olgaglass.dto.request.SubcategoryRequest;
import teplyy.taras.olgaglass.dto.response.SubcategoryResponse;
import teplyy.taras.olgaglass.entity.Subcategory;
import teplyy.taras.olgaglass.reposotory.SubcategoryRepository;
import teplyy.taras.olgaglass.tool.FileTool;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static teplyy.taras.olgaglass.tool.Constants.USER_HOME;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryService categoryService; //звернення до сервісу

    @Autowired
    private FileTool fileTool;

    @Value("${subcategories.img.directory}")
    private String imgDirectory;

    public void save(SubcategoryRequest request) throws IOException {
        subcategoryRepository.save(subcategoryRequestToSubcategory(null, request));

    }

    public void delete(Long id) {
        Subcategory subcategory = findOne(id);
        subcategoryRepository.delete(subcategory);
        Paths.get(System.getProperty(USER_HOME), imgDirectory, subcategory.getImage()).toFile().delete();
    }

    public List<SubcategoryResponse> findAllByCategoryId(Long categoryId) {
        return subcategoryRepository.findAllByCategoryId(categoryId).stream()
                .map(SubcategoryResponse::new).collect(Collectors.toList());
    }

    public List<SubcategoryResponse> findAll() {
        return subcategoryRepository.findAll(Sort.by(Sort.Direction.ASC, "category.name"))
                .stream().map(SubcategoryResponse::new).collect(Collectors.toList());
    }

    public void update(Long id, SubcategoryRequest request) throws IOException {
        subcategoryRepository.save(subcategoryRequestToSubcategory(findOne(id), request));
    }

    private Subcategory subcategoryRequestToSubcategory (Subcategory subcategory, SubcategoryRequest subcategoryRequest)  throws IOException {
        if (subcategory == null) {
            subcategory = new Subcategory();
        }
        subcategory.setName(subcategoryRequest.getName());
        subcategory.setCategory(categoryService.findOne(subcategoryRequest.getCategoryId()));
        if (subcategoryRequest.getImage() != null) {
            subcategory.setImage(fileTool.saveFile(subcategoryRequest.getImage(), imgDirectory));
        }
        return subcategory;
    }


    public Subcategory findOne(Long id) {
        return subcategoryRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Subcategory with id " + id + " not exists"));
    }

}
