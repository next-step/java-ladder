package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadder() {
        Players players = new Players(Arrays.asList("jojo", "zozo", "kiki"));
//        Ladder ladder = new Ladder(players, 5);
    }
}
