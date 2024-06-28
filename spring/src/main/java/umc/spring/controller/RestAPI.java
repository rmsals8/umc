package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.DTO.BookDTO;
import umc.spring.Service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class RestAPI {
    private final BookService bookService;

    // 모든 도서 목록 git config --global user.name
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 도서 추가
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        BookDTO savedBook = bookService.saveBook(bookDTO);
        return ResponseEntity.ok("도서 추가 성공: " + savedBook.getName());
    }

    // 도서 업데이트
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        if (updatedBook != null) {
            return ResponseEntity.ok("도서 업데이트 성공: " + updatedBook.getName());
        } else {
            return ResponseEntity.badRequest().body("잘못된 도서 ID");
        }
    }

    // 도서 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.ok("도서 삭제 성공");
        } else {
            return ResponseEntity.badRequest().body("잘못된 도서 ID");
        }
    }
}