package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {
    @Test
    void 너비_생성() {
        assertThat(new Players("a", "b", "c", "d").count()).isEqualTo(4);
    }
}
