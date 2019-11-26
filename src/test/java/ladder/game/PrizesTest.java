package ladder.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {
    Prizes prizes;

    @BeforeEach
    void setUp() {
        prizes = new Prizes(Arrays.asList("당첨", "결과", "표", "만들", "기"));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:당첨", "1:결과", "2:표", "3:만들", "4:기"}, delimiter = ':')
    void getPrize(int index, String prize) {
        assertThat(prizes.getPrize(index)).isEqualTo(prize);
    }

    @Test
    void getSize() {
        assertThat(prizes.getSize()).isEqualTo(5);
    }
}