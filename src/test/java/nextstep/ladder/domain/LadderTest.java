package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("사다리의 높이가 1 미만이라면 예외를 발생시킨다")
    @Test
    void createLadderHeightExceptionTest() {
        int height = 0;
        int countOfPerson = 5;
        assertThatThrownBy(() -> new Ladder(height, countOfPerson)).isInstanceOf(IllegalArgumentException.class);
    }
}
