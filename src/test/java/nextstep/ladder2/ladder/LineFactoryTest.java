package nextstep.ladder2.ladder;

import nextstep.ladder2.domain.ladder.GenerateStrategy;
import nextstep.ladder2.domain.ladder.Line;
import nextstep.ladder2.domain.ladder.LineFactory;
import nextstep.ladder2.domain.ladder.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineFactoryTest {

    @Test
    public void 입력한_숫자크기의_라인을_생성한다() {
        Line line = LineFactory.create(4);

        assertThat(line.values()).hasSize(4);
    }

    @Test
    public void 사이즈는_1이상이어야_한다() {
        Assertions.assertThatThrownBy( () -> {
            LineFactory.create(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 라인생성전략은_null일수없다() {
        Assertions.assertThatThrownBy( () -> {
            LineFactory.create(1, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void TRUE전략으로_라인생성시_일정패턴으로_생성되어야한다() {
        Point point1 = Point.first(true);
        Point point2 = point1.next(false);
        Point point3 = point2.last();

        assertThat(LineFactory.create(3, GenerateStrategy.trueSupplier)).isEqualTo(
                new Line(point1, point2, point3)
        );
    }
}