package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("zero는 개수가 존재하지 않음")
    @Test
    void isEmptyZero() {
        assertThat(Point.zero().isEmpty()).isTrue();
    }

    @DisplayName("five는 개수가 존재함")
    @Test
    void isEmptyFive() {
        assertThat(Point.five().isEmpty()).isFalse();
    }

    @DisplayName("zero는 0개를 반환")
    @Test
    void getCountZero() {
        assertThat(Point.zero().getCount()).isEqualTo(0);
    }

    @DisplayName("five는 5개를 반환")
    @Test
    void getCountFive() {
        assertThat(Point.five().getCount()).isEqualTo(5);
    }
}
