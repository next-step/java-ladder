package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void width() {
        assertThat(new Line(4).width()).isEqualTo(4);
        assertThat(new Line(5).width()).isEqualTo(5);
        assertThat(new Line(6).width()).isEqualTo(6);
        assertThat(new Line(7).width()).isEqualTo(7);
    }
}