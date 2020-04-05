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

        assertThat(actual.get(1)).isTrue();
    }
}