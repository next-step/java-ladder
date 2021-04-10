package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Prize;

public class PrizeTest {

    @Test
    void 생성_테스트() {
        // given
        Prize prize = new Prize(0, "꽝");
        // when & then
        assertThat(prize).isEqualTo(new Prize(0, "꽝"));
    }

    @Test
    void 유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Prize(0, " "));
    }
}
