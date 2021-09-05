package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("플레이어 사다리 결과 컬렉션 테스트")
public class PlayerResultsTest {
    private static final PlayerResult FIRST_PLAYER_RESULT = new PlayerResult(new Player("aiden"), new LadderResult("1000"));
    private static final PlayerResult SECOND_PLAYER_RESULT = new PlayerResult(new Player("pobi"), new LadderResult("2000"));
    private static final PlayerResult THIRD_PLAYER_RESULT = new PlayerResult(new Player("crong"), new LadderResult("3000"));
    private static final PlayerResults PLAYER_RESULTS =
            new PlayerResults(Arrays.asList(FIRST_PLAYER_RESULT, SECOND_PLAYER_RESULT, THIRD_PLAYER_RESULT));

    @DisplayName("존재하지 안흔 플레이어의 사다리 결과를 찾으려하면 예외가 발생한다.")
    @Test
    void findLadderResultOfNotExistingPlayerExceptionTest() {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PLAYER_RESULTS.findLadderResult("kevin"))
                .withMessage("존재하지 않는 플레이어 이름입니다.");
    }

    @DisplayName("플레이어의 사다리 결과 찾는 기능이 정상 동작해야 한다.")
    @Test
    void findLadderResultTest() {
        // when, then
        assertSame(PLAYER_RESULTS.findLadderResult("aiden"), "1000");
        assertSame(PLAYER_RESULTS.findLadderResult("pobi"), "2000");
        assertSame(PLAYER_RESULTS.findLadderResult("crong"), "3000");
    }
}
