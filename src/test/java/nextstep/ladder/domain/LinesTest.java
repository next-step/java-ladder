package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LinesTest {

    @DisplayName("lines가 사다리 높이만큼 생성되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:4:4", "4:4:4", "6:5:5"}, delimiter = ':')
    void line_size(int width, int ladderHeight, int linesSize) {
        LineGenerator lineGenerator = LineGenerator.getInstance();
        List<Line> listLine = lineGenerator.generateLines(ladderHeight, width);

        Lines lines = Lines.of(listLine);
        List<Line> generatedLine = lines.toList();

        assertThat(generatedLine.size()).isEqualTo(linesSize);
    }
}