package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderResultsTest {
    LadderGame ladderGame;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new LadderInfo(2, 4), () -> true);
        ladderGame = new LadderGame(Arrays.asList("AAA", "BBB"), ladder);
    }

    @DisplayName("AAA -> 에이, BBB -> 비 : ladderGame 에서 사다리를 타면 결과값을 반환한다.")
    @Test
    void LadderGame_start() {
        assertThat(ladderGame.climbLadder(Arrays.asList("에이", "비")))
                .isEqualTo(new LadderResults(Arrays.asList("AAA", "BBB"), Arrays.asList("에이", "비")));
    }

    @DisplayName("player 수와 결과 리스트 수가 맞지 않으면 fail")
    @Test
    void create() {
        assertThrows(IllegalArgumentException.class,
                () -> new LadderResults(
                        Arrays.asList("AAA", "BBB"),
                        Arrays.asList("꽝", "1000", "2000"))
        );
    }
}