package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.ConnectionDto;
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

    @Test
    public void getDto() {
        assertThat(Connection.of(false).getDto()).isEqualTo(new ConnectionDto(false));
        assertThat(Connection.of(true).getDto()).isEqualTo(new ConnectionDto(true));
    }
}
