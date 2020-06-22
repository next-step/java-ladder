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
        assertThatThrownBy(() -> new Direction(true,true))
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
}
