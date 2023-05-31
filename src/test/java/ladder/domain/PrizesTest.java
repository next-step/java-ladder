package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizesTest {
    @Test
    @DisplayName("주어진 인덱스의 요소를 반환한다.")
    public void get() {
        Prizes prizes = new Prizes(List.of("꽝","꽝","1000"));
        assertThat(prizes.get(0).getName()).isEqualTo("꽝");
    }
}
