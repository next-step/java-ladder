package laddergame.domain.ladder;

import laddergame.domain.vo.Column;
import laddergame.domain.vo.Position;
import laddergame.domain.vo.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @DisplayName("사다리 높이와 참여 인원수에 맞는 사다리를 만든다.")
    @ParameterizedTest
    @CsvSource({"1, 2", "2, 4"})
    void createLadder(int ladderHeight, int numberOfPlayer) {
        Ladder ladder = new Ladder(new Height(ladderHeight), numberOfPlayer, () -> true);

        List<Line> lines = ladder.getLines();
        List<Bridge> bridges = lines.get(0).getBridges();

        assertAll(
                () -> assertThat(lines.size()).isEqualTo(ladderHeight),
                () -> assertThat(bridges.size()).isEqualTo(numberOfPlayer - 1)
        );
    }

    private static Stream<Arguments> provideBeforeAndAfterColumn() {
        return Stream.of(Arguments.of(new Column(1), new Column(2)),
                Arguments.of(new Column(2), new Column(1)),
                Arguments.of(new Column(3), new Column(4)),
                Arguments.of(new Column(4), new Column(3)));
    }

    @DisplayName("현재 위치의 높이와 맞는 Line을 찾는다.")
    @Test
    void findCurrentLine() {
        Ladder ladder = new Ladder(new Height(3), 4, () -> true);
        Position position = new Position(1, 2);

        Line findLine = ladder.findCurrentLine(position);

        assertThat(findLine.getLineHeight()).isEqualTo(position.getHeight());
    }

    @DisplayName("사다리를 타고 나서 마지막 위치를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideBeforeAndAfterColumn")
    void progressAllStep(Column before, Column after) {
        Ladder ladder = new Ladder(new Height(3), 4, () -> true);

        Column actualColumn = ladder.progressAllStep(before);

        assertThat(actualColumn).isEqualTo(after);
    }

    @DisplayName("맞지않는 높이로 Line을 찾으면 IllegalArgumentException throw")
    @Test
    void findLineByWrongHeight() {
        Ladder ladder = new Ladder(new Height(3), 4, () -> true);
        Position position = new Position(1, 4);

        assertThatThrownBy(() -> ladder.findCurrentLine(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 높이에 맞는 사다리 한 라인이 존재하지 않습니다. - " +
                        position.getHeight().toInt());
    }
}