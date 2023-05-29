package com.java.services.random_service;

import com.java.constant.BooksType;
import com.java.constant.ComicsType;
import com.java.model.Book;
import com.java.model.Comics;
import com.java.model.Document;
import com.java.model.Writer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomService {

    private final Random random = new Random();

    private final List<String> firstnames = List.of("Jake", "Jack", "Harry", "Jacob", "George", "James", "William", "Connor", "Joe", "Liam", "Ethan");
    private final List<String> lastnames = List.of("Smith", "Jones", "Williams", "Taylor", "Davies", "Brown", "Wilson", "Evans", "Thomas", "Johnson");
    private final List<String> letters = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");
    private final List<BooksType> booksTypes = Arrays.stream(BooksType.values()).toList();
    private final List<ComicsType> comicsTypes = Arrays.stream(ComicsType.values()).toList();


    public Book getRandomBook() {
        Writer author = getRandomAuthor();
        return new Book(
                getRandomPublicationDate(author),
                getRandomTitle(),
                getRandomContent(),
                getRandomBooksType(),
                author,
                getRandomPrice()
        );
    }

    public Comics getRandomComics() {
        Writer author = getRandomAuthor();
        return new Comics(
                getRandomPublicationDate(author),
                getRandomTitle(),
                getRandomContent(),
                getRandomComicsType(),
                author,
                getRandomPrice()
        );
    }

    public Document getRandomDocument() throws Exception {
        int type = random.nextInt(0, 2);
        return switch (type) {
            case 0 -> getRandomBook();
            case 1 -> getRandomComics();
            default -> throw new Exception("Error during generating random document.");
        };
    }

    public Writer getRandomAuthor() {
        return new Writer(
                firstnames.get(random.nextInt(firstnames.size())),
                lastnames.get(random.nextInt(lastnames.size())),
                getRandomDateOfBirth());
    }

    private LocalDate getRandomDateOfBirth() {
        return LocalDate.of(
                random.nextInt(1950, 1990),
                random.nextInt(1, 12),
                random.nextInt(1, 31));
    }

    private LocalDate getRandomPublicationDate(Writer writer) {
        return writer.getDateOfBirth().plusWeeks(random.nextLong(1000, 1500));
    }

    private String getRandomTitle() {
        StringBuilder title = new StringBuilder();
        for (int i = 0; i < random.nextInt(5, 10); i++) {
            title.append(letters.get(random.nextInt(letters.size())));
        }
        return title.toString();
    }

    private String getRandomContent() {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < random.nextInt(10, 25); i++) {
            content.append(letters.get(random.nextInt(letters.size())));
        }
        return content.toString();
    }

    private BooksType getRandomBooksType() {
        return booksTypes.get(random.nextInt(booksTypes.size()));
    }

    private ComicsType getRandomComicsType() {
        return comicsTypes.get(random.nextInt(comicsTypes.size()));
    }

    private Double getRandomPrice(){
        return Math.round(random.nextDouble(10, 100) * 100.0) / 100.0;
    }


}
