package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Prizes;
import ladder.domain.Players;
import ladder.dto.GameInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private Players testPlayers;
    private Prizes testPrizes;
    private GameInfo gameInfo;

    @BeforeEach
    void setUp() {
        this.testPlayers = new Players(Arrays.asList("jojae", "j", "young"));
        this.testPrizes = new Prizes(Arrays.asList("꽝", "3000", "청소"));
        this.gameInfo = new GameInfo(testPlayers, testPrizes);
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void createGameTest() {
        assertThatCode(
                () -> new LadderGame(this.gameInfo, 5)
        ).doesNotThrowAnyException();
    }
}
