package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectionCreatorTest {

    @Test
    @DisplayName("직전에 연결을 만들었다면 연결 생성x")
    void create() {
        ConnectionCreator connectionCreator = new ConnectionCreator();
        ConnectionCreationStrategy connectionCreationStrategy = () -> true;

        Connection connectionConnected = connectionCreator.create(0, connectionCreationStrategy);
        assertThat(connectionConnected).isEqualTo(new Connection(true));

        Connection connectionNotConnected = connectionCreator.create(1, connectionCreationStrategy);
        assertThat(connectionNotConnected).isEqualTo(new Connection(false));
    }
}