package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Boolean.*;
import static java.lang.Boolean.FALSE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @DisplayName("겹치는 라인이 존재하면 예외가 발생한다.")
    @Test
    void overlappingLineExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(Arrays.asList(FALSE, TRUE, TRUE, FALSE)))
                .withMessage("겹치는 라인이 존재하면 안됩니다.");
    }

    @DisplayName("포인트 개수가 1개 미만이면 예외가 발생한다.")
    @Test
    void pointCountLessThanMinExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.of(0))
                .withMessage("포인트 개수는 최소 1개 이어야 합니다.");
    }

    @DisplayName("선 있는 포인트 목록 인덱스가 비어있으먄 예외가 발생한다.")
    @Test
    void emptyTruePointIndicesExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.of(5, null))
                .withMessage("선 있는 포인트 인덱스 목록이 비었습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.of(5, new ArrayList<>()))
                .withMessage("선 있는 포인트 인덱스 목록이 비었습니다.");
    }

    @DisplayName("포인트 목록 개수는 생성시 주입받은 포인트 개수와 같아야 한다.")
    @Test
    void pointCountTest() {
        // given, when, then
        assertEquals(LadderLine.of(2).pointCount(), 2);
    }

    @DisplayName("사다리 라인을 탔을 때 플레이어의 위치가 바뀌는 기능이 정상적으로 동작해야 한다.")
    @Test
    void findPlayerIndexAfterCrossingLineTest() {
        // given
        LadderLine line = new LadderLine(Arrays.asList(TRUE, FALSE, TRUE));

        // when, then
        assertSame(line.findPlayerIndexAfterCrossingLine(0), 1);
        assertSame(line.findPlayerIndexAfterCrossingLine(1), 0);
        assertSame(line.findPlayerIndexAfterCrossingLine(2), 3);
        assertSame(line.findPlayerIndexAfterCrossingLine(3), 2);
    }
}
