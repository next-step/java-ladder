package JavaLadder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizesTest {
    @Test
    public void splitPrizeTest() {
        String input = "test1,test2,test3";
        Prizes prizes = new Prizes(input);
        assertThat(prizes.getPrize(0)).isEqualTo("test1");
    }
}
