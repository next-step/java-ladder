package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderResultsTest {
    LadderGame ladderGame;
    Ladder ladder;
    Players players;

    @BeforeEach
    void setUp() {
        players = new Players(Arrays.asList("AAA", "BBB"));
        ladder = new Ladder(new LadderInfo(2, 4), () -> true);
        ladderGame = LadderGame.of(Arrays.asList("AAA", "BBB"), ladder);
    }

    @DisplayName("AAA -> 에이, BBB -> 비 : ladderGame 에서 사다리를 타면 결과값을 반환한다.")
    @Test
    void LadderGame_start() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put(players.indexOf(0), "에이");
        resultMap.put(players.indexOf(1), "비");

        assertThat(ladderGame.climbLadder(new Results(Arrays.asList("에이", "비"))))
                .isEqualTo(new LadderResults(resultMap));
    }

    @DisplayName("player 수와 결과 리스트 수가 맞지 않으면 fail")
    @Test
    void create() {
        assertThrows(IllegalArgumentException.class,
                () -> ladderGame.climbLadder(new Results(Arrays.asList("꽝", "일", "이", "삼")))
        );
    }
}