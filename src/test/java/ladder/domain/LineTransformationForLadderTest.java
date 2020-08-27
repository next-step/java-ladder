package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTransformationForLadderTest {

    @DisplayName("여러번 등록할수 없음")
    @Test
    void test() {
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LineTransformationForLadder().participantsLine("a,b,c").participantsLine("aa"))
            .withMessage(LineTransformationForLadder.ERROR_MSG_PARTICIPANTS_LINE);

        assertThatIllegalArgumentException()
            .isThrownBy(()->new LineTransformationForLadder().movableLine(5).movableLine(222))
            .withMessage(LineTransformationForLadder.ERROR_MSG_MOVABLE_LINE);


        assertThatIllegalArgumentException()
            .isThrownBy(()->new LineTransformationForLadder().ladderResultLine("abc").ladderResultLine("a,b,c"))
            .withMessage(LineTransformationForLadder.ERROR_MSG_LADDER_RESULT_LINE);
    }

    @DisplayName("참가인원수를 먼저 설정하지 않으면 에러 발생")
    @Test
    void movableLinesTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LineTransformationForLadder().movableLine(5))
            .withMessage(LineTransformationForLadder.ERROR_MSG_MOVABLE_LINE);
    }


    @DisplayName("참가인원수, 사다리 높를 먼저 설정하지 않으면 에러 발생")
    @Test
    void ladderResultTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LineTransformationForLadder().participantsLine("a,b").ladderResultLine("a"))
            .withMessage(LineTransformationForLadder.ERROR_MSG_LADDER_RESULT_LINE);

        assertThatIllegalArgumentException()
            .isThrownBy(()->new LineTransformationForLadder().ladderResultLine("a"))
            .withMessage(LineTransformationForLadder.ERROR_MSG_LADDER_RESULT_LINE);
    }
}