package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LineTest {

    @Test
    public void has_at_least_one_point() {
        assertThat(new Line(4).contains(true)).isEqualTo(true);
        assertThat(new Line(5).contains(true)).isEqualTo(true);
        assertThat(new Line(6).contains(true)).isEqualTo(true);
        assertThat(new Line(7).contains(true)).isEqualTo(true);
    }
}