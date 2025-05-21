public class FilmManager {
    private String[] films;
    private int limit;

    public FilmManager() {
        this.films = new String[0];
        this.limit = 5;
    }

    public FilmManager(int limit) {
        this.films = new String[0];
        this.limit = limit;
    }

    //Добавление фильма
    public void addFilm(String film) {
        String[] newFilms = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            newFilms[i] = films[i];
        }
        newFilms[newFilms.length - 1] = film;
        films = newFilms;
    }

    //Вывод всех фильмов в порядке добавления
    public String[] findAll() {
        return films;
    }

    //Вывод последних добавленных фильмов в обратном порядке
    public String[] findLast() {
        int totalFilms = films.length;
        int resultLength;

        if (totalFilms < limit) {
            resultLength = totalFilms;
        } else {
            resultLength = limit;
        }
        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = films[totalFilms - 1 - i];
        }
        return result;
    }
}
