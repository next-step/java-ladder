package nextstep.step2.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 03:08
 */
class StringUtilTest {

    @DisplayName("문자열을 ',' 기준으로 자르기")
    @ParameterizedTest
    @ValueSource(strings = {"kwon", "byeon", "yun"})
    void splitComma(String names) {
        String split = "kwon,byeon,yun";

        assertThat(StringUtil.split(split).contains(names)).isTrue();
    }

    @DisplayName("문자열을 공백' '  제거하고 자르기")
    @ParameterizedTest
    @ValueSource(strings = {"kwon", "byeon", "yun"})
    void splitCommaHasSpace(String names) {
        String split = "kwon ,b ye on, y un";

        assertThat(StringUtil.split(split).contains(names)).isTrue();
    }

}