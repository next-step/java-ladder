package nextstep.ladder.domain;

import static nextstep.ladder.domain.LadderBarStatus.BAR;
import static nextstep.ladder.domain.LadderBarStatus.EMPTY;
import static nextstep.ladder.domain.LadderBarStatus.OUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {

    @DisplayName("next() : 우측에 BAR가 있으면 한 칸 이동한다")
    @Test
    void next_rightBAR() {
        Location location = new Location(2, 2, 0, 0);

        Location next = location.next(new LadderPoint(-1, -1, OUT), new LadderPoint(0, 0, BAR));
        assertThat(next.getX()).isEqualTo(1);
        assertThat(next.getY()).isEqualTo(1);
    }

    @DisplayName("next() : 좌측에 BAR가 있으면 한 칸 이동한다")
    @Test
    void next_leftBAR() {
        Location location = new Location(2, 2, 1, 0);

        Location next = location.next(new LadderPoint(0, 0, BAR), new LadderPoint(0, 1, EMPTY));
        assertThat(next.getX()).isEqualTo(0);
        assertThat(next.getY()).isEqualTo(1);
    }
}