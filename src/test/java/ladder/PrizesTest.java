package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizesTest {
    @Test
    void create() {
        Prizes result = Prizes.of("꽝,3000,꽝,5000");
        assertThat(result.getPrizes()).isEqualTo(Arrays.asList(Prize.of("꽝"),Prize.of("3000"),Prize.of("꽝"),Prize.of("5000")));
    }
}
