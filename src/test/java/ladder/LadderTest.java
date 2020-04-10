package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리 내려가기 테스트")
    public void downTest() {
        Line line0 = Line.ofLength(3);
        Point p00 = line0.at(0);
        Point p01 = line0.at(1);
        p00.connect(p01);

        Line line1 = Line.ofLength(3);
        Point p11 = line1.at(1);
        Point p12 = line1.at(2);
        p11.connect(p12);

        Line line2 = Line.ofLength(3);
        Point p20 = line2.at(0);
        Point p21 = line2.at(1);
        p20.connect(p21);

        Ladder ladder = Ladder.of(Arrays.asList(line0, line1, line2));
        assertThat(ladder.down(0)).isEqualTo(2);
    }
}
