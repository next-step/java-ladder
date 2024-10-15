package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인은 플레이어 수 - 1의 가로 길이를 가진다")
    @Test
    void lineSize(){
        int playerCount = 3;

        Line line = new Line(playerCount);

        assertThat(line.size()).isEqualTo(2);
    }
}