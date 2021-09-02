package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static ladder.model.LadderLineGeneratorTest.generatePointsMethod;
import static ladder.model.LadderLineGeneratorTest.ladderLinesGenerator;
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
    void emptyVerticalIntervalExceptionTest() throws InvocationTargetException, IllegalAccessException {
        // given
        LadderLine firstLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(true, false)));
        LadderLine secondLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(false, false)));

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(Arrays.asList(firstLine, secondLine)))
                .withMessage("사다리 게임 시스템의 내부 문제가 발생했습니다. 관리자에게 문의하세요.");
    }

    @DisplayName("플레이어 수를 구하는 기능이 정상적으로 동작해야 한다.")
    @Test
    void playerCountTest() throws InvocationTargetException, IllegalAccessException {
        // given
        LadderLine firstLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(true, false)));
        LadderLine secondLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(false, true)));
        Ladder ladder = new Ladder(Arrays.asList(firstLine, secondLine));

        // when, then
        assertSame(ladder.playerCount(), 3);
    }

    @DisplayName("사다리를 타서 플레이어의 결과 위치를 찾아내는 기능이 정상적으로 동작해야 한다.")
    @Test
    void findLadderResultIndexOfPlayerTest() throws InvocationTargetException, IllegalAccessException {
        // given
        LadderLine firstLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(true, false)));
        LadderLine secondLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(false, true)));
        LadderLine thirdLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(true, false)));
        Ladder ladder = new Ladder(Arrays.asList(firstLine, secondLine, thirdLine));

        // when, then
        assertSame(ladder.findResultIndex(0), 2);
        assertSame(ladder.findResultIndex(1), 1);
        assertSame(ladder.findResultIndex(2), 0);
    }
}
