package teplyy.taras.olgaglass.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

public class StaticResoursecConfiguration implements WebMvcConfigurer {

    @Value("${categories.img.directory}")
    private String categoryImagesDirectoryPath;

    @Value("${subcategories.img.directory}")
    private String subcategoryImagesDirectoryPath;

    @Value("${products.img.directory}")
    private String productsImagesDirectoryPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/category/**")
                .addResourceLocations(getPath(categoryImagesDirectoryPath));
        registry.addResourceHandler("/images/subcategory/**")
                .addResourceLocations(getPath(subcategoryImagesDirectoryPath));
        registry.addResourceHandler("/images/product/**")
                .addResourceLocations(getPath(productsImagesDirectoryPath));
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/");
    }

    private String getPath(String directory) {
        return Paths.get(System.getProperty("user.home"), directory).toUri().toString();
    }
}
