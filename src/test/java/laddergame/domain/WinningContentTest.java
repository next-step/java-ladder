package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningContentTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"    ", "꽝꽝꽝꽝꽝꽝꽝꽝"})
    @DisplayName("winningContent 인스턴스 생성시 winningContent가 NULL 또는 빈문자열 또는 길이가 MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT를 넘는 문자열이라면 IllegalArgumentException이 발생한다.")
    void testInstanceCreation(String winningContent) {
        assertThatThrownBy(() -> WinningContent.valueOf(winningContent)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}