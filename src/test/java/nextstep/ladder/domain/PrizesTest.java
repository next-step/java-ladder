package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {

    @Test
    @DisplayName("성공 - 상품결과가 생성된다.")
    void success_generate_prizes() {
        List<String> stringPrizes = List.of("꽝", "5000", "꽝", "3000");

        Prizes prizes = new Prizes(stringPrizes);

        assertThat(prizes.prizes()).hasSize(4);
    }

}
