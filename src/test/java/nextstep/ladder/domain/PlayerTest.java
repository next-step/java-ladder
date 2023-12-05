package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {
    @Test
    void 참가자명_excpetion() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("abcdescd"));
    }
}