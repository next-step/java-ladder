package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("첫번째 포인트 생성 테스트")
    void firstTest() {
        assertThat(Point.first(new FixedGenerator(false))).isEqualTo(new Point(false));
        assertThat(Point.first(new FixedGenerator(true))).isEqualTo(new Point(true));
    }

    @Test
    @DisplayName("마지막 포인트 생성 테스트")
    void lastTest() {
        assertThat(Point.last()).isEqualTo(new Point(false));
        assertThat(Point.last()).isNotEqualTo(new Point(true));
    }

    @Test
    @DisplayName("포인트의 true, false 테스트")
    void hasLineTest(){
        assertThat(new Point(false).hasLine()).isFalse();
        assertThat(new Point(true).hasLine()).isTrue();
    }
}