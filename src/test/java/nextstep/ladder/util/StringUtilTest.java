package nextstep.ladder.util;

import nextstep.ladder.exception.IllegalSeparateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {

    @DisplayName("문자열을 쉼표를 기준으로 분리하여 배열로 리턴한다.")
    @Test
    void split_str() {
        assertThat(StringUtil.split("pobi,honux,crong,jk")).hasSize(4);
    }

    @DisplayName("문자열이 쉼표로 분리되지 않았을 경우 예외가 발생한다.")
    @Test
    void split_exception() {
        assertThatThrownBy(() -> StringUtil.split("1:2:3:4:5"))
                .isInstanceOf(IllegalSeparateException.class);
    }
}