package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("포지션 유효성 체크")
    void validatePositionTest(){
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Position.POSITION_EXCEPTION);
    }

    @Test
    @DisplayName("포지션 증가 테스트")
    void increasePositionTest(){
        assertThat(new Position(0).increase()).isEqualTo(new Position(1));
        assertThat(new Position(5).increase()).isEqualTo(new Position(6));
    }
}
