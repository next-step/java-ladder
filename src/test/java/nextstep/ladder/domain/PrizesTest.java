package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizesTest {
    @DisplayName("경품 리스트를 저장하고 조회할 수 있다.")
    @Test
    void createAndInquiry() {
        String first = "boram";
        String second = "rambo";
        Prizes prizes = new Prizes(Arrays.asList(first, second));
        assertThat(prizes.get(0).getName()).isEqualTo(first);
        assertThat(prizes.get(1).getName()).isEqualTo(second);
    }
}
