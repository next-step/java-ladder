package ladder.domain;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @DisplayName("Line이 가진 Point의 수는 참가자 수 - 1이다.")
    @Test
    void linePointCOunt() {
        assertThat(new Line(3).getPoints().size()).isEqualTo(2);
    }

}
