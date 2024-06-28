package umc.spring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import umc.spring.DTO.BookDTO;

@Entity
@Data
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int price;

    public static Book toEntity(BookDTO dto){
        return Book.builder()
                .id(dto.getId())
                .name(dto.getName())
                .author(dto.getAuthor())
                .price(dto.getPrice())
                .build();
    }

//    public int getId() {
//        return id;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
}
