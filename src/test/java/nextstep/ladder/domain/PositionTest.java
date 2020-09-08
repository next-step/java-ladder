package nextstep.ladder.domain;

import nextstep.ladder.domain.line.LadderLine;
import nextstep.ladder.domain.point.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        ladderLine = new LadderLine(2, () -> true);
    }

    @Test
    @DisplayName("포인트 이동 확인")
    void position() {
        int result = Position.valueOf(ladderLine.getPoints(), 0).move(0);
        assertThat(result).isEqualTo(1);
    }

}
