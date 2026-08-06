package io.hammerhall.streamforge.task.code.level02.medium.part03.steel.wld;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;

import java.util.*;
import java.util.stream.Collectors;

import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Задание: Найти континент с самым большим суммарным населением стран.")
public class WldCode0042 extends Base {

    /**
     * Задание: Найти континент с самым большим суммарным населением стран.
     * <p>
     * Описание: необходимо для каждого континента сложить население всех его
     * стран и вернуть название континента, у которого суммарное население
     * наибольшее.
     *
     * @param countries список стран
     * @return название континента с максимальным суммарным населением
     * @throws NoSuchElementException если список стран пуст
     */
    public String task(@NonNull Collection<Country> countries) {
        return countries.stream()
                .collect(Collectors.groupingBy(
                        Country::getContinent,
                        Collectors.summingInt(Country::getPopulation)
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new)
                .getKey();
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();
        String continent = task(countries);

        assertNotNull(continent);
        assertFalse(continent.isBlank());

        // граница: пустой вход
        assertThrows(NoSuchElementException.class, () -> task(List.of()));

        System.out.println(continent);
    }
}
