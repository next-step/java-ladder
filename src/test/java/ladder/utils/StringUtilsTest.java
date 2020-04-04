package ladder.utils;

import ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @DisplayName("입력받은 문자열을 구분자로 분리하고 trim 처리해서 List로 반환")
    @Test
    public void splitStringToList() throws Exception {
        //given
        String input = "pobi, honux, crong,jk";
        String delimiter = ",";

        //when
        List<String> result = StringUtils.splitStringToList(input, delimiter);

        //then
        assertThat(result.get(0)).isEqualTo("pobi");
        assertThat(result.get(1)).isEqualTo("honux");
        assertThat(result.get(2)).isEqualTo("crong");
        assertThat(result.get(3)).isEqualTo("jk");
    }

    @DisplayName("문자열을 숫자로 변환")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "10:10"}, delimiter = ':')
    public void stringToInt_success(String input, int expect) throws Exception {
        //given
        int num = StringUtils.stringToInt(input);

        //then
        assertThat(num).isEqualTo(expect);
    }

    @DisplayName("문자열을 숫자로 변환")
    @ParameterizedTest
    @ValueSource(strings = {"1a", "2.2", "a", "?"})
    public void stringToInt_fail(String input) throws Exception {
        //then
        assertThatThrownBy(
                () -> StringUtils.stringToInt(input)
        ).isInstanceOf(LadderException.class);
    }
}
