package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Line;

public class LineTest {

    @Test
    void 생성() {
        // given
        int countOfPerson = 5;
        Line line = new Line(countOfPerson);
        // when & then
        assertThat(line).isEqualTo(new Line(countOfPerson));
    }

    @Test
    void 참여자수_유효성() {
        // given
        int countOfPerson = 1;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Line(countOfPerson));

    }
}
