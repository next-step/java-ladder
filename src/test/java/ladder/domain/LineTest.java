package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("참여자가 1명이라면 라인을 생성할 수 없다.")
    @Test
    void createLine_OnePlayer() {
        int playerCount = 1;
        Line line = new Line(playerCount);

        assertThat(line.getLine()).isEmpty();
    }
}