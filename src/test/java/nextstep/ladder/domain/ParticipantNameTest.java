package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class ParticipantNameTest {
    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @NullAndEmptySource
    @DisplayName("null이거나 공백의 이름으로 Name 객체 생성 시, IllegalArgumentException 예외 발생")
    void null_or_blank_name_then_throw_IllegalArgumentException(String invalidName) {
        assertThatThrownBy(() -> new ParticipantName(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null이거나 공백일 수 없습니다: " + invalidName);
    }

    @Test
    void more_than_5_characters_then_throw_IllegalArgumentException() {
        // given
        String moreThanFiveCharactersName = "abcdef";

        // when, then
        assertThatThrownBy(() -> new ParticipantName(moreThanFiveCharactersName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5를 초과할 수 없습니다: " + moreThanFiveCharactersName);
    }
}