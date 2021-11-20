package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    // called on http://localhost:8080/books
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> allBooks = bookService.getAllBooks();

        return ResponseEntity
                .ok(allBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Optional<BookDTO> bookByID = bookService.getBookByID(id);

        if (bookByID.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .ok(bookByID.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id){
        bookService.deleteBookByID(id);
        return ResponseEntity.noContent()
                .build();
    }

    @PostMapping()
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO, UriComponentsBuilder uriComponentsBuilder){

        // http://localhost:8080/books/id
        long bookId = bookService.createBook(bookDTO);

        URI location = uriComponentsBuilder.path("/books/{id}").buildAndExpand(bookId).toUri();

        return ResponseEntity
                .created(location)
                .build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id, @RequestBody BookDTO bookDTO){
    //todo
        throw new UnsupportedOperationException("coming soon!");
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<BookDTO>> getBooks(
            @RequestParam(name= "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy
    ){
            return ResponseEntity.ok(bookService.getBooks(pageNo,pageSize,sortBy));
    }

}
