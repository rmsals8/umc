package umc.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
