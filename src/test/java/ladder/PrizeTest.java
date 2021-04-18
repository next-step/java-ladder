package ladder;

import ladder.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @DisplayName("실행결과 클래스를 생성한다.")
    @Test
    void create() {
        Prize prize = Prize.of(Arrays.asList("꽝"));
        assertThat(prize).isEqualTo(Prize.of(Arrays.asList("꽝")));
    }

    @DisplayName("입력된 인덱스에 맞는 당첨 결과를 반환한다.")
    @Test
    void prizeOf() {
        Prize prize = Prize.of(Arrays.asList("꽝", "5000", "10000", "2000"));
        assertThat(prize.prizeOfIndex(0)).isEqualTo("꽝");
        assertThat(prize.prizeOfIndex(3)).isEqualTo("2000");
    }
}
