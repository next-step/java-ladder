package nextstep.step4.utils;

import nextstep.step3.utils.LadderUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Ladder 유틸")
class LadderUtilsTest {

    @DisplayName("문자열 분리")
    @Test
    void splitString() {
        String input = "a,b,c";
        assertThat(LadderUtils.splitString(input)).isEqualTo(Arrays.asList("a", "b", "c"));
    }

    @DisplayName("문자열 공백 체크")
    @ParameterizedTest
    @CsvSource({",","''","' '"})
    void isBlank_True(String input) {
        assertThat(LadderUtils.isBlank(input)).isTrue();
    }

    @DisplayName("문자열 공백 체크")
    @ParameterizedTest
    @CsvSource({"A"," B"," C "})
    void isBlank_False(String input) {
        assertThat(LadderUtils.isBlank(input)).isFalse();
    }
}
