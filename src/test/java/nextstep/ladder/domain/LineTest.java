package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class LineTest {

    @Test
    @DisplayName("좌표 값들을 인자로 받아 사다리 라인을 생성한다.")
    public void create() throws Exception {
        Line line = new Line(0, new Points(4, new RandomDirectionStrategy()));
        assertThat(line.points().points()).hasSize(4);
    }

    @Test
    @DisplayName("전체 목록의 크기를 인자로 받아 현재 라인이 마지막 라인이 아닐 경우 참을 반환한다.")
    public void isNotLast() throws Exception {
        //given
        Line line1 = new Line(0, new Points(4, new RandomDirectionStrategy()));
        Line line2 = new Line(1, new Points(4, new RandomDirectionStrategy()));
        Lines lines = new Lines(Arrays.asList(line1, line2));

        //when
        boolean notLast = line1.isNotLast(lines.size());
        boolean last = line2.isNotLast(lines.size());

        then(notLast).isTrue();
        then(last).isFalse();
    }

    @Test
    @DisplayName("좌표 인덱스를 인자로 받아 현재 라인의 다음 좌표 인덱스를 반환한다.")
    public void nextPointIndexFrom() throws Exception {
        //given
        Line line = new Line(0, new Points(4, new RandomDirectionStrategy()));
        Points points = line.points();
        Point point = points.points().get(0);
        int expected = point.move();

        //when
        int result = line.nextPointIndexFrom(0);

        then(result).isEqualTo(expected);
    }
}
