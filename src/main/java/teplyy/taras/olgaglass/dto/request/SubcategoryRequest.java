package teplyy.taras.olgaglass.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor

public class SubcategoryRequest {

    @NotNull
    private String name;
    private String Image;

    @NotNull
    private  Long categoryId;

}
