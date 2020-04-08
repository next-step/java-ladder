package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("입력받은 참가자 이름(width - 1)과 사다리 높이(height) 만큼의 사다리가 생성되는지 확인한다.")
    void createLadder() {
        Ladder ladder = new Ladder(4, 5);

        assertThat(ladder.getWidth()).isEqualTo(3);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        int height = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(4, height);
    }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
}

    @Test
    @DisplayName("사다리의 Point(참여자 수 - 1)는 2명 이상이어야 한다.")
    void assertLadderWidth() {
        int participantCount = 1;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(participantCount, 5);
        }).withMessage(Line.POINT_COUNT_ERROR);
    }

    /**
     * |-----|     |
     * |     |-----|
     * |     |-----|
     */
    @Test
    @DisplayName("출발점으로부터 사다리를 타고 알맞은 Position에 도착해야 한다.")
    void moveTest1() {
        List<Line> lines = new ArrayList<>();

        lines.add(createHasLineLeft());
        lines.add(createHasLineRight());
        lines.add(createHasLineRight());

        Ladder ladder = new Ladder(lines);

        assertThat(ladder.move(0)).isEqualTo(1);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(2);
    }

    /**
     * |-----|     |
     */
    private static Line createHasLineLeft() {
        List<Point> points = new ArrayList<>();

        points.add(new Point(0, true));
        points.add(new Point(1, false));

        return new Line(points);
    }

    /**
     * |     |-----|
     */
    private static Line createHasLineRight() {
        List<Point> points = new ArrayList<>();

        points.add(new Point(0, false));
        points.add(new Point(1, true));

        return new Line(points);
    }
}
