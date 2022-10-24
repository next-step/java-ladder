package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.util.StringUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    @DisplayName("전달 받은 문자열과 길이를 비교하여 모자란 길이의 공간을 왼쪽 빈 칸으로 채운다.")
    void appendWhitespace() {
        assertThat(appendWhiteSpaceInside("정우성", 6)).hasSize(6);
        assertThat(appendWhiteSpaceInside("정우성", 6).substring(3, 6)).isEqualTo("정우성");
        assertThat(appendWhiteSpaceInside("정우성", 6).substring(0, 3)).containsOnlyWhitespaces();
    }
}
