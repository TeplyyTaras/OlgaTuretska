package teplyy.taras.olgaglass.service;

import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import teplyy.taras.olgaglass.dto.request.CategoryRequest;
import teplyy.taras.olgaglass.dto.response.CategoryResponse;
import teplyy.taras.olgaglass.entity.Category;
import teplyy.taras.olgaglass.exception.WrongInputDataException;
import teplyy.taras.olgaglass.reposotory.CategoryRepository;
import teplyy.taras.olgaglass.tool.FileTool;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static teplyy.taras.olgaglass.tool.Constants.USER_HOME;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FileTool fileTool;

    @Value("${categories.img.directory}")
    private  String imgDirectory;


    public void save (CategoryRequest request) throws IOException {
//        Category category = new Category();            //перенос в метод
//        category.setName(category.getName());
//        Category save = categoryRepository.save(category);
//        return new CategoryResponse(save);
        categoryRepository.save(categoryRequestToCategory(null, request));
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream() //ліст категорій
                .map(CategoryResponse::new) // перетворення з допомогою конструктора
                .collect(Collectors.toList()); // збір докупи і відповідь
    }

    public Category findOne (Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Category with id" + id + "not exit"));
        // лямбда вираз з конструктором стрінг як медж
    }

    //курва непрацює
    public void delete(Long id) {
       Category category = findOne(id);
       categoryRepository.delete(category);
       Paths.get(System.getProperty(USER_HOME), imgDirectory, category.getImage()).toFile().delete();

//        Category category = findOne(id);
//        categoryRepository.delete(category);
//        Paths.get(System.getProperty(USER_HOME)), imgDirectory, category.getImage()).toFile().delete();
    }

    public void update(Long id, CategoryRequest request) throws IOException {
        categoryRepository.save(categoryRequestToCategory(findOne(id), request));
    }

    private Category categoryRequestToCategory(Category category, CategoryRequest request) throws IOException {
        if(category == null) {
            category = new Category();
        }
        category.setName(request.getName());
        if (request.getImage() != null) {
            category.setImage(fileTool.saveFile(request.getImage(), imgDirectory));
        }
        return category;
    }

    public FileTool getFileTool() {
        return fileTool;
    }

    public void setFileTool(FileTool fileTool) {
        this.fileTool = fileTool;
    }
}
