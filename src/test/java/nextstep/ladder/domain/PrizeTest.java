package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    @DisplayName("결과 내용을 입력받아 결과 객체를 생성한다.")
    public void create() throws Exception {
        Prize prize = new Prize("꽝");
        assertThat(prize).isEqualTo(new Prize("꽝"));
    }
}
