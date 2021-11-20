package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> getBookByID(Long id);

    void deleteBookByID(Long id);

    long createBook(BookDTO bookDTO);

    Page<BookDTO> getBooks(
            int pageNo,
            int pageSize,
            String sortBy);
}
