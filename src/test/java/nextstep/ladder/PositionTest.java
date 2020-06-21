package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ladder.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("포지션 유효성 체크")
    void validatePositionTest(){
        assertThatThrownBy(() -> Position.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Position.POSITION_EXCEPTION);
    }

    @Test
    @DisplayName("포지션 증가 테스트")
    void increasePositionTest(){
        assertThat(Position.of(0).increase()).isEqualTo(Position.of(1));
        assertThat(Position.of(5).increase()).isEqualTo(Position.of(6));
    }
}
