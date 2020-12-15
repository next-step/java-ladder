package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("pass 생성")
    public void next_stay() {
        Point second = Point.createFirstFrom(false).createNextFrom(false);
        assertThat(second.nextIndex()).isEqualTo(1);
    }

    @Test
    @DisplayName("좌측 이동 테스트")
    public void next_left() {
        Point second = Point.createFirstFrom(true).createNextFrom(false);
        assertThat(second.nextIndex()).isEqualTo(0);
    }

    @Test
    @DisplayName("우측 이동 테스트")
    public void next_right() {
        Point second = Point.createFirstFrom(false).createNextFrom(true);
        assertThat(second.nextIndex()).isEqualTo(2);
    }

    @Test
    @DisplayName("불가능한 상태에 대해 방어 테스트")
    public void next() {
        Point second = Point.createFirstFrom(true).createNextFrom(true);
        // true, false 순서로 생성된다.
        assertThat(second.nextIndex()).isEqualTo(0);
    }
}
