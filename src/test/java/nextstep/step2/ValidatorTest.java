package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("입력값 검증")
class ValidatorTest {

    private Validator validator = new Validator();

    @DisplayName("사다리 높이값 체크 - 실패케이스")
    @ParameterizedTest
    @ValueSource(ints = {-1,0})
    void checkLadderHeight_fail(int intputValue) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkLadderHeight(intputValue))
                .withMessage("사다리의 높이는 1 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이값 체크 - 성공케이스")
    @ParameterizedTest
    @ValueSource(ints = {5,9})
    void checkLadderHeight_success(int intputValue) {
        assertThat(validator.checkLadderHeight(intputValue)).isEqualTo(intputValue);
    }

    @DisplayName("사람 이름 체크 - 실패케이스")
    @ParameterizedTest
    @MethodSource("userNamesOverFiveProvider")
    void userNameLengthIsUnderFive_fail(List<String> inputValue) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.userNameLengthIsUnderFive(inputValue))
                .withMessage("참여할 사람의 이름은 최대 5자 입니다.");
    }

    @DisplayName("사람 이름 체크 - 성공케이스")
    @ParameterizedTest
    @MethodSource("userNamesUnderFiveProvider")
    void userNameLengthIsUnderFive_success(List<String> inputValue) {
        assertThat(validator.userNameLengthIsUnderFive(inputValue)).isEqualTo(inputValue);
    }

    private static Stream<List<String>> userNamesOverFiveProvider() {
        return Stream.of(
                Arrays.asList("abcdef", "abcd"),
                Arrays.asList("abc", "다섯글자넘어가"),
                Arrays.asList("abcde", "긴거넘어가요")
        );
    }

    private static Stream<List<String>> userNamesUnderFiveProvider() {
        return Stream.of(
                Arrays.asList("abcd", "abcd"),
                Arrays.asList("abc", "네글자뿐"),
                Arrays.asList("abcde", "다섯글자됌")
        );
    }
}
