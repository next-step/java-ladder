package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PlayerTest {

    @DisplayName("사용자 생성 테스트 :: 정상 테스트")
    @ParameterizedTest
    @MethodSource("providePlayerName")
    void playerConstructorTest(final String playerName, final String expected) {
        Player player = Player.of(playerName);
        String result = player.convertUserNameWithLeftPad();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사용자 생성 테스트 :: 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideLongPlayerName")
    void playerConstructorExceptionTest(final String playerName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Player.of(playerName));
    }

    private static Stream<Arguments> providePlayerName() {
        return Stream.of(Arguments.of("aaa", "   aaa"));
    }

    private static Stream<Arguments> provideLongPlayerName() {
        return Stream.of(Arguments.of("abcdefg", "qwerqweqwer"));
    }
}
