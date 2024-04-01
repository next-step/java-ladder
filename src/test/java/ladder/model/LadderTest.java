package ladder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 0이하인 경우 에러")
    void check_ladder_height() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(0, 5);
        });
    }

    @Test
    @DisplayName("사람수가 0이하인 경우 에러")
    void check_name_number() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(3, 0);
        });
    }
}
