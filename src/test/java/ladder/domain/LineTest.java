package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("참여자가 1명이라면 라인을 생성할 수 없다.")
    @Test
    void createLine_OnePlayer() {
        int playerCount = 1;
        Line line = new Line(playerCount);

        List<Boolean> actual = line.getLine();

        assertThat(actual.get(0)).isFalse();
    }

    @DisplayName("참여자가 2명이라면 라인을 생성할 수 있다.")
    @Test
    void createLine_TwoPlayer() {
        int playerCount = 2;
        Line line = new Line(playerCount);

        List<Boolean> actual = line.getLine();

        assertThat(actual.get(0)).isFalse();
        assertThat(actual.get(1)).isTrue();
    }

    @DisplayName("참여자가 3명이라면 연속된 라인이 생성되면 안된다.")
    @Test
    void createLine_ThreePlayer() {
        int playerCount = 3;
        Line line = new Line(playerCount);

        List<Boolean> actual = line.getLine();

        assertThat(actual.get(0)).isFalse();
        assertThat(actual.get(1)).isTrue();
        assertThat(actual.get(2)).isFalse();
    }

    @DisplayName("참여자가 4명이라면 연속된 라인이 생성되면 안된다.")
    @Test
    void createLine_FourPlayer() {
        int playerCount = 4;
        Line line = new Line(playerCount);

        List<Boolean> actual = line.getLine();

        assertThat(actual.get(0)).isFalse();
        assertThat(actual.get(1)).isTrue();
        assertThat(actual.get(2)).isFalse();
        assertThat(actual.get(3)).isTrue();
    }
}