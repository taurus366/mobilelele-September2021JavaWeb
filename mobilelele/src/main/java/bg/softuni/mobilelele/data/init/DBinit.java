package bg.softuni.mobilelele.data.init;

import bg.softuni.mobilelele.data.enums.CategoryEnum;
import bg.softuni.mobilelele.data.enums.UserRoleEnum;
import bg.softuni.mobilelele.data.model.entity.BrandEntity;
import bg.softuni.mobilelele.data.model.entity.ModelEntity;
import bg.softuni.mobilelele.data.model.entity.UserEntity;
import bg.softuni.mobilelele.data.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.data.repository.BrandRepository;
import bg.softuni.mobilelele.data.repository.UserRepository;
import bg.softuni.mobilelele.data.repository.UserRoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBinit implements CommandLineRunner {


    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public DBinit(BrandRepository brandRepository, UserRepository userRepository, ObjectMapper objectMapper, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public void run(String... args) throws JsonProcessingException {

        initializeBrandAndModels();
        initializeRoles();
        initializaUsers();


    }

    private void initializaUsers() {

        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);



            UserEntity admin = new UserEntity();
            admin.setActive(true)
                    .setUsername("taurus366")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setRoles(List.of(adminRole, userRole))
                    .setPassword(passwordEncoder.encode("TODO"));

            userRepository.save(admin);

            UserEntity user = new UserEntity();
            user.setActive(true)
                    .setUsername("taurus")
                    .setFirstName("user")
                    .setLastName("userov")
                    .setRoles(List.of(userRole))
                    .setPassword(passwordEncoder.encode("taurus"));

            userRepository.save(user);

        }
    }

    private void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    private void initializeBrandAndModels() throws JsonProcessingException {
        //        if (brandRepository.count() == 0){
        BrandEntity brand = new BrandEntity().setName("Ford");

        ModelEntity fiesta = new ModelEntity();
        fiesta
                .setName("fiesta")
                .setImageUrl("testURL")
                .setStartYear(1976)
                .setCategory(CategoryEnum.CAR);

        ModelEntity Mustang = new ModelEntity();
        Mustang
                .setName("Mustang")
                .setImageUrl("testURL")
                .setStartYear(2000)
                .setEndYear(2021)
                .setCategory(CategoryEnum.CAR);

        brand.setModels(List.of(fiesta, Mustang));

        fiesta.setBrand(brand);
        Mustang.setBrand(brand);

        this.brandRepository.save(brand);

        System.out.println(objectMapper.writeValueAsString(new ModelEntity().setName("fiesta").setBrand(new BrandEntity().setName("brand"))));
//        }

    }
}
