package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineConnectionRandomStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인수가 width 만큼 생성되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "4:4", "5:5"}, delimiter = ':')
    void line_size(int width, int lineSize) {
        Line line = Line.of(width, new LineConnectionRandomStrategy());
        List<Boolean> lines = line.stream()
                .collect(Collectors.toList());

        assertThat(lines.size()).isEqualTo(lineSize);
    }
}
