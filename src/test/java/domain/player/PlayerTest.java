package domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void test_생성() {
        new Player("honux");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_생성불가능_길이초과() {
        new Player("abcdef");
    }

    @Test
    public void test_이름_출력() {
        String name = "honux";
        Player player = new Player(name);

        assertThat(player)
                .hasToString(name);
    }

    @Test
    public void test_동일성() {
        String name = "pobi";
        Player player = new Player(name);
        assertThat(player)
                .isEqualTo(new Player(name))
                .hasSameHashCodeAs(new Player(name));
    }
}
