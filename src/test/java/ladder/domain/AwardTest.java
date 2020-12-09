package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AwardTest {

    private static final int AWARD_NAME_MAX_LENGTH = 5;

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

        }).withMessageContaining("실행결과 이름은 최대 "+AWARD_NAME_MAX_LENGTH+" 글자 입니다.");
    }
}
