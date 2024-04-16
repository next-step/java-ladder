package ladder.domain;

import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("이름이 5자를 초과할 경우 예외를 던진다.")
    @Test
    public void over5Length() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("이름이름이름"));
    }

    @DisplayName("이름이 공백일 경우 예외를 던진다.")
    @Test
    public void blankName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(""));
    }
}