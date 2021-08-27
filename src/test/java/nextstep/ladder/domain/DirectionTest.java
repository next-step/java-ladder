package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("이동 없음")
    public void stay() {
        // given
        int position = 2;
        int expected = 2;

        // when
        int moved = Direction.NONE.move(position);

        // then
        assertThat(moved).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽 이동")
    public void moveLeft() {
        // given
        int position = 2;
        int expected = 1;

        // when
        int moved = Direction.LEFT.move(position);

        // then
        assertThat(moved).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽 이동")
    public void moveRight() {
        // given
        int position = 2;
        int expected = 3;

        // when
        int moved = Direction.RIGHT.move(position);

        // then
        assertThat(moved).isEqualTo(expected);
    }

    @ParameterizedTest(name = "decide 테스트 | {arguments}")
    @CsvSource(value = {"true|true|LEFT", "true|false|LEFT", "false|true|RIGHT", "false|false|NONE"}, delimiter = '|')
    public void decide(boolean prevInstall, boolean currentInstall, String directionName) {
        // given
        Direction expected = Direction.valueOf(directionName);

        // when
        Direction direction = Direction.decide(prevInstall, currentInstall);

        // then
        assertThat(direction).isEqualTo(expected);
    }

}