package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {
    @Test
    @DisplayName("사다리가 생성이 되는지 테스트한다.")
    void LottoNumbersGeneratorTest() {

        Line line = new Line(Arrays.asList(false, true, false));
        Line line1 = new Line(Arrays.asList(true, false, false));
        Line line2 = new Line(Arrays.asList(true, false, true));
        Line line3 = new Line(Arrays.asList(false, true, false));
        Line line4 = new Line(Arrays.asList(false, false, true));

        List<Line> lines = Arrays.asList(line, line1, line2, line3, line4);
        LadderGenerator ladderGenerator = (height, width) -> lines;

        assertThat(ladderGenerator.generate(5, 3)).isEqualTo(lines);
    }
}