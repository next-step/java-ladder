package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    @Test
    @DisplayName("사다리 타기 결과를 얻는다.")
    void createPrize() {
        Prizes prizes = new Prizes(List.of("1", "꽝"));
        assertThat(prizes.get(0)).isEqualTo("1");
        assertThat(prizes.get(1)).isEqualTo("꽝");
    }

}
