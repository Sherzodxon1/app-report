package uz.com;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.com.dto.category.CategoryCreateDTO;
import uz.com.dto.category.CategoryDTO;
import uz.com.dto.category.CategoryUpdateDTO;
import uz.com.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);

    Category toEntity(CategoryCreateDTO dto);

    Category toEntity(@MappingTarget Category category, CategoryUpdateDTO dto);
}
