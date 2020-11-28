package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.exception.LadderGameException;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 객체생성_실패_테스트() {
        int given = -1;
        assertThrows(LadderGameException.class, () -> new Position(given));
    }

    @Test
    void decreasePosition_테스트() {
        int given = 1;
        assertThat(new Position(given).decreasePosition()).isEqualTo(new Position(given - 1));
    }

    @Test
    void increasePosition_테스트() {
        int given = 1;
        assertThat(new Position(given).increasePosition()).isEqualTo(new Position(given + 1));
    }

    @Test
    void keepPosition_테스트() {
        int given = 1;
        assertThat(new Position(given).keepPosition()).isEqualTo(new Position(given));
    }
}