package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilTest {

    @Test
    @DisplayName("문자열 분리를 테스트합니다.")
    void split() {
        assertThat(InputUtil.stringSplit("a,b,c")).isEqualTo(List.of("a", "b", "c"));
    }
}