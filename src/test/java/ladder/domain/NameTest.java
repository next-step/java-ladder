package ladder.domain;

import ladder.exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("글자수가 5자를 초과하면 InvalidNameException 반환한다.")
    void invalidName() {
        assertThatThrownBy(() -> new Name("qwerty")).isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 5 글자를 초과할 수 없습니다.");
    }
}
