package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {

    @DisplayName("입력받은 결과들을 갖고 있다.")
    @Test
    void prizes() {
        String input = "꽝,5000,꽝,3000";

        List<Prize> actual = new Prizes(input).getPrizes();

        assertThat(actual).hasSize(4);
    }
}