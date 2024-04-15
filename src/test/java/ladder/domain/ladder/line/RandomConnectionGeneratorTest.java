package ladder.domain.ladder.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomConnectionGeneratorTest {

    @Test
    @DisplayName("이전 연결이 true 상태라면 무작위로 생성하지 않고, false 상태의 연결을 반환한다.")
    void GenerateNext_PreviousTrue_NextFalse() {
        final Connection previousConnection = Connection.first(true);
        final Connection nextConnection = new RandomConnectionGenerator().generateNext(previousConnection);

        assertThat(nextConnection.isRightConnected())
                .isFalse();
    }
}
