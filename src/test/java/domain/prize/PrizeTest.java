package domain.prize;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void test_생성() {
        new Prize("꽝");
    }

    @Test
    public void test_이름_출력() {
        String name = "꽝";
        Prize prize = new Prize(name);

        assertThat(prize.beautify())
                .isEqualTo(name);
        assertThat(prize.beautify("prefix : "))
                .isEqualTo("prefix : " + name);
    }

    @Test
    public void test_동일성() {
        String name = "5000";
        Prize player = new Prize(name);

        assertThat(player)
                .isEqualTo(new Prize(name))
                .hasSameHashCodeAs(new Prize(name));
    }
}
