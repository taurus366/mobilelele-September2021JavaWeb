package bg.softuni.mobilelele.data.repository;

import bg.softuni.mobilelele.data.model.entity.enums.UserRoleEnum;
import bg.softuni.mobilelele.data.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {

    UserRoleEntity findByRole(UserRoleEnum role);
}
