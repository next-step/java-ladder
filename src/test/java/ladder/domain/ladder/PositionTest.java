package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("포지션 생성")
    void create() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("position 값이 음수일 경우 검증 -> IllegalArgumentException")
    void valid() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
        // 정상 값
        assertThatCode(() -> new Position(0))
                .doesNotThrowAnyException();
    }

}