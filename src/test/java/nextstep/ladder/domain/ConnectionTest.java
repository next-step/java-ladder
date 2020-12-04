package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectionTest {

    @Test
    @DisplayName("connected 팩토리 메서드")
    void connected() {
        assertThat(Connection.connected()).isEqualTo(new Connection(true));
    }

    @Test
    @DisplayName("disConnected 팩토리 메서드")
    void disConnected() {
        assertThat(Connection.disConnected()).isEqualTo(new Connection(false));
    }
}