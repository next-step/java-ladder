package ladder.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {
    private Prizes prizes;
    private List<Prize> prizesList;

    @BeforeEach
    void setUp() {
        prizes = new Prizes(Arrays.asList("당첨", "결과", "표", "만들", "기"));
        prizesList = prizes.values();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:당첨", "1:결과", "2:표", "3:만들", "4:기"}, delimiter = ':')
    void getPrize(int index, String prize) {
        assertThat(prizesList.get(index).toString()).isEqualTo(prize);
    }

    @Test
    void getSize() {
        assertThat(prizes.size()).isEqualTo(5);
    }
}