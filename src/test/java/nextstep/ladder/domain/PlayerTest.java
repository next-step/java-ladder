package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("이름은 5글자 이하만 가능하다")
    @Test
    void tooLongName() {
        assertThatThrownBy(() -> new Player("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름은 비어있을 수 없다")
    @ParameterizedTest(name = "name = {0}")
    @NullAndEmptySource
    void emptyName(String name) {
        assertThatThrownBy(() -> new Player(name)).isInstanceOf(IllegalArgumentException.class);
    }

}
