package nextstep.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {

    List<Book> bookList;

    @Test
    void setUp() {
        bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));
    }

    Map<String, String> listToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
    }

    @Test
    void whenConvertFromListToMap() {
        setUp();
        Assertions.assertThat(listToMap(bookList).size()).isEqualTo(3);
    }

    Map<Integer, Book> listToMapWithDupKey(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
                (existing, replacement) -> existing));
    }

    @Test
    void whenMapHasDuplicateKeyThenMergeFunctionHandlesCollision() {
        setUp();
        Map<Integer, Book> booksByYear = listToMapWithDupKey(bookList);
        Assertions.assertThat(booksByYear.size()).isEqualTo(2);
        Assertions.assertThat(booksByYear.get(1954).getIsbn()).isEqualTo("0395489318");
    }



    static class Book {
        private String name;
        private int releaseYear;
        private String isbn;

        public Book(String name, int releaseYear, String isbn) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.isbn = isbn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }
}
