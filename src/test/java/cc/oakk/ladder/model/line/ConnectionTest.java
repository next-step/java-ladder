package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionTest {
    @Test
    public void of() {
        assertThat(Connection.of(true).get()).isTrue();
        assertThat(Connection.of(false).get()).isFalse();

        assertThat(Connection.of(true)).isEqualTo(Connection.of(true));
        assertThat(Connection.of(false)).isEqualTo(Connection.of(false));
    }
}
