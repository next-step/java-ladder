package step3.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Line(5)).isInstanceOf(Line.class);
    }

    @DisplayName("이동")
    @Test
    void move() {
        assertThat(new Line(5).move(4)).isInstanceOf(Integer.class);
    }

}
