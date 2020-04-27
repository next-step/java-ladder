package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("주어진 점들로 라인 생성 확인")
    public void generateLintTest() {
        List<Boolean> expect = Arrays.asList(true, false, true);
        Line line = Line.getNewInstance(expect);

        assertThat(line.getPoints()).isEqualTo(expect);
    }

}
