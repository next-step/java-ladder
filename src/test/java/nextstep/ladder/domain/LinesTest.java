package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class LinesTest {

    @Test
    @DisplayName("각 라인의 좌표들을 인자로 받아 모든 라인을 생성한다.")
    public void create() throws Exception {
        //given
        AllPointsForLines allPointsForLines = new AllPointsForLines(new RandomDirectionStrategy());
        List<Points> allPoints = allPointsForLines.allPoints(4, 5);
        Lines lines = Lines.from(allPoints);

        //when
        List<Line> result = lines.lines();

        then(result).hasSize(5);
    }

    @Test
    @DisplayName("라인 목록에서 첫 번째 라인을 반환한다.")
    public void firstLine() throws Exception {
        //given
        Line line1 = new Line(0, new Points(4, new RandomDirectionStrategy()));
        Line line2 = new Line(1, new Points(4, new RandomDirectionStrategy()));
        Lines lines = new Lines(Arrays.asList(line1, line2));

        //when
        Line firstLine = lines.firstLine();

        then(firstLine).isEqualTo(line1);
    }

    @Test
    @DisplayName("라인 인덱스를 인자로 받아 해당 인덱스의 다음 라인을 반환한다.")
    public void nextLine() throws Exception {
        //given
        Line line1 = new Line(0, new Points(4, new RandomDirectionStrategy()));
        Line line2 = new Line(1, new Points(4, new RandomDirectionStrategy()));
        Lines lines = new Lines(Arrays.asList(line1, line2));

        //when
        Line nextLine = lines.nextLine(0);

        then(nextLine).isEqualTo(line2);
    }
}
