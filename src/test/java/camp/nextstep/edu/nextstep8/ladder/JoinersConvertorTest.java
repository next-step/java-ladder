package camp.nextstep.edu.nextstep8.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JoinersConvertorTest {
    @DisplayName("참가자 문자열이 제대로 변환 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C,D,E:5",
            "apple,bread,car,dry,egg:5",
            "boy,girl:2"
    }, delimiter = ':')
    public void makeJoinersTest(String input, int expectedCount) {
        // when
        List<String> joinMembers = JoinersConvertor.makeJoiners(input);

        // then
        assertThat(joinMembers.size()).isEqualTo(expectedCount);
    }

    @DisplayName("참가자 문자열이 제대로 변환 되는지 확인 (Method source 사용")
    @ParameterizedTest
    @MethodSource("provideJoinerInput")
    public void makeJoinersTestWithMethodSource(String input, int expectedCount) {
        // when
        List<String> joinMembers = JoinersConvertor.makeJoiners(input);

        // then
        assertThat(joinMembers.size()).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> provideJoinerInput() {
        return Stream.of(
                Arguments.of("A,B,C,D,E", 5),
                Arguments.of("apple,bread,car,dry,egg", 5),
                Arguments.of("boy,girl", 2)
        );
    }

    @DisplayName("빈 문자 열일 경우 예외")
    @Test
    public void makeJoinersEmptyTest() {
        // when & then
        assertThatThrownBy(() -> JoinersConvertor.makeJoiners(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자가 없습니다");
    }

    @DisplayName("최대 글자 수를 초과 하였을 경우 예외")
    @Test
    public void makeJoinersExceedLimitTest() {
        // given
        String input = "abcde,123456";

        // when & then
        assertThatThrownBy(() -> JoinersConvertor.makeJoiners(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 글자 수를 초과 하였습니다 : 123456");
    }
}
