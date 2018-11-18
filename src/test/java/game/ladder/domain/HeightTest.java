package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    @Test
    public void 만들기() {
        final int input = 5;
        Height height = new Height(input);

        assertThat(height.getValue()).isEqualTo(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 값이_0일때() {
        final int input = 0;

        new Height(input);
    }

    @Test
    public void 동등성_확인_같을때() {
        final int value = 3;

        Height height1 = new Height(value);
        Height height2 = new Height(value);

        assertThat(height1).isEqualTo(height2);
    }

    @Test
    public void 동등성_확인_다를때() {
        Height height1 = new Height(2);
        Height height2 = new Height(3);

        assertThat(height1).isNotEqualTo(height2);
    }
}