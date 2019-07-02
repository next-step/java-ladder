package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    private Prize prize;

    @BeforeEach
    void setUp() {
        prize = new Prize("꽝");
    }

    @DisplayName("입력한 경품에 LPAD(6자리 공백)")
    @Test
    void getNameFormattedTest() {
        assertThat(prize.getNameFormatted()).isEqualTo("     꽝");
    }

    @DisplayName("단순 경품명 출력")
    @Test
    void getNameTest() {
        assertThat(prize.getPrize()).isEqualTo("꽝");
    }
}
