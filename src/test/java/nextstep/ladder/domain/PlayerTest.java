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
    void playerConstructorTest(final PlayerName playerName, final PlayerName expected) {
        Player player = Player.of(playerName);
        PlayerName result = player.convertPlayerNameWithLeftPad();
        assertThat(result.toString()).isEqualTo(expected.toString());
    }

    @DisplayName("사용자 생성 테스트 :: 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideLongPlayerName")
    void playerConstructorExceptionTest(final String playerName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> PlayerName.of(playerName));
    }

    private static Stream<Arguments> providePlayerName() {
        return Stream.of(Arguments.of(PlayerName.of("aaa"), PlayerName.playerNameWithPadding("   aaa")));
    }

    private static Stream<Arguments> provideLongPlayerName() {
        return Stream.of(Arguments.of("abcdefg", "qwerqweqwer"));
    }
}
