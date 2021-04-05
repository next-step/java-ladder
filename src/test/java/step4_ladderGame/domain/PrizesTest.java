package step4_ladderGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @DisplayName("플레이어 수와 상품의 수는 같아야 한다.")
    @Test
    void testCase1() {
        Assertions.assertThatThrownBy(() -> {
            Prizes.of(new String[]{"LG", "SKT", "KT"}, 4);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
