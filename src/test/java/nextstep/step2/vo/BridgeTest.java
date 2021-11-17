package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("isGo() 포인트의 값에 따라 true / false 를 반환한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void isGoTest(boolean input) {
        Bridge actual = Bridge.create(input);

        assertThat(actual.isGo()).isEqualTo(input);
    }

    @DisplayName("create()는 이미 생성된 포인트를 반환한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getCachedPointTest(boolean input) {
        Bridge actual = Bridge.create(input);

        assertThat(actual).isEqualTo(Bridge.create(input));
        assertThat(actual).isSameAs(Bridge.create(input));
    }

}
