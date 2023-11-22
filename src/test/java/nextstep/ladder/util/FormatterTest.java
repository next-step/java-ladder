package nextstep.ladder.util;

import nextstep.ladder.common.Common;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.domain.UserResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FormatterTest {
    @ParameterizedTest
    @MethodSource("userNamesTextProvider")
    @DisplayName("userNamesFormat를 사용하면, UserNames가 Format에 맞춰서 출력된다. (각 userName은 문자열이 오른쪽 정렬로 5칸을 가지면서 한칸의 공백을 간격으로 한 문자열로 변환된다.)")
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

    @Test
    @DisplayName("LadderFormat을 사용하면, 사다리가 Format에 맞춰서 출력된다. (사다리는 Line 목록을 가지고 있는데 각 Line은 Format에 맞춰서 true 값은 '-----'로 false 값은 '     '로 변환되고 각 값은 '|'로 구분된다.)")
    void testLadderFormat() {
        //given
        final Ladder ladder = Common.makeFixedLadder("1,2,3,4", "꽝,1000,5000,꽝", 5);

        //when
        final String ladderString = Formatter.ladderFormat(ladder.ladderLines());

        //then
        assertThat(ladderString)
                .isEqualTo(
                        "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|"
                );
    }

    @Test
    @DisplayName("userNamesFormat 메서드, LadderFormat 메서드, userResultsFormat 메서드의 결과를 합치면, 사다리 생성 실행 결과가 된다.")
    void testMakingLadderFormat() {
        //given
        final Ladder ladder = Common.makeFixedLadder("pobi,honux,crong,jk", "꽝,1000,5000,꽝", 5);

        //when
        final String userNamesString = Formatter.userNamesFormat(ladder.userNames());
        final String ladderString = Formatter.ladderFormat(ladder.ladderLines());
        final String userResultsString = Formatter.userResultsFormat(ladder.userResults());

        final String result = userNamesString + "\n" + ladderString + "\n" + userResultsString;

        //then
        assertThat(result)
                .isEqualTo(
                        " pobi honux crong    jk\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    꽝  1000  5000     꽝"
                );
    }

    @Test
    @DisplayName("userResultsFormat 메서드를 사용하면, UserResults가 Format에 맞춰서 출력된다. (각 userResult는 문자열이 오른쪽 정렬로 5칸을 가지면서 한칸의 공백을 간격으로 한 문자열로 변환된다.)")
    void testUserResultsFormat() {
        //given
        final int userNamesSize = 4;
        final UserResults userResults = new UserResults("꽝,1000,5000,꽝", userNamesSize);

        //when
        final String userResultsString = Formatter.userResultsFormat(userResults);

        //then
        assertThat(userResultsString).isEqualTo("    꽝  1000  5000     꽝");
    }
}
