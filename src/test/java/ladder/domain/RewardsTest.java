package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardsTest {

    @Test
    @DisplayName("잘못된 상금을 입력한 경우 예외발생 테스트")
    void reward_input_error_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rewards.builder()
                    .countOfPlayers(3)
                    .rewardInput(null)
                    .build();
            Rewards.builder()
                    .countOfPlayers(3)
                    .rewardInput("")
                    .build();
            Rewards.builder()
                    .countOfPlayers(3)
                    .rewardInput("10000,fail")
                    .build();
        });
    }

}
