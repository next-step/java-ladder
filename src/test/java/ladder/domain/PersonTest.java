package ladder.domain;

import ladder.exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    @DisplayName("글자수가 5자를 초과하면 InvalidNameException 반환한다.")
    void invalidName() {
        assertThatThrownBy(() -> new Person("qwerty", 2, 1)).isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 5 글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 Null 이거나 공란일 경우 InvalidNameException 반환한다.")
    void invalidNullOrBlank() {
        assertThatThrownBy(() -> new Person(" ", 1,1)).isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 공란이거나 Null 일 수 없습니다.");

        assertThatThrownBy(() -> new Person(null, 1,1)).isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 공란이거나 Null 일 수 없습니다.");
    }
}
