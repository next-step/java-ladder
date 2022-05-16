package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSpliterTest {

    @DisplayName("문자열 분리 테스트")
    @Test
    void splitTest() {
        assertThat(StringSpliter.split("포비,크롱,철수,짱구"))
                .containsExactly("포비", "크롱", "철수", "짱구");
    }
}