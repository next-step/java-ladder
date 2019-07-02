package com.ladder.model;

import com.ladder.exception.NameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.ladder.model.Player.LENGTH_OF_USER_NAME;
import static com.ladder.model.Position.MIN_OF_POSITION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {

    @DisplayName("플레이어 이름을 생성하는데 성공한다")
    @Test
    void createUsername_success() {
        // given
        Position position = MIN_OF_POSITION;
        String name = "abcde";

        // when
        Player result = Player.of(position, name);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(Player.of(position, name));
    }

    @DisplayName("플레이어 이름이 " + LENGTH_OF_USER_NAME + "자리 초과할 시 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void createUsername_whenLengthMoreThanFive_exception(String wrongName) {
        assertThatExceptionOfType(NameLengthException.class)
                .isThrownBy(() -> ofPlayer(wrongName));
    }

    @DisplayName("플레이어 이름 빈 문자열 또는 null 일 시 실패한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createUsername_whenInputEmptyOrNull_exception(String nullName) {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> ofPlayer(nullName));
    }

    public static Player ofPlayer(String name) {
        return Player.of(MIN_OF_POSITION, name);
    }
}