package nextstep.ladder;

import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilTest {

    @Test
    @DisplayName("문자열 자르기 테스트")
    void splitTest(){
        String words = "abc,def,hij,xyz";
        String [] splitString = StringUtil.split(words);
        assertThat(splitString).hasSize(4);

        String noWords = "";
        assertThatThrownBy(() -> StringUtil.split(noWords))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(StringUtil.EMPTY_WORDS_EXCEPTION);
    }

    @Test
    @DisplayName("문자열 Null 체크 테스트")
    void nullTest(){
        String noWords = "";
        assertThatThrownBy(() -> StringUtil.validateNull(noWords, StringUtil.EMPTY_WORDS_EXCEPTION))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(StringUtil.EMPTY_WORDS_EXCEPTION);
    }
}
