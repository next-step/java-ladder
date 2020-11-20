package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PersonsTest {

    private final Persons persons = new Persons(Arrays.asList(
            new Person("1"),
            new Person("22"),
            new Person("333"),
            new Person("4444"),
            new Person("55555")
    ));

    @Test
    @DisplayName("Persions 의 사이즈가 정상적으로 받아져야 한다.")
    void getSize() {
        assertThat(persons.getSize())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("사람 이름이 연속해서 출력되어야 한다.")
    void testToString() {
        assertThat(persons.toString())
                .isEqualTo("     1    22   333  4444 55555");
    }
}
