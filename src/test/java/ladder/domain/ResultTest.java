package ladder.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class ResultTest {
    @Test
    @DisplayName("결과를 생성한다")
    void of(){
        assertThatCode(() -> Result.newInstance("꽝")).doesNotThrowAnyException();
    }

}
