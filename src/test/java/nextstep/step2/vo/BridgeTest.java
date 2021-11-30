package nextstep.step2.vo;

import nextstep.step2.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("next() random 값에 따라 Bridge를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"RIGHT:false:LEFT", "RIGHT:true:LEFT",
            "DOWN:true:RIGHT", "DOWN:false:DOWN",
            "LEFT:true:RIGHT", "LEFT:false:DOWN"
    }, delimiter = ':')
    void nextTest(String beforeValue, boolean input, String nextValue) {
        Bridge before = Bridge.valueOf(beforeValue);

        assertThat(before.next(input, false)).isEqualTo(Bridge.valueOf(nextValue));
    }

    @DisplayName("next() 마지막 줄은 left, down 만 반환한다..")
    @ParameterizedTest
    @CsvSource(value = {"RIGHT:false:LEFT", "RIGHT:true:LEFT",
            "DOWN:true:DOWN", "DOWN:false:DOWN",
            "LEFT:true:DOWN", "LEFT:false:DOWN"
    }, delimiter = ':')
    void nextLastLineTest(String beforeValue, boolean input, String nextValue) {
        Bridge before = Bridge.valueOf(beforeValue);

        assertThat(before.next(input, true)).isEqualTo(Bridge.valueOf(nextValue));
    }

    @DisplayName("firstBridge() 는 DOWN OR RIGHT만 반환할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"false:DOWN", "true:RIGHT"
    }, delimiter = ':')
    void nextLastLineTest(boolean input, String nextValue) {
        assertThat(Bridge.firstBridge(input)).isEqualTo(Bridge.valueOf(nextValue));
    }

    @DisplayName("Bridge 의 Move() 함수를 호출 하면 bridge에 따라 point를 이동시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"LEFT:0", "RIGHT:2", "DOWN:1"}, delimiter = ':')
    void moveTest(String bridgeName, int expectPoint) {
        Bridge bridge = Bridge.valueOf(bridgeName);
        Point now = Point.of(1);
        assertThat(bridge.move(now)).isEqualTo(Point.of(expectPoint));
    }

}
