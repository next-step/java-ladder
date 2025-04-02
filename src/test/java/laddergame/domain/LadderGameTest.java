package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class LadderGameTest {
    @DisplayName("사다리 게임 생성 테스트")
    @Test
    void create_ladder() {
        assertThatNoException().isThrownBy(() -> new LadderGame("pobi,crong", 3));
    }
}
