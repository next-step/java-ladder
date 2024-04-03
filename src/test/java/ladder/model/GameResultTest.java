package ladder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    @Test
    @DisplayName("입력 받은 게임 결과 개수가 사람수와 다르면 에러")
    void check_ladder_height() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int numberOfPlayer = 5;
            new GameResult("꽝, 5000, 꽝, 4000", numberOfPlayer);
        });
    }

}
