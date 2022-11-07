package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonsTest {
    @Test
    @DisplayName("전체 결과 검색")
    void test1() {
        Ladder ladder = new Ladder(1, 3, () -> false);
        Persons persons = new Persons(List.of("a", "b", "c"));

        assertThat(persons.findAllFinalIndex(ladder))
                .containsEntry(new Person("a"), 0)
                .containsEntry(new Person("b"), 1)
                .containsEntry(new Person("c"), 2);
    }
}
