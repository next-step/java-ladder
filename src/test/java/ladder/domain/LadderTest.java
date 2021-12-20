package ladder.domain;

import ladder.fixture.TestLadderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Boolean> line1 = Arrays.asList(true, false, true, false);
        List<Boolean> line2 = Arrays.asList(false, true, false, false);
        List<Boolean> line3 = Arrays.asList(true, false, false, false);
        List<Boolean> line4 = Arrays.asList(false, true, false, false);
        List<Boolean> line5 = Arrays.asList(true, false, true, false);

        List<Line> lines = new ArrayList<>();
        lines.add(Line.of(() -> line1));
        lines.add(Line.of(() -> line2));
        lines.add(Line.of(() -> line3));
        lines.add(Line.of(() -> line4));
        lines.add(Line.of(() -> line5));

        return Ladder.of(lines);
    }
}
