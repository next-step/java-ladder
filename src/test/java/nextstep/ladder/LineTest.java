package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LineTest {
    @Test
    @DisplayName("Line의 사이즈는 참가인원보다 1 적어야 한다.")
    void lineSizeTest() {
        NumberOfParticipants numberOfParticipants = NumberOfParticipants.valueOf(4);
        Line line = new Line(numberOfParticipants);
        assertThat(line.size()).isEqualTo(numberOfParticipants.value - 1);
    }

    @Test
    @DisplayName("Line의 Points값은 연속된 true가 나오면 안된다.")
    void lineValueTest() {
        NumberOfParticipants numberOfParticipants = NumberOfParticipants.valueOf(10_000);
        assertThatCode(() -> new Line(numberOfParticipants))
                .doesNotThrowAnyException();
    }
}
