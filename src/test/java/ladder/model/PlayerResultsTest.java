package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("플레이어 사다리 결과 컬렉션 테스트")
public class PlayerResultsTest {

    @DisplayName("플레이어의 사다리 결과 찾는 기능이 정상 동작해야 한다.")
    @Test
    void findLadderResultTest() {
        // given
        PlayerResult firstPlayerResult = new PlayerResult(new Player("aiden") , new LadderResult("1000"));
        PlayerResult secondPlayerResult = new PlayerResult(new Player("pobi") , new LadderResult("2000"));
        PlayerResult thirdPlayerResult = new PlayerResult(new Player("crong") , new LadderResult("3000"));
        PlayerResults playerResults = new PlayerResults(Arrays.asList(firstPlayerResult, secondPlayerResult, thirdPlayerResult));

        // when, then
        assertSame(playerResults.findLadderResult("aiden"), "1000");
        assertSame(playerResults.findLadderResult("pobi"), "2000");
        assertSame(playerResults.findLadderResult("crong"), "3000");
    }
}
