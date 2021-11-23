package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("next() random 값에 따라 Bridge를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"RIGHT:false:LEFT", "RIGHT:true:LEFT",
            "DOWN:true:RIGHT", "DOWN:false:DOWN",
            "LEFT:true:DOWN", "LEFT:false:DOWN"
    }, delimiter = ':')
    void isGoTest(String beforeValue, boolean input, String nextValue) {
        Bridge before = Bridge.valueOf(beforeValue);

        assertThat(before.next(input)).isEqualTo(Bridge.valueOf(nextValue));
    }

}
