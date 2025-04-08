package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("사다리 라인 생성 테스트")
    void createTest() {
        var playerCount = 5;
        var line = new Line(playerCount);
    }
}
