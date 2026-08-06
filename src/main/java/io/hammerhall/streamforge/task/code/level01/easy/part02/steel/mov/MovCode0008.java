package io.hammerhall.streamforge.task.code.level01.easy.part02.steel.mov;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.Base;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти все фильмы, у которых больше одного режиссёра.")
public class MovCode0008 extends Base {

    /**
     * Задание: Найти все фильмы, у которых больше одного режиссёра.
     * <p>
     * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те фильмы,
     * у которых количество режиссёров строго больше одного.
     * <p>
     * Порядок фильмов в результате соответствует порядку обхода исходной коллекции.
     *
     * @param movies коллекция фильмов
     * @return список фильмов, у которых строго больше одного режиссёра
     */
    public List<Movie> task(@NonNull Collection<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getDirectors().size() > 1)
                .toList();
    }

    @Test
    void runTask() {
        Collection<Movie> movies = movies();

        List<Movie> moviesWithMultipleGenres = task(movies);

        assertNotNull(moviesWithMultipleGenres);
        assertFalse(moviesWithMultipleGenres.isEmpty());

        moviesWithMultipleGenres.stream().limit(20).forEach(System.out::println);
    }
}
