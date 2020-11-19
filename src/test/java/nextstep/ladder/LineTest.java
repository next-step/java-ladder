package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LineTest {
    @Test
    @DisplayName("Line의 사이즈는 참가인원(CountOfPerson)보다 1 적어야 한다.")
    void lineSizeTest() {
        CountOfPerson countOfPerson = CountOfPerson.of(4);
        Line line = new Line(countOfPerson);
        assertThat(line.size()).isEqualTo(countOfPerson.value - 1);
    }

    @Test
    @DisplayName("Line값은 연속된 true가 나오면 안된다.")
    void lineValueTest() {
        CountOfPerson countOfPerson = CountOfPerson.of(10_000);
        assertThatCode(() -> new Line(countOfPerson))
                .doesNotThrowAnyException();
    }
}
