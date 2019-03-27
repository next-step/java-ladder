package domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LaddersTest {

    @Test
    public void test_지정한_높이만큼_사다리_생성() {
        int height = 5;

        Ladders ladders = Ladders.generate(height, 4);
        assertThat(ladders.height())
                .isEqualTo(height);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_변경불가() {
        Ladders ladders = Ladders.generate(5, 4);
        ladders.getLadders().remove(0);
    }
}
