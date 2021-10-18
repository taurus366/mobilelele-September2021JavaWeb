package bg.softuni.mobilelele.data.repository;

import bg.softuni.mobilelele.data.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity,Long> {
//    ModelEntity findById (Long id);
}
