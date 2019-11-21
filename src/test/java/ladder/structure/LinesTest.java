package ladder.structure;

import ladder.structure.connection.Connections;
import ladder.structure.connection.DefaultConnection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinesTest {
    @Test
    void constructorTest() {
        DefaultConnection connectionStrategy = new DefaultConnection();
        Lines lines = new Lines(5, 4, connectionStrategy);
        assertAll(
                () -> assertThat(lines.getLine(0).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections()),
                () -> assertThat(lines.getLine(1).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections()),
                () -> assertThat(lines.getLine(2).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections()),
                () -> assertThat(lines.getLine(3).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections())
        );
    }
}