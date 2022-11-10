package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 생성() {
        assertThat(new Line(2)).isEqualTo(new Line(2));
    }
}
