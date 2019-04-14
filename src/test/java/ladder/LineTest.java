package ladder;

import ladder.domain.Line;
import ladder.domain.LinkedType;
import ladder.domain.Point;
import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.RandomLineGenerator;
import ladder.support.FixedLineGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test(expected = IllegalArgumentException.class)
    public void 참여인원이_2명_미만일때() {
        // given
        int sizeOfPerson = 1;
        LineGenerator lineGenerator = new RandomLineGenerator();
        // when
        Line line = lineGenerator.generate(sizeOfPerson);
        // then
    }

    @Test
    public void 인원수에_따라_초기화() {
        // given
        int sizeOfPerson = 5;
        LineGenerator lineGenerator = new RandomLineGenerator();
        // when
        Line line = lineGenerator.generate(sizeOfPerson);
        // then
        System.out.println(line);
    }

    @Test
    public void 고정라인_초기화후_이동결과() {
        // given
        int sizeOfPerson = 3;
        List<Point> points = Arrays.asList(
                new Point(0, LinkedType.ONLY_RIGHT_LINKED),
                new Point(1, LinkedType.ONLY_LEFT_LINKED),
                new Point(2, LinkedType.NEITHER_LINKED));
        LineGenerator lineGenerator = new FixedLineGenerator(points);
        // when
        Line line = lineGenerator.generate(sizeOfPerson);
        // then
        assertThat(line.move(2)).isEqualTo(2);
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);

    }
}
