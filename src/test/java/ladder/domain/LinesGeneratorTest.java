package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesGeneratorTest {

    @DisplayName("높이 만큼 라인을 생성할 수 있다")
    @Test
    public void firstLadderLineGenerateTest() {
        List<Line> first = LinesGenerator.first(3);

        assertThat(first).hasSize(3);
    }

    @DisplayName("마지막 라인 생성기는 모든 라인 값을 false 로 갖는다")
    @Test
    public void lastLineGeneratedTest() {
        List<Line> lastLines = LinesGenerator.last(4);

        List<Line> expected = stubLines(false, false, false, false);

        assertThat(lastLines).isEqualTo(expected);
    }

    @DisplayName("첫번째도 마지막도 아닌 일반 라인은 이전라인을 참고해서 생성한다, 이전 의 해당 높이가 true 이면 false")
    @Test
    public void test() {
        List<Line> beforeLines = stubLines(true, true, true, true);
        List<Line> normalLine = LinesGenerator.normal(4, new LadderLine(beforeLines));

        List<Line> expected = stubLines(false, false, false, false);

        assertThat(normalLine).isEqualTo(expected);
    }

    private List<Line> stubLines(boolean... booleans) {
        List<Line> stubLines = new ArrayList<>();
        for (int i = 0; i < booleans.length; i++) {
            stubLines.add(new Line(i, booleans[i]));
        }
        return stubLines;
    }

}
