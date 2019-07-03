package com.ladder.model;

import com.ladder.exception.PlayersLessMinimumException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static com.ladder.model.PlayerTest.ofPlayer;
import static com.ladder.model.Players.MIN_NUMBER_OF_PLAYERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayersTest {

    @DisplayName("콤마를 기준으로 여러 플레이어를 생성하는데 성공한다")
    @Test
    void createPlayers_whenManyNames_success() {
        // given
        String names = "a,b,c,d,e";
        int expectedSize = 5;

        // when
        Players result = Players.of(names);

        // then
        assertThat(result.getPlayers()).contains(ofPlayer("a"),
                ofPlayer("b"),
                ofPlayer("c"),
                ofPlayer("d"),
                ofPlayer("e"));
        assertThat(result.getPlayers()).hasSize(expectedSize);
    }


    @DisplayName("플레이어가 " + MIN_NUMBER_OF_PLAYERS + "미만일 시 생성에 실패한다")
    @Test
    void createUsername_whenOnePlayer_exception() {
        String onePlayer = "pobi";
        assertThatExceptionOfType(PlayersLessMinimumException.class)
                .isThrownBy(() -> Players.of(onePlayer));
    }

    @DisplayName("플레이어 생성 시 공백 및 null 일 시 실패한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createUsername_whenEmptyOrNull_exception(String wrongPlayers) {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> Players.of(wrongPlayers));
    }
}