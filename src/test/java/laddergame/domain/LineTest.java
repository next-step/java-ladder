package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void create() {
        // given
        int countOfPeople = 5;

        // when
        Line line = new Line(countOfPeople);

        // then
        assertThat(line.size()).isEqualTo(countOfPeople-1);
        assertThat(line.getPoints().get(0)).isInstanceOf(Boolean.class);
    }
}