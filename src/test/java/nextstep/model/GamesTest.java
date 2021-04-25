package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GamesTest {
    @Test
    @DisplayName("이동테스트")
    void move() {
        Games games = new Games(3, 1);
        assertThat(games.isLeftBlock()).isFalse();
        games.toRightFocus();
        assertThat(games.focus).isEqualTo(2);
        games.toRightFocus();
        assertThat(games.focus).isEqualTo(3);
        games.toRightFocus();
        assertThat(games.focus).isEqualTo(3);
        games.toRightFocus();
        games.toRightFocus();
        games.toRightFocus();
        games.toRightFocus();
        assertThat(games.focus).isEqualTo(3);
    }
}
