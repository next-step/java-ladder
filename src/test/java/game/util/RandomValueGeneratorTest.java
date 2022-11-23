package game.util;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomValueGeneratorTest {

    @Test
    @Order(1)
    public void 랜덤_숫자_생성_0_or_1() {
        assertThat(RandomValueGenerator.randomNumber(2)).isBetween(0, 1);
    }

}
