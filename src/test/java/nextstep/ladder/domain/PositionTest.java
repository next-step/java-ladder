package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("사다리 라인 위치의 객체 생성을 확인한다.")
    void notCreateLadderPosition() {
        // given
        boolean value = false;

        // when
        Position position = new Position(value);

        // then
        assertThat(position.hasValue()).isFalse();
    }
}
