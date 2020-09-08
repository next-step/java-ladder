package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    public void width() {
        assertThat(new Line(4).width()).isEqualTo(4);
        assertThat(new Line(5).width()).isEqualTo(5);
        assertThat(new Line(6).width()).isEqualTo(6);
        assertThat(new Line(7).width()).isEqualTo(7);
    }

    @Test
    public void connect() {
        final Line line = new Line(6);
        assertThat(line.isConnected(0)).isEqualTo(Connection.FALSE);
        line.connect(0);
        assertThat(line.isConnected(0)).isEqualTo(Connection.TRUE);

        line.connect(2, 4);
        assertThat(line.isConnected(2)).isEqualTo(Connection.TRUE);
        assertThat(line.isConnected(4)).isEqualTo(Connection.TRUE);
    }

    @Test
    public void connect_ShouldThrow() {
        final Line line = new Line(4);
        line.connect(0);
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(1));
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(3));
    }
}