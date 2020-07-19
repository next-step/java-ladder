package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    public void 라인의_포인트는_사람수와_같다() {
        int personSize = 3;
        Line line = Line.of(personSize, LadderLevel.HIGH);

        assertThat(line.getPersonSize()).isEqualTo(personSize);
    }
}