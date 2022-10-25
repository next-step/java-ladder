package ladder.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NamesDisplayTest {
    @DisplayName("출력할 이름 문자열을 생성한다.")
    @ParameterizedTest
    @MethodSource("getSet")
    void get(NamesDisplay display, String expected) {
        assertThat(display.get()).isEqualTo(expected);
    }
    
    private static Stream<Arguments> getSet() {
        return Stream.of(
                Arguments.arguments(new NamesDisplay(List.of("poby","luna","jk"), 5), "poby  luna  jk    "),
                Arguments.arguments(new NamesDisplay(List.of("h","jk","cro"), 5), "h     jk    cro   ")
        );
    }
}
