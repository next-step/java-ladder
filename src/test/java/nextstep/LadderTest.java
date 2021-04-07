package nextstep;

import nextstep.exception.DuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    @DisplayName("같은 값의 좌표 불가")
    void isDuplicate() {
        Ladder ladder = new Ladder();
        assertThatThrownBy(() -> {
            ladder.add(new Coordinate(1, 1));
            ladder.add(new Coordinate(1, 1));
        }).isInstanceOf(DuplicateException.class);
    }
}
