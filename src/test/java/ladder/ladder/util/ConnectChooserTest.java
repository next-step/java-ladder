package ladder.ladder.util;

import ladder.domain.ladder.util.ConnectChooser;
import ladder.domain.ladder.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectChooserTest {
    @Test
    @DisplayName("[fail] 난이도를 1~10까지 입력 가능. 입력 가능수를 초과하면 Exception 발생")
    void test() {
        //Given
        int lessMinNumber = 0;
        int biggerMaxNumber = 11;
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> ConnectChooser.shouldConnect(lessMinNumber))
          .withMessage(ErrorMessages.OVER_RANGE.message());
    }
}
