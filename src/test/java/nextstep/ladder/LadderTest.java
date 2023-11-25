package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Ladder 는 아무런 라인이 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Line> blankLists) {
        assertThatThrownBy(
                () -> new Ladder(blankLists)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
