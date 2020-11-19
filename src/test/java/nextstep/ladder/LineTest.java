package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("Line의 사이즈는 참가인원보다 1 적어야 한다.")
    void lineCreateTest() {
        int countOfPerson = 4;
        Line line = new Line(countOfPerson);
        assertThat(line.size()).isEqualTo(countOfPerson - 1);
    }
}
