package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

class LadderGameTest {

    @DisplayName("참여할 사람 이름과 사다리 높이를 받아 사다리 게임을 생성한다")
    @Test
    void create() {
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        int height = 5;

        assertThatCode(() -> LadderGame.of(playerNames, height)).doesNotThrowAnyException();
    }
}
