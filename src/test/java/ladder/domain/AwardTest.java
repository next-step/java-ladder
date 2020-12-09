package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AwardTest {

    @DisplayName("Award 생성 테스트")
    @Test
    void awardConstructorTest(){

        String awardName = "꽝";

        assertThat(Award.from(awardName).getAwardName()).isEqualTo(awardName);
    }


    @DisplayName("Award 이름 유효성 테스트")
    @Test
    void illegalAwardNameExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            String awardName = "꽝 다음기회에";

            Award.from(awardName);

        }).withMessageContaining(LadderGameErrorMessage.ILLEGAL_MAX_AWARD_NAME.getErrorMessage());
    }
}
