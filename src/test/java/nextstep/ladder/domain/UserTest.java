package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다")
    void nameMaxLengthException() {
        assertThatThrownBy(() -> new User("abcdef")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다. name: abcdef");
    }

    @Test
    @DisplayName("이름이 공백이면 예외가 발생한다")
    void emptyNameException() {
        assertThatThrownBy(() -> new User("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백일 수 없습니다.");
    }
}
