package nextstep.game.util;

import game.util.RandomNumberGenerator;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @Order(1)
    public void 랜덤_숫자_생성_0_or_1() {
        assertThat(RandomNumberGenerator.randomNumber(2)).isBetween(0, 1);
    }

}
