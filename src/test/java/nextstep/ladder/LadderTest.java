package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        int height = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(4, height);
    }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
}

    @Test
    @DisplayName("사다리의 Point(참여자 수 - 1)는 2명 이상이어야 한다.")
    void assertLadderWidth() {
        int participantCount = 1;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(participantCount, 5);
        }).withMessage(Line.POINT_COUNT_ERROR);
    }
}
