package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositionTest {

    @Test
    @DisplayName("위치 생성 테스트")
    void create() {
        assertThatCode(() -> new Position(0,  Direction.LEFT)).doesNotThrowAnyException();
    }
}
