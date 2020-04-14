package ladder.prize.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {

    @DisplayName("결과값으로 Prize 일급컬렉션을 생성할 수 있다.")
    @Test
    public void newPrizesTest() {
        Prizes prizes = Prizes.of(asList("1등", "2등"));

        assertThat(prizes).hasFieldOrPropertyWithValue(
                Prizes.class.getDeclaredFields()[0].getName(),
                asList(Prize.of("1등"), Prize.of("2등")));
    }

}
