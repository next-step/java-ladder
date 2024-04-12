package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @DisplayName("Position은 위치값을 갖는다")
    @Test
    void position() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @DisplayName("Position객체는 음수를 가지면 예외를 반환한다")
    @Test
    void negativeException() {
        int negative = -1;

        assertThatThrownBy(() -> new Position(negative))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("이 (%d)위치는 음수입니다. 위치는 0이상이어야 합니다.", negative));
    }
}
