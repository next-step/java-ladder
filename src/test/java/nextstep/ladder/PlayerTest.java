package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("플레이어 생성 테스트")
    void createTest() {
        var player = new Player("baki");
    }
}
