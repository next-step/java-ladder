package laddergame.domain;

import laddergame.exception.InvalidPlayerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"    ", "abcdef"})
    @DisplayName("Player 인스턴스 생성시 name이 NULL 또는 빈문자열 또는 길이가 5글자를 넘는 문자열이라면 InvalidPlayerException이 발생한다.")
    void testInstanceCreation(String name) {
        assertThatThrownBy(() -> Player.valueOf(name)).isExactlyInstanceOf(InvalidPlayerException.class);
    }
}
