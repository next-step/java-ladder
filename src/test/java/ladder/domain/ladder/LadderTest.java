package ladder.domain.ladder;

import static ladder.domain.ladder.line.LineTest.line;
import static ladder.domain.ladder.line.LineTest.testConnectionGenerator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.ladder.line.Line;
import ladder.domain.player.Players;

class LadderTest {

    @Test
    @DisplayName("플레이어 수와 높이에 따라 사다리를 생성한다.")
    void Ladder() {
        final Line line = line(true, false, true, false);
        final Ladder expectedLadder = new Ladder(List.of(line, line, line));

        final Ladder actualLadder = Ladder.of(
                Players.from(List.of("kyle", "alex", "haley", "harry", "jun")),
                3,
                testConnectionGenerator
        );

        assertThat(actualLadder).isEqualTo(expectedLadder);
    }

    @Test
    @DisplayName("사다리 라인이 없는 경우 예외를 던진다.")
    void Ladder_NoLines_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(List.of()));
    }

    @Test
    @DisplayName("사다리 전체 연결 상태에 따라 포지션을 이동한다.")
    void Move_Positions() {
        final Ladder ladder = new Ladder(List.of(
                line(true, false, true, false),
                line(false, true, false, true),
                line(false, true, false, false)
        ));
        final Map<Integer, Integer> expectedRoute = Map.of(
                0, 1,
                1, 0,
                2, 4,
                3, 2,
                4, 3
        );

        final Map<Integer, Integer> actualRoute = ladder.move();

        assertThat(actualRoute).isEqualTo(expectedRoute);
    }
}
