package ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
