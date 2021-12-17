package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("사다리의 point가 생성되면 true 아니면 false.")
    @Test
    void point_생성() {
        // when
        Point point = new Point(() -> true, false);
        boolean actuality = point.isIndex();

        // then
        assertThat(actuality).isTrue();
    }

    @DisplayName("")
    @Test
    void d() {
        // given

        // when

        // then
    }
}