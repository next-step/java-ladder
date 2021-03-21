package ladder;

import ladder.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    @DisplayName("prize 생성 테스트")
    void create_with_new() {
        String prizeName = "100";
        Prize prize = new Prize(prizeName);

        assertThat(prize).isEqualTo(new Prize(prizeName));
    }
}
