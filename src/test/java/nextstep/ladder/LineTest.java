package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.SizeOfPerson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineTest {
    @Test
    @DisplayName("Line의 size()는 참가인원보다 1 적어야 한다.")
    void lineSizeTest() {
        int numberOfParticipantsValue = 4;
        SizeOfPerson sizeOfPerson = SizeOfPerson.valueOf(numberOfParticipantsValue);
        Line line = Line.from(sizeOfPerson);
        assertThat(line.size()).isEqualTo(numberOfParticipantsValue - 1);
    }

    @Test
    @DisplayName("Line의 points값은 연속된 true가 나오면 안된다.")
    void lineValueTestSuccessCase() {
        SizeOfPerson sizeOfPerson = SizeOfPerson.valueOf(10_000);
        assertThatCode(() -> Line.from(sizeOfPerson))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Line의 points값중에 연속된 true가 존재하면 throw Exception")
    void lineValueTestFailureCase() {
        SizeOfPerson sizeOfPerson = SizeOfPerson.valueOf(3);
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> Line.of(sizeOfPerson, num -> Arrays.asList(true, true, true)))
                .withMessage(Line.POINTS_INVALID_VALUE_ERR_MSG);
    }
}
