package ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class PlayingResultTest {

    static Stream<String> provideStringsForBlank() {
        return Stream.of("", null);
    }

    @Test
    void 실행결과_5글자_초과시_오류발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> new PlayingResult("500000")
                ).withMessageContaining("결과는 최대 5글자입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideStringsForBlank")
    void 실행결과_1글자_미만시_오류발생(String result) {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> new PlayingResult(result)
                ).withMessageContaining("결과는 최소 1글자입니다.");
    }


}
