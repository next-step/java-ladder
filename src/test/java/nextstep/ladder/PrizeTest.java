package nextstep.ladder;

import nextstep.ladder.model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    @DisplayName("Prize class 생성")
    void createPrizeTest() {
        //given
        String prizeValue = "꽝";

        //when
        Prize prize = new Prize(prizeValue);

        //then
        Assertions.assertThat(prize.getValue()).isEqualTo(prizeValue);
    }
}
