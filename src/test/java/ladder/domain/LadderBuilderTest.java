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
            .isThrownBy(()->new LadderBuilder().movableLines(5).movableLines(222))
            .withMessage(LadderBuilder.ERROR_MSG_MOVABLE_LINE);
    }

    @DisplayName("참가인원수를 먼저 설정하지 않으면 에러 발생")
    @Test
    void movableLinesTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LadderBuilder().movableLines(5))
            .withMessage(LadderBuilder.ERROR_MSG_MOVABLE_LINE);
    }
}