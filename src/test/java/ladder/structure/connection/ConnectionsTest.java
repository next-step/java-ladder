package ladder.structure.connection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ConnectionsTest {
    @Test
    @DisplayName("line생성 테스트")
    void constructorTest() {
        DefaultConnection connectionStrategy = new DefaultConnection();
        List<Connection> connections
                = new Connections(3, connectionStrategy).getConnections();
        assertAll(
                () -> assertThat(connections.get(0))
                        .isEqualTo(Connection.CONNECTED_BRIDGE),
                () -> assertThat(connections.get(1))
                        .isEqualTo(Connection.NOT_CONNECTED_BRIDGE),
                () -> assertThat(connections.get(2))
                        .isEqualTo(Connection.CONNECTED_BRIDGE)
        );
    }
}