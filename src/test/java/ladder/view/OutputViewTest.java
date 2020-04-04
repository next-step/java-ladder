package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @DisplayName("참여자 이름 5글자에 맞게 출력한다.")
    @ParameterizedTest
    @MethodSource("provideNames")
    void formatName(String name, String expect) {
        String actual = OutputView.formatName(name);

        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> provideNames() {
        return Stream.of(
                Arguments.of("a"     , "    a")
                ,Arguments.of("aa"   , "   aa")
                ,Arguments.of("aaa"  , "  aaa")
                ,Arguments.of("pobi" , " pobi")
                ,Arguments.of("ohtae", "ohtae")
        );
    }
}