package nextstep.ladder.domain.alternative;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class NextStepLadderLineTest {
    @Test
    void create() {
        new NextStepLadderLine(2, 1);
    }

    @Test
    void illegal_size_or_height() {
        Arrays.<ThrowingCallable>asList(() -> new NextStepLadderLine(1, 1),
                                        () -> new NextStepLadderLine(2, 0))
                .forEach(runnable -> assertThatThrownBy(runnable)
                        .isInstanceOf(IllegalStateException.class));

    }
}
