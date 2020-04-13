package ladder.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineGeneratorTest {

    @DisplayName("높이 만큼 라인을 생성할 수 있다")
    @Test
    public void firstLadderLineGenerateTest() {
        List<LadderLine> generatedLadderLine = LadderLineGenerator.generate(3, 3);
        LadderLine ladderLine = generatedLadderLine.get(0);
        List<Line> lines = ladderLine.getLines();

        assertThat(lines).hasSize(3);
    }

    @DisplayName("마지막 라인 생성기는 모든 라인 값을 false 로 갖는다")
    @Test
    public void lastLineGeneratedTest() {
        List<LadderLine> generatedLadderLine = LadderLineGenerator.generate(3, 3);
        int lastIndex = generatedLadderLine.size() - 1;
        LadderLine ladderLine = generatedLadderLine.get(lastIndex);
        List<Line> lastLines = ladderLine.getLines();

        List<Line> expected = stubLines(false, false, false);

        assertThat(lastLines).isEqualTo(expected);
    }

    private List<Line> stubLines(boolean... booleans) {
        List<Line> stubLines = new ArrayList<>();
        for (int i = 0; i < booleans.length; i++) {
            stubLines.add(Line.of(i, booleans[i]));
        }
        return stubLines;
    }

}
