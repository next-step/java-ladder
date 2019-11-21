package ladder.structure.connection;

import ladder.structure.Connection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConnectionsTest {
    @Test
    void constructorTest() {
        DefaultConnection connectionStrategy = new DefaultConnection();
        Connections connections = new Connections(3, connectionStrategy);
        assertAll(
                ()->assertThat(connections.get(0)).isEqualTo(Connection.CONNECTED_BRIDGE),
                ()->assertThat(connections.get(1)).isEqualTo(Connection.NOT_CONNECTED_BRIDGE),
                ()->assertThat(connections.get(2)).isEqualTo(Connection.CONNECTED_BRIDGE)
        );
    }
}