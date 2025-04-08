package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createTest() {
        var players = List.of("baki", "pobi");
        var height = 5;
        new Ladder(players, height);
    }
}
