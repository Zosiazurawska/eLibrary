import com.java.model.Book;
import com.java.model.Document;
import com.java.model.Library;
import com.java.services.LibraryService;
import com.java.services.random_service.RandomService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class LibraryTest {

    RandomService randomService = new RandomService();

    @Test
    public void shouldSaveNewDocumentInLibrary() throws Exception {
        Library libraryForTest = new Library(
                "testCity",
                2,
                new ArrayList<Document>()
        );

        libraryForTest.getDocuments().add(randomService.getRandomDocument());
        libraryForTest.getDocuments().add(randomService.getRandomDocument());
    }

    @Test
    public void shouldNotSaveNewDocumentInLibrary() throws Exception {
        Library libraryForTest = new Library(
                "testCity",
                2,
                new ArrayList<Document>()
        );

        libraryForTest.getDocuments().add(randomService.getRandomDocument());
        libraryForTest.getDocuments().add(randomService.getRandomDocument());
        libraryForTest.getDocuments().add(randomService.getRandomDocument());
    }

    @Test
    public void shouldReadNewDocumentInLibrary() throws Exception {
        Library libraryForTest = new Library(
                "testCity",
                2,
                new ArrayList<Document>()
        );

        Book randomDocument = randomService.getRandomBook();
        libraryForTest.getDocuments().add(randomDocument);

        Book readBook = (Book) libraryForTest.getDocuments().get(0);

        assertThat(readBook.getContent()).isEqualTo(randomDocument.getContent());
    }

    @Test
    public void shouldNotReadNewDocumentInLibrary() {
        Library libraryForTest = Mockito.mock(Library.class);

        Mockito.when(libraryForTest.read(null)).thenThrow(new NoSuchElementException());

        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> libraryForTest.read(null));

        assertThat(e.getMessage()).isEqualTo(null);
    }

    @Test
    public void shouldDeleteNewDocumentInLibrary() throws Exception {
        Library libraryForTest = new Library(
                "testCity",
                2,
                new ArrayList<Document>()
        );

        libraryForTest.getDocuments().add(randomService.getRandomDocument());
        libraryForTest.getDocuments().add(randomService.getRandomDocument());
        libraryForTest.getDocuments().add(randomService.getRandomDocument());

        libraryForTest.delete(libraryForTest.getDocuments().get(1));

        assertThat(libraryForTest.getDocuments().size()).isEqualTo(2);
    }

    @Test
    public void shouldNotDeleteNewDocumentInLibrary() throws Exception {
        Library libraryForTest = Mockito.mock(Library.class);

        Mockito.when(libraryForTest.delete(null)).thenThrow(new NoSuchElementException());

        NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> libraryForTest.delete(null));

        assertThat(e.getMessage()).isEqualTo(null);
    }
}
