package bg.softuni.hateoas.Repository;

import bg.softuni.hateoas.model.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsReposiory extends JpaRepository<StudentsEntity,Long> {
}
