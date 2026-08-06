package io.hammerhall.streamforge.task.mind.level04.collapse.part02.ingot.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти все фильмы, у которых набор жанров строго равен набору: Drama и Comedy.")
public class MovMind0006 extends Base {

    /**
     * Задание: Найти все фильмы, у которых набор жанров строго равен набору: Drama и Comedy.
     * <p>
     * Описание: необходимо найти фильмы, у которых множество названий жанров
     * состоит ровно из двух значений: "Drama" и "Comedy". Фильм попадает в результат
     * только при полном совпадении наборов — ни больше, ни меньше.
     * Например, фильм с жанрами Drama, Comedy и Romance не подходит.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, у которых набор жанров строго равен {"Drama", "Comedy"}
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getGenres().size() == 2 &&
                        movie.getGenres().getFirst().getName().equals("Drama") &&
                        movie.getGenres().get(1).getName().equals("Comedy"))
                .toList();
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        List<Movie> dramaComedyMovies = task(movies);

        assertNotNull(dramaComedyMovies);
        assertFalse(dramaComedyMovies.isEmpty());
        assertTrue(dramaComedyMovies.stream()
                .noneMatch(movie -> movie.getGenres().size() > 2));

        dramaComedyMovies.forEach(movie -> System.out.println(movie.getTitle() + " " + movie.getGenres()));
    }
}
