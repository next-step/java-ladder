package ladder.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    void 생성검증() {
        Assertions.assertThat(new Line(4)).isInstanceOf(Line.class);
    }
}
