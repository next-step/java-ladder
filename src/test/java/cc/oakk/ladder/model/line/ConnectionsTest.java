package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.ConnectionDto;
import cc.oakk.ladder.model.line.dto.ConnectionsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ConnectionsTest {
    List<Boolean> booleans;
    Connections connections;

    @BeforeEach
    public void beforeAll() {
        this.booleans = Arrays.asList(false, true, false, true, false, false, false);
        List<Connection> connections = booleans.stream()
                .map(Connection::of)
                .collect(Collectors.toList());

        this.connections = new Connections(connections);
    }

    @Test
    public void isConnected() {
        for (int i = 0; i < booleans.size(); i++) {
            assertThat(connections.isConnected(i)).isEqualTo(booleans.get(i));
        }
    }

    @Test
    public void connect() {
        assertThat(connections.connect(5).isConnected(5)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 2, 4 })
    public void connect_ShouldThrow_WhenContinues(int index) {
        assertThatIllegalArgumentException().isThrownBy(() -> connections.connect(index));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3 })
    public void disconnect(int index) {
        assertThat(connections.connect(index).isConnected(index)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7 })
    public void size(int size) {
        Connections connections = new Connections(IntStream.range(0, size).boxed()
                .map(v -> Connection.of(true))
                .collect(Collectors.toList()));

        assertThat(connections.size()).isEqualTo(size);
    }

    @Test
    public void getDto() {
        List<ConnectionDto> connectionDtos = booleans.stream()
                .map(Connection::of)
                .map(Connection::getDto)
                .collect(Collectors.toList());

        assertThat(connections.getDto()).isEqualTo(new ConnectionsDto(connectionDtos));
    }
}
