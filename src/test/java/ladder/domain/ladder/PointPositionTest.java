package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointPositionTest {

    @Test
    @DisplayName("포지션 생성")
    void create() {
        PointPosition position = new PointPosition(1);
        assertThat(position).isEqualTo(new PointPosition(1));
    }

    @Test
    @DisplayName("position 값이 음수일 경우 검증 -> IllegalArgumentException")
    void valid() {
        assertThatThrownBy(() -> new PointPosition(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("position 정상 값")
    void invalid() {
        assertThatCode(() -> new PointPosition(0))
                .doesNotThrowAnyException();
    }

}