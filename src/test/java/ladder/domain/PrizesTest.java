package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizesTest {

    @ParameterizedTest
    @CsvSource({"0, 꽝", "1, 5000", "2, 꽝", "3, 5000"})
    void 입력된_각_사다리의_결과들로_Results를_생성한다(int index, String prize) {
        String inputPrizes = "꽝,5000,꽝,5000";
        Prizes prizes = Prizes.from(inputPrizes);

        assertThat(prizes.getPrizes().get(index).getPrize()).isEqualTo(prize);
    }
}
