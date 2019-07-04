package ladder.ladder;

import ladder.domain.gamer.message.ErrorMessages;
import ladder.domain.ladder.Ladder;
import ladder.domain.reward.Rewards;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LadderTest {
    @Test
    @DisplayName("[success] 파라미터로 입력된 숫자만큼의 Line 를 생성한다.")
    void makeRowsTest() {
        //Given
        int rowsSize = 5;
        int cellSize = 5;
        
        //When
        Ladder ladder = Ladder.from(rowsSize, cellSize);
        
        //Then
        Assertions.assertThat(ladder.getSize()).isEqualTo(rowsSize);
    }
    
    @Test
    @DisplayName("[fail] 입력된 라인번호로 보상정보를 가져온다. 입력된 라인번호가 총 라인수를 넘어가면 exception 발생")
    void test() {
        //Given
        Ladder ladder = Ladder.from(3,3);
        int lineNumber = 4;
        
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> ladder.getRewardNumber(lineNumber))
            .withMessage(ErrorMessages.OVER_INPUT_LADDER_SIZE.message());
    }
}
