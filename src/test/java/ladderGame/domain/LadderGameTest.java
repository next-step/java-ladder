package ladderGame.domain;

import ladderGame.dto.GameInformation;
import ladderGame.dto.LadderGameResult;
import ladderGame.dto.ResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private final static String FIRST_PLAYER_NAME = "hello";
    private final static String THIRD_RESULT_CONTENT = "3000";
    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        Players players = Players.of(Arrays.asList(FIRST_PLAYER_NAME, "world", "nice"));
        LadderResults ladderResults = LadderResults.of(Arrays.asList("1000", "2000", THIRD_RESULT_CONTENT));
        GameInformation gameInformation = GameInformation.of(players, ladderResults);
        Ladder ladder = Ladder.ofDirections(Arrays.asList(
                DirectionLayer.ofGenerator(3, count -> Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT)),
                DirectionLayer.ofGenerator(3, count -> Arrays.asList(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT)),
                DirectionLayer.ofGenerator(3, count -> Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT))
        ));
        ladderGame = LadderGame.of(ladder, gameInformation);
    }

    @Test
    @DisplayName("사다리타기 결과")
    void result() {
        LadderGameResult results = ladderGame.run();
        List<ResultDto> ladderResult = results.getLadderResult();
        assertThat(ladderResult.get(0).getName()).isEqualTo(FIRST_PLAYER_NAME);
        assertThat(ladderResult.get(0).getContent()).isEqualTo(THIRD_RESULT_CONTENT);
    }
}