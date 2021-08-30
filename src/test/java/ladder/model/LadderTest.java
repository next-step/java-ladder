package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.*;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("사다리 테스트")
public class LadderTest {

    @DisplayName("사다리의 높이가 1 미만이면 예외가 발생한다.")
    @Test
    void ladderHeightLessThanMinExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(5, 0))
                .withMessage("사다리 높이는 최소 1 이어야 합니다.");
    }

    @DisplayName("빈 가로 구간이 존재하면 예외가 발생한다.")
    @Test
    void emptyVerticalIntervalExceptionTest() {
        // given
        LadderLine firstLine = new LadderLine(Arrays.asList(TRUE, FALSE));
        LadderLine secondLine = new LadderLine(Arrays.asList(FALSE, FALSE));

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(Arrays.asList(firstLine, secondLine)))
                .withMessage("빈 가로 구간이 존재하면 안됩니다.");
    }

    @DisplayName("플레이어 수를 구하는 기능이 정상적으로 동작해야 한다.")
    @Test
    void playerCountTest() {
        // given
        LadderLine firstLine = new LadderLine(Arrays.asList(TRUE, FALSE));
        LadderLine secondLine = new LadderLine(Arrays.asList(FALSE, TRUE));
        Ladder ladder = new Ladder(Arrays.asList(firstLine, secondLine));

        // when, then
        assertSame(ladder.playerCount(), 3);
    }

    @DisplayName("사다리를 타서 플레이어의 결과 위치를 찾아내는 기능이 정상적으로 동작해야 한다.")
    @Test
    void findLadderResultIndexOfPlayerTest() {
        // given
        LadderLine firstLine = new LadderLine(Arrays.asList(TRUE, FALSE));
        LadderLine secondLine = new LadderLine(Arrays.asList(FALSE, TRUE));
        LadderLine thirdLine = new LadderLine(Arrays.asList(TRUE, FALSE));
        Ladder ladder = new Ladder(Arrays.asList(firstLine, secondLine, thirdLine));

        // when, then
        assertSame(ladder.findResultIndex(0), 2);
        assertSame(ladder.findResultIndex(1), 1);
        assertSame(ladder.findResultIndex(2), 0);
    }
}
