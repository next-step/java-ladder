package ladder.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderLineTest {

    @Test
    @DisplayName("라인의 인덱스값을 정상적으로 가져오는지 확인한다")
    void getPoint() {
        LadderLine ladderLine = LadderLine.of(Arrays.asList(Point.of(Index.of(0), Direction.of(true, true))));
        assertThat(ladderLine.getPoint(Index.of(0)).getIndex().get()).isEqualTo(0);
    }

    @Test
    @DisplayName("라인의 방향값을 정상적으로 가져오는지 확인한다")
    void getPoint2() {
        LadderLine ladderLine = LadderLine.of(Arrays.asList(Point.of(Index.of(0), Direction.of(true, true))));
        assertTrue(ladderLine.getPoint(Index.of(0)).isLeft());
        assertTrue(ladderLine.getPoint(Index.of(0)).isRight());
    }
}
