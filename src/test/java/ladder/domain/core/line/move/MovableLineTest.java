package ladder.domain.core.line.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.ui.result.DisplayResult;

import static ladder.domain.core.line.move.MovableLine.ERROR_MSG_OUT_OF_RANGE_HEIGHT;
import static ladder.domain.core.line.move.MovablePoints.ERROR_MSG_OUT_OF_RANGE_INDEX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MovableLineTest {
    @DisplayName("높이 기준으로 사다리가 이동 가능한 사다리가 정상적으로 생성되는 지 확인")
    @Test
    void collectMovablePointsDisplayResultList() {
        DisplayResult displayResult = MovableLine.of(3, 1).toDisplayResult();
        assertThat(displayResult.toDisplay()).isEqualTo(    "     |     \n" +
                                                            "     |     \n" +
                                                            "     |     ");
    }

    @DisplayName("지정된 start index를 기준으로 최종이동된 마지막 index를 가져옴")
    @Test
    void indexOfTest() {
        MovableLine movableLine = MovableLine.of(3, 1);
        assertThat(movableLine.indexOf(0)).isEqualTo(0);
    }

    @DisplayName("잘못 start index이면 에러 발생 확인")
    @Test
    void indexOfExceptionTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> MovableLine.of(0, 1))
            .withMessage(ERROR_MSG_OUT_OF_RANGE_HEIGHT);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> MovableLine.of(3, 1).indexOf(10))
            .withMessage(ERROR_MSG_OUT_OF_RANGE_INDEX);
    }
}