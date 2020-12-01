package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.mock.MockAlwaysTruePointsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderLineTest {
    @Test
    @DisplayName("Line의 size()는 참가인원과 같아야 한다.")
    void lineSizeTest() {
        int sizeOfPerson = 4;
        LadderLine line = LadderLine.init(sizeOfPerson);
        assertThat(line.size()).isEqualTo(sizeOfPerson);
    }

    @Test
    @DisplayName("Line의 points값은 연속된 true가 나오면 안된다.")
    void lineValueTestSuccessCase() {
        int sizeOfPerson = 10_000;
        assertThatCode(() -> LadderLine.init(sizeOfPerson))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Line의 points값중에 연속된 true가 존재하면 throw Exception")
    void lineValueTestFailureCase() {
        int sizeOfPerson = 3;
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> LadderLine.init(sizeOfPerson, new MockAlwaysTruePointsGenerator()))
                .withMessage(Direction.INVALID_STATE_ERR_MSG);
    }
}
