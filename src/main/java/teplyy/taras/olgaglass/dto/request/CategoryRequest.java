package teplyy.taras.olgaglass.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor //3.10
public class CategoryRequest {

    @NotNull
    private String name;

    private String image;

}
