package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CollectionTest {

    private final List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10_000_000; i++) {
            numbers.add(i);
        }
    }

    @Test
    @DisplayName("new ArrayList 로 방어적 복사시 걸리는 시간")
    void copyArrayList() {
        long startTime = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("endTime - startTime = " + (endTime - startTime));
    }

    @Test
    @DisplayName("unmodifiableList 로 방어적 복사시 걸리는 시간")
    void unmodifiable() {
        long startTime = System.currentTimeMillis();
        List<Integer> integers = Collections.unmodifiableList(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("endTime - startTime = " + (endTime - startTime));
    }
}
