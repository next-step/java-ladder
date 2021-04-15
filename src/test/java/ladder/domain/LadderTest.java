package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("사다리 게임 생성 - 사다리 높이 검증")
    void ladderHeight(int ladderHeight) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(4, ladderHeight))
                .withMessageMatching("사다리의 높이는 최소 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1})
    @DisplayName("사다리 게임 생성 - 사다리 너비 검증")
    void ladderWidth(int ladderWidth) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(ladderWidth, 5))
                .withMessageMatching("사다리의 너비는 최소 2 이상이어야 합니다.");
    }

    @Test
    @DisplayName("사다리 생성 검증")
    void ladder() {
        // given
        Ladder ladder = new Ladder(4, 5);

        // when
        List<Line> lineList = ladder.getLines();

        // then
        assertAll(
                () -> assertThat(5).isEqualTo(lineList.size()),
                () -> lineList.forEach(line -> assertThat(4).isEqualTo(line.getPoints().size()))
        );
    }

    @Test
    @DisplayName("그려진 사다리는 수정할 수 없음")
    void ladderIsUnmodifiable() {
        // given
        Ladder ladder = new Ladder(4, 5);

        // when
        List<Line> lineList = ladder.getLines();

        // then
        assertThrows(UnsupportedOperationException.class, () -> lineList.add(new Line(5)));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:3", "2:2", "3:1"}, delimiter = ':')
    @DisplayName("사다리타기 결과 테스트")
    void getExitNumber(int entranceNumber, int exitNumber) {
        // given
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));

        // when
        Ladder ladder = new Ladder(lines);

        // then
        assertThat(exitNumber).isEqualTo(ladder.getExitNumber(entranceNumber));
    }
}