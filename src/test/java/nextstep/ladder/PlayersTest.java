package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayersTest {

    @Test
    @DisplayName("플레이어목록 생성 테스트")
    void createTest() {
        var players = new Players(List.of("baki", "pobi"));
    }
}
