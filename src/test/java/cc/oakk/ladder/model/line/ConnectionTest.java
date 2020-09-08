package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.ConnectionDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionTest {
    @Test
    public void getDto() {
        assertThat(new Connection(false).getDto()).isEqualTo(new ConnectionDto(false));
        assertThat(new Connection(true).getDto()).isEqualTo(new ConnectionDto(true));
    }
}
