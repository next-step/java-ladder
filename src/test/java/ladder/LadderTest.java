package ladder;

import ladder.domain.GameAttendees;
import ladder.domain.Ladder;
import ladder.domain.LadderCompensation;
import ladder.domain.LadderResult;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    /*
        created ladder
        a b c d
        |-| |-|
        |-| |-|
        e f g h
     */
    @Test
    void IsPlayResultEqualWithExpected() {
        GameAttendees gameAttendees = new GameAttendees("a,b,c,d");
        LadderCompensation compensations = new LadderCompensation("e,f,g,h");
        Ladder ladder = new Ladder(gameAttendees, 2, new ForceLineStrategy());

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("a", "e");
        expectedMap.put("b", "f");
        expectedMap.put("c", "g");
        expectedMap.put("d", "h");

        String actualResult = ladder.playLadderGame(gameAttendees, compensations).getLadderResultBy("all");
        String expectedResult = new LadderResult(expectedMap).getLadderResultBy("all");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
