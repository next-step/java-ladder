package ladder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultListTest {
    @Test
    @DisplayName("입력 받은 게임 결과 개수가 사람수와 다르면 에러")
    void check_number_of_result() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int numberOfPlayer = 5;
            new GameResultList("꽝, 5000, 꽝, 4000", numberOfPlayer);
        });
    }

    @Test
    @DisplayName("입력 받은 게임 결과의 글자수가 5자 이상이면 에러")
    void check_length_of_result() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int numberOfPlayer = 4;
            new GameResultList("꽝, 500000, 꽝, 4000", numberOfPlayer);
        });
    }

}
