package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositionTest {

    @Test
    @DisplayName("위치 생성 테스트")
    void create() {
        Line line = new Line(true, Direction.of(Direction.LEFT));
        assertThatCode(() -> new Position(0, Height.of(4), line)).doesNotThrowAnyException();
    }
}
