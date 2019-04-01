package domain.prize;

import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizesTest {

    @Test
    public void test_크기() {
        Prizes prizes = Prizes.generate("꽝, 3000, 꽝, 5000");
        assertThat(prizes.size())
                .isEqualTo(4);
    }

    @Test
    public void test_동일성() {
        Prizes prizes = Prizes.generate("꽝, 3000, 꽝, 5000");

        assertThat(prizes)
                .isEqualTo(Prizes.generate("꽝, 3000, 꽝, 5000"))
                .hasSameHashCodeAs(Prizes.generate("꽝, 3000, 꽝, 5000"));
    }

    @Test
    public void test_필터링() {
        Prizes prizes = Prizes.generate("꽝, 3000, 꽝, 5000");

        assertThat(prizes.filter(Arrays.asList(3, 1)))
                .isEqualTo(Prizes.generate("5000, 3000"));
    }

    @Test
    public void test_경품목록_출력() {
        Prizes prizes = Prizes.generate("꽝, 3000, 꽝, 5000");
        assertThat(prizes.beautify())
                .isEqualTo("    꽝  3000     꽝  5000");
    }
}