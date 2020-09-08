package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.ConnectionDto;
import cc.oakk.ladder.model.line.dto.ConnectionsDto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionsTest {
    @Test
    public void getDto() {
        List<Connection> connections = Stream.of(false, true, false, true, false, false, true)
                .map(Connection::new)
                .collect(Collectors.toList());
        List<ConnectionDto> connectionDtos = connections.stream()
                .map(Connection::getDto)
                .collect(Collectors.toList());

        Connections instance = new Connections(connections);
        assertThat(instance.getDto()).isEqualTo(new ConnectionsDto(connectionDtos));
    }
}
