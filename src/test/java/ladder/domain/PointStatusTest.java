package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PointStatusTest {

    @Test
    @DisplayName("허용되지 않은 레이아웃 에러처리")
    void testInvalidLayout() {
        PointStatus first = PointStatus.first(true);

        assertThatThrownBy(
                () -> first.next(true)
        ).isInstanceOf(InvalidLayoutException.class);
    }

    @Test
    @DisplayName("우측으로 이동")
    void testGoRight() {
        PointStatus first = PointStatus.first(false);
        PointStatus sample = first.next(true);

        assertThat(sample.nextIndex(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("좌측으로 이동")
    void testGoLeft() {
        PointStatus first = PointStatus.first(true);
        PointStatus sample = first.next(false);

        assertThat(sample.nextIndex(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("아래로 이동")
    void testGoPass() {
        PointStatus first = PointStatus.first(false);
        PointStatus sample = first.next(false);

        assertThat(sample.nextIndex(1)).isEqualTo(1);
    }
}
