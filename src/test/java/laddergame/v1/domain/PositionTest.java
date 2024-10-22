package laddergame.v1.domain;

import laddergame.v1.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @DisplayName("사다리 게임의 위치는 0이상이어야 합니다")
    @Test
    void positionLimit(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1))
                .withMessage("사다리 게임의 위치는 0이상이어야 합니다");
    }

    @DisplayName("같은 위치인지 확인한다")
    @Test
    void same(){
        Position position = new Position(1);

        assertThat(position.same(1)).isTrue();
    }

}