package nextstep.ladder;

import ladder.domain.Direction;
import nextstep.ladder.mock.BooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @Test
    @DisplayName("가로라인 겹치면 예외처리")
    void validateDirectionTest(){
        assertThatThrownBy(() -> Direction.of(true,true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Direction.CONNECTED_LINE_EXCEPTION);
    }

    @Test
    @DisplayName("방향 결정 테스트")
    void decideDirectionTest(){
        assertThat(Direction.decideRight(new BooleanGenerator(false)))
                .isEqualTo(Direction.of(false,false));

        assertThat(Direction.decideRight(new BooleanGenerator(true)))
                .isEqualTo(Direction.of(false,true));
    }

    @Test
    @DisplayName("라인 방향에 따라 포지션 값에 전달할 이동 값(숫자) 전달하는 메소드 테스트")
    void moveMethodTest() {
        assertThat(Direction.of(true, false).move()).isEqualTo(-1);
        assertThat(Direction.of(false, true).move()).isEqualTo(1);
        assertThat(Direction.of(false, false).move()).isEqualTo(0);
    }
}
