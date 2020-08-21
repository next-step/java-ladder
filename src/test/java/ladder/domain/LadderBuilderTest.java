package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderBuilderTest {

    @DisplayName("여러번 등록할수 없음")
    @Test
    void test() {
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LadderBuilder().participantsLine("a,b,c").participantsLine("aa"))
            .withMessage(LadderBuilder.ERROR_MSG_PARTICIPANTS_LINE);

        assertThatIllegalArgumentException()
            .isThrownBy(()->new LadderBuilder().movableLine(5).movableLine(222))
            .withMessage(LadderBuilder.ERROR_MSG_MOVABLE_LINE);


        assertThatIllegalArgumentException()
            .isThrownBy(()->new LadderBuilder().ladderResultLine("abc").ladderResultLine("a,b,c"))
            .withMessage(LadderBuilder.ERROR_MSG_LADDER_RESULT_LINE);
    }

    @DisplayName("참가인원수를 먼저 설정하지 않으면 에러 발생")
    @Test
    void movableLinesTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LadderBuilder().movableLine(5))
            .withMessage(LadderBuilder.ERROR_MSG_MOVABLE_LINE);
    }


    @DisplayName("참가인원수, 사다리 높를 먼저 설정하지 않으면 에러 발생")
    @Test
    void ladderResultTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LadderBuilder().participantsLine("a,b").ladderResultLine("a"))
            .withMessage(LadderBuilder.ERROR_MSG_LADDER_RESULT_LINE);

        assertThatIllegalArgumentException()
            .isThrownBy(()->new LadderBuilder().ladderResultLine("a"))
            .withMessage(LadderBuilder.ERROR_MSG_LADDER_RESULT_LINE);
    }
}