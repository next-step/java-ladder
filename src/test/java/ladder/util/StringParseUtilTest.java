package ladder.util;

import ladder.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringParseUtilTest {

    @Test
    void parseToInt() {
    }

    @Test
    void splitString() {
    }

    @Test
    void trimString() {
    }

    @Test
    @DisplayName("사람 이름 입력 테스트 (구분자 사용)")
    void test_person_name_with_comma(){
        assertThat(StringParseUtil.splitString("crong, honox",","))
                .contains("crong")
                .contains("honox");
    }

}