package ladder.domain.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionLogFactoryTest {

    @DisplayName("입력 수만큼의 위치 로그를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void createBy(int count) {
        PositionLogFactory positionLogFactory = new PositionLogFactory();
        PositionLogs logs = positionLogFactory.createBy(count);

        assertThat(logs.size()).isEqualTo(count);
    }
}
