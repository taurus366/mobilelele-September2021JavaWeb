package bg.softuni.mobilelele.data.repository;

import bg.softuni.mobilelele.data.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
    Optional<UserEntity> findByUsernameIgnoreCase(String username);
}