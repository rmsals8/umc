package umc.spring.DTO;

import lombok.*;
import umc.spring.entity.Book;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private int id;
    private String name;
    private String author;
    private int price;

    public static BookDTO toDto(Book entity){
        return BookDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .author(entity.getAuthor())
                .price(entity.getPrice())
                .build();
    }

    public Book toEntity() {
        return Book.builder()
                .id(this.id)
                .name(this.name)
                .author(this.author)
                .price(this.price)
                .build();
    }
}
