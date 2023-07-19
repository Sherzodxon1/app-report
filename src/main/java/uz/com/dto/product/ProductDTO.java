package uz.com.dto.product;

import lombok.*;
import uz.com.dto.category.CategoryDTO;
import uz.com.entity.Product;
import uz.com.enums.UnitType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Integer id;

    private boolean active;

    private String name;

    private CategoryDTO category;

    private UUID uuid;

    private UnitType unitType;

}
