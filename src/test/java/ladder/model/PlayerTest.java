package ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class PlayerTest {

    static Stream<String> provideStringsForBlank() {
        return Stream.of("", null);
    }

    @Test
    void 사람이름_5글자_초과시_오류발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> new Player("player1")
                ).withMessageContaining("이름은 최대 5글자입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideStringsForBlank")
    void 사람이름_1글자_미만시_오류발생(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> new Player(name)
                ).withMessageContaining("이름은 최소 1글자입니다.");
    }


}
