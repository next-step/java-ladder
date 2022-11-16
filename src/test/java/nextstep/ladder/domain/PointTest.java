package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("true값을 가질땐, 노드로 판정 되야 한다")
    @Test
    void isNode_true() {
        assertThat(Point.valueOf(true).isNode()).isTrue();
    }

    @DisplayName("false값을 가질땐, 노드로 판정 되어서는 안된다")
    @Test
    void isNode_false() {
        assertThat(Point.valueOf(false).isNode()).isFalse();
    }

    @DisplayName("같은 값을 가지는 개체은 동등해야 한다")
    @Test
    void equals() {
        assertAll(
            () -> assertThat(Point.valueOf(true)).isEqualTo(Point.valueOf(true)),
            () -> assertThat(Point.valueOf(false)).isEqualTo(Point.valueOf(false)),
            () -> assertThat(Point.valueOf(true)).isNotEqualTo(Point.valueOf(false)),
            () -> assertThat(Point.valueOf(false)).isNotEqualTo(Point.valueOf(true))
        );
    }

}