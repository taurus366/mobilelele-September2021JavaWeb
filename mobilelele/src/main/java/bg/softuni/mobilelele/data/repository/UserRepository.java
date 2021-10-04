package bg.softuni.mobilelele.data.repository;

import bg.softuni.mobilelele.data.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
