package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineConnectionRandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {

    private LineGenerator lineGenerator;

    @BeforeEach
    void init() {
        lineGenerator = LineGenerator.getInstance();
    }

    @DisplayName("라인생성기로 Line 생성")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "4:4", "5:5"}, delimiter = ':')
    void generateLine(int width, int expected) {
        List<Boolean> list = lineGenerator.generateLine(width, new LineConnectionRandomStrategy());
        assertThat(list.size()).isEqualTo(expected);
    }

    @DisplayName("라인생성기로 Lines 생성")
    @ParameterizedTest
    @CsvSource(value = {"3:3:3", "4:3:4", "5:6:5"}, delimiter = ':')
    void generateLines(int height, int width, int expected) {
        List<Line> lines = lineGenerator.generateLines(height, width);
        assertThat(lines.size()).isEqualTo(expected);
    }
}
