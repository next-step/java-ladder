package ladder;

import ladder.domain.LadderGame;
import ladder.domain.PlayResults;
import ladder.domain.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private Players testPlayers;
    private PlayResults testPlayResults;

    @BeforeEach
    void setUp() {
        this.testPlayers = new Players(Arrays.asList("jojae", "j", "young"));
        this.testPlayResults = new PlayResults(Arrays.asList("꽝", "3000", "청소"));
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void createGameTest() {
        new LadderGame(this.testPlayers, this.testPlayResults, 5);
    }

    @Test
    @DisplayName("게임 생성 실패(플레이어 이름길이) 테스트")
    void validatePlayersTest() {
        assertThatThrownBy(
                () -> new LadderGame(new Players(Arrays.asList("jojaeasdfasdf", "", "young")), this.testPlayResults, 5)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 생성 실패(결과내용 길이) 테스트")
    void validatePlayResultsTest() {
        assertThatThrownBy(
                () -> new LadderGame(new Players(Arrays.asList("", "꽝", "팔굽혀펴기40회")), this.testPlayResults, 5)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
