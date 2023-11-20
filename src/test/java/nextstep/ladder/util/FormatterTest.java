package nextstep.ladder.util;

import nextstep.ladder.domain.UserNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FormatterTest {
    @ParameterizedTest
    @MethodSource("userNamesTextProvider")
    @DisplayName("UserNames를 입력으로 넣고 userNamesFormat 메서드를 사용하면, 각 문자열이 왼쪽 정렬로 5칸을 가지면서 한칸의 공백을 간격으로 한 문자열을 반환한다.")
    void testUserNamesFormat(String text, String expected) {
        //given
        UserNames userNames = new UserNames(text);

        //when
        String actual = Formatter.userNamesFormat(userNames);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> userNamesTextProvider() {
        return Stream.of(
                Arguments.of("pobi,honux,crong,jk", " pobi honux crong    jk"),
                Arguments.of("A,B,C", "    A     B     C"),
                Arguments.of("1,2,3,4,5,6", "    1     2     3     4     5     6")
        );
    }

}
