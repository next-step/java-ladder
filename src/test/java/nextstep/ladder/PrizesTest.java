package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Prizes;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizesTest {

    @Test
    @DisplayName("보상 결과 윺효성 테스트")
    void InvalidPrizesTest(){
        assertThatThrownBy(() -> Prizes.of("꽝,5000,꽝,3000",3))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
