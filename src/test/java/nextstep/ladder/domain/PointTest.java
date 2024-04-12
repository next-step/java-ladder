package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("Point(점)은 boolean값을 갖는다")
    @Test
    void haveBoolean() {
        assertThat(new Point(true)).isEqualTo(new Point(true));
        assertThat(new Point(false)).isEqualTo(new Point(false));
    }

    @DisplayName("이전(i - 1) 점이 존재하는지 검증한다")
    @Test
    void hasPointAtPrevious() {
        assertThat(new Point(true).isExist()).isTrue();
        assertThat(new Point(false).isExist()).isFalse();
    }
}
