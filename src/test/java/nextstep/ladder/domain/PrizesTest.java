package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PrizesTest {
    @Test
    @DisplayName("Prizes 생성")
    public void prizes() {
        assertThat(new Prizes(List.of("꽝", "5000", "꽝", "3000")).getPrizes()).containsExactly("꽝", "5000", "꽝", "3000");
    }

    @Test
    @DisplayName("n번째 prize를 얻는다")
    public void get() {
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"));
        assertAll(
                () -> assertThat(prizes.get(0)).isEqualTo("꽝"),
                () -> assertThat(prizes.get(1)).isEqualTo("5000"),
                () -> assertThat(prizes.get(2)).isEqualTo("꽝"),
                () -> assertThat(prizes.get(3)).isEqualTo("3000")
        );
    }
}
