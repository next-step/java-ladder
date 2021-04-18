package laddergame.domain.ladder;

import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.line.Point;
import laddergame.domain.ladder.line.PointLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;
    private Size size = new Size(5, 6);

    @BeforeEach
    void setUp() {
        ladder = new Ladder(size);
    }

    @Test
    void 사다리를생성() {
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    void 사다리의선들을생성() {
        ladder.makeLink(() -> true);
        ladder.getLines().forEach(line -> {
            assertThat(line.isConnect()).containsAll(Collections.singleton(true));
        });
    }

    @Test
    @DisplayName("시작지점부터 사다리의 마지막지점까지 이동")
    void 사다리따라서이동() {
        ladder = makeLadder(new Size(5, 4));

        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(3);
        assertThat(ladder.move(2)).isEqualTo(0);
        assertThat(ladder.move(3)).isEqualTo(1);
    }

    /*
    * |-----|     |-----|
    * |     |-----|     |
    * |-----|     |-----|
    * |     |-----|     |
    * |-----|     |-----|
    * 이런 형태의 지그재그 사다리 제작하는 테스트용 함수 (결과: 0 -> 2, 1 -> 3, 2 -> 0, 3 -> 1)
    * */
    private Ladder makeLadder(Size testSize) {
        List<Line> lineList = new ArrayList<>();
        List<Point> points = makePoints(Arrays.asList(false, true, true, false));
        testSize.heightRange()
                .forEach(i -> {
                    Line line = new Line(testSize);
                    if (i % 2 == 0) {
                        line.connect(() -> true);
                    }
                    if (i % 2 != 0) {
                        line = new Line(points);
                    }
                    lineList.add(line);
                });
        return new Ladder(lineList);
    }

    /* true인 지점간 연결하는 함수 */
    private List<Point> makePoints(List<Boolean> checkList) {
        List<Point> points = new ArrayList<>();
        checkList.forEach(i -> points.add(new Point()));

        PointLink link = new PointLink();
        IntStream.range(0, checkList.size())
                .filter(i -> checkList.get(i))
                .forEach(i -> {
                    link.pair(points.get(i));
                    link.link(() -> true);
                });
        return points;
    }
}
