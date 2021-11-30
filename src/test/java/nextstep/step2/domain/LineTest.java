package nextstep.step2.domain;

import nextstep.step2.vo.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("연속으로 이어지는 브릿지는 만들어지지 않는다.")
    @Test
    void createTest() {

        Line actual = Line.createWithEndLine(5, () -> true);

        List<Bridge> expect = Arrays.asList(
                Bridge.RIGHT,
                Bridge.LEFT,
                Bridge.RIGHT,
                Bridge.LEFT,
                Bridge.DOWN
        );
        assertThat(actual.getBridges()).isEqualTo(expect);
    }

    @DisplayName("빈 bridge 리스트가 오면 illegal Exception")
    @Test
    void createFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.create(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Line.create(Collections.emptyList()));
    }

    @DisplayName("맨 처음 bridge 는 left 가 오지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"2:true:RIGHT", "3:false:DOWN", "5:true:RIGHT"}, delimiter = ':')
    void firstBridgeNotLeftTest(int count, boolean isRight, String expectBridge) {
        Line line = Line.createWithEndLine(count, () -> isRight);
        Bridge bridge = line.getBridges().get(0);
        assertThat(bridge).isEqualTo(Bridge.valueOf(expectBridge));
    }

    @DisplayName("마지막 bridge 는 right 가 오지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"4:true:LEFT", "3:false:DOWN", "5:true:DOWN"}, delimiter = ':')
    void LastBridgeNotRightTest(int count, boolean isRight, String expectBridge) {
        Line line = Line.createWithEndLine(count, () -> isRight);
        Bridge bridge = line.getBridges().get(count - 1);
        assertThat(bridge).isEqualTo(Bridge.valueOf(expectBridge));
    }

    @DisplayName("|-| |-| | 의 사다리 모양에서 각 포인트에서 정확하게 이동 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1","1:0","2:3","3:2","4:4"}, delimiter = ':')
    void moveTest(int beforePoint, int afterPoint) {
        Line line = Line.create(
                Arrays.asList(Bridge.RIGHT, Bridge.LEFT, Bridge.RIGHT, Bridge.LEFT, Bridge.DOWN)
        );
        Point before = Point.of(beforePoint);
        assertThat(line.move(before)).isEqualTo(Point.of(afterPoint));
    }


}
