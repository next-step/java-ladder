package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    public void 생성() {
        Game game = new Game(Arrays.asList("aa", "bb", "cc", "dd"), 5);
        assertThat(game).isEqualTo(new Game(Arrays.asList("aa", "bb", "cc", "dd"), 5));
    }

}