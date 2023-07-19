package uz.com.dto.product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ProductUpdateDTO {

    @NotNull(message = "Id is required !!!")
    private Integer id;

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotNull(message = "Category id is required !!!")
    private Integer categoryId;

    @NotBlank(message = "Name is required !!!")
    private String unitTypeName;

}

