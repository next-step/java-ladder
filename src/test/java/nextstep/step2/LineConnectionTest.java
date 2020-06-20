package nextstep.step2;

import nextstep.step2.domain.LineConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("라인 연결 상태 클래스 테스트")
public class LineConnectionTest {

    @Test
    @DisplayName("이전에 라인이 연결되었다면 다음 라인은 연결되지 않아야함을 테스트")
    void createLineConnectionTest() {
        boolean lineConnectionState = true;
        LineConnection lineConnection = LineConnection.connectLadder(lineConnectionState);
        assertThat(lineConnection.isConnect()).isNotEqualTo(lineConnectionState);
    }
}
