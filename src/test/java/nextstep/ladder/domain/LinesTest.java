package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    @DisplayName("Lines 생성 테스트")
    void createLines() {
        final List<Line> lineList = List.of(LineTest.LINE_TEST1, LineTest.LINE_TEST2);
        Lines lines = new Lines(lineList);
        assertThat(lines.getLines()).containsAll(lineList);
    }
}