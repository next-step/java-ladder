package ladderGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameInfomationTest {

    private GameInfomation gameInfomation;

    @BeforeEach
    void setUp() {
        Players players = Players.of(Arrays.asList("hello", "world", "nice"));
        LadderResults ladderResults = LadderResults.of(Arrays.asList("1000", "2000", "3000", "꽝"));
        gameInfomation = GameInfomation.of(players, ladderResults);
    }

    @Test
    @DisplayName("사용자 이름 찾기")
    void getNamePosition() {
        assertThat(gameInfomation.getPlayerNameByPosition(new Position(1))).isEqualTo("world");
    }

    @Test
    @DisplayName("사다리 결과 값 찾기")
    void getResultByPosition() {
        assertThat(gameInfomation.getResultByPosition(new Position(1))).isEqualTo("2000");
    }

    @Test
    @DisplayName("참가자 수")
    void getNumberOfPlayer() {
        assertThat(gameInfomation.getNumberOfPlayer()).isEqualTo(3);
    }
}