package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MutableLineTest {
    @Test
    public void connect() {
        final MutableLine line = new MutableLine(6);
        assertThat(line.isConnected(0)).isEqualTo(Connection.FALSE);
        line.connect(0);
        assertThat(line.isConnected(0)).isEqualTo(Connection.TRUE);

        line.connect(2, 4);
        assertThat(line.isConnected(2)).isEqualTo(Connection.TRUE);
        assertThat(line.isConnected(4)).isEqualTo(Connection.TRUE);
    }

    @Test
    public void connect_ShouldThrow() {
        final MutableLine line = new MutableLine(4);
        line.connect(0);
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(1));
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(3));
    }
}