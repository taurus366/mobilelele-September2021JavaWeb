package bg.softuni.mobilelele.data.repository;

import bg.softuni.mobilelele.data.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

}
