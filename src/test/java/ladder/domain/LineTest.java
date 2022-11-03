package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인의 포인트 수는 사람의 수와 같다.")
    void line_size() {
        // given
        int countOfPerson = 5;

        // when
        Line line = new Line(countOfPerson);

        // then
        assertThat(line.getPoints()).hasSize(countOfPerson);
    }

}
