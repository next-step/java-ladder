package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Line;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 라인 하나 생성 테스트")
    void oneLineTest() {
        Line line = new Line(3);
        System.out.println(line);
        assertThat(line.row().size()).isEqualTo(3);
    }
}
