package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private static final Line lineTest = Line.getNewInstance(Arrays.asList(true, false, true, false, false));

    @Test
    @DisplayName("주어진 점들로 라인 생성 확인")
    public void generateLintTest() {
        List<Boolean> expect = Arrays.asList(true, false, true);
        Line line = Line.getNewInstance(expect);

        assertThat(line.getPoints()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:3", "4:4"}, delimiter = ':')
    @DisplayName("주어진 위치의 이동 결과값 반환")
    public void movePositionSuccess(int position, int result) {
        assertThat(lineTest.movePosition(position)).isEqualTo(result);
    }

}
