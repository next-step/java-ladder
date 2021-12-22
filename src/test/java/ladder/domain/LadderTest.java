package ladder.domain;

import ladder.fixture.TestLadderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("높이 5")
    @Test
    void 사다리생성() {
        Ladder ladder = TestLadderFactory.createLadder("pobi,honux,crong,jk", 5);
        assertThat(ladder.countOfLine()).isEqualTo(5);
    }

    @Test
    void 사다리게임실행() {
        Ladder ladder = createFiveHeightLadder();
        assertThat(ladder.move(0)).isEqualTo(0);
        assertThat(ladder.move(1)).isEqualTo(3);
    }

    private static Ladder createFiveHeightLadder() {
        List<Point> line1 = TestLadderFactory.createPoints(true, false, true, false);
        List<Point> line2 = TestLadderFactory.createPoints(false, true, false, false);
        List<Point> line3 = TestLadderFactory.createPoints(true, false, false, false);
        List<Point> line4 = TestLadderFactory.createPoints(false, true, false, false);
        List<Point> line5 = TestLadderFactory.createPoints(true, false, true, false);

        List<Line> lines = new ArrayList<>();
        lines.add(Line.of(() -> line1));
        lines.add(Line.of(() -> line2));
        lines.add(Line.of(() -> line3));
        lines.add(Line.of(() -> line4));
        lines.add(Line.of(() -> line5));

        return Ladder.of(lines);
    }
}
