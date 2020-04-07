package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @DisplayName("사다리 게임 생성 후 유저, 사다리 체크")
    @Test
    void resultCheckByCreation() {
        LadderGame ladderGame = LadderGame.of("yohan,hymin,heji", 10);
        assertThat(ladderGame.getUsers()).containsExactly(User.of("yohan"), User.of("hymin"), User.of("heji"));
        assertThat(ladderGame.getLadder().size()).isEqualTo(10);
        ladderGame.getLadder().forEach(links -> assertThat(links.getLinkCount()).isEqualTo(3));

    }
}
