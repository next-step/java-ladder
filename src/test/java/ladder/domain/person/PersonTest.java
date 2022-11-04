package ladder.domain.person;

import ladder.domain.person.name.PersonName;
import ladder.exception.person.IllegalPersonNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @DisplayName("사람 이름은 최대 5글자이다.")
    @Test
    void valid_personname_length() {
        assertThatThrownBy(() -> new Person("abcdef", 0, 0)).isInstanceOf(IllegalPersonNameException.class);
    }

    @ParameterizedTest(name = "사람 이름은 공백일 수 없습니다.")
    @ValueSource(strings = {"", "   "})
    void valid_blank(String name) {
        assertThatThrownBy(() -> new Person(name, 0, 0)).isInstanceOf(IllegalPersonNameException.class);
    }

    @DisplayName("사람 이름은 null일 수 없습니다.")
    @Test
    void valid_null() {
        assertThatThrownBy(() -> new Person(null, 0, 0)).isInstanceOf(IllegalPersonNameException.class);
    }

    @ParameterizedTest(name = "사람 이름 가져오기")
    @ValueSource(strings = {"pobi", "crong", "sik"})
    void name(String name) {
        assertThat(new Person(name, 0, 0).name()).isEqualTo(new PersonName(name));
    }
}
