package ladder.domain.line;

import static ladder.domain.line.ConnectionCount.MINIMUM_CONNECTION_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionCountTest {

    @Test
    @DisplayName("사다리 연결 개수를 생성한다.")
    void ConnectionCount_FromPlayersCount() {
        final ConnectionCount connectionCount = ConnectionCount.from(MINIMUM_CONNECTION_COUNT + 1);

        assertThat(connectionCount.count())
                .isEqualTo(MINIMUM_CONNECTION_COUNT);
    }

    @Test
    @DisplayName("사다리 연결 개수가 최소 개수 미만인 경우 예외를 던진다.")
    void ConnectionCount_LessThanMinimum_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ConnectionCount.from(MINIMUM_CONNECTION_COUNT));
    }
}
