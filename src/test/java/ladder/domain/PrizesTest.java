package ladder.domain;

import ladder.exception.PrizeCountNotMatchException;
import ladder.exception.PrizeNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PrizesTest {

    @DisplayName("입력받은 결과들을 갖고 있다.")
    @Test
    void prizes() {
        int playerCount = 4;
        String input = "꽝,5000,꽝,3000";

        List<Prize> actual = new Prizes(input, playerCount).getPrizes();

        assertThat(actual).hasSize(4);
    }

    @DisplayName("입력받은 결과갯수와 참여자 수가 맞지 않으면 예외를 발생한다.")
    @Test
    void checkAvailablePrizes() {
        int playerCount = 3;
        String input = "꽝,5000,꽝,3000";

        assertThatExceptionOfType(PrizeCountNotMatchException.class).isThrownBy(
                () -> new Prizes(input, playerCount).getPrizes()
        );
    }

    @DisplayName("입력받은 상품순서대로 상품 위치가 정해진다.")
    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:5000", "2:꽝", "3:3000"}, delimiter = ':')
    void orderPrizePosition(int position, String expect) {
        int playerCount = 4;
        String input = "꽝,5000,꽝,3000";

        Prizes prizes = new Prizes(input, playerCount);

        Prize prize = prizes.find(new Position(position));

        assertThat(prize.getPrize()).isEqualTo(expect);
    }

    @DisplayName("상품을 못찾을 경우 예외를 발생한다.")
    @Test
    void notFoundException() {
        int playerCount = 4;
        String input = "꽝,5000,꽝,3000";
        int position = 5;

        Prizes prizes = new Prizes(input, playerCount);

        assertThatExceptionOfType(PrizeNotFoundException.class).isThrownBy(
                () -> prizes.find(new Position(position))
        );
    }
}