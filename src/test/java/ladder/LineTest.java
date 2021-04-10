package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LineTest {
    @DisplayName("참가자별로 사다리의 한 라인을 그린다.")
    @Test
    void makeLine() {
        Players players = Players.of(Arrays.asList("kong", "dal", "apple", "red", "blue"));
        Line ladderLine = Line.init(players);
        ladderLine.makeLine();
        System.out.println(ladderLine);
    }
}
