package ladder.domain;

import ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @DisplayName("사다리 정상 생성 테스트")
    @Test
    void from() {
        List<Line> lines = LineFactory.createLines(5, 4, new RandomLineStrategy());
        Ladder ladder = Ladder.from(lines);
        assertThat(ladder).isNotNull();
    }

    @DisplayName("사다리를 생성하기 위한 인자값이 빈값 또는 null 인 경우 예외 발생 테스트")
    @Test
    void emptyException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.from(new ArrayList<>()))
                .withMessageContaining("존재하지 않습니다.")
        ;
    }

    @DisplayName("사다리 한 줄 아래로 이동하는 테스트")
    @Test
    void movedFrom() {
        List<Line> lines = new ArrayList<>(List.of(
                Line.from(Arrays.asList(false, true, false, true)),
                Line.from(Arrays.asList(false, false, true, false))
        ));
        Ladder ladder = Ladder.from(lines);
        Line movedLine = ladder.movedFrom(Position.from(0));

        assertThat(movedLine).isEqualTo(lines.get(1));
    }

    @DisplayName("더 이상 이동할 사다리가 없는 경우 예외 발생 테스트")
    @Test
    void overException() {
        int heightOfLadder = 5;
        List<Line> lines = LineFactory.createLines(heightOfLadder, 4, new RandomLineStrategy());
        Ladder ladder = Ladder.from(lines);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladder.movedFrom(Position.from(heightOfLadder)))
                .withMessageContaining("더 이상")
        ;
    }
}