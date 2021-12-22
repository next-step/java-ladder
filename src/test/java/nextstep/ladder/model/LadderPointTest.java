package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderPointTest {

    @Test
    void firstWithTrueTest() {
        // when & then
        assertThat(LadderPoint.first(TRUE).getDirection()).isEqualTo(PointDirection.RIGHT);
    }

    @Test
    void firstWithFalseTest() {
        // when & then
        assertThat(LadderPoint.first(FALSE).getDirection()).isEqualTo(PointDirection.NONE);
    }

    @Test
    void nextFromFirstTest() {
        // when & then
        assertThat(LadderPoint.first(TRUE).next().getDirection()).isEqualTo(PointDirection.LEFT);
    }

    @Test
    void nextFromNonFirstTest() {
        // when & then
        assertThat(LadderPoint.first(FALSE).next().getDirection()).isIn(PointDirection.RIGHT, PointDirection.NONE);
    }

    @Test
    void lastFromFirstTest() {
        // when & then
        assertThat(LadderPoint.first(TRUE).last().getDirection()).isEqualTo(PointDirection.LEFT);
    }

    @Test
    void lastFromNonFirstTest() {
        // when & then
        assertThat(LadderPoint.first(FALSE).last().getDirection()).isEqualTo(PointDirection.NONE);
    }
}
