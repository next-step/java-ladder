package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointDirectionTest {

    @Test
    void PointDirectionFirst_False_CreateTest() {
        PointDirection direction = PointDirection.first(false);
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    void PointDirectionFirst_True_CreateTest() {
        PointDirection direction = PointDirection.first(true);
        assertThat(direction.isRight()).isTrue();
    }

    @Test
    void PointDirectionNext_False_CreateTest() {
        PointDirection direction = PointDirection.first(true);
        PointDirection next = direction.next(false);
        assertThat(next.isRight()).isFalse();
    }

    @Test
    void PointDirectionNext_True_CreateTest() {
        PointDirection direction = PointDirection.first(false);
        PointDirection next = direction.next(true);
        assertThat(next.isRight()).isTrue();
    }

    @Test
    void PointDirection_FirstFalse_NextFalse_CreateTest() {
        PointDirection direction = PointDirection.first(false);
        PointDirection next = direction.next(false);
        assertThat(next.isRight()).isFalse();
    }


    @Test
    void PointDirection_Last_CreateTest() {
        PointDirection direction = PointDirection.first(false);
        PointDirection next = direction.next(false);
        PointDirection last = next.last();
        assertThat(last.isRight()).isFalse();
    }
}