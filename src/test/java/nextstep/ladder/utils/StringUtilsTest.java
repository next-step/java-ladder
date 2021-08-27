package nextstep.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("String Utils 테스트")
public class StringUtilsTest {

    @DisplayName(",를 기준으로 이름을 분리하여 리스트로 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", " pobi ,honux,crong, jk"})
    void split(String input) {
        List<String> result = StringUtils.splitWithComma(input);
        assertThat(result).containsExactly("pobi", "honux", "crong", "jk");
    }
}
