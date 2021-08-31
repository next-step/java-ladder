package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사다리 포인트 테스트")
public class LadderPointTest {

    @DisplayName("포인트 인덱스가 0 미만이면 예외가 발생한다.")
    @Test
    void minLadderPointIndexExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderPoint(-1, new LadderDirection(false, false)))
                .withMessage("포인트 인덱스는 0이상 이어야 합니다.");
    }

    @DisplayName("사다리에서 움직일 때 값이 true인 사다리 방향에 따라 포인트 인덱스가 증가하거나 감소하거나 그대로다.")
    @CsvSource(value = {"false:false:1", "false:true:2", "true:false:0"}, delimiter = ':')
    @ParameterizedTest
    void moveLadderPointTest(boolean left, boolean right, int movedIndex) {
        // given, when
        LadderDirection direction = new LadderDirection(left, right);
        LadderPoint ladderPoint = new LadderPoint(1, direction);

        // then
        assertEquals(ladderPoint.move(), movedIndex);
    }
}
