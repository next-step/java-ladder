package ladder;

import ladder.domain.LadderGame;
import ladder.domain.PlayResults;
import ladder.domain.Players;
import ladder.dto.GameInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private Players testPlayers;
    private PlayResults testPlayResults;
    private GameInfo gameInfo;

    @BeforeEach
    void setUp() {
        this.testPlayers = new Players(Arrays.asList("jojae", "j", "young"));
        this.testPlayResults = new PlayResults(Arrays.asList("꽝", "3000", "청소"));
        this.gameInfo = new GameInfo(testPlayers, testPlayResults);
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void createGameTest() {
        new LadderGame(this.gameInfo, 5);
    }
}
