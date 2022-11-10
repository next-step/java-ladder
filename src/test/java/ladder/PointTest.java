package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 생성() {
        assertThat(new Point(true)).isEqualTo(new Point(true));
    }

    @Test
    public void 연결_여부() {
        assertThat(new Point(true).connected()).isTrue();
    }
}
