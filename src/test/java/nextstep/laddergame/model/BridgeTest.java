package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @DisplayName("0, 1의 값으로 생성할 때 true, false로 생성되는지를 검증")
    @ParameterizedTest
    @CsvSource({ "0,false", "1,true" })
    void numberConstructorTest(int booleanNumber, boolean exist) {
        assertThat(new Bridge(booleanNumber)).isEqualTo(new Bridge(exist));
    }

    @DisplayName("empty 객체를 생성했을 때 false로 생성되는지 검증")
    @Test
    void emptyTest() {
        assertThat(Bridge.empty()).isEqualTo(new Bridge(false));
    }

    @DisplayName("true면 bridge가 있고, false면 bridge가 없음을 검증")
    @ParameterizedTest
    @CsvSource({ "true,true", "false,false" })
    void hasLineTest(boolean exist, boolean expected) {
        assertThat(new Bridge(exist).exist()).isEqualTo(expected);
    }
}
