package ladder;

import static ladder.PlayersCount.MINIMUM_PLAYERS_COUNT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersCountTest {

    @Test
    @DisplayName("플레이어 수가 최소 인원 미만인 경우 예외를 던진다.")
    void PlayersCount_LessThanMinimum_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayersCount(MINIMUM_PLAYERS_COUNT - 1));
    }
}
