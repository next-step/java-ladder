package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectionStatusTest {

    @Test
    @DisplayName("연결여부 상태를 반환한다.")
    void test01() {
        ConnectionStatus connectionStatus = new ConnectionStatus(true);

        assertThat(connectionStatus.isConnected()).isTrue();
    }

}
