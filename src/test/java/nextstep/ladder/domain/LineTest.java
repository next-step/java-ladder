package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void create_line_false() {
        int countOfPerson = 4;
        LineStrategy falseLine = () -> false;

        Line line = new Line(countOfPerson, falseLine);
        assertThat(line.getPoints()).hasSize(3);
        assertThat(line.getPoints()).containsExactly(false, false, false);
    }

    @Test
    void create_line_true() {
        int countOfPerson = 4;
        LineStrategy trueLine = () -> true;

        Line line = new Line(countOfPerson, trueLine);
        assertThat(line.getPoints()).hasSize(3);
        assertThat(line.getPoints()).containsExactly(true, false, true);
    }
}