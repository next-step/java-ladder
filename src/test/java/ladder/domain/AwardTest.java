package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AwardTest {

    @DisplayName("Award 생성 테스트")
    @Test
    void awardConstructorTest(){
        // given
        String awardName = "꽝";

        // when
        Award award = new Award(awardName);

        // then
        assertThat(award.getAwardName()).isEqualTo(awardName);
    }


    @DisplayName("Award 이름 유효성 테스트")
    @Test
    void illegalAwardNameExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            String awardName = "꽝 다음기회에";

            new Award(awardName);

        }).withMessageContaining(LadderGameErrorMessage.ILLEGAL_MAX_AWARD_NAME.getErrorMessage());
    }
}
