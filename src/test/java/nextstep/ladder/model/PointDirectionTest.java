package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointDirectionTest {

    @Test
    void initTest() {
        PointDirection right = PointDirection.first(TRUE);
        PointDirection none = PointDirection.first(FALSE);
        assertThat(right).isEqualTo(PointDirection.RIGHT);
        assertThat(none).isEqualTo(PointDirection.NONE);
    }

    @Test
    void nowRightDirectionTest() {
        assertThat(PointDirection.RIGHT.next()).isEqualTo(PointDirection.LEFT);
    }

    @Test
    void nowLeftDirectionTest() {
        for (int i = 0; i < 100; i++) {
            assertThat(PointDirection.LEFT.next()).isNotEqualTo(PointDirection.LEFT);
        }
    }

    @Test
    void nowNoneDirectionTest() {
        for (int i = 0; i < 100; i++) {
            assertThat(PointDirection.NONE.next()).isNotEqualTo(PointDirection.LEFT);
        }
    }

    @Test
    void lastNowRightDirectionTest() {
        assertThat(PointDirection.RIGHT.last()).isEqualTo(PointDirection.LEFT);
    }

    @Test
    void lastNowLeftDirectionTest() {
        assertThat(PointDirection.LEFT.last()).isEqualTo(PointDirection.NONE);
    }

    @Test
    void lastNowNoneDirectionTest() {
        assertThat(PointDirection.NONE.last()).isEqualTo(PointDirection.NONE);
    }

    @Test
    void moveTest() {
        // given
        int currentPosition = 1;
        // when
        assertAll(
                () -> assertThat(PointDirection.NONE.move(currentPosition)).isEqualTo(currentPosition),
                () -> assertThat(PointDirection.LEFT.move(currentPosition)).isEqualTo(currentPosition - 1),
                () -> assertThat(PointDirection.RIGHT.move(currentPosition)).isEqualTo(currentPosition + 1)
        );
    }
}
