package ladder.domain.ladder;

import ladder.domain.data.PlayerData;
import ladder.domain.line.Height;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @DisplayName("플레이어 null 입력 예외 발생")
    @Test
    void createPlayerNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.create(null, Height.valueOf(5)));
    }

    @DisplayName("높이 null 입력 예외 발생")
    @Test
    void createHeightNull() {
        Players players = Players.create(PlayerData.make(5));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.create(players, null));
    }
}
