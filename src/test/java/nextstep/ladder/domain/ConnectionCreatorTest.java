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

        Connection connection1 = connectionCreator.create(0, connectionCreationStrategy);
        assertThat(connection1).isNotNull();

        Connection connection2 = connectionCreator.create(1, connectionCreationStrategy);
        assertThat(connection2).isNull();
    }
}