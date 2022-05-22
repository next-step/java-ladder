package nextstep.ladder.model;

import nextstep.ladder.exception.LadderLengthException;
import nextstep.ladder.model.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    @DisplayName("사다리 최소 길이 예외 처리")
    void minimum() {
        assertThatThrownBy(() -> Line.create(1)).isExactlyInstanceOf(LadderLengthException.class);
    }
}
