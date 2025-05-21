import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {
    @Test
    public void testAddAndFindAll() {
        FilmManager manager = new FilmManager();
        manager.addFilm("Фильм 1");
        manager.addFilm("Фильм 2");
        manager.addFilm("Фильм 3");

        String[] allFilms = manager.findAll();

        Assertions.assertArrayEquals(new String[]{"Фильм 1", "Фильм 2", "Фильм 3"}, allFilms);
    }

    @Test
    public void testFindLastDefaultLimit() {
        FilmManager manager = new FilmManager();
        for (int i = 1; i <= 7; i++) {
            manager.addFilm("Фильм " + i);
        }
        String[] lastFilms = manager.findLast();

        Assertions.assertArrayEquals(new String[]{"Фильм 7", "Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3"}, lastFilms);
    }

    @Test
    public void testFindLastCustomLimit() {
        FilmManager manager = new FilmManager(3);
        for (int i = 1; i <= 5; i++) {
            manager.addFilm("Фильм " + i);
        }
        String[] lastFilms = manager.findLast();

        Assertions.assertArrayEquals(new String[]{"Фильм 5", "Фильм 4", "Фильм 3"}, lastFilms);
    }

    @Test
    public void testFindLastLessThanLimit() {
        FilmManager manager = new FilmManager();
        manager.addFilm("Фильм А");
        manager.addFilm("Фильм Б");

        String[] lastFilms = manager.findLast();

        Assertions.assertArrayEquals(new String[]{"Фильм Б", "Фильм А"}, lastFilms);
    }
}
