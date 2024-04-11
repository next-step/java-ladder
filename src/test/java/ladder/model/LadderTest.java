package ladder.model;

import ladder.model.utils.ConnectLine;
import ladder.model.utils.ConnectLineRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 0이하인 경우 에러")
    void check_ladder_height() {
        ConnectLine connectLine = new ConnectLineRandom();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(0, 5, connectLine);
        });
    }

    @Test
    @DisplayName("사람수가 0이하인 경우 에러")
    void check_name_number() {
        ConnectLine connectLine = new ConnectLineRandom();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(3, 0, connectLine);
        });
    }
}
