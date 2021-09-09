package nextstep.laddergame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static nextstep.laddergame.domain.LineConnection.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @ParameterizedTest(name = "사다리의 한 라인은 연속으로 연결된 포인트를 가질 수 없다.")
    @CsvSource(value = {"CONNECTED,CONNECTED,UNCONNECTED", "CONNECTED,CONNECTED,CONNECTED", "UNCONNECTED,CONNECTED,CONNECTED"})
    public void invalidLineConnectTest(LineConnection p1, LineConnection p2, LineConnection p3) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(() -> Arrays.asList(p1, p2, p3)));
    }

    @ParameterizedTest(name = "현재 라인에서의 포지션으로 다음 라인에서의 포지션을 알 수 있다.")
    @CsvSource(value = {
            "UNCONNECTED,UNCONNECTED,0,0", "UNCONNECTED,UNCONNECTED,1,1", "UNCONNECTED,UNCONNECTED,2,2",
            "CONNECTED,UNCONNECTED,0,1", "CONNECTED,UNCONNECTED,1,0", "CONNECTED,UNCONNECTED,2,2",
            "UNCONNECTED,CONNECTED,0,0", "UNCONNECTED,CONNECTED,1,2", "UNCONNECTED,CONNECTED,2,1"
    })
    public void nextLinePositionTest(LineConnection point1, LineConnection point2, int currentPosition, int nextPosition) {
        Line line = Line.of(() -> Arrays.asList(point1, point2));
        assertThat(line.move(currentPosition))
                .isEqualTo(nextPosition);
    }

    @ParameterizedTest(name = "포지션이 라인을 벗어나는 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 4})
    public void invalidPositionTest(int position) {
        Line line = Line.of(() -> Arrays.asList(UNCONNECTED, UNCONNECTED, UNCONNECTED));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> line.move(position))
                .withMessageContaining(String.valueOf(position));
    }

}