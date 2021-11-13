package bg.softuni.hateoas.model.mapping;

import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.entity.StudentsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    StudentDTO mapEntityToDTO(StudentsEntity student);
}
