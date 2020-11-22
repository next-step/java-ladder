package ladder.domain.model;

import ladder.dto.PersonDto;
import ladder.exception.BadNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class PersonTest {

    @ParameterizedTest
    @DisplayName("이름이 5글자가 넘으면, BadNameException 이 발생한다.")
    @ValueSource(strings = {"Bad Name", "나쁜 이름짓기", "666666"})
    void constructor_BadNameException(String name) {
        assertThatExceptionOfType(BadNameException.class)
                .isThrownBy(() -> new Person(name));
    }

    @Test
    @DisplayName("Person 의 이름이 dto 로 잘 포장되는지 확인")
    void exportPersonDto() {
        String name = "n";
        Person person = new Person(name);
        PersonDto dto = person.exportPersonDto();
        assertThat(dto.getName())
                .isEqualTo(name);
    }

    @Test
    @DisplayName("Person 의 equals 확인")
    void testEquals() {
        String name1 = "n1";
        String name2 = "n2";
        assertAll(
                () -> assertThat(new Person(name1))
                        .isEqualTo(new Person(name1)),
                () -> assertThat(new Person(name1))
                        .isNotEqualTo(new Person(name2))
        );
    }

    @Test
    @DisplayName("Person 의 hashCode 확인")
    void testHashCode() {
        String name1 = "n1";
        String name2 = "n2";
        assertAll(
                () -> assertThat(new Person(name1).hashCode())
                        .isEqualTo(new Person(name1).hashCode()),
                () -> assertThat(new Person(name1).hashCode())
                        .isNotEqualTo(new Person(name2).hashCode())
        );
    }
}
