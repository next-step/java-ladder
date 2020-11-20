package ladder.domain;

import ladder.exception.BadNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PersonTest {

    @ParameterizedTest
    @DisplayName("이름이 5글자가 넘으면, BadNameException 이 발생한다.")
    @ValueSource(strings = {"Bad Name", "나쁜 이름짓기", "666666"})
    void constructor_BadNameException(String name) {
        assertThatExceptionOfType(BadNameException.class)
                .isThrownBy(() -> new Person(name));
    }
}
