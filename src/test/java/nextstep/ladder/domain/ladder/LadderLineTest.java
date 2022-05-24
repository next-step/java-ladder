package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.Position;
import nextstep.ladder.util.RandomConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @DisplayName("사다리의 한 행을 생성한다.")
    @Test
    void createLadderLineTest() {
        LadderLine ladderLine = LadderLine.of(5, new RandomConnectStrategy());
        System.out.println(ladderLine);
    }

    @DisplayName("사다리의 한 행의 특점 지점을 반환한다.")
    @Test
    void pointTest() {
        LadderLine ladderLine = LadderLine.of(5, new RandomConnectStrategy());
        assertThat(ladderLine.point(Position.from(3)))
                .isEqualTo(Point.of(Position.from(3), Direction.of(true, false)));
    }

    @DisplayName("사다리의 한 행의 크기를 반환한다.")
    @Test
    void sizeTest() {
        LadderLine ladderLine = LadderLine.of(5, new RandomConnectStrategy());
        assertThat(ladderLine.size()).isEqualTo(5);
    }
}
