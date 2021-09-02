package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ladder.model.LadderLineGeneratorTest.generatePointsMethod;
import static ladder.model.LadderLineGeneratorTest.ladderLinesGenerator;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("사다리 라인 테스트")
public class LadderLineTest {

    @DisplayName("사다리 라인의 포인트 목록이 비었으면 예외가 발생한다")
    @Test
    void emptyLadderLineExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(null))
                .withMessage("포인트 목록이 비었습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(new ArrayList<>()))
                .withMessage("포인트 목록이 비었습니다.");
    }

    @DisplayName("사다리 라인을 탔을 때 플레이어의 위치가 바뀌는 기능이 정상적으로 동작해야 한다.")
    @Test
    void findPlayerIndexAfterCrossingLineTest() throws InvocationTargetException, IllegalAccessException {
        // given

        LadderLine line = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(true, false, true)));

        // when, then
        assertSame(line.findPlayerIndexAfterCrossingLine(0), 1);
        assertSame(line.findPlayerIndexAfterCrossingLine(1), 0);
        assertSame(line.findPlayerIndexAfterCrossingLine(2), 3);
        assertSame(line.findPlayerIndexAfterCrossingLine(3), 2);
    }
}
