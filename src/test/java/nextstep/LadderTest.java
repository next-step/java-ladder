package nextstep;

import nextstep.exception.DuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    @DisplayName("같은 값의 좌표 불가")
    void isDuplicate() {
        Ladder ladder = new Ladder(0);
        assertThatThrownBy(() -> {
            ladder.add("bong", 1);
            ladder.add("big", 1);
        }).isInstanceOf(DuplicateException.class);
    }

    @Test
    @DisplayName("게임?")
    void game() throws DuplicateException {
        Ladder ladder = new Ladder(2);
        ladder.add("bong", 1);
        ladder.add("big", 2);
        ladder.add("cptbong", 3);
        ladder.move();
        assertThat(ladder.heights()).contains(2);
    }
}
