package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    @DisplayName("잘 막히나 테스트")
    void isBlock() {
        Games games = new Games(3, 1);
        assertThat(games.isLeftBlock()).isFalse();
        games.toLeftFocus();
        games.toLeftFocus();
        games.toLeftFocus();
        games.toLeftFocus();
        games.toLeftFocus();
        assertThat(games.isLeftBlock()).isTrue();
    }

    @Test
    @DisplayName("이동해도 되는지 테스트")
    void isTrue() {
        Points points = new Points(Arrays.asList(false, true, false));
        Games games = new Games(points.size(), 1);
        games.toLeftFocus();
        games.toLeftFocus();
        games.toLeftFocus();
        games.toLeftFocus();
        games.toLeftFocus();
        assertThat(games.isLeftTrue(points)).isFalse();

        assertThat(games.focus).isEqualTo(0);

        games.toRightFocus();
        assertThat(games.focus).isEqualTo(1);
        assertThat(games.isRightTrue(points)).isTrue();

        games.toRightFocus();
        assertThat(games.focus).isEqualTo(3);

        games.toRightFocus();
        games.toRightFocus();
        games.toRightFocus();
        games.toRightFocus();
        assertThat(games.isRightTrue(points)).isFalse();
    }
}
