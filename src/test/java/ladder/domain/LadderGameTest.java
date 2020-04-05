package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @DisplayName("사다리 게임 생성 후 유저, 사다리 체크")
    @Test
    void resultCheckByCreation() {
        LadderGame ladderGame = LadderGame.of("yohan,hymin,heji", 10);
        LadderGameResult result = ladderGame.getResult();

        assertThat(result.getUsers()).isEqualTo(Users.of("yohan,hymin,heji"));
        assertThat(result.getLadder().getLadderLines().size()).isEqualTo(10);
        result.getLadder().getLadderLines().forEach(links -> assertThat(links.getLinkCount()).isEqualTo(3));
    }
}
