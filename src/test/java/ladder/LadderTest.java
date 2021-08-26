package ladder;

import ladder.domain.Index;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.exception.LadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @DisplayName("참여할_사람의_인원_수와_사다리_높이가_주어지면_사다리_높이만큼의_Line객체를_가진_Ladder가_생성된다")
    @Test
    void newLadderTest() {
        int countOfPerson = 4;
        int height = 5;
        Ladder ladder = Ladder.from(countOfPerson, height);

        assertThat(ladder).isInstanceOf(Ladder.class);
        assertThat(ladder.toList().size()).isEqualTo(height);
    }

    @DisplayName("사다리_높이가_0이하이면_예외가_발생한다")
    @Test
    void exceptionTest() {
        int countOfPerson = 4;
        int height = 0;
        assertThatThrownBy(() -> Ladder.from(countOfPerson, height)).isInstanceOf(LadderHeightException.class);
    }

    @DisplayName("사다리와 시작인덱스가 주어진다면, 결과인덱스값을 알 수 있다")
    @Test
    void resultIndexOfTest() {
        // 기본 사다리 생성 |-----|
        List<Point> points = new ArrayList<>();
        points.add(Point.of(false, true));
        points.add(Point.of(true, false));
        points.add(Point.of(false, true));
        points.add(Point.of(true, false));

        List<Line> lines = Arrays.asList(Line.from(points));
        Ladder ladder = Ladder.from(lines);
        assertThat(ladder.resultIndexOf(Index.from(0))).isEqualTo(1);
        assertThat(ladder.resultIndexOf(Index.from(1))).isEqualTo(0);
    }
}
