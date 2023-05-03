package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectableTest {

    @Test
    @DisplayName("연결여부 상태를 반환한다.")
    void test01() {
        Connectable connectable = new Connectable(true);

        assertThat(connectable.isConnected()).isTrue();
    }

}
