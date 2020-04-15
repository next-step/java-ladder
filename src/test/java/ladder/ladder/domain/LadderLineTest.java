package ladder.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @DisplayName("라인(가로줄)의 모음으로 사다리라인(세로줄)을 생성할 수 있다.")
    @Test
    public void ladderLineGetTest() {
        Line firstStubLine = Line.of(0, true);
        Line secondStubLine = Line.of(1, true);
        List<Line> lines = asList(firstStubLine, secondStubLine);

        LadderLine ladderLine = LadderLine.of(lines);
        List<Line> existingLines = ladderLine.getLines();

        assertThat(existingLines).isEqualTo(lines);
    }


}
