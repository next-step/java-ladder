package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @DisplayName("입력된 높이 만큼의 하나의 완성된 사다리 라인을 만들 수 있다.")
    @Test
    public void newLadderLineTest() {
        List<Line> lines = Arrays.asList(new Line(0, true), new Line(1, true));
        LadderLine ladderLine = new LadderLine(lines);
        LadderLine anotherLadderLine = new LadderLine(lines);

        assertThat(ladderLine).isEqualTo(anotherLadderLine);
    }

    @Test
    public void ladderLineGetTest() {
        Line firstStubLine = new Line(0, true);
        Line secondStubLine = new Line(1, true);
        List<Line> lines = Arrays.asList(firstStubLine, secondStubLine);

        LadderLine ladderLine = new LadderLine(lines);
        List<Line> existingLines = ladderLine.getLines();

        assertThat(existingLines).isEqualTo(lines);
    }

}
