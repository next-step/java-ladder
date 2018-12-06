package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    public void 옆으로_이동_가능() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, Direction.RIGHT));
        points.add(new Point(1, Direction.LEFT));

        LadderLine line = new LadderLine(points);

        Position moved = line.move(Position.from(0));

        assertThat(moved).isEqualTo(Position.from(1));
    }

    @Test
    public void 이동하지_못하는_라인임() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, Direction.NONE));

        LadderLine line = new LadderLine(points);

        Position moved = line.move(Position.from(0));

        assertThat(moved).isEqualTo(Position.from(0));
    }

    @Test
    public void 항상_포인트_생성_테스트() {
        // 항상 포인트를 생성하는 전략
        LadderLine line = LadderLine.initialize(4, () -> true);

        // 연속해서 포인트는 존재할 수 없음
        String expected = "     |-----|     |-----|";
        assertThat(line.toString()).isEqualTo(expected);
    }

    @Test
    public void 항상_포인트_안_생성_테스트() {
        LadderLine line = LadderLine.initialize(4, () -> false);

        String expected = "     |     |     |     |";
        assertThat(line.toString()).isEqualTo(expected);
    }
}