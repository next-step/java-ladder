package ladder;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import ladder.exception.InvalidRewordsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardsTest {

    @Test
    @DisplayName("리워드 생성.")
    void init_rewards() {
        assertDoesNotThrow(() -> new Rewards(List.of("꽝", "5000", "꽝", "3000"), 4));
    }

    @Test
    @DisplayName("리워드가 사람수에 맞지 않으면 예외 발생.")
    void fail_to_init_rewards_by_count_of_person_mismatch() {
        assertAll(
                () -> assertThatExceptionOfType(InvalidRewordsException.class)
                        .isThrownBy(() -> new Rewards(new ArrayList<>(), 3)),
                () -> assertThatExceptionOfType(InvalidRewordsException.class)
                        .isThrownBy(() -> new Rewards(null, 3))
        );
    }
}