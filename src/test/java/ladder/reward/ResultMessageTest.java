package ladder.reward;

import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultMessageTest {
    @Test
    @DisplayName("[fail] \"\" 나 null 이 들어오면 exception 이 발생한다.")
    void test() {
        //Given
        String emptyString = "";
        String nullString = null;

        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Reward.from(emptyString))
          .withMessage(ErrorMessages.CANT_INPUT_EMPTY_STRING.message());
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Reward.from(nullString))
          .withMessage(ErrorMessages.CANT_INPUT_EMPTY_STRING.message());
    }
}
