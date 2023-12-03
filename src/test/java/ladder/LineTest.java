package ladder;

import ladder.domain.Line;
import ladder.domain.RandomLineCondition;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 라인_생성() {
        int countOfPerson = 3;
        Line lineTF = new Line(countOfPerson, () -> true);
        List<Boolean> pointsTF = lineTF.getPoints(); // true, false

        Line lineFX = new Line(countOfPerson, () -> false);
        List<Boolean> pointsFX = lineFX.getPoints(); // false, (true/false)

        assertThat(pointsTF).isEqualTo(Arrays.asList(true, false));
        assertThat(pointsFX.get(0)).isFalse();
    }

    @Test
    void 라인_생성_중복없음() {
        int countOfPerson = 3;
        RandomLineCondition pointCondition = new RandomLineCondition();
        Line line = new Line(countOfPerson, pointCondition);
        List<Boolean> points = line.getPoints();

        assertThat(points).isNotEqualTo(Arrays.asList(true, true));
    }
}