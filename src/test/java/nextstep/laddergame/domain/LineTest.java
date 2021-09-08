package nextstep.laddergame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @ParameterizedTest(name = "사다리의 한 라인은 연속으로 연결된 포인트를 가질 수 없다.")
    @CsvSource(value = {"CONNECTED,CONNECTED,UNCONNECTED", "CONNECTED,CONNECTED,CONNECTED", "UNCONNECTED,CONNECTED,CONNECTED"})
    public void invalidLineConnectTest(LineConnection p1, LineConnection p2, LineConnection p3) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(() -> Arrays.asList(p1, p2, p3)));
    }

}