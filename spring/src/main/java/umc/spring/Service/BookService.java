package umc.spring.Service;

import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import umc.spring.DTO.BookDTO;
import umc.spring.Repository.BookRepository;
import umc.spring.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    // DTO를 엔티티로 변환하여 저장하고, 다시 DTO로 변환하여 반환
    public BookDTO saveBook(BookDTO bookDTO){
        // (1) DTO를 엔티티로 변환
        Book entity = bookDTO.toEntity();

        // (2) 엔티티 저장
        Book savedEntity = repository.save(entity);


        // (3) 엔티티를 DTO로 변환
        BookDTO dto = BookDTO.toDto(savedEntity);

        return dto;
    }

    // ID로 도서를 조회하여 DTO로 반환
    public BookDTO getBook(int id) {
        return repository.findById(id)
                .map(BookDTO::toDto)
                .orElse(null);
    }

    // 모든 도서를 조회하여 DTO 목록으로 반환
    public List<BookDTO> getAllBooks() {
        return repository.findAll().stream()
                .map(BookDTO::toDto)
                .collect(Collectors.toList());
    }

    // 도서를 업데이트하고, 업데이트된 도서를 DTO로 반환
    public BookDTO updateBook(int id, BookDTO bookDTO) {
        return repository.findById(id)
                .map(book -> {
                    book.setName(bookDTO.getName());
                    book.setAuthor(bookDTO.getAuthor());
                    book.setPrice(bookDTO.getPrice());
                    Book updatedBook = repository.save(book);
                    return BookDTO.toDto(updatedBook);
                })
                .orElse(null);
    }

    // 도서를 삭제하고, 성공 여부를 반환
    public boolean deleteBook(int id) {
        return repository.findById(id)
                .map(book -> {
                    repository.delete(book);
                    return true;
                })
                .orElse(false);
    }
}