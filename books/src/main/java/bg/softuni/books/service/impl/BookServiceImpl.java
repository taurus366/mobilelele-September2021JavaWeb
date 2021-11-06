package bg.softuni.books.service.impl;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import bg.softuni.books.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(this::asBook)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDTO> getBookByID(Long id) {
        return
                bookRepository.findById(id)
                        .map(this::asBook);
    }

    @Override
    public void deleteBookByID(Long id) {
        bookRepository
                .deleteById(id);
    }

    @Override
    public long createBook(BookDTO bookDTO) {

        AuthorEntity author = authorRepository.findByName(bookDTO.getAuthor().getName())
                .orElseGet(() -> new AuthorEntity().setName(bookDTO.getAuthor().getName()));

        BookEntity newBook = new BookEntity()
                .setAuthor(author)
                .setIsbn(bookDTO.getIsbn())
                .setTitle(bookDTO.getTitle());

        return bookRepository
                .save(newBook).getId();
    }

    private BookDTO asBook(BookEntity book){
        System.out.println(book);

        BookDTO bookDTO = modelMapper.map(book,BookDTO.class);
        AuthorDTO authorDTO = modelMapper.map(book.getAuthor(),AuthorDTO.class);

        System.out.println(bookDTO);

        bookDTO.setAuthor(authorDTO);
        return bookDTO;
    }
}
