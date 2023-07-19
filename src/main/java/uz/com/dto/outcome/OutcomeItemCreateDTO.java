package uz.com.dto.outcome;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class OutcomeItemCreateDTO {

    @NotNull(message = "Product id is required !!!")
    private Integer productId;

    @NotNull(message = "Amount is required !!!")
    private Integer amount;

    @NotBlank(message = "Unit type is required !!!")
    private String unitTypeName;

    @NotNull(message = "Cost is required !!!")
    private Integer cost;

}
