package bg.softuni.books.repository;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

}
