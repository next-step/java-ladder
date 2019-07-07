package ladderGame.domain;

import ladderGame.dto.GameInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameInformationTest {

    private GameInformation gameInformation;

    @BeforeEach
    void setUp() {
        Players players = Players.of(Arrays.asList("hello", "world", "nice"));
        LadderResults ladderResults = LadderResults.of(Arrays.asList("1000", "2000", "3000", "꽝"));
        gameInformation = GameInformation.of(players, ladderResults);
    }

    @Test
    @DisplayName("사용자 이름 찾기")
    void getNamePosition() {
        assertThat(gameInformation.getPlayerNameByPosition(new Position(1))).isEqualTo("world");
    }

    @Test
    @DisplayName("사다리 결과 값 찾기")
    void getResultByPosition() {
        assertThat(gameInformation.getResultByPosition(new Position(1))).isEqualTo("2000");
    }

    @Test
    @DisplayName("참가자 수")
    void getNumberOfPlayer() {
        assertThat(gameInformation.getNumberOfPlayer()).isEqualTo(3);
    }
}