package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderConnectedDirectionTest {

    @DisplayName("오른쪽과 왼쪽 연결 여부를 전달하면, 연결 방향을 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "true,false,RIGHT",
            "false,true,LEFT",
            "false,false,NONE"
    })
    void of(boolean connectedRight, boolean connectedLeft, LadderConnectedDirection expected) {
        assertThat(LadderConnectedDirection.of(connectedRight, connectedLeft)).isEqualTo(expected);
    }

    @DisplayName("오른쪽과 왼쪽이 모두 연결되어 있으면, 예외가 발생해야 한다.")
    @Test
    void of_givenRightAndLeftConnected() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderConnectedDirection.of(true, true));
    }

    @DisplayName("연결 방향에 따라 다음 라인의 위치를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "RIGHT,0,1",
            "LEFT,1,0",
            "NONE,0,0"
    })
    void indexOfNextLinePosition(LadderConnectedDirection direction, int indexOfPosition, int expected) {
        assertThat(direction.getNextLinePosition(indexOfPosition)).isEqualTo(expected);
    }

}
