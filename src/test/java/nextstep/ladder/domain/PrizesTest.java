package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:5000", "2:꽝", "3:3000"}, delimiter = ':')
    @DisplayName("성공 - 인덱스에 해당하는 결과를 구한다.")
    void success_find_prize(int index, String prize) {
        List<String> stringPrizes = List.of("꽝", "5000", "꽝", "3000");

        Prizes prizes = new Prizes(stringPrizes);

        assertThat(prizes.prize(index)).isEqualTo(new Prize(prize));
    }

}
