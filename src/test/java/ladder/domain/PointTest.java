package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    @DisplayName("Point 객체 생성")
    void create() {
        // given
        Point point = new Point(false, false);

        // when
        assertThat(point).isNotNull();
    }

    @Test
    @DisplayName("Point 객체 생성 - 왼쪽만 true")
    void left() {
        // given
        Point point = new Point(true, false);

        // when
        assertThat(point.isLeft()).isTrue();
        assertThat(point.isRight()).isFalse();
    }

    @Test
    @DisplayName("Point 객체 생성 - 오른쪽만 true")
    void right() {
        // given
        Point point = new Point(false, true);

        // when
        assertThat(point.isLeft()).isFalse();
        assertThat(point.isRight()).isTrue();
    }

    @Test
    @DisplayName("Point 객체 생성(예외) - 양쪽 모두 true")
    void leftRightException() {
        // when
        assertThatThrownBy(() -> {
            new Point(true, true);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인은 한 좌표에 하나만 가질 수 있습니다.");
    }
}